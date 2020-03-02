package TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class test_web_page {

		  WebDriver driver;
		@BeforeMethod
		public void launch() {
			System.setProperty("webdriver.chrome.driver","chromedriver");
			  driver = new ChromeDriver();
			  driver.get("http://ec2-18-191-145-51.us-east-2.compute.amazonaws.com:9090/");
			  driver.manage().window().maximize();
			  driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		}
		
		@Test 
		public void verifyaboutus() {

			
			WebElement linkName= driver.findElement(By.linkText("About Us"));
			
			if(linkName.isDisplayed())
			{
			  System.out.println("Yes link is there");
			}
			else
			{
			  System.out.println("No link is there");
			}
			
			linkName.click();
			
			if(driver.getPageSource().contains("Lorem Ipsum Dipsum is simply dummy text of the printing and typesetting industry")) {
			  System.out.println("Yes text - 'Lorem Ipsum Dipsum is simply dummy text of the printing and typesetting industry' is there");
			}
			else
			{
			  System.out.println("No text - 'Lorem Ipsum Dipsum is simply dummy text of the printing and typesetting industry' is not there");
			}
		}

	  @AfterMethod
	  public void close() {
		  driver.close();
		}
	}	
	
