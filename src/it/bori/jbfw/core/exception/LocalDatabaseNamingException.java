package it.bori.jbfw.core.exception;


public class LocalDatabaseNamingException extends JBFWException
{

	public LocalDatabaseNamingException(int length)
	{
		super("Wrong Naming Excetpion: name length [" + length + "] not reach minium required length.");
	}

}
