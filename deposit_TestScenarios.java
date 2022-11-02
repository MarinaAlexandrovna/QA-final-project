import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@TestMethodOrder(OrderAnnotation.class)
public class deposit_TestScenarios {

	public static WebDriver driver = null;
	 
	@BeforeAll
	public static void beforeAll() {
		System.setProperty("webdriver.chrome.driver", "/Users/apple/Downloads/chromedriver");
		driver = new ChromeDriver (); 
	}
	
	@AfterAll
	public static void afterAll(){
		driver.close();
	}
	
	@Test
	@Order(1)
	
	public void CheckAllFieldsName() throws InterruptedException {
		//to log in
		driver.get("https://demo.guru99.com/v4");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.switchTo().frame("gdpr-consent-notice").findElement(By.id("save")).click(); //close the frame to accept datd privacy popup
		Thread.sleep(1000);
		driver.findElement(By.name("uid")).sendKeys("mngr435116");
		driver.findElement(By.name("password")).sendKeys("YjapasY");
		driver.findElement(By.cssSelector("body > form > table > tbody > tr:nth-child(3) > td:nth-child(2) > input[type=submit]:nth-child(1)")).click();
		Thread.sleep(3000);
		
		//to check all Lables
		driver.get("https://demo.guru99.com/v4/manager/addAccount.php");
		
		String actualCustomerId = driver.findElement(By.cssSelector("body > table > tbody > tr > td > table > tbody > tr:nth-child(2) > td:nth-child(1)")).getText();
		String expectedCustomerId = "Customer id";
		assertEquals(actualCustomerId, expectedCustomerId);
		
		
		String actualType = driver.findElement(By.cssSelector("body > table > tbody > tr > td > table > tbody > tr:nth-child(3) > td:nth-child(1)")).getText();
		String expectedType = "Account type";
		assertEquals(actualType, expectedType);
		
		String actualDeposit = driver.findElement(By.cssSelector("body > table > tbody > tr > td > table > tbody > tr:nth-child(4) > td:nth-child(1)")).getText();
		String expectedDeposit = "Initial deposit";
		assertEquals(actualDeposit, expectedDeposit);
		
	}
	
	@Test
	@Order(2)
	
	public void deposit_HappyPath() throws InterruptedException {
		
		//to log in
		driver.get("https://demo.guru99.com/v4");
		Thread.sleep(1000);
		driver.findElement(By.name("uid")).sendKeys("mngr435116");
		driver.findElement(By.name("password")).sendKeys("YjapasY");
		driver.findElement(By.cssSelector("body > form > table > tbody > tr:nth-child(3) > td:nth-child(2) > input[type=submit]:nth-child(1)")).click();
		Thread.sleep(3000);
		
		//create new account
				/*driver.findElement(By.cssSelector("body > table > tbody > tr > td > table > tbody > tr:nth-child(2) > td:nth-child(2) > input[type=text]")).sendKeys("50355");
				driver.findElement(By.cssSelector("body > table > tbody > tr > td > table > tbody > tr:nth-child(3) > td:nth-child(2) > select")).getCssValue("Savings");
				driver.findElement(By.cssSelector("body > table > tbody > tr > td > table > tbody > tr:nth-child(4) > td:nth-child(2) > input[type=text]")).sendKeys("6000");
				driver.findElement(By.cssSelector("body > table > tbody > tr > td > table > tbody > tr:nth-child(5) > td:nth-child(2) > input[type=submit]:nth-child(1)")).click();
				Thread.sleep(3000);*/
		
		//checking deposit
		driver.get("https://demo.guru99.com/v4/manager/DepositInput.php");
		
		driver.findElement(By.cssSelector("body > table > tbody > tr > td > table > tbody > tr:nth-child(6) > td:nth-child(2) > input[type=text]")).sendKeys("111695");
		driver.findElement(By.name("ammount")).sendKeys("6000");
		driver.findElement(By.name("desc")).sendKeys("rent");
		driver.findElement(By.cssSelector("body > table > tbody > tr > td > table > tbody > tr:nth-child(12) > td:nth-child(2) > input[type=submit]:nth-child(1)")).click();
		Thread.sleep(3000);
	}
	
}
