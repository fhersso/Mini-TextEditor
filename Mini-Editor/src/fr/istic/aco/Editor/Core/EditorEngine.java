package fr.istic.aco.Editor.Core;
/**
 * Implementation of the MiniEditorEngine interface
 * @author Vargas-Hoque
 *
 */
public class EditorEngine implements MiniEditorEngine{
	
	private MiniEditorBuffer buffer;
	private MiniEditorClipboard clipboard;
	private MiniEditorSelection selection;
	/**
	 * EditorEngine constructor
	 */
	public EditorEngine()
	{
		this.buffer = new EditorBuffer();
		this.clipboard = new EditorClipboard();
		this.selection = new EditorSelection();;
	}
	/**
	 * Get buffer content
	 * @return String buffer
	 */
	@Override
	public String getBuffer() {
		return buffer.readBuffer(0, buffer.getSize());
	}
	/**
	 * Get the selected text from the buffer
	 * @return String substring from buffer
	 */
	@Override
	public String getSelection() {
		return buffer.readBuffer(selection.getBegin(),selection.getEnd());
	}
	/**
	 * Get clipboard content
	 * @return String clipboard
	 */
	@Override
	public String getClipboard() {
		return clipboard.readClipboard();
	}
	/**
	 * Insert a string in the buffer
	 * @param subString String Substring 
	 */
	@Override
	public void editorInsert(String subString) {
		buffer.writeBuffer(selection.getBegin(), selection.getEnd(), subString);
		selection.setBegin(selection.getBegin()+subString.length());
		selection.setEnd(selection.getBegin());
	}
	/**
	 * Set a new selection on the buffer
	 * @param start Int Start
	 * @param stop Int Stop
	 */
	@Override
	public void editorSelect(int start, int stop) {
		if(stop>buffer.getSize())
			selection.setEnd(buffer.getSize());
		else
			selection.setEnd(stop);
		
		if(start>buffer.getSize())
			selection.setBegin(buffer.getSize());
		else
			selection.setBegin(start);
	}
	/**
	 * Copy the selection from the buffer to the clipboard
	 */
	@Override
	public void editorCopy() {
		clipboard.writeClipboard(buffer.readBuffer(selection.getBegin(), selection.getEnd()));
		
	}
	/**
	 * Cut selected text from the buffer and place it on the clipboard
	 */
	@Override
	public void editorCut() {
		clipboard.writeClipboard(buffer.readBuffer(selection.getBegin(), selection.getEnd()));
		buffer.writeBuffer(selection.getBegin(), selection.getEnd(), "");
		selection.setEnd(selection.getBegin());
		
		
	}
	/**
	 * Paste the clipboard on the buffer
	 */
	@Override
	public void editorPaste() {
		buffer.writeBuffer(selection.getBegin(), selection.getEnd(), clipboard.readClipboard());
		selection.setBegin(selection.getBegin()+clipboard.getSize());
		selection.setEnd(selection.getBegin());
	}

}
