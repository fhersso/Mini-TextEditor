package fr.istic.aco.Editor.Core;
/**
 * MiniEditorSelection interface
 * @author Vargas-Hoque
 *
 */
public interface MiniEditorSelection {
	
	/**
	 * Get the value of the beginning of the selection
	 * @return Beginning of selection
	 */
	public int getBegin();
	
	/**
	 * Set the value of the beginning of the selection
	 * @param begin Beginning value of the selection
	 */
	public void setBegin(int begin);
	
	/**
	 * Get the value of the end of the selection
	 * @return End of selection
	 */
	public int getEnd();
	
	/**
	 * Set the value of the end of the selection
	 * @param end End value of the selection
	 */
	public void setEnd(int end);
	
	/**
	 * Get the length of the selection
	 * @return Length of selection
	 */
	public int getLenght();

}
