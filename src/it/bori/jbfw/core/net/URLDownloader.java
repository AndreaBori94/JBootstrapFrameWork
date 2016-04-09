package it.bori.jbfw.core.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Class for easy download url from a web source
 * 
 * @author Andrea Bori
 *
 */
public class URLDownloader {

	/**
	 * URL target where point the stream
	 */
	private URL target;

	/**
	 * Default constructor, accept a string as URL
	 * 
	 * @param target
	 *            the path to web source
	 * @throws MalformedURLException
	 *             if the URL it's not properly composed
	 */
	public URLDownloader(String target) throws MalformedURLException {
		this.target = new URL(target);
	}

	/**
	 * Get the URL object
	 * 
	 * @return the URL object
	 */
	public URL getTarget() {
		return this.target;
	}

	/**
	 * Parse the url and put his content inside a string then return it
	 * 
	 * @return String with all content of the url
	 * @throws IOException
	 *             if parsing it's interrupted
	 */
	public String downloadContent() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(
				getTarget().openStream()));
		String content = "";
		String inputLine;
		while ((inputLine = in.readLine()) != null)
			content += inputLine;
		in.close();
		return content;
	}
}
