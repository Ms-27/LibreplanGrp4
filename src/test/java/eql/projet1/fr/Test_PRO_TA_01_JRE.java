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
		public void testCreationProjet() {
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
			
			//page_index.signout_btn.click();
		}
	}


 