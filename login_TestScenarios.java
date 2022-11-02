import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


@TestMethodOrder(OrderAnnotation.class)
public class login_TestScenarios {
	//declare webdriver
	
	public static WebDriver driver = null;
 
	
	@BeforeAll
	public static void beforeAll() {
		System.setProperty("webdriver.chrome.driver", "/Users/apple/Downloads/chromedriver");
		driver = new ChromeDriver (); //name of the function
	}
	
	@AfterAll
	public static void afterAll(){
		driver.close();
	}
	
	// we have three test cases @Test
	
	@Test
	@Order(1)
	public void login_happyPath() throws InterruptedException {
	
		
	//mention where my chromedriver is located
	//System.setProperty("webdriver.chrome.driver", "/Users/apple/Downloads/chromedriver");
	//using variable driver we can talk to browser 
	//driver = new ChromeDriver (); //name of the function
	
	driver.get("https://demo.guru99.com/v4");
	//driver.manage().window().maximize(); //the window's size
	Thread.sleep(3000);
	
	driver.switchTo().frame("gdpr-consent-notice").findElement(By.id("save")).click();
	
	Thread.sleep(1000);
	driver.findElement(By.name("uid")).sendKeys("mngr435116");
	driver.findElement(By.name("password")).sendKeys("YjapasY");
	driver.findElement(By.cssSelector("body > form > table > tbody > tr:nth-child(3) > td:nth-child(2) > input[type=submit]:nth-child(1)")).click();
	
	Thread.sleep(3000);
	
	String actualResults = driver.getCurrentUrl();
	String expectedResults = "https://demo.guru99.com/v4/manager/Managerhomepage.php";
	//we want to compare if both are equal 
	
	assertEquals(actualResults,expectedResults); //if they are different the system shows us where difference is
	assertTrue(actualResults.contains(expectedResults));
	//assertThat(actualResults, is(expectedResults));
	
	//driver.close(); //close the current step
	//driver.quit(); //close the tab
	
	}
	
	@Test
	@Order(2)
	public void login_unhappyPath_wrongUserName() throws InterruptedException {
		
		driver.get("https://demo.guru99.com/v4");

		Thread.sleep(1000);
		driver.findElement(By.name("uid")).sendKeys("mnSR435116");
		driver.findElement(By.name("password")).sendKeys("YjapasY");
		driver.findElement(By.cssSelector("body > form > table > tbody > tr:nth-child(3) > td:nth-child(2) > input[type=submit]:nth-child(1)")).click();
		Thread.sleep(3000);
		String validation = driver.switchTo().alert().getText();
		String expectedResults = "User or Password is not valid";
		
		assertEquals(validation, expectedResults);
		
		driver.switchTo().alert().accept();//automatically click OK
		
	}
	
	@Test
	@Order(3)
	public void login_unhappyPath_blankfield() throws InterruptedException {
		
		driver.get("https://demo.guru99.com/v4");
		
		driver.findElement(By.name("uid")).click();
		driver.findElement(By.name("password")).click();
		driver.findElement(By.cssSelector("body > form > table > tbody > tr:nth-child(3) > td:nth-child(2) > input[type=submit]:nth-child(1)")).click();
		Thread.sleep(3000);
		String validation = driver.switchTo().alert().getText();
		String expectedResults = "User or Password is not valid";
		
		assertEquals(validation, expectedResults);
		
		driver.switchTo().alert().accept();
	}
}
