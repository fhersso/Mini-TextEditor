package fr.istic.aco.Editor.Core.Cmd;
import fr.istic.aco.Editor.Core.MiniEditorEngine;
/**
 * Select concrete command
 * @author Vargas-Hoque
 *
 */
public class SelectCommand implements Command{
	private MiniEditorEngine engine;
	private int start, stop;
	/**
	 * SelectCommand Constructor
	 * @param engine MiniEditorEngine engine
	 * @param start Integer start of selection
	 * @param stop Integer end of selection
	 */
	public SelectCommand(MiniEditorEngine engine, int start, int stop) {
		this.engine = engine;
		this.start = start;
		this.stop = stop;
	}
	/**
	 * Execute select concrete command
	 */
	@Override
	public void execute() {
		engine.editorSelect(start, stop);
	}
	/**
	 * Undo select concrete command
	 */
	@Override
	public void undo() {
		//not needed
		
	}
	/**
	 * Redo select concrete command
	 */
	@Override
	public void redo() {
		//not needed
		
	}
}
