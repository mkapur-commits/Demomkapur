package com.crm.qa.testbase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	
	public TestBase() throws IOException {
		
		prop = new Properties();
		
		FileInputStream fp;

			fp = new FileInputStream("C://Users//Meenu//eclipse-workspace//FreeCRMProject//src//main//java//com//qa//crm//configproperty//config.properties");
			prop.load(fp);
		
			}
		

	
      @Test
		public static void initialization(){
		String browsername = prop.getProperty("browser");
		if (browsername.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C://Users//Meenu//Desktop//drivers//chromedriver//chromedriver.exe");
			driver=new ChromeDriver();
		}
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
		
		
		
		
	}
	

}
