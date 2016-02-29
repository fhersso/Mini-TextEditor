package fr.istic.aco.Editor.Core.Cmd;

import java.util.ArrayList;
 
/**
 * MiniEditor CommandInvoker
 * @author Vargas-Hoque
 *
 */
public class CommandInvoker {
	private ArrayList<Command> commandList,cmdRecorder,undoList; //list of commands
	private int start, end; // Record index
	private boolean recordStart;
	/**
	 * ConmmandInvoker Constructor
	 */
	public CommandInvoker() {
		commandList = new ArrayList<Command>();
		cmdRecorder = new ArrayList<Command>();
		undoList = new ArrayList<Command>();
		start = 0;
		end = 0;
		recordStart = false;
	}
	/**
	 * Run and store command on the commandList
	 * @param command ConcreteCommand
	 */
	public void saveAndRun(Command command){
		commandList.add(command);
		command.execute();
	}
	/**
	 * Start recording of commands in cmdRecorder
	 */
	public void startRecording() {
		start = commandList.size();
		end=start;
		recordStart=true;
		cmdRecorder.clear();
	}
	/**
	 * Stop recording commands 
	 */
	public void endRecording() {
		if(recordStart){
			end = commandList.size();
			recordStart=false;
			for(int i = start;i<end;i++)
			{
				cmdRecorder.add(commandList.get(i));
			}
		}
	}
	/**
	 * Play all the recorded commands
	 */
	public void playRecording() {
		if (!cmdRecorder.isEmpty())
		for(int i = 0;i<cmdRecorder.size();i++)
		{
			cmdRecorder.get(i).execute();
		}
	}
	/**
	 * Undo the last performed command/commands
	 */
	public void undoCommand(){
		if (!commandList.isEmpty()){
			undoList.add(commandList.remove(commandList.size()-1));
			if(undoList.get(undoList.size()-1) instanceof CopyCommand || undoList.get(undoList.size()-1) instanceof SelectCommand)
				undoCommand();
			else
				undoList.get(undoList.size()-1).undo();
		}
	}
	/**
	 * Redo the command or commands that have been undone.
	 */
	public void redoCommand(){
		if (!undoList.isEmpty()){
			commandList.add(undoList.remove(undoList.size()-1));
			if(commandList.get(commandList.size()-1) instanceof CopyCommand || commandList.get(commandList.size()-1) instanceof SelectCommand)
				redoCommand();
			else
				commandList.get(commandList.size()-1).redo();
		}
	}
}