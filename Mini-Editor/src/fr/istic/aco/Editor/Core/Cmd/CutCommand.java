package fr.istic.aco.Editor.Core.Cmd;
import fr.istic.aco.Editor.Core.MiniEditorEngine;
/**
 * Cut concrete command
 * @author Vargas-Hoque
 *
 */
public class CutCommand implements Command {
	private MiniEditorEngine engine;
	private String oldBuffer,buffer;
	/**
	 * CutCommand constructor
	 * @param engine MiniEditorEngine engine
	 */
	public CutCommand(MiniEditorEngine engine) {
		this.engine = engine;
		this.oldBuffer = engine.getBuffer();
		this.buffer = new String();
	}
	/**
	 * Execute cut concrete command
	 */
	@Override
	public void execute() {
		engine.editorCut();
		buffer = engine.getBuffer();
	}
	/**
	 * Undo cut concrete command
	 */
	@Override
	public void undo() {
		engine.editorSelect(0, engine.getBuffer().length());
		engine.editorInsert(oldBuffer);
	}
	/**
	 * Redo cut concrete command
	 */
	@Override
	public void redo() {
		engine.editorSelect(0, engine.getBuffer().length());
		engine.editorInsert(buffer);
	}
}

