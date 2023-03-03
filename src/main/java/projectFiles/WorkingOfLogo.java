package projectFiles;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingOfLogo {
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
				// click on logo
				driver.findElement(By.xpath(p.getProperty("logoPath"))).click();
				//check
				String currentUrl = driver.getCurrentUrl();
		        if (currentUrl.contains("https://demoqa.com")) {
		            System.out.println("Pass");
		        } else {
		            System.out.println("Fail");
		        }
				
		        // close browser
		        driver.close();
				
				
				
				
				
	}

}
