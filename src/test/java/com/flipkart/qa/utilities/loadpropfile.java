package com.flipkart.qa.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class loadpropfile {
	
	static Properties pro;
	
	public loadpropfile() {
	
		pro = new Properties();
		File file = new File("./configuration/config.properties");
		try {
			FileInputStream fis = new FileInputStream(file);
			pro.load(fis);
		} catch (FileNotFoundException e) {
					e.printStackTrace();
		} catch (IOException e) {	
			e.printStackTrace();
		}
		}
	
	public static String geturl() {
		 return pro.getProperty("url");
	}
	
	public String getsearchinput() {
		return pro.getProperty("searchinput");
	}
	
	public static String browsername() {
		return pro.getProperty("Browsername");
	}
	
	public String emailid() {
		return pro.getProperty("Email");
	}
}
