package eql.projet1.fr;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

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
	
	@FindBy (xpath="//td/div/input[@size]")
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
	
	@FindBy (xpath="//div[contains(@class, 'z-arrow')]")
	WebElement arrow_alert;
	
	@FindBy (xpath="//div[contains(@class, '-close')]")
	WebElement cross_alert;
	
	@FindBy (xpath="//div[contains(text(), 'Vous devez spécifier un nombre au lieu de Prix 1.')]")
	WebElement msg_alert1;
	
	@FindBy (xpath="//div[contains(text(), 'ne peut pas être vide')]")
	WebElement msg_alert2;
	
	// 
	@FindBy (xpath="//img[contains(@src, 'ico_borrar')]")
    WebElement img_trash;
	
	@FindBy (xpath="//td[text()='OK']")
	WebElement Ok_del_btn;
}
