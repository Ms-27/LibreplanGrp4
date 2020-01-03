package eql.projet1.fr;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageTypeAvancement {

	@FindBy (xpath="//div[contains(text(), 'avancement')]")
	WebElement avancement_header;
	
	@FindBy (xpath="//div[contains(text(), 'Nom')]")
	WebElement nom_th;
	
	@FindBy (xpath="//div[contains(text(), 'Activé')]")
	WebElement act_th;
	
	@FindBy (xpath="//div[contains(text(), 'Prédéfini')]")
	WebElement pred_th;
	
	@FindBy (xpath="//div[contains(text(), 'Opérations')]")
	WebElement op_th;

	@FindBy(xpath = "//span[contains(text(), 'Modifier')]")
	WebElement modifier_tab;
	
	@FindBy(xpath = "//div[contains(text(), 'Nom d'unité')]")
	WebElement nom_unite_th;
	
	@FindBy(xpath ="//span[contains(text(), 'Actif')] " )
	WebElement actif_th;
	
	@FindBy(xpath ="//span[contains(text(), 'Valeur maximum par défaut')]")
	WebElement val_max_def_th;
	
	@FindBy(xpath ="//span[contains(text(), 'Précision')] ")
	WebElement precision_th;
	
	
	@FindBy(xpath ="//div[contains(text(), 'Type')]")
	WebElement type_th;

	@FindBy(xpath = "//span[contains(text(), 'Pourcentage')]")
	WebElement pourcentage_th;
	
	@FindBy (xpath="//td[contains(text(), 'Créer')]")
	WebElement creer_btn;
	
	@FindBy(xpath = "//td[contains(text(), 'Enregistrer')]")
	WebElement enregistrer_btn;
	
	@FindBy(xpath = "//td[contains(text(), 'Sauver')]")
	WebElement sauver_btn;
	
	@FindBy(xpath="//td[contains(text(), 'Annuler')]")
	WebElement annuler_btn;

	@FindBy(xpath="//input[contains(@class, 'focus-element')]")
	WebElement champ_nom_unite;


}
