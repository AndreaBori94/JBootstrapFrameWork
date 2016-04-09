package it.bori.jbfw.core.exception;

import java.io.Serializable;

/**
 * Called when user name or password are not valid
 * 
 * @author Andrea Bori
 *
 */
public class RemoteWebRepositoryAuthenticationException extends JBFWException implements Serializable{

	/**
	 * serialVersionUID used for serialization
	 */
	private static final long serialVersionUID = -6115389305891557915L;

	/**
	 * Default constructor, called when user name or password are not valid
	 */
	public RemoteWebRepositoryAuthenticationException() {
		super("Authentication invalid");
	}

}
