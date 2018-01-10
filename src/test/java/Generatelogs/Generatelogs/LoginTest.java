package Generatelogs.Generatelogs;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTest {
	
	WebDriver driver;
	
	
	@BeforeMethod
	public void setUp() {	
		System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\geckodriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("https://www.freecrm.com");	
	}
	
	@Test
	public void validateLoginPageTitle(){
		String valueTitle = driver.getTitle();
		Assert.assertEquals(valueTitle, "#1 Free CRM for Any Business: Online Customer Relationship Software", "Title of the Page isn't as expected");
	}
	
	@Test
	public void validateCRMImage(){
		boolean validateCrmImage = driver.findElement(By.xpath("//img[@class='img-responsive']")).isDisplayed();
		Assert.assertTrue(validateCrmImage);
	}
	
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}

}
