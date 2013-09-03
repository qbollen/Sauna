package com.orbita;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener
{
	private JPanel plArea = new JPanel();
	private JPanel plInput = new JPanel();
	private JPanel plButton = new JPanel();
	private JLabel lbUserName = new JLabel("User Name:");
	private JLabel lbPassword = new JLabel("Password:");
	private JTextField tfUserName = new JTextField();
	private JTextField tfPassword = new JTextField();
	private JButton bnLogin = new JButton("Login");
	private JButton bnClose = new JButton("Close");

	public Login()
	{
		this.addListener();
		initFrame();
	}
	
	public void addListener()
	{
		this.bnLogin.addActionListener(this);
		this.bnClose.addActionListener(this);
	}
	
	public void initFrame()
	{
		this.plArea.setLayout(null);
		this.plInput.setLayout(null);
		this.plButton.setLayout(null);
		
		this.lbUserName.setBounds(10, 10, 110, 25);
		this.plInput.add(lbUserName);
		
		this.lbPassword.setBounds(10, 50, 110, 25);
		this.plInput.add(lbPassword);
		
		this.tfUserName.setBounds(90, 10, 130, 25);
		this.plInput.add(tfUserName);
		
		this.tfPassword.setBounds(90, 50, 130, 25);
		this.plInput.add(tfPassword);
		
		this.plInput.setBounds(80, 30, 300, 80);
		
		this.plArea.add(plInput);
		
		this.bnLogin.setBounds(10,10, 90, 25);
		this.plButton.add(bnLogin);
		
		this.bnClose.setBounds(130,10, 90, 25);
		this.plButton.add(bnClose);
		
		this.plButton.setBounds(80,130, 300,50);
		
		this.plArea.add(plButton);
		
		this.add(plArea);
		
		this.setTitle("Login");
		Image image = new ImageIcon("ico.png").getImage();
		this.setIconImage(image);
		this.setResizable(false);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int centerX = screenSize.width / 2;
		int centerY = screenSize.height / 2;
		int width = 400;
		int height = 250;
		this.setBounds(centerX-width/2, centerY-height/2, width, height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.tfUserName.requestFocus(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		if (e.getSource() == this.bnLogin)
		{
			
		}
		else if(e.getSource() == this.bnClose)
		{
			System.exit(0);
		}
	}
	
	public static void main(String[] args)
	{
		new Login();
	}
	
}
