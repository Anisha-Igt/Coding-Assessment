package SeleniumAutomation;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactory {
	private static Map<String, WebDriver> drivers = new HashMap<String, WebDriver>();

	/*
	 * Factory method for getting browser's driver
	 */
	public static WebDriver getBrowser(String browserName) {
		WebDriver driver = null;

		switch (browserName) {
		case "Firefox":
			driver = drivers.get("Firefox");
			if (driver == null) {				
				driver = new FirefoxDriver();
				drivers.put("Firefox", driver);
			}
			break;
		case "Edge":
			driver = drivers.get("Edge");
			if (driver == null) {
				System.setProperty("webdriver.http.factory", "jdk-http-client");							
				driver = new EdgeDriver();
				drivers.put("Edge", driver);
			}
			break;
		case "Chrome":
			driver = drivers.get("Chrome");
			if (driver == null) {
				System.setProperty("webdriver.http.factory", "jdk-http-client");			
				driver = new ChromeDriver();
				drivers.put("Chrome", driver);
			}
			break;
		}
		return driver;
	}

	public static void closeAllDriver() {
		for (String key : drivers.keySet()) {
			drivers.get(key).close();
			drivers.get(key).quit();
		}
	}
}
