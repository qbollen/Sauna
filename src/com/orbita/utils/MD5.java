package com.orbita.utils;

import java.security.MessageDigest;

public class MD5
{
	private MD5(){}
	public static String Encrypt(String text)
	{
		String s = null;
		//���ڽ��ֽ�ת��Ϊ16���Ʊ�ʾ���ַ�
		char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		try
		{
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(text.getBytes());
			byte tmp[] = md.digest();
			//ÿ���ֽ���16���Ʊ�ʾ��ʹ�������ַ�.
			char str[] = new char[16 * 2];
			int k = 0; //��ʾת�������ж�Ӧ���ַ�λ��
			for (int i = 0; i < 16; i++)
			{
				byte byte0 = tmp[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf]; //ȡ�ֽ��и�4λ������ת��
				str[k++] = hexDigits[byte0 & 0xf]; //ȡ�ֽ��е�4λ������ת��
			}
			
			s = new String(str); //ת��Ľ��ת��Ϊ�ַ���
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
