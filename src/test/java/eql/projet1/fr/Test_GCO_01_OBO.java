package eql.projet1.fr;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Test_GCO_01_OBO {

	WebDriver driver;
	String login = "admin";
	String pswd = "admin";
	
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
	public void testConnexion() {
		// connexion à l'adresse de l'application
		driver.get("http://localhost:8090/libreplan/");
		assertEquals("Erreur titre de la page", "LibrePlan: accès utilisateur", driver.getTitle());
		
		// connexion
		PageLogin page_login = PageFactory.initElements(driver, PageLogin.class);
		PageIndex page_index = page_login.connect(driver, login, pswd);
		assertTrue(page_index.calendrier_tab.isDisplayed());
		
		// accès à la page Type d'Heures
		PageTypeHeures page_typeheures = page_index.accessTypeHeures(driver);
		assertEquals("Erreur titre de la page", "LibrePlan: Types d'heures", driver.getTitle());
		assertTrue(page_typeheures.code_th.isDisplayed());
		assertTrue(page_typeheures.ndt_th.isDisplayed());
		assertTrue(page_typeheures.ppd_th.isDisplayed());
		assertTrue(page_typeheures.active_th.isDisplayed());
		assertTrue(page_typeheures.actions_th.isDisplayed());
		assertTrue(page_typeheures.creer_btn.isDisplayed());
		
		// création d'un type d'heure
		page_typeheures.creer_btn.click();
		assertTrue(page_typeheures.creer_title.getText().contains("Créer Type d'heures"));
		assertTrue(page_typeheures.donneestypeheure_tab.getText().contains("Données du type d'heure de travail"));
		
		//
		assertTrue(page_typeheures.code_td.getText().contains("Code"));
		assertFalse(page_typeheures.code_field.getAttribute("disabled").isEmpty());
		
<<<<<<< Updated upstream
		
=======
>>>>>>> Stashed changes

		///findBy => champ nom & champ prix par def & btn rec
		/// TT.fillField(nom_field, "Prix 1");
		///	String s = page_XXX.nom_field.getAttribute("value");
		/// TT.fillField(prixpardef_field, "");
		/// page_XXX.rec_btn.click();

		
		
		// déconnexion
		page_index.signout_btn.click();
	}
}
