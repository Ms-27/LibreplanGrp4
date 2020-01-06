package eql.projet1.fr;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test_CRI_01_CGA {

	WebDriver driver;

	// JDD
	String sql_path = "src/test/datasets/criterion_type_create.sql";
	
	String snap_path = "src/test/snapshots/debug.png";
	String snap_path1 = "src/test/snapshots/debug1.png";
	
	String login = "admin";
	String password = "admin";
	
	String critere_name_annuler = "Critère - Test bouton [Annuler]";
	String critere_description_annuler = "Critère - Test bouton [Annuler]";
	String critere_name_enregistrer = "Critère - Test bouton [Enregistrer]";
	String critere_description_enregistrer = "Critère - Test bouton [Enregistrer]";
	String critere_name_sauver = "Critère - Test bouton [Sauver et continuer]";
	String critere_description_sauver = "Critère - Test bouton [Sauver et continuer]";
	String critere_name_sauver2 = "Critère - Test bouton [Sauver et continuer] 2";

	@Before
	public void startup() throws Exception {
		driver = TechnicalTools.setBrowser(EBrowser.chrome);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		BddConnexion.setDataBase(sql_path);
	}

	@After
	public void teardDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		// Step 1 : Connexion à l'application
		driver.get("http://localhost:8090/libreplan/");
		assertEquals("Erreur titre de la page", "LibrePlan: accès utilisateur", driver.getTitle());

		// Accès à la page Index
		PageLogin page_login = PageFactory.initElements(driver, PageLogin.class);
		PageIndex page_index = page_login.connect(driver, login, password);
		assertEquals("Erreur Ressources non présent", "Ressources ", page_index.ressources_btn.getText());

		// Step 2 : Accès à la page Critere du sous menu Ressources
		PageCritere page_critere = page_index.accesCritere(driver);
		assertEquals("La page Critere ne c'est pas chargé", "Types de critères Liste", page_critere.criteres_header.getText());
		assertEquals("Le tableau n'est pas correct", "Nom", page_critere.nom_th.getText());
		assertEquals("Le tableau n'est pas correct", "Code", page_critere.code_th.getText());
		assertEquals("Le tableau n'est pas correct", "Type", page_critere.type_th.getText());
		assertEquals("Le tableau n'est pas correct", "Activé", page_critere.active_th.getText());
		assertEquals("Le tableau n'est pas correct", "Opérations", page_critere.operation_th.getText());
		assertTrue("Le bouton Créer n'existe pas", page_critere.creer_btn.isEnabled());

		// Step 3 : Accès au formulaire Créer types de critère
		page_critere.creer_btn.click();
		assertTrue("Le bouton Enregistrer n'est pas présent", page_critere.enregistrer_btn.isEnabled());
		assertTrue("Le bouton Sauver et Continuer n'est pas présent", page_critere.sauver_btn.isEnabled());
		assertTrue("Le bouton Annuler n'est pas présent", page_critere.annuler_btn.isEnabled());

		// Step 4 : Créer un critère - bouton [Annuler] 
		TechnicalTools.fillFields(page_critere.nom_input, critere_name_annuler);
		page_critere.type_dropdown_btn.click();
		page_critere.participant_ddm_content.click();
		assertTrue("La checkbox valeur multiple par ressource n'est pas coché", page_critere.valeur_multiple_ressources_checkbox.isEnabled());
		assertTrue("La checkbox hiérarchie n'est pas coché", page_critere.hierarchie_checkbox.isEnabled());
		assertTrue("La checkbox activé n'est pas coché", page_critere.active_checkbox.isEnabled());

		TechnicalTools.fillFields(page_critere.description_field, critere_description_annuler);
		page_critere.annuler_btn.click();
		wait.until(ExpectedConditions.visibilityOf(page_critere.criteres_header));
		assertEquals("Le tableau ne s'est pas annulé", "Types de critères Liste", page_critere.criteres_header.getText());
		assertFalse("Le bouton Annuler est présent", page_critere.annuler_btn.isDisplayed());
		
		// Step 5 : Créer un critère - bouton [Enregistrer]
		page_critere.creer_btn.click();
		assertTrue("Le bouton Enregistrer n'est pas présent", page_critere.enregistrer_btn.isEnabled());
		assertTrue("Le bouton Sauver et Continuer n'est pas présent", page_critere.sauver_btn.isEnabled());
		assertTrue("Le bouton Annuler n'est pas présent", page_critere.annuler_btn.isEnabled());
		TechnicalTools.fillFields(page_critere.nom_input, critere_name_enregistrer);
		page_critere.type_dropdown_btn.click();
		page_critere.participant_ddm_content.click();
		assertTrue("La checkbox valeur multiple par ressource n'est pas coché", page_critere.valeur_multiple_ressources_checkbox.isEnabled());
		assertTrue("La checkbox hiérarchie n'est pas coché", page_critere.hierarchie_checkbox.isEnabled());
		assertTrue("La checkbox activé n'est pas coché", page_critere.active_checkbox.isEnabled());

		TechnicalTools.fillFields(page_critere.description_field, critere_description_enregistrer);
		page_critere.enregistrer_btn.click();
		wait.until(ExpectedConditions.visibilityOf(page_critere.criteres_header));
		assertEquals("Le tableau ne s'est pas enregistré", "Types de critères Liste", page_critere.criteres_header.getText());
		
		// Step 6 : Créer un critère - Accès au formulaire de création :
		page_critere.creer_btn.click();
		assertTrue("Le bouton Enregistrer n'est pas présent", page_critere.enregistrer_btn.isEnabled());
		assertTrue("Le bouton Sauver et Continuer n'est pas présent", page_critere.sauver_btn.isEnabled());
		assertTrue("Le bouton Annuler n'est pas présent", page_critere.annuler_btn.isEnabled());
		
		// Step 7 : Créer un critère - bouton [Sauver et continuer] :
		TechnicalTools.fillFields(page_critere.nom_input, critere_name_sauver);
		page_critere.type_dropdown_btn.click();
		page_critere.participant_ddm_content.click();
		assertTrue("La checkbox valeur multiple par ressource n'est pas coché", page_critere.valeur_multiple_ressources_checkbox.isEnabled());
		assertTrue("La checkbox hiérarchie n'est pas coché", page_critere.hierarchie_checkbox.isEnabled());
		assertTrue("La checkbox activé n'est pas coché", page_critere.active_checkbox.isEnabled());
		TechnicalTools.fillFields(page_critere.description_field, critere_description_sauver);
		page_critere.sauver_btn.click();
		wait.until(ExpectedConditions.visibilityOf(page_critere.critere_message_sauver_continuer));
		TechnicalTools.takeSnapShot(driver, snap_path);
		assertEquals("Le critère ne c'est pas bien sauvegardé", "Type de critère \"Critère - Test bouton [Sauver et continuer]\" enregistré", page_critere.critere_message_sauver_continuer.getText());
		assertEquals("Le critère n'est pas en modification", "Modifier Type de critère: Critère - Test bouton [Sauver et continuer]", page_critere.criteres_modifier_header.getText());
		
		// Step 8 : Retour page d'administration des critères :
		page_critere.annuler_btn.click();
		wait.until(ExpectedConditions.visibilityOf(page_critere.criteres_header));
		assertEquals("Le tableau ne s'est pas annulé", "Types de critères Liste", page_critere.criteres_header.getText());
		assertFalse("Le bouton Annuler est présent", page_critere.annuler_btn.isDisplayed());
		
		// Step 9 : Modifier un critère - accès formulaire de modification - Colonne "Opération" :
		page_critere.critere_modifier_sauver_continuer_btn.click();
		assertEquals("Le critère n'est pas en modification", "Modifier Type de critère: Critère - Test bouton [Sauver et continuer]", page_critere.criteres_modifier_header.getText());
		
		// Step 10 : Modifier un critère -  Bouton [Annuler] :
		TechnicalTools.fillFields(page_critere.nom_input, critere_name_sauver2);
		page_critere.annuler_btn.click();
		assertEquals("Le tableau ne s'est pas annulé", "Types de critères Liste", page_critere.criteres_header.getText());
		assertEquals("L'élément ne s'est pas annulé", "Critère - Test bouton [Sauver et continuer]", page_critere.sauver_continuer_table_name.getText());
	}

}
