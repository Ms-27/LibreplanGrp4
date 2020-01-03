package eql.projet1.fr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Test_AVA_01_SBA {
	
	WebDriver driver;
	String login = "admin";
	String pswd = "admin";
	
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
	public void testTypeAvancement() {
		// connexion à l'adresse de l'application
				driver.get("http://localhost:8090/libreplan/");
				assertEquals("Erreur titre de la page", "LibrePlan: accès utilisateur", driver.getTitle());
				
				// connexion
				PageLogin page_login = PageFactory.initElements(driver, PageLogin.class);
				PageIndex page_index = page_login.connect(driver, login, pswd);
				assertEquals("Erreur Ressources non présent", "Ressources ", page_index.ressources_btn.getText());
				
				// accès à la page Type d'Avancement
				PageTypeAvancement page_typeavancement = page_index.accesTypeAvancement(driver);
				assertEquals("Le Type d'avancement ne s'est pas chargé", "Types d'avancement Liste", page_typeavancement.avancement_header.getText());
				assertTrue(page_typeavancement.nom_th.isDisplayed());
				assertTrue(page_typeavancement.act_th.isDisplayed());
				assertTrue(page_typeavancement.pred_th.isDisplayed());
				assertTrue(page_typeavancement.op_th.isDisplayed());
				assertTrue(page_typeavancement.creer_btn.isDisplayed());
				
				assertTrue("Le bouton Créer n'est pas présent", page_typeavancement.creer_btn.isEnabled());
				// création d'un type d'avancement
				page_typeavancement.creer_btn.click();
				
				
	
				assertTrue("Le bouton Enregistrer n'est pas présent", page_typeavancement.enregistrer_btn.isEnabled());
				assertTrue("Le bouton Sauver et continuer n'est pas présent", page_typeavancement.sauver_btn.isEnabled());
				assertTrue("Le bouton Sauver et continuer n'est pas présent", page_typeavancement.annuler_btn.isEnabled());
				
	}
	

}
