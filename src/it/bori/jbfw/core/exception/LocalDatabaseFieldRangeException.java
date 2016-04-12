package it.bori.jbfw.core.exception;

public class LocalDatabaseFieldRangeException extends JBFWException
{

	public LocalDatabaseFieldRangeException(int min, int max)
	{
		super(
				"Local Database Field Range Exception: Given range, it's inverse. min it's more or equals than max.");
	}
}
