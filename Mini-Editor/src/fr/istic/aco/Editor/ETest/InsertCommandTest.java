package fr.istic.aco.Editor.ETest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import fr.istic.aco.Editor.Core.Cmd.*;
import fr.istic.aco.Editor.Core.*;
/**
 * Test of the InsertCommand Class
 * @author Vargas-Hoque
 *
 */
public class InsertCommandTest {
	private Command command;
	private MiniEditorEngine mockedEngine,engine;
	@Before
	public void setUp() throws Exception {
		mockedEngine = mock(EditorEngine.class);
		engine=new EditorEngine();
		command = new InsertCommand(mockedEngine,"");
	}
	/**
	 * Test of the execute method
	 */
	@Test
	public void testExecute() {
		command.execute();
		verify(mockedEngine).editorInsert("");
	}
	/**
	 * Test of the undo/redo
	 */
	@Test
	public void testUndoRedo() {
		command = new InsertCommand(engine,"Texto");
		command.execute();
		assertEquals(engine.getBuffer(),"Texto");
		command.undo();
		assertEquals(engine.getBuffer(),"");
		command.redo();
		assertEquals(engine.getBuffer(),"Texto");
	}
}
