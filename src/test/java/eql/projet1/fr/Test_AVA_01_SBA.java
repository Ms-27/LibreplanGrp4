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

public class Test_AVA_01_SBA {

	WebDriver driver;
	String login = "admin";
	String pswd = "admin";
	String val_max = "100,00";
	String precision = "0,1000";

	String nom_unite = "Type avancement - Test 1";
	String val_max_defaut = "10,00";


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
	public void testTypeAvancement() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 10);

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

		assertEquals("Le Nom d'unité n'est pas vide","",page_typeavancement.nom_unite_input.getText());
		assertTrue("La case Actif n'est pas cochée par défaut",page_typeavancement.actif_checkbox.isEnabled());
		assertEquals("La valeur par defaut de la valeur max n'est pas celle attendue",val_max,page_typeavancement
				.val_max_input.getAttribute("value"));
		assertEquals("La valeur par defaut de la précision n'est pas celle attendue",precision,page_typeavancement
				.precision_input.getAttribute("value"));

		assertEquals("La valeur User est modifiable",null,page_typeavancement.user_input.getAttribute("value"));

		assertFalse("La case pourcentage est cochée",page_typeavancement.pourcentage_checkbox.isSelected());


		assertTrue("Le bouton Enregistrer n'est pas présent", page_typeavancement.enregistrer_btn.isEnabled());
		assertTrue("Le bouton Sauver et continuer n'est pas présent", page_typeavancement.sauver_btn.isEnabled());
		assertTrue("Le bouton Annuler n'est pas présent", page_typeavancement.annuler_btn.isEnabled());


		// création d'un type d'avancement - sans pourcentage 

		page_typeavancement = page_typeavancement.addTypeAvancement(driver, nom_unite, val_max_defaut);

		wait.until(ExpectedConditions.visibilityOf(page_typeavancement.avancement_header));
		assertTrue("Erreur titre de la page",page_typeavancement.avancement_header.getText().contains("avancement Liste"));

		wait.until(ExpectedConditions.visibilityOf(page_typeavancement.enregister_msg));
		assertTrue("Message d'enregistrement non affiché",page_typeavancement.enregister_msg.getText().contains("enregistré"));

		
		assertFalse("La Case est cochée",page_typeavancement.actif_checkbox.isSelected());
		assertFalse("La Case peut être sélectionnée",page_typeavancement.actif_checkbox.isDisplayed());
		
		//assertTrue("L'icone supprimer n'est pas visible")
		

	}


}
