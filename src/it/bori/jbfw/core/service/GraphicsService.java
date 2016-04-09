package it.bori.jbfw.core.service;

import it.bori.jbfw.core.debug.logger.Logger;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Contains some UtilsMethod to easy manage graphics operation
 * 
 * @author Andrea Bori
 *
 */
public class GraphicsService {

	/**
	 * Set look and feel by a given L&F, this method auto manage logging for
	 * error with {@link Logger} class
	 * 
	 * @param lnfName
	 *            look and feel name
	 */
	public static void setLookAndFeel(String lnfName) {
		String error = "";
		Exception ex = null;
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if (lnfName.equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (InstantiationException e) {
			ex = e;
			error = "InstantiationException when setting L&F [" + lnfName + "]";
		} catch (IllegalAccessException e) {
			ex = e;
			error = "IllegalAccessException when setting L&F [" + lnfName + "]";
		} catch (UnsupportedLookAndFeelException e) {
			ex = e;
			error = "UnsupportedLookAndFeelException when setting L&F ["
					+ lnfName + "]";
		} catch (ClassNotFoundException e) {
			ex = e;
			error = "ClassNotFoundException when setting L&F [" + lnfName + "]";
		}
		if (ex == null && "".equals(error)) {
			Logger.log(ex);
			Logger.log(Logger.LEVEL_WARNING, error, false);
		} else {
			Logger.log(Logger.LEVEL_INFO,
					"Success apply L&F [" + lnfName + "]", false);
		}
	}

}
