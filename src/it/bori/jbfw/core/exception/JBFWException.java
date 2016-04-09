package it.bori.jbfw.core.exception;

import java.io.Serializable;
import it.bori.jbfw.core.debug.logger.Logger;

/**
 * Generic Java Bootstrap Frame Work Exception class
 * 
 * @author Andrea Bori
 *
 */
public class JBFWException extends Exception implements Serializable
{

	/**
	 * serialVersionUID used for serializing
	 */
	private static final long	serialVersionUID	= 26832995012219205L;

	/**
	 * Default constructor, simply pass to logger instance this class
	 * 
	 * @param msg
	 *            the message to be displayed and logged
	 */
	public JBFWException(String msg)
	{
		super(msg);
		Logger.log(this);
	}
}
