package it.bori.jbfw.core.graphics.dialog;

import javax.swing.JOptionPane;

/**
 * Dialog manager, allow easy and fast deploy of jDialog
 * 
 * @author Andrea Bori
 *
 */
public class DialogManager {

	/**
	 * Allow user to reply OK or ABORT
	 */
	public static int OPTION_OK_ABORT = JOptionPane.CANCEL_OPTION;
	/**
	 * Allow user to reply OK
	 */
	public static int OPTION_OK = JOptionPane.CLOSED_OPTION;
	/**
	 * Allow user to reply YES or NO
	 */
	public static int OPTION_YES_NO = JOptionPane.OK_OPTION;
	/**
	 * Allow user to reply YES, NO or CANCEL
	 */
	public static int OPTION_YES_NO_CANCEL = JOptionPane.YES_NO_CANCEL_OPTION;

	/**
	 * Show an error icon
	 */
	public static int TYPE_ERROR = JOptionPane.ERROR_MESSAGE;
	/**
	 * Show an information icon
	 */
	public static int TYPE_INFORMATION = JOptionPane.INFORMATION_MESSAGE;
	/**
	 * Show a plain dialog icon
	 */
	public static int TYPE_PLAIN = JOptionPane.PLAIN_MESSAGE;
	/**
	 * Show a question mark icon
	 */
	public static int TYPE_QUESTION = JOptionPane.QUESTION_MESSAGE;
	/**
	 * Show a warning icon
	 */
	public static int TYPE_WARNING = JOptionPane.WARNING_MESSAGE;

	/**
	 * Generic call, simply show a dialog to user with custom preference
	 * 
	 * @param msg
	 *            content of dialog
	 * @param title
	 *            title of dialog
	 * @param optionType
	 *            option type see class constant OPTION_*
	 * @param messageType
	 *            type, see class constant TYPE_*
	 * @return Integer the user choice
	 */
	public static int show(String msg, String title, int optionType,
			int messageType) {
		return JOptionPane.showConfirmDialog(null, msg, title, optionType,
				messageType);
	}

	/**
	 * Warning call, simply show a dialog to user with automated custom
	 * preference
	 * 
	 * @param message
	 *            content of dialog
	 * @param title
	 *            title of dialog
	 * @param action
	 *            option type see class constant OPTION_*
	 * @return Integer the user choice
	 */
	public static int warning(String title, String message, int action) {
		return JOptionPane.showConfirmDialog(null, message, title, action,
				TYPE_WARNING);
	}

	/**
	 * Error call, simply show a dialog to user with automated custom preference
	 * 
	 * @param message
	 *            content of dialog
	 * @param title
	 *            title of dialog
	 * @param action
	 *            option type see class constant OPTION_*
	 * @return Integer the user choice
	 */
	public static int error(String title, String message, int action) {
		return JOptionPane.showConfirmDialog(null, message, title, action,
				TYPE_ERROR);
	}

	/**
	 * Information call, simply show a dialog to user with automated custom
	 * preference
	 * 
	 * @param message
	 *            content of dialog
	 * @param title
	 *            title of dialog
	 * @param action
	 *            option type see class constant OPTION_*
	 * @return Integer the user choice
	 */
	public static int inform(String title, String message, int action) {
		return JOptionPane.showConfirmDialog(null, message, title, action,
				TYPE_INFORMATION);
	}

	/**
	 * Plain Dialog call, simply show a dialog to user with automated custom
	 * preference
	 * 
	 * @param message
	 *            content of dialog
	 * @param title
	 *            title of dialog
	 * @param action
	 *            option type see class constant OPTION_*
	 * @return Integer the user choice
	 */
	public static int says(String title, String message, int action) {
		return JOptionPane.showConfirmDialog(null, message, title, action,
				TYPE_PLAIN);
	}

	/**
	 * Question call, simply show a dialog to user with automated custom
	 * preference
	 * 
	 * @param message
	 *            content of dialog
	 * @param title
	 *            title of dialog
	 * @param action
	 *            option type see class constant OPTION_*
	 * @return Integer the user choice
	 */
	public static int ask(String title, String message, int action) {
		return JOptionPane.showConfirmDialog(null, message, title, action,
				TYPE_QUESTION);
	}
}
