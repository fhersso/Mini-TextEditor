package fr.istic.aco.Editor.ETest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

import fr.istic.aco.Editor.Core.Cmd.*;
import fr.istic.aco.Editor.Core.*;
/**
 * Test of the PasteCommand Class
 * @author Vargas-Hoque
 *
 */
public class PasteCommandTest {
	private Command command;
	private MiniEditorEngine mockedEngine,engine;
	@Before
	public void setUp() throws Exception {
		mockedEngine = mock(EditorEngine.class);
		engine=new EditorEngine();
		command = new PasteCommand(mockedEngine);
	}
	/**
	 * Test of the execute method
	 */
	@Test
	public void testExecute() {
		command.execute();
		verify(mockedEngine).editorPaste();
	}
	/**
	 * Test of the undo/redo
	 */
	@Test
	public void testUndoRedo() {
		engine.editorInsert("text");
		engine.editorSelect(0, 1);
		engine.editorCopy();
		engine.editorSelect(0, 0);
		command = new PasteCommand(engine);
		command.execute();
		assertEquals(engine.getBuffer(),"ttext");
		command.undo();
		assertEquals(engine.getBuffer(),"text");
		command.redo();
		assertEquals(engine.getBuffer(),"ttext");
	}


}
