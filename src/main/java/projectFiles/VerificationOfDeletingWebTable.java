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

public class VerificationOfDeletingWebTable {
	public static void main(String[] args) throws IOException, InterruptedException {
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
				    
		//find ElementTab and Click
		driver.findElement(By.xpath(p.getProperty("elementTab"))).click();
		// Click on the 'Web Tables' option
        WebElement webTablesOption = driver.findElement(By.xpath(p.getProperty("webTable")));
        webTablesOption.click();
        //wait for browser to load
        Thread.sleep(1000);
        //click on delete any data
        driver.findElement(By.xpath(p.getProperty("deleteButton"))).click();
        // close browser
        driver.quit();
        
        
        
	}

}
