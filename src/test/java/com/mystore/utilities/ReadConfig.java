package com.mystore.utilities;

import java.io.FileInputStream;

import java.util.Properties;

public class ReadConfig 
{
	Properties properties;
	String path="C:\\Users\\REDDY\\AutomationWebProgrammingWorkSpace\\MyStoreV2\\Configuration\\config.properties";
	public ReadConfig()
	{
		
		try {
			properties=new Properties();
			FileInputStream fis=new FileInputStream(path);
			properties.load(fis);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	public String getBaseurl()
	{
		String value=properties.getProperty("baseurl");
		if(value!=null)
		{
		return value;
		}
		else
		{
			throw new RuntimeException("url not specified in config file");
		}
	}
	public String getBrowser()
	{
		String value=properties.getProperty("browser");
		if(value!=null)
		{
		return value;
		}
		else
		{
			throw new RuntimeException("browser not specified in config file");
		}
	}

}
