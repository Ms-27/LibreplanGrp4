package eql.projet1.fr;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test_Demo_Logger {

	WebDriver driver;
	static Logger logger = LoggerFactory.getLogger(Test_Demo_Logger.class);

	// JDD
	String login = "admin";
	String password = "admin";

	@Before
	public void setUp() {
		driver = TechnicalTools.setBrowser(EBrowser.chrome);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void test() {
		driver.get("localhost:8090/libreplan");
		PageLogin page_login = PageFactory.initElements(driver, PageLogin.class);
		PageIndex page_index = page_login.connect(driver, login, password);
		WebElement libreplan_logo = driver.findElement(By.xpath("//img[contains(@src, 'logo')]"));
		TechnicalTools.assertTrueLogger(logger, "Le logo Libreplan n'existe pas", !libreplan_logo.isDisplayed());
	}

}
