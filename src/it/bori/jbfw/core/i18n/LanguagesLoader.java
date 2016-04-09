package it.bori.jbfw.core.i18n;

import it.bori.jbfw.core.exception.LangNotFoundException;
import it.bori.jbfw.core.exception.UnmatchedLanguagesException;
import it.bori.jbfw.core.exception.WordNotFoundException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class used for manage i18n languages
 * 
 * @author Andrea Bori
 *
 */
public class LanguagesLoader {

	/**
	 * Contains a list of languages available
	 */
	private static List<Lang> langs = new ArrayList<Lang>();

	/**
	 * Load a list of languages from a langFile
	 * 
	 * @param langsFile
	 *            the source of languages file where all languages are stored
	 * @throws LangNotFoundException
	 *             throw in case of one languages cannot be found
	 * @throws IOException
	 *             throw when something with parsing went wrong, like
	 *             interrupted
	 */
	public static void loadLang(String langsFile) throws LangNotFoundException,
			IOException {
		BufferedReader reader = new BufferedReader(new FileReader(langsFile));
		List<Lang> langs = new ArrayList<Lang>();
		String line = "";

		while ((line = reader.readLine()) != null) {
			String langPath;
			String langName;
			if (line.contains("[langName]")) {
				line = line.replace("[langName]", "").trim();
				langPath = line;
				langName = langPath.split("/")[0];
				langs.add(new Lang(langName, langPath));
			}
		}
		reader.close();
		LanguagesLoader.langs = langs;
	}

	/**
	 * Validate all languages, if one or more languages fail the match, it will
	 * throw {@link UnmatchedLanguagesException}
	 * 
	 * @throws UnmatchedLanguagesException
	 *             in case of one or more languages fail the matching test
	 *             between theme self
	 */
	public static void validateLanguages() throws UnmatchedLanguagesException {
		Lang[] allLang = langs.toArray(new Lang[0]);
		int size = -1;
		List<String> failList = new ArrayList<String>();
		for (int i = 0; i < allLang.length; i++) {
			try {
				String current = allLang[i].getPath() + ".i18n";
				BufferedReader br = new BufferedReader(new FileReader(current));
				int currentSize = 0;
				String line = "";
				while ((line = br.readLine()) != null) {
					if (!line.isEmpty()) {
						currentSize++;
					}
				}
				br.close();
				if (size == -1) {
					size = currentSize;
				} else {
					if (currentSize != size) {
						failList.add(allLang[i].getName());
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (failList.size() != 0) {
				String allFail = "";
				for (int j = 0; j < failList.size(); j++) {
					allFail += failList.get(i) + " ";
				}
				throw new UnmatchedLanguagesException(allFail.trim());
			}
		}
	}

	/**
	 * Get a specific languages, if no languages where found it will thrown
	 * {@link LangNotFoundException}
	 * 
	 * @param langName
	 *            the name of the requested ( and registered ) language
	 * @return Language object
	 * @throws LangNotFoundException
	 *             throw it in case of languages not found inside the registry
	 */
	public static Lang getLang(String langName) throws LangNotFoundException {
		int point = -1;
		for (int i = 0; i < LanguagesLoader.langs.size(); i++) {
			if (langName.equals(LanguagesLoader.langs.get(i))) {
				point = i;
			}
		}
		if (point > -1) {
			return LanguagesLoader.langs.get(point);
		} else
			throw new LangNotFoundException(langName);
	}

	/**
	 * Fast access to a word from the {@link LanguagesLoader} class, require
	 * directly the langName that used for call
	 * {@link LanguagesLoader#getLang(String)} and then the word that will be
	 * used to call the {@link LanguagesLoader#getWord(String, String)} method
	 * and retrieve the word corresponding to the {@link Lang} required
	 * 
	 * @param lang
	 *            languages name ( example: "it" or "it-IT"
	 * @param word
	 *            the requested word
	 * @return String the corresponding word the the requested languages
	 * @throws WordNotFoundException
	 *             throw in case of no word found inside given languages
	 * @throws LangNotFoundException
	 *             throw in case of no languages found inside registry
	 */
	public static String getWord(String lang, String word)
			throws WordNotFoundException, LangNotFoundException {
		return getLang(lang).getWord(word);
	}

}