package testNG;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClickOnAlertsFrameWindowOption {
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
	public void CloseBrowser() {
		
		// Close the browser 
		driver.quit();
		
	}
	@Test
	public void clickOnAlerts() throws IOException {
		// property file setup
		FileInputStream fis = new FileInputStream("E:\\ExcelR\\excelR\\DemoQAProject\\src\\test\\resources\\config.properties");
		Properties p = new Properties();
		p.load(fis);
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		  //  js.executeScript("window.scrollBy(0,500)");
		    js.executeScript("window.scrollBy(0,500)");
		    
		    
		//find alert tab and Click
		driver.findElement(By.xpath(p.getProperty("alertsTab"))).click();
		
		// Verify that the user is now on the ElementTab page
       String currentUrl = driver.getCurrentUrl();
       if (currentUrl.contains("https://demoqa.com/alertsWindows")) {
           System.out.println("Pass");
       } else {
           System.out.println("Fail");
       }

		
	}


}
