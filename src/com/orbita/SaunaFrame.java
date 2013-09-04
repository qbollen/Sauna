package com.orbita;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import com.orbita.login.Login;

public class SaunaFrame
{
	private JFrame frame;
	private JLabel backLabel;
	public SaunaFrame()
	{
		frame = new JFrame("Sauna");
		frame.getContentPane().setBackground(new Color(170, 188, 120));
		frame.addComponentListener(new FrameListener());
		frame.getContentPane().setLayout(new BorderLayout());
		frame.setBounds(100,100,800,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		backLabel = new JLabel();	
		updateBackImage();
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
	
	private void updateBackImage()
	{
		if (backLabel != null)
		{
			int backw = frame.getWidth();
			int backh = frame.getHeight();
			backLabel.setSize(backw, backh);
			backLabel.setText("<html><body><image width='" + backw
					+ "' height='" + (backh - 110) + "' src="
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
