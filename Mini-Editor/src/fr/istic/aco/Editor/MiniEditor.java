package fr.istic.aco.Editor;

/**
 * MiniEditor Interface
 *
 */
public interface MiniEditor 
{
	/**
	 * Get buffer content
	 * @return String Buffer
	 */
	public String getBuffer();
	/**
	 * Get a selection from the buffer
	 * @return String substringBuffer
	 */
	public String getSelection();
	/**
	 * Get the clipboard content
	 * @return String clipboard
	 */
	public String getClipboard();
    /**
     * Insert new string 
     * @param substring String newstring
     */
	public void editorInsert(String substring);
	/**
	 * Make a substring selection
	 * @param start Int start
	 * @param stop Int stop
	 */
	public void editorSelect(int start, int stop);
	/**
	 * Copy selection to the clipboard
	 */
	public void editorCopy();
	/**
	 * Cut selection
	 */
	public void editorCut();
	/**
	 * Paste clipboard content
	 */
	public void editorPaste();
	/**
	 * Start recording of commands
	 */
	public void editorStartRecording();
	/**
	 * Stop recording of comands
	 */
	public void editorEndRecording();
	/**
	 * Execute recorded commands
	 */
	public void editorPlayRecording();
	/**
	 * Undo previous command
	 */
	public void editorUndo();
	/**
	 * Redo previous command
	 */
	public void editorRedo();
}
