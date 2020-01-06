package eql.projet1.fr;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;



public class Test_PRO_TA_02_JRE {

	WebDriver driver;
	String login = "admin";
	String pswd = "admin";
	String project_name = "PROJET_TEST1";
	String project_code = "PRJTEST001";

	@Before
	public void setUp() {
		driver = TechnicalTools.setBrowser(EBrowser.chrome);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() {
		//driver.quit();
	}

	@Test
	public void testCreationProjet() throws InterruptedException {
		//Step1
		driver.get("http://localhost:8090/libreplan/");
		assertEquals("Erreur titre de la page", "LibrePlan: accès utilisateur", driver.getTitle());	
		PageLogin page_login = PageFactory.initElements(driver, PageLogin.class);
		PageIndex page_index = page_login.connect(driver, login, pswd);
		assertTrue(page_index.user_txt.isDisplayed());
		assertTrue(page_index.user_txt.getText().contains("admin"));

		//Step2
		page_index.list_project_left_menu.click();
		PageProjet page_projet = PageFactory.initElements(driver, PageProjet.class);
		assertTrue(page_projet.first_project.isDisplayed());
		
		//Step3
		page_projet.project_name.click();
		assertTrue(page_projet.WBS_project_tab.isDisplayed());
		
		//Step4
		assertEquals(project_name,page_projet.path_name_project_menu.getText());
		
	}
}