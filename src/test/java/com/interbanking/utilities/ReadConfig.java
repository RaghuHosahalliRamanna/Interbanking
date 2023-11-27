package com.interbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig()
	{
		File src = new File("./Configuration/Config.properties");
		try
		{
			FileInputStream fis=new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}catch(Exception e)
		{
		System.out.println("Exception is "+ e.getMessage());
		}
	}
	
	public String getAppUrl()
	{
		 String url = pro.getProperty("BaseURL");
		 return url;
	}
	
	public String UserID()
	{
		String username = pro.getProperty("UserID");
		return username;
	}
	
	public String password()
	{
		String pwd = pro.getProperty("Password");
		return pwd;
	}
	
}
