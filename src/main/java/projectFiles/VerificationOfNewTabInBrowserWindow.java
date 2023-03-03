package projectFiles;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerificationOfNewTabInBrowserWindow {
	public static void main(String[] args) throws IOException {
		// property file setup
		FileInputStream fis = new FileInputStream("E:\\ExcelR\\excelR\\DemoQAProject\\src\\test\\resources\\config.properties");
		Properties p = new Properties();
		p.load(fis);
		//opening Browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get(p.getProperty("url"));
		
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		  //  js.executeScript("window.scrollBy(0,500)");
		    js.executeScript("window.scrollBy(0,500)");
		    
		    
		//find alert tab and Click
		driver.findElement(By.xpath(p.getProperty("alertsTab"))).click();
		//find browser window and Click
		 js.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.cssSelector(p.getProperty("browserWindow"))).click();
				
			
	}

}
