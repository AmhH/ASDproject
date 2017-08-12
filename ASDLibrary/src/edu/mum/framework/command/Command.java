package edu.mum.framework.command;

public interface Command<T> {
	public void execute();
	public void undo();
}
