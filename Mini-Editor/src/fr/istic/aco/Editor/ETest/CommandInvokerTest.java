package fr.istic.aco.Editor.ETest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

import fr.istic.aco.Editor.Core.Cmd.*;

/**
 * Test of the CommandInvoker Class
 * @author Vargas-Hoque
 *
 */
public class CommandInvokerTest {
	private Command mockedCopyCommand,mockedInsertCommand,mockedSelectCommand;
	private CommandInvoker invoker;
	@Before
	public void setUp() throws Exception {
		mockedCopyCommand = mock(CopyCommand.class);
		mockedInsertCommand = mock(InsertCommand.class);
		mockedSelectCommand = mock(SelectCommand.class);
		invoker = new CommandInvoker();
	}
	/**
	 * Test of the SaveAndRun Method
	 */
	@Test
	public void testSaveAndRun() {
		invoker.saveAndRun(mockedInsertCommand);
		verify(mockedInsertCommand).execute();
		
	}
	/**
	 * Test of the command recorder methods
	 */
	@Test
	public void testCommandRecorder() {
		invoker.startRecording();
		invoker.saveAndRun(mockedInsertCommand);
		invoker.saveAndRun(mockedSelectCommand);
		invoker.saveAndRun(mockedCopyCommand);
		invoker.endRecording();
		verify(mockedInsertCommand, times(1)).execute();
		invoker.playRecording();//1 more Insert Command
		invoker.playRecording();//1 more time Insert command
		verify(mockedInsertCommand, times(3)).execute();
		invoker.startRecording();
		invoker.endRecording();
		invoker.playRecording();//0 more times
		verify(mockedInsertCommand, times(3)).execute();
	}
	
	/**
	 * Test of the command recorder methods
	 */
	@Test
	public void testUndoRedoCommands() {
		//Only 3 commands have an undo (3 insertions)
		invoker.saveAndRun(mockedInsertCommand);//make an insert
		invoker.saveAndRun(mockedInsertCommand);//make an insert
		invoker.saveAndRun(mockedSelectCommand);//make a selection
		invoker.saveAndRun(mockedCopyCommand);//make copy to clipboard
		invoker.saveAndRun(mockedInsertCommand);//make an insert
		
		invoker.undoCommand();
		invoker.undoCommand();
		invoker.undoCommand();
		verify(mockedInsertCommand, times(3)).undo();
		verify(mockedSelectCommand, times(0)).undo();
		verify(mockedCopyCommand, times(0)).undo();
		
		invoker.redoCommand();
		invoker.redoCommand();
		invoker.redoCommand();
		verify(mockedInsertCommand, times(3)).redo();
		verify(mockedSelectCommand, times(0)).redo();
		verify(mockedCopyCommand, times(0)).redo();
	}
}
