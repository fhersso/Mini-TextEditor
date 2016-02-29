package fr.istic.aco.Editor.Core;
/**
 * Implementation of the MiniEditorBuffer Interface
 * @author Vargas-Hoque
 *
 */
public class EditorBuffer implements MiniEditorBuffer {
	private String bufferString;
	/**
	* EditorBuffer Constructor
	*/
	public EditorBuffer() {
		this.bufferString = new String();
	}
	/**
	 * Read a substring from the buffer
	 * @param begin Integer index begin
	 * @param end Integer index end
	 * @return String substring
	 */
	@Override
	public String readBuffer(int begin, int end) {
		return bufferString.substring(begin, end);
	}
	/**
	 * Write a substring on the buffer
	 * @param begin Integer index begin
	 * @param end Integer index end
	 * @param subString New string
	 */
	@Override
	public void writeBuffer(int begin, int end, String subString) {
		this.bufferString = bufferString.substring(0, begin) + 
				subString + bufferString.substring(end);
		
	}
	/**
	 * Get the buffer length
	 * @return Integer size
	 */
	@Override
	public int getSize() {
		return bufferString.length();
	}

}
