package projectFiles;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyThatUserIsAbleToLogin {
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
		    js.executeScript("window.scrollBy(0,1000)");
		    
		    
		//find books store tab and Click
		driver.findElement(By.xpath(p.getProperty("booksStoreApplication"))).click();
		  js.executeScript("window.scrollBy(0,100)");
		//find login tab and Click
		driver.findElement(By.xpath(p.getProperty("loginTabPath"))).click();
		//enter username and password
		driver.findElement(By.xpath(p.getProperty("usernamePath"))).sendKeys("Jiggs");
		driver.findElement(By.xpath(p.getProperty("passwordPath"))).sendKeys("Excelr@123456");
		driver.findElement(By.xpath(p.getProperty("loginButton"))).click();
		

        // Close the 

        driver.quit();
	}

}
