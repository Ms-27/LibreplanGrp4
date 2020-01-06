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
	public void testCreationProjet() throws InterruptedException {
		//Step1
		driver.get("http://localhost:8090/libreplan/");
		assertEquals("Erreur titre de la page", "LibrePlan: accès utilisateur", driver.getTitle());	
		PageLogin page_login = PageFactory.initElements(driver, PageLogin.class);
		PageIndex page_index = page_login.connect(driver, login, pswd);
		assertTrue(page_index.user_txt.isDisplayed());
		assertTrue(page_index.user_txt.getText().contains("admin"));

		//Step2
		page_index.print_ico.click();
		assertEquals("Imprimer la configuration", page_index.name_print_popup.getText());
		assertEquals("Options d'export", page_index.legend_print_popup.getText());
		assertTrue(page_index.checkbox1_print_popup.isSelected());
		assertTrue(page_index.checkbox2_print_popup.isSelected());
		assertTrue(page_index.checkbox3_print_popup.isSelected());
		assertTrue(page_index.checkbox4_print_popup.isSelected());
		assertTrue(page_index.checkbox5_print_popup.isSelected());
		assertTrue(page_index.checkbox6_print_popup.isSelected());
		assertEquals("Merci de vous rappeler que seules les modifications enregistrées seront affichées", page_index.text_print_popup.getText());
		assertTrue(page_index.validate_print_popup_btn.isDisplayed());
		assertTrue(page_index.cancel_print_popup_btn.isDisplayed());
		
		//Step3
		page_index.cancel_print_popup_btn.click();
		Thread.sleep(50);
		try {
			assertFalse(page_index.name_print_popup.isDisplayed());
		}
		catch (NoSuchElementException e) {}	
	
		//Step4
		page_index.print_ico.click();
		assertEquals("Imprimer la configuration", page_index.name_print_popup.getText());
		assertEquals("Options d'export", page_index.legend_print_popup.getText());
		assertTrue(page_index.checkbox1_print_popup.isSelected());
		assertTrue(page_index.checkbox2_print_popup.isSelected());
		assertTrue(page_index.checkbox3_print_popup.isSelected());
		assertTrue(page_index.checkbox4_print_popup.isSelected());
		assertTrue(page_index.checkbox5_print_popup.isSelected());
		assertTrue(page_index.checkbox6_print_popup.isSelected());
		assertEquals("Merci de vous rappeler que seules les modifications enregistrées seront affichées", page_index.text_print_popup.getText());
		assertTrue(page_index.validate_print_popup_btn.isDisplayed());
		assertTrue(page_index.cancel_print_popup_btn.isDisplayed());
		
		//Step5
		page_index.checkbox1_print_popup.click();
		page_index.checkbox2_print_popup.click();
		page_index.checkbox3_print_popup.click();
		page_index.checkbox4_print_popup.click();
		page_index.checkbox5_print_popup.click();
		page_index.checkbox6_print_popup.click();
		
		page_index.validate_print_popup_btn.click();
}
}