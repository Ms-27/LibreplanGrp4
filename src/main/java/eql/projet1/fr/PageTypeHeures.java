package eql.projet1.fr;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageTypeHeures extends PageAbstractMenu {
	// famille de titre de colonne du tableau
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
	
	// bouton Créer
	@FindBy (xpath="//td[contains(text(), 'Créer')]")
	WebElement creer_btn;
	
	// Titres de la apge
	@FindBy (xpath="//td[contains(text(), \"Créer Type d'heures\")]")
	WebElement creer_title;
	
	@FindBy (xpath="//div[contains(text(), 'Types')]")
	WebElement typeheures_title;
	
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
	
	// élément des messages d'alerte
	@FindBy (xpath="//div[@class='z-errbox z-popup']")
	WebElement frame_alert;
	
	@FindBy (xpath="//div[contains(@class, 'z-arrow')]")
	WebElement arrow_alert;
	
	@FindBy (xpath="//div[contains(@class, '-close')]")
	WebElement cross_alert;
	
	@FindBy (xpath="//div[contains(text(), 'Vous devez spécifier un nombre au lieu de Prix 1.')]")
	WebElement msg1_alert;
	
	@FindBy (xpath="//div[contains(text(), 'ne peut pas être vide')]")
	WebElement msg2_alert;
	
	@FindBy (xpath="//img[contains(@src, 'ico_ok.png')]/following-sibling::span")
	WebElement msg3_alert;
	
	@FindBy (xpath="//div[contains(text(), 'le type d'heures de travail pour les feuilles de temps personnelles ne peut pas être désactivé')]")
	WebElement msg4_alert;
	
	// sélection d'un lien par le nom du type d'heure
	@FindBy (xpath="//span[.='Prix 1']/../../following-sibling::td/div")
	WebElement price_by_name_link;
	
	@FindBy (xpath="//span[.='Prix 1']/../../preceding-sibling::td/div")
	WebElement code_by_name_link;
}
