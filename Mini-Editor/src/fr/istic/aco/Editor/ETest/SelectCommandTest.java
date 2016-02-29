package fr.istic.aco.Editor.ETest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

import fr.istic.aco.Editor.Core.Cmd.*;
import fr.istic.aco.Editor.Core.*;
/**
 * Test of the SelectCommand Class
 * @author Vargas-Hoque
 *
 */
public class SelectCommandTest {
	private Command command;
	private MiniEditorEngine mockedEngine;
	@Before
	public void setUp() throws Exception {
		mockedEngine = mock(EditorEngine.class);
		command = new SelectCommand(mockedEngine,0,0);
	}
	/**
	 * Test of the execute method
	 */
	@Test
	public void test() {
		command.execute();
		verify(mockedEngine).editorSelect(0, 0);
	}

}
