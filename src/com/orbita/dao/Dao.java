package com.orbita.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import model.TbUser;

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

	
	public static ResultSet findForResultSet(String sql)
	{
		if (conn == null)
			return null;
		ResultSet rs = null;
		try
		{
			Statement stmt = null;
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(sql);
		}
		catch( Exception e)
		{
			e.printStackTrace();
		}
		
		return rs;
	}
	
	/**
	 * read user data
	 */
	public static TbUser getUser(String username, String userpwd)
	{
		TbUser user = new TbUser();
		ResultSet rs = findForResultSet("select * from users where username='" + username + "'");
		try
		{
			if (rs.next())
			{
				user.setUsername(username);
				user.setUserpwd(rs.getString("userpwd"));
				if (user.getUserpwd().equals(userpwd))
				{
					user.setId(rs.getInt("Id"));
					user.setUname(rs.getString("uname"));
					user.setAuthority(rs.getString("authority"));
				}
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return user;
	}
}
