package Generatelogs.Generatelogs;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTestCookie {
	
	private static final boolean Cookie = false;
	WebDriver driver;
	Cookie ck;
	
	
	@Test
	public void setUp() {	
		
		System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\geckodriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		ck = new Cookie("JSESSIONID", "3e30ea734894b1795d4c40b55b3410714a18");
		
//		//Cookie cookie = new Cookie.Builder("JSESSIONID", "3e30ea734894b1795d4c40b55b3410714a18")
//			    .domain(".freecrm.com/")
//			    .isHttpOnly(true)
//			    .isSecure(false)
//			    .path("/mypath")
//			    .build();

		
		
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		
		driver.get("https://www.freecrm.com");
		//driver.manage().addCookie(cookie);
		driver.manage().addCookie(ck);
		
		driver.get("https://www.freecrm.com/index.cfm?CFID=637777&CFTOKEN=69638921&jsessionid=3e30ea734894b1795d4c40b55b3410714a18");
		
		Set<Cookie> cookies = driver.manage().getCookies();
		
		System.out.println("Size of cookies" + cookies.size());
		
		for(Cookie Cookie: cookies) {
			System.out.println(Cookie.getName() + " Value: " +  Cookie.getValue());
		}
		
		
	}


	private void For(Object object) {
		// TODO Auto-generated method stub
		
	}

}
