package fr.istic.aco.Editor.Core.Cmd;
import fr.istic.aco.Editor.Core.MiniEditorEngine;
/**
 * Copy concrete command
 * @author Vargas-Hoque
 *
 */
public class CopyCommand implements Command {
	private MiniEditorEngine engine;
	/**
	 * CopyCommand constructor
	 * @param engine MiniEditorEngine engine
	 */
	public CopyCommand(MiniEditorEngine engine) {
		this.engine = engine;
	}
	/**
	 * Execute copy concrete command
	 */
	@Override
	public void execute() {
		engine.editorCopy();		
	}
	/**
	 * Undo copy concrete command
	 */
	@Override
	public void undo() {
		//not needed
		
	}
	/**
	 * Redo copy concrete command
	 */
	@Override
	public void redo() {
		// Redo not needed
		
	}
}