package fr.istic.aco.Editor.ETest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import fr.istic.aco.Editor.Core.Cmd.*;
import fr.istic.aco.Editor.Core.*;
/**
 * Test of the CutCommand Class
 * @author Vargas-Hoque
 *
 */
public class CutCommandTest {
	private Command command;
	private MiniEditorEngine mockedEngine, engine;
	@Before
	public void setUp() throws Exception {
		mockedEngine = mock(EditorEngine.class);
		engine=new EditorEngine();
		command = new CutCommand(mockedEngine);
	}
	/**
	 * Test of the execute method
	 */
	@Test
	public void testExecute() {
		command.execute();
		verify(mockedEngine).editorCut();
	}
	/**
	 * Test of the undo/redo
	 */
	@Test
	public void testUndoRedo() {
		engine.editorInsert("text");
		engine.editorSelect(0, 5);
		command = new CutCommand(engine);
		command.execute();
		assertEquals(engine.getBuffer(),"");
		command.undo();
		assertEquals(engine.getBuffer(),"text");
		command.redo();
		assertEquals(engine.getBuffer(),"");
	}

}
