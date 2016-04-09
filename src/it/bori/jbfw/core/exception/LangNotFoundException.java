package it.bori.jbfw.core.exception;

import java.io.Serializable;

/**
 * Exception launched when a languages file it's not found where "langsFile"
 * says
 * 
 * @author Andrea Bori
 *
 */
public class LangNotFoundException extends JBFWException implements
		Serializable
{

	/**
	 * serialVersionUID used for serialize
	 */
	private static final long serialVersionUID = -8269787313087680143L;

	/**
	 * Default constructor, need the lang name for specify what languages cannot
	 * be obtained
	 * 
	 * @param languages
	 *            languages name
	 */
	public LangNotFoundException(String languages)
	{
		super("Cannot find lang [" + languages + "]");
	}
}
