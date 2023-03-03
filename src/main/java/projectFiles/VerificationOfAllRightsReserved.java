package projectFiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerificationOfAllRightsReserved {
	public static void main(String[] args) throws IOException {
		// property file setup
		FileInputStream fis = new FileInputStream("E:\\ExcelR\\excelR\\DemoQAProject\\src\\test\\resources\\config.properties");
		Properties p = new Properties();
		p.load(fis);
		//opening Browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get(p.getProperty("url"));
		 // Scroll to the bottom of the page using JavaScriptExecutor
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		// find All Rights Reserved link at bottom and click
		driver.findElement(By.xpath(p.getProperty("allRightsReserved"))).click();
		// Verify that the user is now on the All Rights Link
		String currentUrl = driver.getCurrentUrl();
		if (currentUrl.contains("/all_rights_reserved")) {
		    System.out.println("Pass");        
		} else {
		    System.out.println("Fail");        
		}           
     
		// Close the browser
		driver.quit();
	}

}
