package it.bori.jbfw.core.exception;

public class LocalDatabaseRangeException extends JBFWException
{

	public LocalDatabaseRangeException(int min, int max, int cur)
	{
		super("Local Database Range Exception: Invalid Range. " + cur
				+ " must be between " + min + " and " + max);
	}

}
