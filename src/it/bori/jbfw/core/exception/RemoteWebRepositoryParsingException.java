package it.bori.jbfw.core.exception;

import java.io.Serializable;

/**
 * Called when an error occurred while parsing and fetching the content from a
 * given path
 * 
 * @author Andrea Bori
 *
 */
public class RemoteWebRepositoryParsingException extends JBFWException implements Serializable {

	/**
	 * serialVersionUID used for serialization
	 */
	private static final long serialVersionUID = -5419932759726469744L;

	/**
	 * Default constructor, called when an error occurred while parsing and
	 * fetching the content from a given path
	 * 
	 * @param currentPath
	 *            the current path where it encounter an error
	 */
	public RemoteWebRepositoryParsingException(String currentPath) {
		super("Error while parsing ( listing ) " + currentPath);
		// TODO Auto-generated constructor stub
	}

}
