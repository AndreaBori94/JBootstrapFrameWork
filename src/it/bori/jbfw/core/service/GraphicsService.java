package it.bori.jbfw.core.service;

import java.awt.Toolkit;

import it.bori.jbfw.core.debug.logger.Logger;
import it.bori.jbfw.core.graphics.geometrix.vector.Vector2d;
import it.bori.jbfw.core.graphics.geometrix.vector.Vector2i;

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

	/**
	 * Return a {@link Vector2i} object contains Width and Height of screen use
	 * {@link Vector2i#getX()} and {@link Vector2i#getY()} to get respective
	 * value
	 * 
	 * @return {@link Vector2i} object with x as Width and Y as Height
	 */
	public Vector2i getScreenSize() {
		Vector2i v = new Vector2i(0, 0);
		v.setX((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth());
		v.setY((int) Toolkit.getDefaultToolkit().getScreenSize().getHeight());
		return v;
	}

	/**
	 * Return a {@link Vector2i} object contains Width and Height in half of the
	 * screen. use {@link Vector2i#getX()} and {@link Vector2i#getY()} to get
	 * respective value
	 * 
	 * @return {@link Vector2i} object with x as Width and Y as Height
	 */
	public Vector2i getHalfScreenSize() {
		Vector2i v = new Vector2i(0, 0);
		v.setX((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2);
		v.setY((int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2);
		return v;
	}

	/**
	 * Return a {@link Vector2d} object contains center coordinate for an object
	 * inside a given space
	 * 
	 * @param sizeX
	 *            the X size of the container
	 * @param sizeY
	 *            the Y size of the container
	 * @param width
	 *            the width of the object
	 * @param height
	 *            the height of the object
	 * @return a Vector2d width right coordinate
	 */
	public Vector2d calcMiddlePosition(int sizeX, int sizeY, int width,
			int height) {
		return new Vector2d((sizeX / 2) - (width / 2), (sizeY / 2)
				- (height / 2));
	}

}
