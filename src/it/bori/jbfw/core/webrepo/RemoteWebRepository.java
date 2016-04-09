package it.bori.jbfw.core.webrepo;

import it.bori.jbfw.core.debug.logger.Logger;
import it.bori.jbfw.core.exception.RemoteWebRepositoryAuthenticationException;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URL;

//http://localhost:4502/crx/server/crx.default
public class RemoteWebRepository {

	/**
	 * URL object composed by protocoll+host+port+workspace
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
	 * Default constructor, connect to a remove Java Content Repository
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
	 */
	public RemoteWebRepository(String host, int port, String workspace,
			String user, String pass, boolean ssl) {
		Logger.log("Enstablish connection to JCR");
		Logger.log("Setting default Authenticator");
		setSSL(ssl);
		setHost(host);
		setPort(port);
		setWorkspace(workspace);
		setAuthenticator(user, pass);
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
		if (port >= 49152 && port <= 65535) {
			this.port = port;
			Logger.log("Setting port " + this.port);
		} else {
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
		if (ssl) {
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
		if (host.length() > 0) {
			this.host = host;
		} else
			this.host = "localhost";
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
		if (workspace.length() > 0) {
			this.workspace = workspace;
		} else
			this.workspace = "crx.default";
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
		if (path.length() > 0) {
			if ("".equals(path)) {
				this.navPath = "/";
			} else {
				if (!navPath.startsWith("/")) {
					this.navPath = "/" + path;
				} else
					this.navPath = path;
			}
		} else
			this.navPath = "/";
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
		try {
			this.url = new URL(getFullQualifiedPath());
		} catch (Exception e) {
			e.printStackTrace();
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
		if (isSSL()) {
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
		if (usr != null && pwd != null) {
			if (!"".equals(usr) && !"".equals(pwd)) {
				Authenticator.setDefault(new Authenticator() {
					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(usr, pwd
								.toCharArray());
					}
				});
			} else
				throw new RemoteWebRepositoryAuthenticationException();
		} else
			throw new RemoteWebRepositoryAuthenticationException();
	}
}
