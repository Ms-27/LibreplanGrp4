package eql.projet1.fr;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.*;

public class Test_GCO_01_OBO {

	WebDriver driver;
	static Logger logger = LoggerFactory.getLogger(Test_GCO_01_OBO.class);
	//JDD
	String login = "admin";
	String pswd = "admin";
	
	@Before
	public void setUp() {
		driver = TechnicalTools.setBrowser(EBrowser.chrome);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() {
		// on supprime ce qu'on vient de créer pour remettre l'application dans son état initial
		driver.findElement(By.xpath("//img[contains(@src, 'ico_borrar')]")).click();
		driver.findElement(By.xpath("//td[text()='OK']")).click();
		// déconnexion
		driver.findElement(By.xpath("//a[contains(@href, 'logout')]")).click();
		// fermeture du navigateur
		driver.quit();
	}
	
	@Test
	public void testGCO01() throws Exception{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		// connexion à l'adresse de l'application
		driver.get("http://localhost:8090/libreplan/");
		assertEquals("Erreur titre de la page", "LibrePlan: accès utilisateur", driver.getTitle());
		
		// connexion
		PageLogin page_login = PageFactory.initElements(driver, PageLogin.class);
		PageIndex page_index = page_login.connect(driver, login, pswd);
		assertTrue("l'onglet calendrier ne s'affiche pas", page_index.calendrier_tab.isDisplayed());
		
		// accès à la page Type d'Heures
		PageTypeHeures page_typeheures = page_index.accessTypeHeures(driver);
		assertEquals("Erreur titre de la page", "LibrePlan: Types d'heures", driver.getTitle());
		//TechnicalTools.assertEqualsLogger(logger, "Erreur titre de la page", "Castorama", driver.getTitle());
		//TechnicalTools.assertEqualsLogger(logger, "Erreur titre de la page", "LibrePlan: Types d'heures", driver.getTitle());
		assertTrue("Code: ne s'affiche pas en titre de colonne",page_typeheures.code_th.isDisplayed());
		assertTrue("Nom de type: ne s'affiche pas en titre de colonne",page_typeheures.ndt_th.isDisplayed());
		assertTrue("Prix par défaut: ne s'affiche pas en titre de colonne",page_typeheures.ppd_th.isDisplayed());
		assertTrue("Activé: ne s'affiche pas en titre de colonne",page_typeheures.active_th.isDisplayed());
		assertTrue("Actions: ne s'affiche pas en titre de colonne",page_typeheures.actions_th.isDisplayed());
		assertTrue("Le bouton Créer ne s'affiche pas",page_typeheures.creer_btn.isDisplayed());
		
		// création d'un type d'heure
		page_typeheures.creer_btn.click();
		// vérification du titre un d'un élément de la page
		assertTrue("Erreur titre de section", page_typeheures.creer_title.getText().contains("Créer Type d'heures"));
		assertTrue("Erreur titre d'onglet", page_typeheures.donneestypeheure_tab.getText().contains("Données du type d'heure de travail"));
		
		// 
		assertTrue("Pas d'affichage titre ligne: Code", page_typeheures.code_td.getText().contains("Code"));
		//TechnicalTools.assertFalseLogger(logger,"Pas d'affichage titre ligne: Code", page_typeheures.code_td.getText().contains("Code"));
		assertFalse("Le champ Code est éditable", page_typeheures.code_field.isEnabled());
		//TechnicalTools.assertTrueLogger(logger, "Le champ Code est éditable", page_typeheures.code_field.isEnabled());
		assertFalse("Le champ Code est vide", page_typeheures.code_field.getAttribute("value").isEmpty());
		
		assertTrue("La checkbox Cod n'est pas présente", page_typeheures.code_chckbx.isDisplayed());
		assertTrue("La checkbox Générer le code n'est pas cochée", page_typeheures.code_chckbx.isSelected());
		assertTrue("Le nom de la checkbox Code n'est pas le bon", page_typeheures.code_chckbx_name.getText().contains("Générer le code"));
		
		assertTrue("Pas d'affichage titre ligne: Nom", page_typeheures.nom_td.getText().contains("Nom"));
		assertTrue("Le champ Nom n'est pas vide", page_typeheures.nom_field.getAttribute("value").isEmpty());
		assertTrue("Pas d'affichage titre ligne: Prix par défaut", page_typeheures.ppd_td.getText().contains("Prix par défaut"));
		assertTrue("Le champ Prix par défaut n'est pas vide", page_typeheures.ppd_field.getAttribute("value").isEmpty());
		assertTrue("Pas d'affichage titre ligne: Activé", page_typeheures.active_td.getText().contains("Activé"));
		assertTrue("Le champ Prix par défaut n'est pas vide", page_typeheures.active_chckbx.isSelected());
		
		assertTrue("Bouton Enregistrer non présent", page_typeheures.enregistrer_btn.isDisplayed());
		assertTrue("Bouton Sauver et continuer non présent", page_typeheures.savetcont_btn.isDisplayed());
		assertTrue("Bouton Annuler non présent", page_typeheures.annuler_btn.isDisplayed());
		
		// on renseigne la valeur Prix 1 dans le champ nom, on la copie et on la colle dans le champ Prix par défaut
		TechnicalTools.fillFields(page_typeheures.nom_field, "Prix 1");
		Actions a = new Actions(driver);
		a.moveToElement(page_typeheures.nom_field).click().build().perform();
		page_typeheures.nom_field.sendKeys(Keys.CONTROL + "a");
		page_typeheures.nom_field.sendKeys(Keys.CONTROL + "c");
		a.moveToElement(page_typeheures.ppd_field).click().build().perform();
		page_typeheures.ppd_field.sendKeys(Keys.CONTROL + "v");
		page_typeheures.enregistrer_btn.click();
		Thread.sleep(300);
		
		// on vérifie la présence d'une flèche et d'une croix sur le message d'erreur
		assertTrue(page_typeheures.arrow_alert.isDisplayed());
		assertTrue(page_typeheures.cross_alert.isDisplayed());
		// on teste la couleur du cadre et le message de l'alerte

		assertTrue(page_typeheures.frame_alert.getCssValue("color").equals("rgba(255, 0, 0, 1)"));
		assertTrue(page_typeheures.msg1_alert.isDisplayed());
		
		// on remplit la valeur du champ prix par défaut	
		TechnicalTools.fillFields(page_typeheures.ppd_field, "150");
		a.moveToElement(page_typeheures.nom_field).click().build().perform();
		// on vérfie la vlaeur du champ Prix par défaut
		assertTrue(page_typeheures.ppd_field.getAttribute("value").equals("150 €"));
		
		// on décoche la checkbox Code et on supprime la valeur du champ code
		page_typeheures.code_chckbx.click();
		a.moveToElement(page_typeheures.code_field).click().build().perform();
		page_typeheures.code_field.clear();
		assertTrue(page_typeheures.code_field.getAttribute("value").isEmpty());
		
		// on vérifie la présence d'une flèch et d'une croix sur le message d'erreur
		assertTrue(page_typeheures.arrow_alert.isDisplayed());
		assertTrue(page_typeheures.cross_alert.isDisplayed());
		// on teste la couleur du cadre et le message de l'alerte
		assertTrue(page_typeheures.frame_alert.getCssValue("color").equals("rgba(255, 0, 0, 1)"));
		assertTrue(page_typeheures.msg2_alert.isDisplayed());
		
		// on renseigne une valeur pour le champ Code
		TechnicalTools.fillFields(page_typeheures.code_field, "code-de-test");
		// on clique sur le bouton enregistrer
		page_typeheures.enregistrer_btn.click();
		
		System.out.println(page_typeheures.typeheures_title.getAttribute("value"));
		//assertTrue(page_typeheures.typeheures_title.getText().contains("heures Liste"));
		//assertTrue(page_typeheures.frame_alert.getCssValue("color").equals("rgba(255, 0, 0, 1)"));
		//System.out.println(page_typeheures.msg3_alert.getAttribute("color"));
		//assertTrue(page_typeheures.msg3_alert.getText().contains("Type d'heures \"Prix1\" enregistré"));
		
		System.out.println(page_typeheures.msg3_alert.getText());
		
		page_typeheures.price_by_name_link.click();
		
		page_typeheures.annuler_btn.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(page_typeheures.code_by_name_link));
		page_typeheures.code_by_name_link.click();
		
		page_typeheures.active_chckbx.click();
		page_typeheures.enregistrer_btn.click();
		Thread.sleep(500);
		
		// on vérifie la couleur du cadre du message d'erreur et le message affiché dedans
		//assertTrue("Message d'alerte non affiché", page_typeheures.msg4_alert.isDisplayed());
		//assertTrue(page_typeheures.frame_alert.getCssValue("color").equals("rgba(204, 80, 19, 1)"));
		
	}
}
