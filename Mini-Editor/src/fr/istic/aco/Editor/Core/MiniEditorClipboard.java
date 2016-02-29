package fr.istic.aco.Editor.Core;
/**
 * MiniEditorClipboard interface
 * @author Vargas-Hoque
 *
 */
public interface MiniEditorClipboard {
	/**
	 * Read the content of the clipboard 
	 * @return Clipboard string
	 */
	public String readClipboard();
	/**
	 * Write a new string on the clipboard 
	 * @param clipString New string
	 */
	public void writeClipboard(String clipString);
	/**
	 * Get the clipboard length
	 * @return Int size
	 */
	public int getSize();
}
