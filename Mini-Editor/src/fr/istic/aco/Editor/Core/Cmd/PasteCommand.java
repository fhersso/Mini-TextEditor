package fr.istic.aco.Editor.Core.Cmd;
import fr.istic.aco.Editor.Core.MiniEditorEngine;
/**
 * Paste concrete command
 * @author Vargas-Hoque
 *
 */
public class PasteCommand implements Command {
	private MiniEditorEngine engine;
	private String oldBuffer,buffer;
	/**
	 * PasteCommand constructor
	 * @param engine MiniEditorEngine engine
	 */
	public PasteCommand(MiniEditorEngine engine) {
		this.engine = engine;
		this.oldBuffer = engine.getBuffer();
		this.buffer = new String();
	}
	/**
	 * Execute paste concrete command
	 */
	@Override
	public void execute() {
		engine.editorPaste();
		buffer = engine.getBuffer();
		
	}
	/**
	 * Undo paste concrete command
	 */
	@Override
	public void undo() {
		engine.editorSelect(0, engine.getBuffer().length());
		engine.editorInsert(oldBuffer);
		
	}
	/**
	 * Redo paste concrete command
	 */
	@Override
	public void redo() {
		engine.editorSelect(0, engine.getBuffer().length());
		engine.editorInsert(buffer);
	}
}

