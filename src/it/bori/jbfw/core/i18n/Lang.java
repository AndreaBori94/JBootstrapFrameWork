package it.bori.jbfw.core.i18n;

import it.bori.jbfw.core.exception.LangNotFoundException;
import it.bori.jbfw.core.exception.WordNotFoundException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Properties;

/**
 * Language object, contains information about single languages file has method
 * for retrieve language word
 * 
 * @author Andrea Bori
 *
 */
public class Lang implements Serializable
{

	/**
	 * serialVersionUID used for serialization
	 */
	private static final long serialVersionUID = -4161483547578444712L;

	/**
	 * Languages name, can be "it" or "it-IT" for example
	 */
	private String lang;

	/**
	 * languages resource where file it's stored ( do not include extension, and
	 * extension must be "i18n" else it will throw {@link LangNotFoundException}
	 * )
	 */
	private String langSource;

	/**
	 * {@link Properties} object containing all the key with respective
	 * languages value
	 */
	private Properties langList;

	/**
	 * Default constructor of the class, require the languages name and it's
	 * source. DO NOT INCLUDE THE EXTENSION inside the langsFile the file MUST
	 * have as extension the "i18n"
	 * 
	 * @param lang
	 *            the name of the languages, as example "it" or "it-IT"
	 * @param source
	 *            the source path where the languages content it's stored, do
	 *            not include extension, it's must have as extension "i18n"
	 * @throws LangNotFoundException
	 *             throw it if not languages where found at given path
	 * @throws IOException
	 *             in case parsing is interrupted or something whent wrong
	 */
	public Lang(String lang, String source) throws LangNotFoundException,
			IOException
	{
		this.lang = lang;
		this.langSource = source + "lang.i18n";
		if (!new File(this.langSource).exists())
			throw new LangNotFoundException(this.lang);

		this.langList = new Properties();
		this.langList.load(new FileInputStream(source));
	}

	/**
	 * Get a requested word by a given key
	 * 
	 * @param word
	 *            the requested word, it's a "key" stored inside the file (
	 *            unique for all languages with a differed value for each
	 *            languages )
	 * @return the String represented the word founded
	 * @throws WordNotFoundException
	 *             throw it in case it's not found the requested word
	 */
	public String getWord(String word) throws WordNotFoundException {
		String w = this.langList.getProperty(word);
		if (w == null)
		{
			throw new WordNotFoundException(this.lang, w);
		}
		else
			return w;
	}

	/**
	 * Get the name of the language
	 * 
	 * @return String name of lang, can be "it" or "it-IT" for example
	 */
	public String getName() {
		return this.lang;
	}

	/**
	 * Get the path of the file do not include extension, extension MUST be
	 * "i18n"
	 * 
	 * @return the source path without extension
	 */
	public String getPath() {
		return this.langSource;
	}
}
