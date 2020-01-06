package eql.projet1.fr;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.slf4j.Logger;

import junit.framework.Assert;

import java.io.File;

import java.text.SimpleDateFormat;


import java.util.Date;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class TechnicalTools {

	static WebDriver driver;

	static WebDriver setBrowser(EBrowser nav) {
		switch (nav) {
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
		default:
			return null;
		}
	}

	public static void fillFields(WebElement e, String s) {
		e.clear();
		e.sendKeys(s);
	}

	public static void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception {
		// Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
		// Call getScreenshotAs method to create image file
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		// Move image file to new destination
		File DestFile = new File(fileWithPath);
		// Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
	}
	
	public static String todayDate() {
		Date aujourdhui = new Date();
		SimpleDateFormat formater = null;	
		formater = new SimpleDateFormat("d MMM yyyy");
		return formater.format(aujourdhui);
	}
	
	public static void assertTrueLogger(Logger l, String s, boolean b) {
		if (! b) {
			l.error(s);
			throw new AssertionError(s);
		}
	}
	
	public static void assertFalseLogger(Logger l, String s, boolean b) {
		if (b) {
			l.error(s);
			throw new AssertionError(s);
		}
	}
	
	public static void assertEqualsLogger(Logger l, String s, Object expected, Object actual) {
		if (!(expected.equals(actual))) {
			l.error(s);
			throw new AssertionError(s);
		}
	}
}
