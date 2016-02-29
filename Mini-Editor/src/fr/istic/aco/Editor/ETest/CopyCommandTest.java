
package fr.istic.aco.Editor.ETest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.junit.Before;
import org.junit.Test;
import fr.istic.aco.Editor.Core.Cmd.*;
import fr.istic.aco.Editor.Core.*;
/**
 * Test of the CopyCommand Class
 * @author Vargas-Hoque
 *
 */
public class CopyCommandTest {
	private Command command;
	private MiniEditorEngine mockedEngine;
	@Before
	public void setUp() throws Exception {
		mockedEngine = mock(EditorEngine.class);
		command = new CopyCommand(mockedEngine);
	}
	/**
	 * Test of the execute method
	 */
	@Test
	public void testExecuteCommand() {
		command.execute();
		verify(mockedEngine).editorCopy();
	}

}
