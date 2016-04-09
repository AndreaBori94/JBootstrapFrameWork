package it.bori.jbfw.core.exception;

/**
 * Called when user name or password are not valid
 * 
 * @author Andrea Bori
 *
 */
public class RemoteWebRepositoryAuthenticationException extends JBFWException {

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
