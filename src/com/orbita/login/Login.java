package com.orbita.login;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import model.TbUser;

import com.orbita.SaunaFrame;
import com.orbita.dao.Dao;

public class Login extends JFrame
{
	private JLabel userLabel;
	private JLabel passLabel;
	private JButton exit;
	private JButton login;
	private static TbUser user;
	
	public Login()
	{
		setTitle("Login");
		final JPanel panel = new LoginPanel();
		panel.setLayout(null);
		getContentPane().add(panel);
		setBounds(300, 200, panel.getWidth(), panel.getHeight());
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int screenX = screen.width / 2;
		int screenY = screen.height / 2;
		setLocation(screenX - getWidth() / 2, screenY - getHeight() / 2);
		userLabel = new JLabel();
		userLabel.setText("User Name:");
		userLabel.setBounds(150, 135, 200, 25);
		panel.add(userLabel);
		final JTextField userName = new JTextField();
		userName.setBounds(230,135,150,25);
		panel.add(userName);	
	    passLabel = new JLabel();
	    passLabel.setText("Password:");
	    passLabel.setBounds(150, 165, 200, 25);
	    panel.add(passLabel);
	    final JPasswordField userPassword = new JPasswordField();
	    userPassword.addKeyListener(new KeyAdapter()
	    {
			@Override
			public void keyPressed(final KeyEvent e)
			{
				// TODO Auto-generated method stub
				if (e.getKeyCode() == 10)
					login.doClick();
			}
	    });
		userPassword.setBounds(230, 165, 150, 25);
		panel.add(userPassword);
		login = new JButton();
		login.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(final ActionEvent e)
			{
				// TODO Auto-generated method stub
				String pwd = new String(userPassword.getPassword());
				user = Dao.getUser(userName.getText(),pwd);
				if (user.getUsername() == null || user.getUserpwd() == null)
				{	
					userName.setText(null);
					userPassword.setText(null);
					return;
				}
				setVisible(false);
				new SaunaFrame();
			}
		});
		login.setText("Login");
		login.setBounds(200, 200, 80, 25);
		panel.add(login);
		exit = new JButton();
		exit.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		exit.setText("Exit");;
		exit.setBounds(300, 200, 80, 25);
		panel.add(exit);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
	}
}
