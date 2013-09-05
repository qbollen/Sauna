package com.orbita.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Dao
{
	protected static String dbClassName = null;
	protected static String dbUrl = null;
	protected static String dbUser = null;
	protected static String dbPwd = null;
	public static Connection conn = null;
	private Dao(){}
	static
	{
		try
		{
			if (conn == null)
			{
				Properties prop = new Properties();
				prop.load(new FileInputStream("config.ini"));
				dbClassName = prop.getProperty("ClassName");
				dbUrl = prop.getProperty("Url");
				dbUser = prop.getProperty("User");
				dbPwd = prop.getProperty("Pwd");
				Class.forName(dbClassName);
				conn = DriverManager.getConnection(dbUrl, dbUser, dbPwd);
			}
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
	}
	
	/**
	 * read all users
	 */
	//public static 
}
