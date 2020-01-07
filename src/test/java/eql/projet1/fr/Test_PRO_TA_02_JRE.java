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
		driver = TechnicalTools.setBrowser(EBrowser.firefox);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() {
		//driver.quit();
	}

	@Test
	public void testCreationTache() throws InterruptedException {
		//Step1
		driver.get("http://localhost:8090/libreplan/");
		assertEquals("Erreur titre de la page", "LibrePlan: accès utilisateur", driver.getTitle());	
		PageLogin page_login = PageFactory.initElements(driver, PageLogin.class);
		PageIndex page_index = page_login.connect(driver, login, pswd);
		assertTrue(page_index.user_txt.isDisplayed());
		assertTrue(page_index.user_txt.getText().contains("admin"));

		//Step2
		page_index.accesProject(driver);
		PageProjet page_projet = PageFactory.initElements(driver, PageProjet.class);
		assertTrue(page_projet.first_project.isDisplayed());

		//Step3
		page_projet.project_name.click();
		assertTrue(page_projet.WBS_project_tab.isDisplayed());

		//Step4
		assertEquals("Détail du projet",page_projet.path_detail_project_menu.getText());
		assertEquals(project_name,page_projet.path_name_project_menu.getText());

		//Step5
		TechnicalTools.fillFields(page_projet.new_task_name_input, "Tache1-P1");
		TechnicalTools.fillFields(page_projet.new_task_hour_input, "5");
		page_projet.new_task_validate_btn.click();

		//Step6
		TechnicalTools.fillFields(page_projet.new_task_name_input, "Tache2-P1");
		TechnicalTools.fillFields(page_projet.new_task_hour_input, "10");
		page_projet.new_task_validate_btn.click();

		//Step7
		TechnicalTools.fillFields(page_projet.new_task_name_input, "Tache3-P1");
		TechnicalTools.fillFields(page_projet.new_task_hour_input, "20");
		page_projet.new_task_validate_btn.click();

		//Step8

		TechnicalTools.fillFields(page_projet.new_task_name_input, "Tache4-P1");
		TechnicalTools.fillFields(page_projet.new_task_hour_input, "8");
		page_projet.new_task_validate_btn.click();

		//Step9
		page_projet.first_task.click();
		page_projet.down_btn.click();

		//Step9
		page_projet.third_task.click();
		page_projet.up_btn.click();
		
		page_projet.first_task_code_input.sendKeys("T1");
		page_projet.second_task_code_input.sendKeys("T2");
		page_projet.third_task_code_input.sendKeys("T3");
		page_projet.four_task_code_input.sendKeys("T4");
		
		page_projet.first_task_date_input.sendKeys("05/01/2020");
		page_projet.second_task_date_input.sendKeys("08/01/2020");
		
		page_projet.third_task_date_input.sendKeys("03/01/2020");
		page_projet.four_task_date_input.sendKeys("05/01/2020");
		
		page_projet.save_btn.click();
		page_projet.cancel_conf_ok_btn_popup.click();
	}
}