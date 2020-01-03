package eql.projet1.fr;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageTypeHeures extends PageAbstractMenu {
	@FindBy (xpath="//div[contains(text(), 'Code')]")
	WebElement code_th;
	
	@FindBy (xpath="//div[contains(text(), 'Nom de type')]")
	WebElement ndt_th;
	
	@FindBy (xpath="//div[contains(text(), 'Prix par défaut')]")
	WebElement ppd_th;

	@FindBy (xpath="//div[contains(text(), 'Activé')]")
	WebElement active_th;
	
	@FindBy (xpath="//div[contains(text(), 'Actions')]")
	WebElement actions_th;
	
	@FindBy (xpath="//td[contains(text(), 'Créer')]")
	WebElement creer_btn;
	
	@FindBy (xpath="//td[contains(text(), \"Créer Type d'heures\")]")
	WebElement creer_title;
	
	@FindBy (xpath="//span[contains(text(), \"Données du type d'heure de travail\")]")
	WebElement donneestypeheure_tab;
	
	@FindBy (xpath="//span[contains(text(), 'Code')]")
	WebElement code_td;
	
	@FindBy (xpath="//td/input[@style=\"width:300px;\"]")
	WebElement code_field;
	
	@FindBy (xpath="//td/span/input[@type=\"checkbox\"]")
	WebElement code_chckbx;
	
	@FindBy (xpath="//td/span/input[@type=\"checkbox\"]/following-sibling::label")
	WebElement code_chckbx_name;
	
	@FindBy (xpath="//span[contains(text(), 'Nom')]")
	WebElement nom_td;
	
	@FindBy (xpath="//td/div/input[not(@size)]")
	WebElement nom_field;
	
	@FindBy (xpath="//span[contains(text(), 'Prix par défaut')]")
	WebElement ppd_td;
	
	@FindBy (xpath="//input[@size='11']")
	WebElement ppd_field;
	
	@FindBy (xpath="//span[contains(text(), 'Activé')]")
	WebElement active_td;	
	
	@FindBy (xpath="//span[@style='width:300px;']/input[@type=\"checkbox\"]")
	WebElement active_chckbx;
	
	@FindBy (xpath="//td[contains(text(), 'Enregistrer')]")
	WebElement enregistrer_btn;
	
	@FindBy (xpath="//td[contains(text(), 'Sauver et continuer')]")
	WebElement savetcont_btn;
	
	@FindBy (xpath="//td[contains(text(), 'Annuler')]")
	WebElement annuler_btn;
}
