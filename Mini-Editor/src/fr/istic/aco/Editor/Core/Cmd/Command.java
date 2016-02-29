package fr.istic.aco.Editor.Core.Cmd;
/**
 * Command Interface
 * @author Vargas-Hoque
 *
 */
public interface Command 
{
	/**
	 * Command execution
	 */
	public void execute();
	/**
	 * Command undo
	 */
	public void undo();
	/**
	 * Command redo
	 */
	public void redo();
}
