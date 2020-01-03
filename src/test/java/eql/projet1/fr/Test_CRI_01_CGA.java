package eql.projet1.fr;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class Test_CRI_01_CGA {
	
	WebDriver driver;
	
	@Before
	public void startup() {
		driver = TechnicalTools.setBrowser(EBrowser.chrome);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@After
	public void teardDown() {
		driver.quit();
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
