package eql.projet1.fr;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Test_PRO_TA_05_JRE {

	WebDriver driver;
	String login = "admin";
	String pswd = "admin";
	String project_name = "PROJET_TEST1";
	String project_code = "PRJTEST001";
	String snap_path = "src/test/snapshots/debug.png";

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
	public void testCreationProjet() throws Exception {
		//Step1
		driver.get("http://localhost:8090/libreplan/");
		assertEquals("Erreur titre de la page", "LibrePlan: accès utilisateur", driver.getTitle());	
		PageLogin page_login = PageFactory.initElements(driver, PageLogin.class);
		PageIndex page_index = page_login.connect(driver, login, pswd);
		assertTrue("Le bouton utilisateur n'est pas présent",page_index.user_txt.isDisplayed());
		assertTrue("Le nom de l'utilisateur n'est pas correct",page_index.user_txt.getText().contains("admin"));

		//Step2
		page_index.print_ico.click();
		assertEquals("Titre de la popup incorrect","Imprimer la configuration", page_index.name_print_popup.getText());
		assertEquals("Titre de la légende de la popup incorrect","Options d'export", page_index.legend_print_popup.getText());
		assertTrue("La checkbox : Afficher les libellés n'est pas cochée",page_index.checkbox1_print_popup.isSelected());
		assertTrue("La checkbox : Montrer les affectations de ressource n'est pas cochée",page_index.checkbox2_print_popup.isSelected());
		assertTrue("La checkbox : Etendre les groupes de tâches n'est pas cochée",page_index.checkbox3_print_popup.isSelected());
		assertTrue("La checkbox : Afficher l'avancement n'est pas cochée",page_index.checkbox4_print_popup.isSelected());
		assertTrue("La checkbox : Afficher toutes les heures rapportées n'est pas cochée",page_index.checkbox5_print_popup.isSelected());
		assertTrue("La checkbox : Afficher la barre de coût monétaire n'est pas cochée",page_index.checkbox6_print_popup.isSelected());
		assertEquals("Le texte de la popup n'est pas correct","Merci de vous rappeler que seules les modifications enregistrées seront affichées", page_index.text_print_popup.getText());
		assertTrue("Le bouton de validation n'est pas présent",page_index.validate_print_popup_btn.isDisplayed());
		assertTrue("Le bouton d'annulation n'est pas présent",page_index.cancel_print_popup_btn.isDisplayed());
		
		//Step3
		page_index.cancel_print_popup_btn.click();
		Thread.sleep(50);
		try {
			assertFalse("La popup d'impression est toujours présente",page_index.name_print_popup.isDisplayed());
		}
		catch (NoSuchElementException e) {}	
	
		//Step4
		page_index.print_ico.click();
		assertEquals("Imprimer la configuration", page_index.name_print_popup.getText());
		assertEquals("Options d'export", page_index.legend_print_popup.getText());
		assertTrue("La checkbox : Afficher les libellés n'est pas cochée",page_index.checkbox1_print_popup.isSelected());
		assertTrue("La checkbox : Montrer les affectations de ressource n'est pas cochée",page_index.checkbox2_print_popup.isSelected());
		assertTrue("La checkbox : Etendre les groupes de tâches n'est pas cochée",page_index.checkbox3_print_popup.isSelected());
		assertTrue("La checkbox : Afficher l'avancement n'est pas cochée",page_index.checkbox4_print_popup.isSelected());
		assertTrue("La checkbox : Afficher toutes les heures rapportées n'est pas cochée",page_index.checkbox5_print_popup.isSelected());
		assertTrue("La checkbox : Afficher la barre de coût monétaire n'est pas cochée",page_index.checkbox6_print_popup.isSelected()); 
		assertEquals("Le texte de la popup n'est pas correct","Merci de vous rappeler que seules les modifications enregistrées seront affichées", page_index.text_print_popup.getText());
		assertTrue("Le bouton de validation n'est pas présent",page_index.validate_print_popup_btn.isDisplayed());
		assertTrue("Le bouton d'annulation n'est pas présent",page_index.cancel_print_popup_btn.isDisplayed());
		
		//Step5
		page_index.checkbox1_print_popup.click();
		page_index.checkbox2_print_popup.click();
		page_index.checkbox3_print_popup.click();
		page_index.checkbox4_print_popup.click();
		page_index.checkbox5_print_popup.click();
		page_index.checkbox6_print_popup.click();
		
		page_index.validate_print_popup_btn.click();
		
		TechnicalTools.takeSnapShot(driver, snap_path);
		System.out.println(page_index.error_title_popup.getText());
		System.out.println(page_index.error_code_popup.getText());
		System.out.println(page_index.error_text_popup.getText());
		
}
}