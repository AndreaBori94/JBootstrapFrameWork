package it.bori.jbfw.core.webrepo;

import it.bori.jbfw.core.debug.logger.Logger;
import it.bori.jbfw.core.exception.RemoteWebRepositoryAuthenticationException;
import it.bori.jbfw.core.exception.RemoteWebRepositoryParsingException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Remote Web Repository Connector class that allow user to interact ( only view
 * and navigate ) inside a remote Java Content Repository an URL it's normally
 * builded like "http://localhost:4502/crx/server/crx.default"
 * 
 * @author Andrea Bori
 *
 */
public class RemoteWebRepository implements Serializable
{

	/**
	 * serialVersionUID used for serialization
	 */
	private static final long serialVersionUID = -4931157742995109909L;

	/**
	 * URL object composed by protocol+host+port+workspace
	 */
	private URL url;

	/**
	 * Remote Machine communicating port by default it's "4502"
	 */
	private int port;

	/**
	 * Remote Machine Host Name by default it's "localhost"
	 */
	private String host;

	/**
	 * Remote Machine Workspace by default it's "crx/server/crx.default"
	 */
	private String workspace;

	/**
	 * Navigation path, by default it's "/" it's can't go more backward than "/"
	 */
	private String navPath;

	/**
	 * Condition if it's used secured connection with HTTPS or simply HTTP
	 */
	private boolean ssl;

	/**
	 * Default constructor, connect to a remove Java Content Repository, if
	 * username and/or password are empty or null it will throw a
	 * {@link RemoteWebRepositoryAuthenticationException}
	 * 
	 * @param host
	 *            name of machine containing Java Content Repository, by default
	 *            it's "localhost"
	 * @param port
	 *            port where service it's connected, by default it's "4502"
	 * @param workspace
	 *            name of the workspace by default it's crx/server/crx.default
	 * @param user
	 *            user name used to authenticate with the remote machine
	 * @param pass
	 *            password used to authenticate with the remote machine
	 * @param ssl
	 *            boolean if it's used the SSL "HTTPS" to authenticate
	 * @throws RemoteWebRepositoryAuthenticationException
	 *             called when user name and/or password are not valid
	 */
	public RemoteWebRepository(String host, int port, String workspace,
			String user, String pass, boolean ssl)
			throws RemoteWebRepositoryAuthenticationException
	{
		Logger.log("Enstablish connection to JCR");
		Logger.log("Setting default Authenticator");
		setSSL(ssl);
		setHost(host);
		setPort(port);
		setWorkspace(workspace);
		setAuthenticator(user, pass);
		Logger.log("Remote Web Repository it's ready and listening");
	}

	/**
	 * Less specific constructor, connect to a remove Java Content Repository,
	 * if username and/or password are empty or null it will throw a
	 * {@link RemoteWebRepositoryAuthenticationException}
	 * 
	 * @param host
	 *            name of machine containing Java Content Repository, by default
	 *            it's "localhost"
	 * @param port
	 *            port where service it's connected, by default it's "4502"
	 * @param workspace
	 *            name of the workspace by default it's crx/server/crx.default
	 * @param user
	 *            user name used to authenticate with the remote machine
	 * @param pass
	 *            password used to authenticate with the remote machine
	 * @throws RemoteWebRepositoryAuthenticationException
	 *             called when user name and/or password are not valid
	 */
	public RemoteWebRepository(String host, int port, String workspace,
			String user, String pass)
			throws RemoteWebRepositoryAuthenticationException
	{
		Logger.log("Enstablish connection to JCR");
		Logger.log("Setting default Authenticator");
		setSSL(false);
		setHost(host);
		setPort(port);
		setWorkspace(workspace);
		setAuthenticator(user, pass);
		Logger.log("Remote Web Repository it's ready and listening");
	}

	/**
	 * Basic constructor, connect to a remove Java Content Repository, if
	 * username and/or password are empty or null it will throw a
	 * {@link RemoteWebRepositoryAuthenticationException}
	 * 
	 * @param host
	 *            name of machine containing Java Content Repository, by default
	 *            it's "localhost"
	 * @param workspace
	 *            name of the workspace by default it's crx/server/crx.default
	 * @param user
	 *            user name used to authenticate with the remote machine
	 * @param pass
	 *            password used to authenticate with the remote machine
	 * @throws RemoteWebRepositoryAuthenticationException
	 *             called when user name and/or password are not valid
	 */
	public RemoteWebRepository(String host, String workspace, String user,
			String pass) throws RemoteWebRepositoryAuthenticationException
	{
		Logger.log("Enstablish connection to JCR");
		Logger.log("Setting default Authenticator");
		setSSL(false);
		setHost(host);
		setPort(4502);
		setWorkspace(workspace);
		setAuthenticator(user, pass);
		Logger.log("Remote Web Repository it's ready and listening");
	}

	/**
	 * Set the connection port, not allowed less than 49152 and no more than
	 * 65535
	 * 
	 * @param port
	 *            the port number, must be between 49152 and 65535 by default
	 *            it's 4502
	 */
	private void setPort(int port) {
		if (port >= 49152 && port <= 65535)
		{
			this.port = port;
			Logger.log("Setting port " + this.port);
		}
		else
		{
			Logger.log(Logger.LEVEL_WARNING, "Trying to set port " + port
					+ " fail, set default 4502", false);
			this.port = 4502;
		}
	}

	/**
	 * Get the port number
	 * 
	 * @return the port number
	 */
	public int getPort() {
		return this.port;
	}

	/**
	 * Set what protocol use, if true use HTTPS else use HTTP
	 * 
	 * @param ssl
	 *            condition if use HTTPS or HTTP
	 */
	public void setSSL(boolean ssl) {
		if (ssl)
		{
			Logger.log("Setting secured connection");
		}
		this.ssl = ssl;
	}

	public boolean isSSL() {
		return this.ssl;
	}

	/**
	 * Set the new HOST can be (for example ) "localhost"
	 * 
	 * @param host
	 *            the new HOST
	 */
	public void setHost(String host) {
		if (host.length() > 0)
		{
			this.host = host;
			Logger.log(Logger.LEVEL_WARNING,
					"No host specified, setting \"localhost\" as default",
					false);
		}
		else
		{
			this.host = "localhost";
			Logger.log("Setting " + host + " as HOST");
		}
	}

	/**
	 * Return the host
	 * 
	 * @return the current host
	 */
	public String getHost() {
		return this.host;
	}

	/**
	 * Set the workspace, usually it's crx.default
	 * 
	 * @param workspace
	 *            the new workspace where redirect the URL pointer
	 */
	public void setWorkspace(String workspace) {
		if (workspace.length() > 0)
		{
			Logger.log("Setting workspace as " + workspace);
			this.workspace = workspace;
		}
		else
		{
			Logger.log(
					Logger.LEVEL_WARNING,
					"No workspace specified, setting \"crx.default\" as default",
					false);
			this.workspace = "crx.default";
		}
	}

	/**
	 * Get the current workspace
	 * 
	 * @return the current workspace
	 */
	public String getWorkspace() {
		return this.workspace;
	}

	/**
	 * Set a new "destination" to the Class pointer
	 * 
	 * @param path
	 *            the new path to point the pointer
	 */
	public void setPath(String path) {
		if (path.length() > 0)
		{
			if ("".equals(path))
			{
				this.navPath = "/";
			}
			else
			{
				if (!navPath.startsWith("/"))
				{
					this.navPath = "/" + path;
				}
				else
					this.navPath = path;
			}
		}
		else
			this.navPath = "/";
		Logger.log("Switch to " + path);
	}

	/**
	 * Return the path
	 * 
	 * @return String the path
	 */
	public String getPath() {
		return this.navPath;
	}

	/**
	 * Compose the URL and then return it
	 * 
	 * @return URL object with fullQualifiedPath
	 */
	public URL getUrl() {
		try
		{
			this.url = new URL(getFullQualifiedPath());
		}
		catch (Exception e)
		{
			e.printStackTrace();
			Logger.log(e);
		}
		return this.url;
	}

	/**
	 * Compose the path and return it
	 * 
	 * @return String the "fullQualifiedPath"
	 */
	public String getFullQualifiedPath() {
		String fqp = "http://";
		if (isSSL())
		{
			fqp = "https://";
		}
		fqp += getHost() + ":" + getPort() + "/crx/repository/"
				+ getWorkspace() + "/" + getPath();
		return fqp;
	}

	/**
	 * Call only internally, define the default Authentication for HTTP
	 * protocol, when opening the "url" inside a browser it will prompt a
	 * message containing "requiring user name and password" this will reply
	 * automatically, if password or username are not setted or empty
	 * {@link RemoteWebRepositoryAuthenticationException} will be triggered
	 * 
	 * @param usr
	 *            User name of repository
	 * @param pwd
	 *            Password of repository
	 * @throws RemoteWebRepositoryAuthenticationException
	 *             called when user name and/or password are not valid
	 */
	private void setAuthenticator(String usr, String pwd)
			throws RemoteWebRepositoryAuthenticationException {
		if (usr != null && pwd != null)
		{
			if (!"".equals(usr) && !"".equals(pwd))
			{
				Authenticator.setDefault(new Authenticator() {

					@Override protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(usr, pwd
								.toCharArray());
					}
				});
			}
			else
				throw new RemoteWebRepositoryAuthenticationException();
		}
		else
			throw new RemoteWebRepositoryAuthenticationException();
	}

	/**
	 * Get all node inside the specific path
	 * 
	 * @return String[] array with a list of subLink, can be empty
	 * @throws RemoteWebRepositoryParsingException
	 *             called when any error occurred while parsing and fetching
	 *             content from a given path
	 */
	public String[] getList() throws RemoteWebRepositoryParsingException {
		List<String> tagValues = new ArrayList<String>();
		boolean error = false;
		try
		{
			Pattern TAG_REGEX = Pattern.compile("<a href=\"(.+?)\"");
			Matcher matcher = TAG_REGEX.matcher(getFullQualifiedPath());
			while (matcher.find())
			{
				if (matcher.group(1).contains(getHost() + ":" + getPort()))
				{
					tagValues.add(matcher.group(1));
				}
			}
		}
		catch (Exception e)
		{
			error = true;
		}
		if (error)
			throw new RemoteWebRepositoryParsingException(
					getFullQualifiedPath());
		return tagValues.toArray(new String[0]);
	}

	/**
	 * Read and download a file to a local instance
	 * 
	 * @return boolean true if success else false
	 */
	public boolean fetchFile() {
		try
		{
			if (isFile(getFullQualifiedPath()))
			{
				if (buildLocalPath(getPath()))
				{
					String content = getContent();
					BufferedWriter out = new BufferedWriter(new FileWriter(
							getPath()));
					out.write(content);
					out.close();

				}
				else
					return false;
			}
			else
				return false;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			Logger.log(e);
		}
		return true;
	}

	/**
	 * Build inside a local instance a folder structure based on given path
	 * 
	 * @param path
	 *            path containing the folder structure
	 * @return boolean condition if success
	 */
	public boolean buildLocalPath(String path) {
		try
		{
			if (path.length() > 0)
			{
				String[] allPath = path.split("/");
				String compiledPath = "";
				for (int i = 0; i < allPath.length; i++)
				{
					compiledPath += allPath[i];
					if (isFile(compiledPath))
					{
						new File(compiledPath).createNewFile();
					}
					else
					{
						new File(compiledPath).mkdir();
					}
				}
			}
			else
			{
				if (isFile(path))
				{
					new File(path).createNewFile();
				}
				else
				{
					new File(path).mkdir();
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			Logger.log(e);
			return false;
		}
		return true;
	}

	/**
	 * Read the file content and return a string with the file content
	 * 
	 * @return String containing the file source
	 * @throws RemoteWebRepositoryParsingException
	 *             called when any error occurred while parsing and fetching
	 *             content from a given path
	 */
	public String getContent() throws RemoteWebRepositoryParsingException {
		String content = "";
		boolean error = false;
		try
		{
			BufferedReader in = new BufferedReader(new InputStreamReader(
					getUrl().openStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null)
				content += inputLine;
			in.close();

		}
		catch (Exception e)
		{
			error = true;
			return null;
		}

		if (error)
			throw new RemoteWebRepositoryParsingException(
					getFullQualifiedPath());
		return content;
	}

	/**
	 * Check from a given path, if that redirect to a source file ( if has an
	 * extension then it's a file )
	 * 
	 * @param path
	 *            the path where check this condition
	 * @return boolean true if it's a file else false
	 */
	public boolean isFile(String path) {
		String[] splitted = path.split("/");
		if (path.length() > 0)
		{
			String last = splitted[splitted.length];
			return last.lastIndexOf('.') > -1;
		}
		else
		{
			return path.lastIndexOf('.') > -1;
		}
	}

	/**
	 * Return the current deep level
	 * 
	 * @return the deep level from (0 to N)
	 */
	public int getDeepLevel() {
		return getPath().split("/").length;
	}
}
