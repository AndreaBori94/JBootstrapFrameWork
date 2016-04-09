package it.bori.jbfw.core.exception;

/**
 * Exception when a word it's not found when requested
 * 
 * @author Andrea Bori
 *
 */
public class WordNotFoundException extends JBFWException {

	/**
	 * serialVersionUID for serialization
	 */
	private static final long serialVersionUID = -7507929888508336923L;

	/**
	 * Default constructor, called when a word inside a languages it's not found
	 * 
	 * @param lang
	 *            languages where word should be
	 * @param word
	 *            the word that hasn't been found
	 */
	public WordNotFoundException(String lang, String word) {
		super("Word [" + word + "] not found exception in [" + lang + "]");
	}

}
