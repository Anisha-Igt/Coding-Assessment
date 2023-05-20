package SeleniumAutomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;


public class TestNGclass {
	
	WebDriver driver;
	String label;
	WebDriverWait wait;
			
	@BeforeTest
	@Parameters({"browser"})
	public void setup(String browser) {
		
		driver = DriverFactory.getBrowser(browser);
	}
	
	@Test(dataProvider="searchText", dataProviderClass=DataProviderClass.class)	
	public void verifyGoogle(String str) {
		
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys(str);
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[1]/h3)[1]")));
		label = driver.findElement(By.xpath("(//a[1]/h3)[1]")).getText();
		Assert.assertTrue(label.contains(str), str + " is present in the first search result");
			
	}
	
	@Test(dataProvider="searchText", dataProviderClass=DataProviderClass.class)	
	public void verifyYahoo(String str) {
		
		driver.get("https://in.search.yahoo.com/");
		driver.findElement(By.name("p")).sendKeys(str);
		driver.findElement(By.name("p")).sendKeys(Keys.ENTER);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@class='first']/div/div/h3/a")));
		label = driver.findElement(By.xpath("//li[@class='first']/div/div/h3/a")).getAttribute("aria-label");
		Assert.assertTrue(label.contains(str), str + " is present in the first search result");
			
	}
	
	@Test(dataProvider="searchText", dataProviderClass=DataProviderClass.class)	
	public void verifyAOL(String str) {
		
		driver.get("https://search.aol.com/");
		driver.findElement(By.name("q")).sendKeys(str);
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@class='first']/following-sibling::li[1]/div/div/h3/a")));
		label = driver.findElement(By.xpath("//li[@class='first']/following-sibling::li[1]/div/div/h3/a")).getAttribute("aria-label");
		Assert.assertTrue(label.contains(str), str + " is present in the first search result");
			
	}
	
	@AfterTest
	public void tearDown() {
		
		DriverFactory.closeAllDriver();;
	}
}