package eql.projet1.fr;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Test_PRO_TA_01_JRE {
	
		WebDriver driver;
		String login = "admin";
		String pswd = "admin";
		String project_name = "PROJET_TEST1";
		String project_code = "PRJTEST001";
		
		@Before
		public void setUp() {
			driver = TechnicalTools.setBrowser(EBrowser.chrome);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
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
			page_index.new_project_btn.click();
			assertEquals("Créer un nouveau projet", page_index.name_popup.getText());				
			assertTrue(page_index.new_project_name_input.getText().isEmpty());
			assertTrue(page_index.new_project_model_input.getText().isEmpty());		
			assertFalse(page_index.new_project_code_input.isEnabled());
			assertFalse(page_index.new_project_code_input.getAttribute("value").isEmpty());
			assertTrue(page_index.new_project_code_checkbox.isSelected());
			assertEquals(TechnicalTools.todayDate(), page_index.new_project_date_input.getAttribute("value"));
			assertTrue(page_index.new_project_deadline_input.getAttribute("value").isEmpty());	
			assertTrue(page_index.new_project_client_input.getText().isEmpty());	
			assertEquals("Default",page_index.new_project_calendar_input.getAttribute("value") );
			assertTrue(page_index.new_project_save_btn.isEnabled());
			assertTrue(page_index.new_project_cancel_btn.isEnabled());
			
			//Step3
			page_index.new_project_code_checkbox.click();		
			TechnicalTools.fillFields(page_index.new_project_name_input, project_name);
			TechnicalTools.fillFields(page_index.new_project_code_input, project_code);
			
			page_index.new_project_start_calendar_btn.click();
			String today_date = page_index.new_project_date_selected.getText();
			int itoday_date = Integer.parseInt(today_date);
			int new_start_date = itoday_date + 5;			
			page_index.dayWanted(driver, new_start_date);
			page_index.new_project_end_calendar_btn.click();
			int new_end_date = itoday_date + 15;
			page_index.dayWanted(driver, new_end_date);
			
			page_index.new_project_save_btn.click();
			
			PageProjet page_projet = PageFactory.initElements(driver, PageProjet.class);
			 
			
			assertEquals("Détail du projet",page_projet.path_detail_project_menu.getText());
			
			
			//Step4
			assertTrue(page_projet.plan_project_left_menu.isDisplayed());
			assertTrue(page_projet.detail_project_left_menu.isDisplayed());
			assertTrue(page_projet.resources_project_left_menu.isDisplayed());
			assertTrue(page_projet.allowances_project_left_menu.isDisplayed());
			assertTrue(page_projet.board_project_left_menu.isDisplayed());
			
			//Step5
			assertTrue(page_projet.WBS_project_tab.isDisplayed());
			assertTrue(page_projet.data_project_tab.isDisplayed());
			assertTrue(page_projet.cost_project_tab.isDisplayed());
			assertTrue(page_projet.advancement_project_tab.isDisplayed());
			assertTrue(page_projet.wording_project_tab.isDisplayed());
			assertTrue(page_projet.requirement_project_tab.isDisplayed());
			assertTrue(page_projet.material_project_tab.isDisplayed());
			assertTrue(page_projet.task_project_tab.isDisplayed());
			assertTrue(page_projet.auth_project_tab.isEnabled());
			
			//Step6
			assertEquals("Enregistrer le projet",page_projet.save_project_ico.getAttribute("title") );
			assertEquals("Annuler l'édition",page_projet.cancel_project_ico.getAttribute("title") );
			
			//Step7
			page_projet.cancel_project_ico.click();
			assertEquals("Confirmer la fenêtre de sortie", page_projet.cancel_conf_name_popup.getText());
			assertEquals("Les modifications non enregistrées seront perdues. Êtes-vous sûr ?", page_projet.cancel_conf_msg_popup.getText());
			assertTrue(page_projet.cancel_conf_ok_btn_popup.isDisplayed());
			assertTrue(page_projet.cancel_conf_cancel_btn_popup.isDisplayed());
			
			//Step8
			page_projet.cancel_conf_cancel_btn_popup.click();
			assertEquals("Détail du projet",page_projet.path_detail_project_menu.getText());
			assertTrue(page_projet.WBS_project_tab.isDisplayed());
			
			//Step9
			page_projet.cancel_project_ico.click();
			assertEquals("Confirmer la fenêtre de sortie", page_projet.cancel_conf_name_popup.getText());
			assertEquals("Les modifications non enregistrées seront perdues. Êtes-vous sûr ?", page_projet.cancel_conf_msg_popup.getText());
			assertTrue(page_projet.cancel_conf_ok_btn_popup.isDisplayed());
			assertTrue(page_projet.cancel_conf_cancel_btn_popup.isDisplayed());
			
			//Step10
//			page_projet.cancel_conf_ok_btn_popup.click();
//			assertTrue(page_projet.cancel_conf_name_popup.isDisplayed());
//			Thread.sleep(2000);
//			assertFalse(page_projet.cancel_conf_name_popup.isDisplayed());
//			
//			
//			assertTrue(page_projet.plan_project_left_menu.isDisplayed());
//			assertFalse(page_projet.project_tab_menu.isDisplayed());
//			
			
			//Step11
			page_projet.cancel_conf_cancel_btn_popup.click();
			page_projet.accesProject(driver);
			assertTrue(page_projet.project_name.isDisplayed());
			assertTrue(page_projet.list_project_left_menu.isDisplayed());
			
			
			//Step12
			assertEquals(project_name, page_projet.project_name.getText());
			
			//page_index.signout_btn.click();
		}
	}


 