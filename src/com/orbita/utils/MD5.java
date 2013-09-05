package com.orbita.utils;

import java.security.MessageDigest;

public class MD5
{
	private MD5(){}
	public static String Encrypt(String text)
	{
		String s = null;
		//用于将字节转换为16进制表示的字符
		char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		try
		{
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(text.getBytes());
			byte tmp[] = md.digest();
			//每个字节用16进制表示，使用两个字符.
			char str[] = new char[16 * 2];
			int k = 0; //表示转换后结果中对应的字符位置
			for (int i = 0; i < 16; i++)
			{
				byte byte0 = tmp[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf]; //取字节中高4位的数字转换
				str[k++] = hexDigits[byte0 & 0xf]; //取字节中低4位的数字转换
			}
			
			s = new String(str); //转后的结果转换为字符串
		}
		catch (Exception ee)
		{
			ee.printStackTrace();
		}	
		return s;
	}
	
	public static boolean Verify(String text, String md5)
	{
		return Encrypt(text).equals(md5);
	}
}
