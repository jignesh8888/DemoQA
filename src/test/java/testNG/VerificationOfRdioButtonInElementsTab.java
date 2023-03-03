package testNG;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerificationOfRdioButtonInElementsTab {
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
	public void radioButton() throws IOException, InterruptedException {
		// property file setup
		FileInputStream fis = new FileInputStream("E:\\ExcelR\\excelR\\DemoQAProject\\src\\test\\resources\\config.properties");
		Properties p = new Properties();
		p.load(fis);
		
				JavascriptExecutor js = (JavascriptExecutor) driver;
				//  js.executeScript("window.scrollBy(0,500)");
				js.executeScript("window.scrollBy(0,500)");
				    
				    
				//find ElementTab and Click
				driver.findElement(By.xpath(p.getProperty("elementTab"))).click();
		
				// Click on the Radio Button option
				WebElement radioButtonOption = driver.findElement(By.xpath(p.getProperty("radioButton")));
				radioButtonOption.click();

				// Select the Yes radio button
				WebElement yesRadioButton = driver.findElement(By.xpath(p.getProperty("yesButton")));
				yesRadioButton.click();

				// Select the Impressive radio button
				WebElement impressiveRadioButton = driver.findElement(By.xpath(p.getProperty("impressiveButton")));
				impressiveRadioButton.click();


				// Deselect the Yes radio button
				yesRadioButton.click();


				// Deselect the Impressive radio button
				impressiveRadioButton.click();



	}

}
