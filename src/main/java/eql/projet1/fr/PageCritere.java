package eql.projet1.fr;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageCritere {

	@FindBy(xpath = "//div[contains(text(), 'critère')]")
	WebElement criteres_header;
	
	@FindBy(xpath = "//span[contains(text(), 'Modifier')]")
	WebElement modifier_tab;

	@FindBy(xpath = "//div[contains(text(), 'Code')]")
	WebElement code_th;

	@FindBy(xpath = "//div[contains(text(), 'Nom')]")
	WebElement nom_th;

	@FindBy(xpath = "//div[contains(text(), 'Type')][contains(@class, 'column-cnt')]")
	WebElement type_th;

	@FindBy(xpath = "//div[contains(text(), 'Activé')]")
	WebElement active_th;

	@FindBy(xpath = "//div[contains(text(), 'Opération')]")
	WebElement operation_th;

	@FindBy(xpath = "//td[contains(text(), 'Créer')]")
	WebElement creer_btn;
	
	@FindBy(xpath = "//td[contains(text(), 'Enregistrer')]")
	WebElement enregistrer_btn;
	
	@FindBy(xpath = "//td[contains(text(), 'Sauver')]")
	WebElement sauver_btn;
	
	@FindBy(xpath = "//td[contains(text(), 'Annuler')]")
	WebElement annuler_btn;

}
