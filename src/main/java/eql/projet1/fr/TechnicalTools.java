package eql.projet1.fr;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TechnicalTools {

static WebDriver driver;
	
	static WebDriver setBrowser(EBrowser nav) {
		switch(nav) {
		case firefox:
			System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			return driver;
		case chrome:
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			return driver;
		case ie:
			System.setProperty("webdriver.ie.driver", "src/test/resources/drivers/IEDriverServer.exe");
			WebDriver driver = new InternetExplorerDriver();
			return driver;
			default: return null;
		}
	}
	
	public static void fillFields(WebElement e, String s) {
		e.clear();
		e.sendKeys(s);
	}
}
