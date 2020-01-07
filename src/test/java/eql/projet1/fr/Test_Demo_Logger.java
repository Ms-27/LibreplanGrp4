package eql.projet1.fr;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test_Demo_Logger {
	
	WebDriver driver;
	static Logger logger = LoggerFactory.getLogger(Test_Demo_Logger.class);

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
		driver.get("https://jpetstore.cfapps.io/catalog");
		WebElement sign_in = driver.findElement(By.xpath("//*[@id=\"MenuContent\"]/a[2]"));
		TechnicalTools.assertEqualsLogger(logger, "Le lien Sign in n'existe pas", "Sign in", sign_in.getText());
	}

}
