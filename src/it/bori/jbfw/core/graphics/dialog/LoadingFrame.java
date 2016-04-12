package it.bori.jbfw.core.graphics.dialog;

import it.bori.jbfw.core.debug.logger.Logger;
import it.bori.jbfw.core.service.GraphicsService;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class LoadingFrame extends JFrame implements Runnable
{

	private JPanel contentPane;
	private JProgressBar pb_main;
	private JLabel lbl_appname;
	private JLabel lbl_version;
	private JProgressBar pb_sub;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		LoadingFrame frame = new LoadingFrame("Java Content Repository Viewer",
				"1.0.0");
		frame.setVisible(true);
		Logger.init(true);
		GraphicsService.setLookAndFeel("default");
	}

	/**
	 * Create the frame.
	 */
	public LoadingFrame(String appName, String version)
	{
		Thread t = new Thread(this);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		pb_main = new JProgressBar();
		pb_main.setStringPainted(true);
		pb_main.setMinimum(1);
		// pb_main.setIndeterminate(true);
		pb_main.setBounds(10, 224, 414, 26);
		contentPane.add(pb_main);

		lbl_appname = new JLabel(appName);
		lbl_appname.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lbl_appname.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_appname.setBounds(10, 11, 414, 56);
		contentPane.add(lbl_appname);

		lbl_version = new JLabel(version);
		lbl_version.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_version.setBounds(320, 181, 104, 14);
		contentPane.add(lbl_version);

		pb_sub = new JProgressBar();
		pb_sub.setStringPainted(true);
		pb_sub.setMinimum(1);
		// pb_sub.setIndeterminate(true);
		pb_sub.setBounds(10, 199, 414, 14);
		contentPane.add(pb_sub);
		t.start();
	}

	@Override public void run() {
		try
		{
			while (true)
			{
				if (pb_main.getValue() >= 99)
				{
					pb_main.setIndeterminate(true);
					pb_sub.setIndeterminate(true);
				}
				else
				{
					validate();
					repaint();
					pb_sub.setValue(pb_sub.getValue() + 1);
					if (pb_sub.getValue() >= 100)
					{
						pb_sub.setValue(0);
						pb_main.setValue(pb_main.getValue()
								+ new java.util.Random().nextInt(10) + 1);
					}
					try
					{
						Thread.sleep(new java.util.Random().nextInt(2) + 1);
					}
					catch (Exception e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
