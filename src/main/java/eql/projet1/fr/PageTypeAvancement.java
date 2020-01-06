package eql.projet1.fr;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageTypeAvancement {


	
	@FindBy (xpath="//div[contains(text(), 'avancement Liste')]")
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
	
	@FindBy(xpath ="//div[2]/div/div/div/div[3]/table/tbody[2]/tr[2]/td[2]/div/span/input" )
	WebElement actif_checkbox;
	
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
	WebElement nom_unite_input;
	
	@FindBy(xpath="//tr[3]/td[2]/div/input")
	WebElement val_max_input;
	
	@FindBy(xpath="//tr[4]/td[2]/div/input")
	WebElement precision_input;

	@FindBy(xpath = "//span[contains(text(), 'User')]")
	WebElement user_input;
	
	@FindBy(xpath = "//tr[6]/td[2]/div/span/input")
	WebElement pourcentage_checkbox;	
	
	@FindBy(xpath = "//td/table/tbody/tr/td/div/span")
	WebElement enregister_msg;

	@FindBy(xpath = "//tr[6]//tr[2]/td[2]/img[@src='/libreplan/common/img/ico_borrar1.png']")
	WebElement supprimer_icon;
	
	@FindBy(xpath = "//tr[6]//tr[2]/td[2]/img[@src='/libreplan/common/img/ico_editar1.png']")
	WebElement modifier_icon;

	
	public PageTypeAvancement addTypeAvancement(WebDriver d, String nom, String val_max) {
		TechnicalTools.fillFields(nom_unite_input, nom);
		actif_checkbox.click();
		TechnicalTools.fillFields(val_max_input, val_max);
		enregistrer_btn.click();
		
		return PageFactory.initElements(d, PageTypeAvancement.class);
	}

}
