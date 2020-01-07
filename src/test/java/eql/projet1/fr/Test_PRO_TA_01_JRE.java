package eql.projet1.fr;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
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
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() {
		driver.quit();
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
		assertEquals("Le nom de la popup n'est pas correct", "Créer un nouveau projet", page_index.name_popup.getText());				
		assertTrue("Le champ n'est pas vide", page_index.new_project_name_input.getText().isEmpty());
		assertTrue("Le champ n'est pas vide",page_index.new_project_model_input.getText().isEmpty());		
		assertFalse("Le champ est éditable",page_index.new_project_code_input.isEnabled());
		assertFalse("Le champ est vide",page_index.new_project_code_input.getAttribute("value").isEmpty());
		assertTrue("La checkbox n'est pas coché",page_index.new_project_code_checkbox.isSelected());
		assertEquals("La date n'est pas correct",TechnicalTools.dayDate(0), page_index.new_project_date_input.getAttribute("value"));
		assertTrue("Le champ date n'est pas vide",page_index.new_project_deadline_input.getAttribute("value").isEmpty());	
		assertTrue("Le champ client n'est pas vide",page_index.new_project_client_input.getText().isEmpty());	
		assertEquals("Le champ n'est pas rempli avec = Defautl","Default",page_index.new_project_calendar_input.getAttribute("value") );
		assertTrue("Le bouton enregistrer n'existe pas",page_index.new_project_save_btn.isEnabled());
		assertTrue("Le bouton annuler n'existe pas",page_index.new_project_cancel_btn.isEnabled());

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
		assertEquals("Le titre n'est pas correct","Détail du projet",page_projet.path_detail_project_menu.getText());


		//Step4
		assertTrue("Le menu : planification n'est pas affiché ",page_projet.plan_project_left_menu.isDisplayed());
		assertTrue("Le menu : détail n'est pas affiché ",page_projet.detail_project_left_menu.isDisplayed());
		assertTrue("Le menu : ressource n'est pas affiché ",page_projet.resources_project_left_menu.isDisplayed());
		assertTrue("Le menu : allocation n'est pas affiché ",page_projet.allowances_project_left_menu.isDisplayed());
		assertTrue("Le menu : tableau n'est pas affiché ",page_projet.board_project_left_menu.isDisplayed());

		//Step5
		assertTrue("Le menu : WBS n'est pas affiché ",page_projet.WBS_project_tab.isDisplayed());
		assertTrue("Le menu : Donné n'est pas affiché ",page_projet.data_project_tab.isDisplayed());
		assertTrue("Le menu : Coût n'est pas affiché ",page_projet.cost_project_tab.isDisplayed());
		assertTrue("Le menu : Avancement n'est pas affiché ",page_projet.advancement_project_tab.isDisplayed());
		assertTrue("Le menu : Libellés n'est pas affiché ",page_projet.wording_project_tab.isDisplayed());
		assertTrue("Le menu : Exigence n'est pas affiché ",page_projet.requirement_project_tab.isDisplayed());
		assertTrue("Le menu : Matériel n'est pas affiché ",page_projet.material_project_tab.isDisplayed());
		assertTrue("Le menu : Formulaire n'est pas affiché ",page_projet.task_project_tab.isDisplayed());
		assertTrue("Le menu : Autorisation n'est pas affiché ",page_projet.auth_project_tab.isEnabled());

		//Step6
		assertEquals("l'infobulle : enregistrer le projet n'est pas affiché ","Enregistrer le projet",page_projet.save_project_ico.getAttribute("title") );
		assertEquals("L'infobulle : Annuler l'édition n'est pas affiché ","Annuler l'édition",page_projet.cancel_project_ico.getAttribute("title") );

		//Step7
		page_projet.cancel_project_ico.click();
		assertEquals("Le titre de la popup n'est pas correct","Confirmer la fenêtre de sortie", page_projet.cancel_conf_name_popup.getText());
		assertEquals("Le message de confirmation n'est pas correct","Les modifications non enregistrées seront perdues. Êtes-vous sûr ?", page_projet.cancel_conf_msg_popup.getText());
		assertTrue("Le bouton OK n'existe pas",page_projet.cancel_conf_ok_btn_popup.isDisplayed());
		assertTrue("Le bouton Annuler n'existe pas",page_projet.cancel_conf_cancel_btn_popup.isDisplayed());

		//Step8
		page_projet.cancel_conf_cancel_btn_popup.click();
		assertEquals("Le titre de la popup n'est pas correct","Détail du projet",page_projet.path_detail_project_menu.getText());
		assertTrue("Le chemin n'est pas correct",page_projet.WBS_project_tab.isDisplayed());

		//Step9
		page_projet.cancel_project_ico.click();
		assertEquals("le titre de la popup n'est pas correct","Confirmer la fenêtre de sortie", page_projet.cancel_conf_name_popup.getText());
		assertEquals("le message de la popp n'est pas correct","Les modifications non enregistrées seront perdues. Êtes-vous sûr ?", page_projet.cancel_conf_msg_popup.getText());
		assertTrue("Le bouton OK n'existe pas",page_projet.cancel_conf_ok_btn_popup.isDisplayed());
		assertTrue("Le bouton Annuler n'existe pas",page_projet.cancel_conf_cancel_btn_popup.isDisplayed());

		//Step10
		page_projet.cancel_conf_ok_btn_popup.click();
		Thread.sleep(50);

		try {
			assertFalse("La popup est toujours présente",page_projet.cancel_conf_name_popup.isDisplayed());
		}
		catch (NoSuchElementException e) {}

		assertTrue("Le menu : planification n'est pas présent",page_projet.plan_project_left_menu.isDisplayed());

		try {
			assertFalse("Le menu est toujours présent",page_projet.project_tab_menu.isDisplayed());
		}
		catch (NoSuchElementException e) {}		

		//Step11
		page_projet.accesProject(driver);
		assertTrue("le premier projet n'est pas présent",page_projet.first_project.isDisplayed());
		assertTrue("le menu de liste de projet n'est pas présent",page_projet.list_project_left_menu.isDisplayed());

		//Step12
		assertEquals("le nom du projet n'est pas correct",project_name, page_projet.project_name.getText());
		assertEquals("le code du projet n'est pas correct",project_code, page_projet.project_code.getText());
		assertEquals("la date ne correspond pas",TechnicalTools.dayDate(5), page_projet.project_start_date.getText());
		assertEquals("la date ne correspond pas",TechnicalTools.dayDate(15), page_projet.project_end_date.getText());
		assertTrue("le champ client n'est pas vide",page_projet.project_client.getText().isEmpty());
		assertEquals("le budget ne correspond pas","0 €", page_projet.project_budget.getText());
		assertEquals("le nmombre d'heure ne correspond pas","0", page_projet.project_hour.getText());
		assertEquals("l'état du projet n'est pas correct","PRE-VENTES", page_projet.project_state.getText());
		assertTrue("l'icone édition n'est pas affiché",page_projet.project_edit_ico.isDisplayed());
		assertTrue("l'icone suppression n'est pas affiché",page_projet.project_supp_ico.isDisplayed());
		assertTrue("l'icone plan n'est pas affiché",page_projet.project_plan_ico.isDisplayed());
		assertTrue("l'icone modèle n'est pas affiché",page_projet.project_model_ico.isDisplayed());

		//Step pour supp
		page_projet.project_supp_ico.click();
		page_projet.cancel_conf_ok_btn_popup.click();
		Thread.sleep(100);
	}
}


