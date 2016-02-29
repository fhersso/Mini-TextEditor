package fr.istic.aco.Editor.Core;
/**
 * MiniEditorBuffer Interface
 * @author Vargas-Hoque
 *
 */
public interface MiniEditorBuffer {
	/**
	 * Read a substring from the buffer
	 * @param begin Integer index begin
	 * @param end Integer index end
	 * @return String buffer
	 */
	public String readBuffer(int begin, int end );
	/**
	 * Write a substring on the buffer
	 * @param begin Integer index begin
	 * @param end Integer index end
	 * @param subString New string
	 */
	public void writeBuffer(int begin, int end, String subString);
	/**
	 * Get the buffer length
	 * @return Integer size
	 */
	public int getSize();
}
