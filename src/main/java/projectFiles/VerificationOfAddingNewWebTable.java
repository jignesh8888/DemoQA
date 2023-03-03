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

public class VerificationOfAddingNewWebTable {
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
        
        // Click on the 'Add' button to add a new Web Table
        WebElement addButton = driver.findElement(By.xpath(p.getProperty("addButton ")));
        addButton.click();

		
        // Fill in the data
        WebElement firstNameField = driver.findElement(By.id(p.getProperty("firstName")));
        firstNameField.sendKeys("Jignesh");
        WebElement lastNameField = driver.findElement(By.id(p.getProperty("lastName")));
        lastNameField.sendKeys("Khairnar");
        WebElement emailField = driver.findElement(By.id(p.getProperty("userEmail")));
        emailField.sendKeys("jk1234@gmail.com");
        WebElement age = driver.findElement(By.id(p.getProperty("age")));
        age.sendKeys("21");
        WebElement salary = driver.findElement(By.id(p.getProperty("salary")));
        salary.sendKeys("21000");
        WebElement dept = driver.findElement(By.id(p.getProperty("department")));
        dept.sendKeys("Civil");
        // Click on the 'Submit' button to add the new Web Table record
        WebElement submitButton = driver.findElement(By.id(p.getProperty("submit")));
        submitButton.click();
      
        // Close the browser
        driver.quit();
				
	}

}
