package fr.istic.aco.Editor.Core;
/**
 * MiniEditorEngine Interface
 * @author Vargas-Hoque
 *
 */
public interface MiniEditorEngine {
	/**
	 * Get buffer content
	 * @return String buffer
	 */
	public String getBuffer();
	/**
	 * Get the selected text from the buffer
	 * @return String substring from buffer
	 */
	public String getSelection();
	/**
	 * Get clipboard content
	 * @return String clipboard
	 */
	public String getClipboard();
	/**
	 * Insert a string in the buffer
	 * @param subString String Substring 
	 */
	public void editorInsert(String subString);
	/**
	 * Set a new selection on the buffer
	 * @param start Int Start
	 * @param stop Int Stop
	 */
	public void editorSelect(int start, int stop);
	/**
	 * Copy the selection from the buffer to the clipboard
	 */
	public void editorCopy();
	/**
	 * Cut selected text from the buffer and place it on the clipboard
	 */
	public void editorCut();
	/**
	 * Paste the clipboard on the buffer in the position of selection
	 */
	public void editorPaste();
}