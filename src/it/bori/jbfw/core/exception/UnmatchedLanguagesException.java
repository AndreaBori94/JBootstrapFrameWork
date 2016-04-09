package it.bori.jbfw.core.exception;

import java.io.Serializable;

/**
 * Exception called when one or more languages are not "aligned"
 * 
 * @author Andrea Bori
 *
 */
public class UnmatchedLanguagesException extends JBFWException implements Serializable {

	/**
	 * serialVersionUID used for serialization
	 */
	private static final long serialVersionUID = 4924102636862442392L;

	/**
	 * Default constructor called when one or more languages are not "aligned"
	 * 
	 * @param langs_that_Fail
	 *            String with a list of languages that fail
	 */
	public UnmatchedLanguagesException(String langs_that_Fail) {
		super("Unmatched Languages Exception found inside [" + langs_that_Fail
				+ "]");
	}

}
