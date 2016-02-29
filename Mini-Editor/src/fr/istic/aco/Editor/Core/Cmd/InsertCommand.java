package fr.istic.aco.Editor.Core.Cmd;
import fr.istic.aco.Editor.Core.MiniEditorEngine;
/**
 * Insert concrete command
 * @author Vargas-Hoque
 *
 */
public class InsertCommand implements Command {
	private MiniEditorEngine engine;
	private String subString,oldBuffer,buffer;
	/**
	 * InsertCommand constructor
	 * @param engine MiniEditorEngine engine
	 * @param subString new substring
	 */
	public InsertCommand (MiniEditorEngine engine, String subString)
	{
		this.engine = engine;
		this.subString = subString;
		this.oldBuffer = engine.getBuffer();
		this.buffer = new String();

	}
	/**
	 * Execute insert concrete command
	 */
	@Override
	public void execute() {
		engine.editorInsert(subString);
		buffer = engine.getBuffer();
	}
	/**
	 * Undo insert concrete command
	 */
	@Override
	public void undo() {
		engine.editorSelect(0, engine.getBuffer().length());
		engine.editorInsert(oldBuffer);
	}
	/**
	 * Redo insert concrete command
	 */
	@Override
	public void redo() {
		engine.editorSelect(0, engine.getBuffer().length());
		engine.editorInsert(buffer);
	}
}
