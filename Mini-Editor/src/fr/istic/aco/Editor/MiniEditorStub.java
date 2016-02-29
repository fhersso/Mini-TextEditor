package fr.istic.aco.Editor;

import fr.istic.aco.Editor.Core.EditorEngine;
import fr.istic.aco.Editor.Core.Cmd.*;
/**
 * Implementation of MiniEditor Interface
 *
 */
public class MiniEditorStub implements MiniEditor
{

	private EditorEngine engine;
	private CommandInvoker invoker;
	/**
	 * MiniEditorStub Constructor
	 */
	public MiniEditorStub() {
		engine = new EditorEngine();
		invoker = new CommandInvoker();
	}
	/**
	 * Get buffer content
	 * @return String Buffer
	 */
	@Override
	public String getBuffer()
	{
		return engine.getBuffer();
	}
	/**
	 * Get a selection from the buffer
	 * @return String substringBuffer
	 */
	@Override
	public String getSelection()
	{
		return engine.getSelection();
	}
	/**
	 * Get the clipboard content
	 * @return String clipboard
	 */
	@Override
	public String getClipboard()
	{
		return engine.getClipboard();
	}
    /**
     * Insert new string 
     * @param substring String newstring
     */
	@Override
	public void editorInsert(String substring)
	{	
		Command insert = new InsertCommand(engine, substring);
		invoker.saveAndRun(insert);
	}
	/**
	 * Make a substring selection
	 * @param start Int start
	 * @param stop Int stop
	 */
	@Override
	public void editorSelect(int start, int stop)
	{
		Command select = new SelectCommand(engine, start, stop);
		invoker.saveAndRun(select);
		System.out.println("DEBUG: selecting interval [" + start + "," + stop + "]");
	}
	/**
	 * Copy selection to the clipboard
	 */
	@Override
	public void editorCopy()
	{	
		Command copy = new CopyCommand(engine);
		invoker.saveAndRun(copy);
	}
	/**
	 * Cut selection
	 */
	@Override
	public void editorCut() 
	{
		Command cut = new CutCommand(engine);
		invoker.saveAndRun(cut);
	}
	/**
	 * Paste clipboard content
	 */
	@Override
	public void editorPaste()
	{
		Command paste = new PasteCommand(engine);
		invoker.saveAndRun(paste);
	}
	/**
	 * Start recording of commands
	 */
	@Override
	public void editorStartRecording()
	{
		invoker.startRecording();
	}
	/**
	 * Stop recording of commands
	 */
	@Override
	public void editorEndRecording()
	{	
		invoker.endRecording();
	}
	/**
	 * Execute recorded commands
	 */
	@Override
	public void editorPlayRecording()
	{
		invoker.playRecording();
	}
	/**
	 * Undo previous command
	 */
	@Override
	public void editorUndo()
	{
		invoker.undoCommand();
	}
	/**
	 * Redo previous command
	 */
	@Override
	public void editorRedo()
	{
		invoker.redoCommand();
	}

}
