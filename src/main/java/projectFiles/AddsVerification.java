package projectFiles;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddsVerification {
	public static void main(String[] args) throws IOException {
		// property file setup
		FileInputStream fis = new FileInputStream("E:\\ExcelR\\excelR\\DemoQAProject\\src\\test\\resources\\config.properties");
		Properties p = new Properties();
		p.load(fis);
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get(p.getProperty("url"));
		driver.findElement(By.xpath(p.getProperty("addPath"))).click();
	  	 String expectedUrl = p.getProperty("addExpUrl");
	  	 String actualUrl = driver.getCurrentUrl();
	  	    if (actualUrl.equals(expectedUrl)) {
	  	      System.out.println(" Passed");
	  	    } else {
	  	      System.out.println(" Failed");
	  	    }
	    driver.close();
	}

}
