package com.orbita;

public class Device
{
	public native boolean initEncoder(boolean beep);
	
	public native boolean exitEncoder();
	
	public native boolean writeAllData(String[] data);
	
	public native String readAllData();
	
	public native boolean writeFlagBlockData(String[] data);
	
	public native String readFlagBlockData();
	
	//≤‚ ‘∑Ω∑®
	public native boolean TestFunc();
	
	static
	{
		System.loadLibrary("MediumDll");
	}
	
	/*public static void main(String[] args)
	{
		Device device = new Device();
		device.initEncoder(true);jj
		String[] tmp = new String[48];
		for (int i = 0; i < 48; i++)
			tmp[i] = "11";
		
		tmp[44] = "01";
		tmp[45] = "01";
		tmp[46] = "02";
		tmp[47] = "05";
				
		//device.writeAllData(tmp);
		
		String[] data = new String[16];
		for (int i = 0; i < 16; i++)
			data[i] = "01";
		
		data[12] = "01";
		data[13] = "01";
		data[14] = "02";
		data[15] = "05";
		
		//device.writeFlagBlockData(data);
		
		//String j = device.readAllData();
		
		String z = device.readFlagBlockData();
		
		device.exitEncoder();
	}*/
}
