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
	
	//JDD
	String login = "admin";
	String password = "admin";
	
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
	public void test() {
		driver.get("http://localhost:8090/libreplan/");
		assertEquals("Erreur titre de la page", "LibrePlan: accès utilisateur", driver.getTitle());
		
		PageLogin page_login = PageFactory.initElements(driver, PageLogin.class);
		PageIndex page_index = page_login.connect(driver, login, password);
		assertEquals("Erreur Ressources non présent", "Ressources ", page_index.ressources_btn.getText());
		
		PageCritere page_critere = page_index.accesCritere(driver);
		assertEquals("La page Critere ne c'est pas chargé", "Types de critères Liste", page_critere.criteres_header.getText());
		assertEquals("Le tableau n'est pas correct", "Nom", page_critere.nom_th.getText());
		assertEquals("Le tableau n'est pas correct", "Code", page_critere.code_th.getText());
		assertEquals("Le tableau n'est pas correct", "Type", page_critere.type_th.getText());
		assertEquals("Le tableau n'est pas correct", "Activé", page_critere.active_th.getText());
		assertEquals("Le tableau n'est pas correct", "Opérations", page_critere.operation_th.getText());
		assertTrue("Le bouton Créer n'existe pas", page_critere.creer_btn.isEnabled());
		
		page_critere.creer_btn.click();
		assertTrue("Le bouton Enregistrer n'est pas présent", page_critere.enregistrer_btn.isEnabled());
		
	}

}
