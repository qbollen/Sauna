package com.orbita;

import java.awt.EventQueue;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Toolkit;

public class Main
{

	private JFrame frame = new JFrame();
	private JMenuBar menuBar = new JMenuBar();
	private JMenu mnNewMenu = new JMenu("Setup");
	private JMenuItem mntmNewMenuItem_2 = new JMenuItem("User Manage");
	private JMenuItem mntmNewMenuItem_1 = new JMenuItem("Exit");
	private JToolBar toolBar = new JToolBar();
	private JToolBar toolBar_1 = new JToolBar();
	private JButton btnNewButton_1 = new JButton("New button");
	
	Action setupAction = new AbstractAction("Setup", new ImageIcon("png/setup.png"))
	{

		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			// TODO Auto-generated method stub
			
		}
		
	};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("png\\ico.png"));
		frame.setBounds(100, 100, 450, 300);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);//这个就是设
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setJMenuBar(menuBar);
		menuBar.add(mnNewMenu);
		mnNewMenu.add(mntmNewMenuItem_2);
		mnNewMenu.addSeparator();
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		frame.getContentPane().add(toolBar, BorderLayout.NORTH);
		toolBar.add(setupAction);		
		toolBar_1.setFloatable(false);
		frame.getContentPane().add(toolBar_1, BorderLayout.SOUTH);
		toolBar_1.add(btnNewButton_1);		
	}

}
