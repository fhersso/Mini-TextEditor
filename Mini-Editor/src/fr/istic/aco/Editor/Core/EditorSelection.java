package fr.istic.aco.Editor.Core;
/**
 * Implementation of MiniEditorSelection interface
 * @author Vargas-Hoque
 *
 */
public class EditorSelection implements MiniEditorSelection{
	private int begin, end;
	
	/**
	 * EditorSelection Constructor
	 */
	public EditorSelection() {
		begin = 0;
		end = 0;
	}

	/**
	 * Get the value of the beginning of the selection
	 * @return Beginning of selection
	 */
	@Override
	public int getBegin() {
		return begin;
	}
	
	/**
	 * Set the value of the beginning of the selection
	 * @param begin Beginning value of the selection
	 */
	@Override
	public void setBegin(int begin) {
		this.begin=begin;
	}
	
	/**
	 * Get the value of the end of the selection
	 * @return End of selection
	 */
	@Override
	public int getEnd() {
		return end;
	}

	/**
	 * Set the value of the end of the selection
	 * @param end End value of the selection
	 */
	@Override
	public void setEnd(int end) {
		this.end=end;
	}

	/**
	 * Get the length of the selection
	 * @return Length of selection
	 */
	@Override
	public int getLenght() {
		return Math.abs(end-begin);
	}

}
