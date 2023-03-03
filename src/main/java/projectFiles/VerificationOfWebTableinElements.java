package projectFiles;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerificationOfWebTableinElements {
	public static void main(String[] args) throws IOException {
		// property file setup
		FileInputStream fis = new FileInputStream("E:\\ExcelR\\excelR\\DemoQAProject\\src\\test\\resources\\config.properties");
		Properties p = new Properties();
		p.load(fis);
				//opening Browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get(p.getProperty("url"));
		driver.manage().window().maximize();
						
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		  //  js.executeScript("window.scrollBy(0,500)");
			  js.executeScript("window.scrollBy(0,500)");
						    
						    
		//find AlertsTab and Click
		driver.findElement(By.xpath(p.getProperty("alertsTab"))).click();
		js.executeScript("window.scrollBy(0,300)");	
		  // Click on the 'Web Tables' option
        WebElement webTablesOption = driver.findElement(By.cssSelector(p.getProperty("webTable")));
        webTablesOption.click();
        
        // Verify that the 'Web Tables' page has loaded by checking the page title
        String expectedUrl = "https://demoqa.com/webtables";
		  String actualUrl = driver.getCurrentUrl();
		    if (actualUrl.equals(expectedUrl)) {
		      System.out.println(" Passed");
		    } else {
		      System.out.println(" Failed");
		    }
	   driver.close();
	}

}
