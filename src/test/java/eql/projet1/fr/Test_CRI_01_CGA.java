package eql.projet1.fr;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Test_CRI_01_CGA {

	WebDriver driver;

	// JDD
	String snapPath = "src/test/snapshots/debug.png";
	String snapPath1 = "src/test/snapshots/debug1.png";
	String login = "admin";
	String password = "admin";
	String critere_name = "Critère - Test bouton [Annuler]";
	String critere_description = "Critère - Test bouton [Annuler]";
	String critere_name1 = "Critère - Test bouton [Enregistrer]";
	String critere_description1 = "Critère - Test bouton [Enregistrer]";

	String filePath = "src/test/snapshots/debug_participant.png";

	@Before
	public void startup() throws Exception {
		driver = TechnicalTools.setBrowser(EBrowser.chrome);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@After
	public void teardDown() throws Exception {
		driver.quit();
		BddConnexion.deleteSpecificData("src/test/JDD/nettoyage_criterion_type.xml");
	}

	@Test
	public void test() throws Exception {
		// Connexion à l'application
		driver.get("http://localhost:8090/libreplan/");
		assertEquals("Erreur titre de la page", "LibrePlan: accès utilisateur", driver.getTitle());

		// Accès à la page Index
		PageLogin page_login = PageFactory.initElements(driver, PageLogin.class);
		PageIndex page_index = page_login.connect(driver, login, password);
		assertEquals("Erreur Ressources non présent", "Ressources ", page_index.ressources_btn.getText());

		// Accès à la page Critere du sous menu Ressources
		PageCritere page_critere = page_index.accesCritere(driver);
		assertEquals("La page Critere ne c'est pas chargé", "Types de critères Liste", page_critere.criteres_header.getText());
		assertEquals("Le tableau n'est pas correct", "Nom", page_critere.nom_th.getText());
		assertEquals("Le tableau n'est pas correct", "Code", page_critere.code_th.getText());
		assertEquals("Le tableau n'est pas correct", "Type", page_critere.type_th.getText());
		assertEquals("Le tableau n'est pas correct", "Activé", page_critere.active_th.getText());
		assertEquals("Le tableau n'est pas correct", "Opérations", page_critere.operation_th.getText());
		assertTrue("Le bouton Créer n'existe pas", page_critere.creer_btn.isEnabled());

		// Accès au formulaire Créer types de critère
		page_critere.creer_btn.click();
		assertTrue("Le bouton Enregistrer n'est pas présent", page_critere.enregistrer_btn.isEnabled());
		assertTrue("Le bouton Sauver et Continuer n'est pas présent", page_critere.sauver_btn.isEnabled());
		assertTrue("Le bouton Annuler n'est pas présent", page_critere.annuler_btn.isEnabled());

		// Créer un critère - bouton [Annuler] 
		TechnicalTools.fillFields(page_critere.nom_input, critere_name);
		page_critere.type_dropdown_btn.click();
		page_critere.participant_ddm_content.click();
		assertTrue("La checkbox valeur multiple par ressource n'est pas coché", page_critere.valeur_multiple_ressources_checkbox.isEnabled());
		assertTrue("La checkbox hiérarchie n'est pas coché", page_critere.hierarchie_checkbox.isEnabled());
		assertTrue("La checkbox activé n'est pas coché", page_critere.active_checkbox.isEnabled());

		TechnicalTools.fillFields(page_critere.description_field, critere_description);
		page_critere.annuler_btn.click();
		Thread.sleep(2000);
		assertEquals("Le tableau ne s'est pas annulé", "Types de critères Liste", page_critere.criteres_header.getText());
		assertFalse("Le bouton Annuler est présent", page_critere.annuler_btn.isDisplayed());
		
		// Créer un critère - bouton [Enregistrer]
		page_critere.creer_btn.click();
		assertTrue("Le bouton Enregistrer n'est pas présent", page_critere.enregistrer_btn.isEnabled());
		assertTrue("Le bouton Sauver et Continuer n'est pas présent", page_critere.sauver_btn.isEnabled());
		assertTrue("Le bouton Annuler n'est pas présent", page_critere.annuler_btn.isEnabled());
		TechnicalTools.fillFields(page_critere.nom_input, critere_name1);
		page_critere.type_dropdown_btn.click();
		page_critere.participant_ddm_content.click();
		assertTrue("La checkbox valeur multiple par ressource n'est pas coché", page_critere.valeur_multiple_ressources_checkbox.isEnabled());
		assertTrue("La checkbox hiérarchie n'est pas coché", page_critere.hierarchie_checkbox.isEnabled());
		assertTrue("La checkbox activé n'est pas coché", page_critere.active_checkbox.isEnabled());

		TechnicalTools.fillFields(page_critere.description_field, critere_description1);
		TechnicalTools.takeSnapShot(driver, snapPath);
		page_critere.enregistrer_btn.click();
		TechnicalTools.takeSnapShot(driver, snapPath1);
		assertEquals("Le tableau ne s'est pas enregistré", "Types de critères Liste", page_critere.criteres_header.getText());
		

	}

}
