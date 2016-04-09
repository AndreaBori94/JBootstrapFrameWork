package it.bori.jbfw.core.debug.logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

/**
 * Logger Class, simply manage the "out printing logging"
 * 
 * @author Andrea Bori
 *
 */
public class Logger {
	/**
	 * Use this, to "define" a simply info to userAdmin
	 */
	public static final int LEVEL_INFO = 0;
	/**
	 * Use this, to "define" a potential error, or simply a warning
	 */
	public static final int LEVEL_WARNING = 1;
	/**
	 * Use this, to "define" an error
	 */
	public static final int LEVEL_ERROR = 2;

	/**
	 * Used inside Logger to check if application has call init method or not
	 */
	private static boolean initialized = false;

	/**
	 * Contains how many times the specified LogLevel has been called, when
	 * application "die", it's print all this information
	 */
	private static int[] LEVEL_CALLED = { 0, 0, 0, 0 };

	/**
	 * Object containing the output pointer
	 */
	private static File source;
	/**
	 * Object used to write log inside the source
	 */
	private static BufferedWriter writer;

	/**
	 * Initialize the Logger class, with append condition
	 * 
	 * @param append
	 *            boolean if append or not, if not it will create a new file
	 *            with an incremental name convention
	 */
	public static void init(boolean append) {
		int fileID = 0;
		if (!append) {
			while (true) {
				if (new File("output_err_" + fileID + ".log").exists()) {
					fileID++;
				} else {
					break;
				}
			}
		}
		Logger.source = new File("output_err_" + fileID + ".log");
		try {
			Logger.writer = new BufferedWriter(new FileWriter(Logger.source,
					true));
		} catch (IOException e) {
			Logger.showMessage("Console", "Logger Class Failure.",
					Logger.LEVEL_ERROR);
			e.printStackTrace();
			System.exit(1);
		}
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			@Override
			public void run() {
				Logger.log(Logger.LEVEL_INFO, "INF: " + LEVEL_CALLED[0], false);
				Logger.log(Logger.LEVEL_INFO, "WAR: " + LEVEL_CALLED[1], false);
				Logger.log(Logger.LEVEL_INFO, "ERR: " + LEVEL_CALLED[2], false);
				Logger.log(Logger.LEVEL_INFO, "UND: " + LEVEL_CALLED[3], false);
				Logger.log(Logger.LEVEL_INFO, "Application Terminating", false);
			}
		}));
		Logger.log(Logger.LEVEL_INFO, "Application Starting", false);
		Logger.log(Logger.LEVEL_INFO, "Registered: LOG STREAM", false);
		Logger.log(Logger.LEVEL_INFO, "Registered: " + fileID + " Files", false);
		Logger.log(Logger.LEVEL_INFO, "Registered: Shutdown Hook", false);
		Logger.log(Logger.LEVEL_INFO, "Application ready to start setup", false);
		Logger.initialized = true;
	}

	/**
	 * Show message to user, using JOptionPane.showMessageDialog() method
	 * 
	 * @param title
	 *            title of message
	 * @param content
	 *            content of message
	 * @param Level
	 *            level of error see constant class
	 */
	public static void showMessage(String title, String content, int Level) {
		int status = JOptionPane.INFORMATION_MESSAGE;
		if (Level == Logger.LEVEL_ERROR) {
			status = JOptionPane.ERROR_MESSAGE;
		} else if (Level == Logger.LEVEL_INFO) {
			status = JOptionPane.INFORMATION_MESSAGE;
		} else if (Level == Logger.LEVEL_WARNING) {
			status = JOptionPane.WARNING_MESSAGE;
		}
		JOptionPane.showMessageDialog(null, content, title, status);
	}

	/**
	 * Write log inside the output file, and if requested, alert user with a
	 * message
	 * 
	 * @param status
	 *            kind of error, use Class Constant
	 * @param message
	 *            Kind of "message" need to be reported
	 * @param report
	 *            boolean, if report to user
	 */
	public static void log(int status, String message, boolean report) {
		if (!Logger.initialized) {
			return;
		}

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String composedMessage = dateFormat.format(date) + " ";
		try {
			switch (status) {
			case 0: {
				composedMessage += "*INF*";
				Logger.LEVEL_CALLED[status]++;
				break;
			}
			case 1: {
				composedMessage += "*WAR*";
				Logger.LEVEL_CALLED[status]++;
				break;
			}
			case 2: {
				composedMessage += "*ERR*";
				Logger.LEVEL_CALLED[status]++;
				break;
			}
			default: {
				composedMessage += "*UND*";
				Logger.LEVEL_CALLED[4]++;
			}
			}
			composedMessage += " " + message;
			Logger.writer.write(composedMessage);
			Logger.writer.newLine();
			Logger.writer.flush();
			if (report) {
				showMessage("Console Logger Report:", message, status);
			}
		} catch (Exception e) {
			Logger.showMessage("Console", "Logger Class Failure.",
					Logger.LEVEL_ERROR);
			e.printStackTrace();
			System.exit(1);
		}
	}

	/**
	 * Simply log a message with INFO status and don't report with dialog to
	 * user.
	 * 
	 * @param message
	 *            content of message to write inside output
	 */
	public static void log(String message) {
		Logger.log(LEVEL_INFO, message, false);
	}

	/**
	 * Simply out printing exception, getting message and title from exception
	 * 
	 * @param e
	 *            exception to caught
	 */
	public static void log(Exception e) {
		Logger.log(Logger.LEVEL_ERROR, e.getMessage(), false);
	}
}
