package fr.istic.aco.Editor.Core;
/**
 * Implementation of the MiniEditorClipboard Interface
 * @author Vargas-Hoque
 *
 */
public class EditorClipboard implements MiniEditorClipboard{
	private String clipString;
	/**
	 * EditorClipboard Constructor
	 */
	public EditorClipboard() {
		this.clipString = new String();
	}
	/**
	 * Read the content of the clipboard 
	 * @return Clipboard string
	 */
	@Override
	public String readClipboard() {
		return clipString;
	}
	/**
	 * Write a new string on the clipboard 
	 * @param clipString New string
	 */
	@Override
	public void writeClipboard(String clipString) {
		this.clipString = clipString;
	}
	/**
	 * Get the clipboard length
	 * @return Integer size
	 */
	@Override
	public int getSize() {
		return clipString.length();
	}

}
