import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@TestMethodOrder(OrderAnnotation.class)
public class newCustomer_TestScenarios {

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
	public void errorMessageBlankFieald() throws InterruptedException {
		
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
		//end of login
		
		driver.get("https://demo.guru99.com/v4/manager/addcustomerpage.php");
		
		/*driver.findElement(By.linkText("New Customer")).click();
		Thread.sleep(3000); 	
		WebElement frame1 = driver.findElement(By.id("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0"));
		driver.switchTo().frame(frame1);
		WebElement frame2 = driver.findElement(By.id("ad_iframe"));
		driver.switchTo().frame(frame2);
		driver.findElement(By.xpath("//div[@id='dismiss-button']/div/span")).click();
		driver.switchTo().defaultContent();
		*/
		
		/*driver.switchTo().frame("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0").findElement(By.id("dismiss-button")).click(); //close iframe after click on the link New customer.))
		Thread.sleep(3000);*/
		
		//check the page
		String actualResults = driver.findElement(By.cssSelector("body > table > tbody > tr > td > table > tbody > tr:nth-child(1) > td > p")).getText();
		String expectedResults = "Add New Customer";
		assertEquals(expectedResults,actualResults);
		
		//add new customer
		driver.findElement(By.name("name")).click();		
		driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[2]")).click();			
		driver.findElement(By.id("dob")).click();		
		driver.findElement(By.name("addr")).click();		
		driver.findElement(By.name("city")).click();		
		driver.findElement(By.name("state")).click();	
		driver.findElement(By.name("pinno")).click();			
		driver.findElement(By.name("telephoneno")).click();			
		driver.findElement(By.name("emailid")).click();		
		driver.findElement(By.name("password")).click();		
		
		//driver.findElement(By.cssSelector("body > table > tbody > tr > td > table > tbody > tr:nth-child(14) > td:nth-child(2) > input[type=submit]:nth-child(1)")).click();
		//Thread.sleep(3000);
		
		//to check blank fields
		String actualResult = driver.findElement(By.cssSelector("#message")).getText();
		String expectedRersults = "Customer name must not be blank";
		assertEquals(actualResults, expectedResults);
		
		String actualDate = driver.findElement(By.cssSelector("#message24")).getText();
		String expectedDate = "Date Field must not be blank";
		assertEquals(actualDate, expectedDate);
		
		String actualAddress = driver.findElement(By.cssSelector("#message3")).getText();
		String expectedAddress = "Address Field must not be blank";
		assertEquals(actualAddress, expectedAddress);
		
		String actualCity = driver.findElement(By.cssSelector("#message4")).getText();
		String expectedCity = "City Field must not be blank";
		assertEquals(actualCity, expectedCity);
		
		String actualState = driver.findElement(By.cssSelector("#message5")).getText();
		String expectedState = "State must not be blank";
		assertEquals(actualState, expectedState);
		
		String actualPin = driver.findElement(By.cssSelector("#message6")).getText();
		String expectedPin = "PIN Code must not be blank";
		assertEquals(actualPin, expectedPin);
		
		String actualMobile = driver.findElement(By.cssSelector("#message7")).getText();
		String expectedMobile = "Mobile no must not be blank";
		assertEquals(actualMobile, expectedMobile);
		
		String actualEmail = driver.findElement(By.cssSelector("#message9")).getText();
		String expectedEmail = "Email-ID must not be blank";
		assertEquals(actualEmail, expectedEmail);
		
		String actualPassward = driver.findElement(By.cssSelector("#message18")).getText();
		String expectedPassward = "Password must not be blank";
		assertEquals(actualPassward, expectedPassward);
		
	}
	
	@Test
	@Order(2)
	public void addNewCustomer_happyPath() throws InterruptedException {
		
	
		//add new customer
		driver.findElement(By.name("name")).sendKeys("Marina");
		driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[2]")).click();			Thread.sleep(1000);
		String date = "0020-05-0117";
		driver.findElement(By.id("dob")).sendKeys(date); //2000/01/01		Thread.sleep(1000);
		driver.findElement(By.name("addr")).sendKeys("Ozo gatve 25");		Thread.sleep(1000);
		driver.findElement(By.name("city")).sendKeys("Vilnius");		Thread.sleep(1000);
		driver.findElement(By.name("state")).sendKeys("State");		Thread.sleep(1000);
		driver.findElement(By.name("pinno")).sendKeys("111111");			Thread.sleep(1000);
		driver.findElement(By.name("telephoneno")).sendKeys("370370370");			Thread.sleep(1000);
		driver.findElement(By.name("emailid")).sendKeys("ku@killa.me");			Thread.sleep(1000);
		driver.findElement(By.name("password")).sendKeys("ko12345");				Thread.sleep(1000);
		driver.findElement(By.cssSelector("body > table > tbody > tr > td > table > tbody > tr:nth-child(14) > td:nth-child(2) > input[type=submit]:nth-child(1)")).click();
		Thread.sleep(3000);
		
		// to check new customer's fields
		String actualName = driver.findElement(By.cssSelector("#customer > tbody > tr:nth-child(5) > td:nth-child(2)")).getText();
		String expectedName = "Marina";
		assertTrue(actualName.contains(expectedName));
		
		String actualGender = driver.findElement(By.cssSelector("#customer > tbody > tr:nth-child(6) > td:nth-child(2)")).getText();
		String expectedGender = "Female";
		assertTrue(actualGender.contains(expectedGender));
		
		String actualDate = driver.findElement(By.cssSelector("#customer > tbody > tr:nth-child(7) > td:nth-child(2)")).getText();
		String expectedDate = "2005-01-17";
		assertEquals(actualDate, expectedDate);
		
		String actualAddress = driver.findElement(By.cssSelector("##customer > tbody > tr:nth-child(8) > td:nth-child(2)")).getText();
		String expectedAddress = "Ozo gatve 25";
		assertEquals(actualAddress, expectedAddress);
		
		String actualCity = driver.findElement(By.cssSelector("#customer > tbody > tr:nth-child(9) > td:nth-child(2)")).getText();
		String expectedCity = "Vilnius";
		assertEquals(actualCity, expectedCity);
		
		String actualState = driver.findElement(By.cssSelector("#customer > tbody > tr:nth-child(10) > td:nth-child(2)")).getText();
		String expectedState = "State";
		assertEquals(actualState, expectedState);
		
		String actualPin = driver.findElement(By.cssSelector("#customer > tbody > tr:nth-child(11) > td:nth-child(2)")).getText();
		String expectedPin = "111111";
		assertEquals(actualPin, expectedPin);
		
		String actualMobile = driver.findElement(By.cssSelector("#customer > tbody > tr:nth-child(12) > td:nth-child(2)")).getText();
		String expectedMobile = "370370370";
		assertEquals(actualMobile, expectedMobile);
		
		String actualEmail = driver.findElement(By.cssSelector("#customer > tbody > tr:nth-child(13) > td:nth-child(2)")).getText();
		String expectedEmail = "ku@killa.me";
		assertEquals(actualEmail, expectedEmail);
		
	}
	
	
	@Test
	public void checkAllLabels() throws InterruptedException {
		
		driver.get("https://demo.guru99.com/v4");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.switchTo().frame("gdpr-consent-notice").findElement(By.id("save")).click(); //close the frame to accept datd privacy popup
		Thread.sleep(1000);
		driver.findElement(By.name("uid")).sendKeys("mngr435116");
		driver.findElement(By.name("password")).sendKeys("YjapasY");
		driver.findElement(By.cssSelector("body > form > table > tbody > tr:nth-child(3) > td:nth-child(2) > input[type=submit]:nth-child(1)")).click();
		Thread.sleep(3000);
		//end of login
		
		driver.findElement(By.linkText("New Customer")).click();
		Thread.sleep(3000); 
		//we should to find if there is frame or alert
		driver.switchTo().frame("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0").findElement(By.id("dismiss-button")).click(); //close iframe after click on the link New customer.))
		//driver.switchTo().alert().accept();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[2]/a")).click();
		//driver.findElement(By.cssSelector("body > div:nth-child(6) > div > ul > li:nth-child(2) > a")).click();
		//a[contains(text(), New customer
		
		//1.
		String actualResults = driver.findElement(By.cssSelector("body > table > tbody > tr > td > table > tbody > tr:nth-child(1) > td > p")).getText();
		String expectedResults = "Add New Customer";
		assertEquals(expectedResults,actualResults);
		
		//2.
		//check if the lable "customer name" is correct
		actualResults = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td[1]")).getText();
		expectedResults = "Customer Name";
		assertTrue(actualResults.contains(expectedResults));
		
		//3.
		//check if the lable "Gender" is correct
		assertEquals( "Gender", driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[1]")).getText());
	}
}
