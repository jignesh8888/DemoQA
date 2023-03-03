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

public class VerificationOfTextBoxInElementsTab {
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
						    
						    
		//find ElementTab and Click
		driver.findElement(By.xpath(p.getProperty("elementTab"))).click();
				

        // Click on the Text Box option
        WebElement textBoxOption = driver.findElement(By.xpath(p.getProperty("textBoxOption")));
        textBoxOption.click();

        // Enter text in the Full Name field
        WebElement fullNameField = driver.findElement(By.id("userName"));
        fullNameField.sendKeys("Jignesh Khairnar");

        // Enter text in the Email field
        WebElement emailField = driver.findElement(By.id("userEmail"));
        emailField.sendKeys("abc@gmail.com");

        // Enter text in the Current Address field
        WebElement currentAddressField = driver.findElement(By.id("currentAddress"));
        currentAddressField.sendKeys("Plot No.14, At post Dhule.");

        // Enter text in the Permanent Address field
        WebElement permanentAddressField = driver.findElement(By.id("permanentAddress"));
        permanentAddressField.sendKeys("Plot No.20, At post Bengaluru.");
       
        js.executeScript("window.scrollBy(0,500)");

        // Click on the Submit button
        WebElement submitButton = driver.findElement(By.xpath(p.getProperty("submit")));
        submitButton.click();

        // Verify that the form was submitted successfully
        WebElement confirmMessage = driver.findElement(By.xpath("//div[@class='border col-md-12 col-sm-12']//p[@id='name']"));
        String expectedMessage = "Jignesh Khairnar";
        String actualMessage = confirmMessage.getText();
        if (actualMessage.contains("Jignesh Khairnar")) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }

        // Quit the browser
        driver.quit();
	}

}
