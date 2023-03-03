package testNG;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchingWeb {
	WebDriver driver ;
	
	@BeforeTest
	
	public void startBrowser() throws IOException {
				// property file setup
				FileInputStream fis = new FileInputStream("E:\\ExcelR\\excelR\\DemoQAProject\\src\\test\\resources\\config.properties");
				Properties p = new Properties();
				p.load(fis);
				
				WebDriverManager.chromedriver().setup();
				WebDriver driver = new ChromeDriver();
				driver.get(p.getProperty("url"));

	}
	@AfterTest
	public void closeBrowser() {
		 // Close the browser 
		 driver.quit();
		
	}
	@Test
	public void launchingWeb() {
		
		 String expectedUrl = "https://demoqa.com";
		  String actualUrl = driver.getCurrentUrl();
		    if (actualUrl.equals(expectedUrl)) {
		      System.out.println(" Passed");
		    } else {
		      System.out.println(" Failed");
		    }

	}
	
	}
	
	

	
	