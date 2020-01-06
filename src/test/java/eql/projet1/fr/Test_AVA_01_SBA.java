package eql.projet1.fr;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.sql.SQLException;
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
	String sql_path = "src/test/datasets/advance_type_create.sql";
	
	String login = "admin";
	String pswd = "admin";
	String val_max = "100,00";
	String precision = "0,1000";

	String nom_unite1 = "Type avancement - Test 1";
	String nom_unite2 = "Type avancement - Test 2";
	String val_max_defaut = "10,00";

	String msg_enregistrement2 = "Type d'avancement \"Type d'avancement - Test 2\" enregistré";


	@Before
	public void startup() throws ClassNotFoundException, FileNotFoundException, SQLException {
		driver = TechnicalTools.setBrowser(EBrowser.chrome);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		BddConnexion.setDataBase(sql_path);
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

		assertTrue("Le Nom d'unité n'est pas vide",page_typeavancement.nom_unite_input.getText().isEmpty());
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

		page_typeavancement = page_typeavancement.addTypeAvancement(driver, nom_unite1, val_max_defaut);

		wait.until(ExpectedConditions.visibilityOf(page_typeavancement.avancement_header));
		assertTrue("Erreur titre de la page",page_typeavancement.avancement_header.getText().contains("avancement Liste"));

		wait.until(ExpectedConditions.visibilityOf(page_typeavancement.enregister_msg));
		String m = page_typeavancement.enregister_msg.getText();
		assertEquals("Message d'enregistrement non affiché","Type d'avancement \"Type avancement - Test 1\" enregistré",m);

		assertFalse("La Case est cochée",page_typeavancement.actif_checkbox.isSelected());
		assertFalse("La Case peut être sélectionnée",page_typeavancement.actif_checkbox.isDisplayed());

		assertTrue("L'icone supprimer n'est pas visible",page_typeavancement.supprimer_icon.isDisplayed());
		assertTrue("L'icone supprimer n'est pas visible",page_typeavancement.modifier_icon.isDisplayed());

		// Accès au formulaire de création

		page_typeavancement.creer_btn.click();
		wait.until(ExpectedConditions.visibilityOf(page_typeavancement.creer_type_header));
		assertTrue("Erreur titre de la page",page_typeavancement.creer_type_header.getText().contains("Créer Type"));

		page_typeavancement.addAvancementSansPour(driver, nom_unite2);
		Thread.sleep(2000);
		assertFalse("Valeur maximum par défaut est modifiable",page_typeavancement.val_max_input.isEnabled());
		Thread.sleep(2000);
		page_typeavancement.sauver_btn.click();


		assertEquals("Erreur titre la page","Modifier Type d'avancement: Type avancement - Test 2",page_typeavancement.modifier_type_header.getText());
		assertEquals("Message d'enregistrement n'est pas correct","Type d'avancement \"Type avancement - Test 2\" enregistré", page_typeavancement.enregister_msg.getText());
		wait.until(ExpectedConditions.visibilityOf(page_typeavancement.enregister_msg));
		page_typeavancement.annuler_btn.click();
		
		String s = page_typeavancement.avancement_header.getText();
		System.out.println(s);
		System.out.println("erreur");
		//assertTrue("Erreur titre de la page",page_typeavancement.avancement_header.getText().contains("avancement Liste"));

	}


}
