package com.orbita;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import com.orbita.login.Login;

public class SaunaFrame
{
	//private JDesktopPane desktopPane;
	private JFrame frame;
	private JLabel backLabel;
	private JToolBar toolBar;
	public SaunaFrame()
	{
		frame = new JFrame("Sauna");
		Image image = new ImageIcon("res/ico.png").getImage();
		frame.setIconImage(image);
		frame.getContentPane().setBackground(new Color(170, 188, 120));
		frame.addComponentListener(new FrameListener());
		frame.getContentPane().setLayout(new BorderLayout());
		frame.setBounds(100,100,800,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		toolBar = new JToolBar();
		toolBar.setBackground(new Color(170, 188, 120));
		toolBar.setBorder(new LineBorder(new Color(170, 188, 120)));

		toolBar.add(createFrameButton("Setup", "Setup"));
		
		frame.getContentPane().add(toolBar,BorderLayout.NORTH);
		
		backLabel = new JLabel();
		backLabel.setVerticalAlignment(SwingConstants.TOP);
		backLabel.setHorizontalAlignment(SwingConstants.CENTER);
		updateBackImage();
		//desktopPane = new JDesktopPane();
		//desktopPane.add(backLabel, new Integer(Integer.MIN_VALUE));
		//frame.getContentPane().add(desktopPane);
		frame.getContentPane().add(backLabel);
		frame.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				// TODO Auto-generated method stub
				new Login();
			}			
		});
	}
	
	private JButton createFrameButton(String fName, String cname)
	{
		String path = "res/ActionIcon/";
		String imgUrl = path + fName + ".png";
		String imgUrl_roll = path + fName + "_roll.png";
		String imgUrl_down = path + fName + "_down.png";
		Icon icon = new ImageIcon(imgUrl);
		Icon icon_roll = null;
		if (imgUrl_roll != null)
			icon_roll = new ImageIcon(imgUrl_roll);
		Icon icon_down = null;
		if (imgUrl_down != null)
			icon_down = new ImageIcon(imgUrl_down);
		Action action = new OpenFrameAction(fName, cname, icon);
		JButton button = new JButton(action);
		button.setMargin(new Insets(0, 0, 0, 0));
		button.setHideActionText(true);
		button.setFocusPainted(false);
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
		if (icon_roll != null)
			button.setRolloverIcon(icon_roll);
		if (icon_down != null)
			button.setPressedIcon(icon_down);
		return button;
	}
	
	protected final class OpenFrameAction extends AbstractAction
	{
		private String frameName = null;
		private OpenFrameAction()
		{
			
		}
		
		public OpenFrameAction(String cname, String frameName, Icon icon)
		{
			this.frameName = frameName;
			putValue(Action.NAME, cname);
			putValue(Action.SHORT_DESCRIPTION, cname);
			putValue(Action.SMALL_ICON, icon);
		}
		
		@Override
		public void actionPerformed(final ActionEvent e)
		{
			// TODO Auto-generated method stub
			
			
		}
		
	}
	
	private void updateBackImage()
	{
		if (backLabel != null)
		{
			int backw = frame.getWidth();
			int backh = frame.getHeight();
			backLabel.setSize(backw, backh);
			backLabel.setText("<html><body><img width='" + backw
					+ "' height='" + (backh - 90) + "' src="
					+ SaunaFrame.this.getClass().getResource("welcome.jpg")
					+ "'></img></body></html>");
		}
			
	}
	
	private final class FrameListener extends ComponentAdapter
	{
		@Override
		public void componentResized(ComponentEvent e)
		{
			// TODO Auto-generated method stub
			updateBackImage();
		}	
	}
}
