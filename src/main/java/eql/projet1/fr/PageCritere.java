package eql.projet1.fr;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageCritere {

	@FindBy(xpath = "//div[contains(text(), 'critère')]")
	WebElement criteres_header;

	@FindBy(xpath = "//td[contains(text(), 'Modifier Type de critère')]")
	WebElement criteres_modifier_header;

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

	@FindBy(xpath = "//span[@class='save-button global-action z-button']/table")
	WebElement enregistrer_btn;

	@FindBy(xpath = "//span[@class='saveandcontinue-button global-action z-button']/table")
	WebElement sauver_btn;

	@FindBy(xpath = "//span[@class='cancel-button global-action z-button']/table")
	WebElement annuler_btn;

	@FindBy(xpath = "//div[contains(@class, 'row-cnt')]/input[@class=\"z-textbox\"]")
	WebElement nom_input;

	@FindBy(xpath = "//input[@class='z-combobox-inp']")
	WebElement type_input;

	@FindBy(xpath = "//i[@class=\"z-combobox-btn\"]")
	WebElement type_dropdown_btn;

	@FindBy(xpath = "//td[contains(text(), 'PARTICIPANT')]")
	WebElement participant_ddm_content;

	@FindBy(xpath = "//tr[3]/td[2]/div/span/input")
	WebElement valeur_multiple_ressources_checkbox;

	@FindBy(xpath = "//tr[4]/td[2]/div/span/input")
	WebElement hierarchie_checkbox;

	@FindBy(xpath = "//tr[5]/td[2]/div/span/input")
	WebElement active_checkbox;

	@FindBy(xpath = "//textarea")
	WebElement description_field;

	@FindBy(xpath = "//div[contains(@class, 'z-row')]/span[contains(text(), 'Test bouton')]")
	WebElement critere_test_table;

	@FindBy(xpath = "//span[contains(text(), '[Sauver et continuer]')]")
	WebElement critere_message_sauver_continuer;

	@FindBy(xpath = "//tr[3]/td[5]//img[contains(@src, 'editar1')]")
	WebElement critere_modifier_sauver_continuer_btn;

	@FindBy(xpath = "//span[@title='Critère - Test bouton [Sauver et continuer]']/..")
	WebElement sauver_continuer_table_name;

	@FindBy(xpath = "//td[text()='Modifier Type de critère: Critère - Test bouton [Sauver et continuer]']")
	WebElement modification_sauver_continuer_title;
	
	@FindBy(xpath = "//span[text()='Type de critère \"Critère - Test bouton [Sauver et continuer] 2\" enregistré']")
	WebElement sauver_continuer_message;
	
	@FindBy(xpath = "//span[text()='Critère - Test bouton [Sauver et continuer] 2']")
	WebElement sauver_continuer2_table_name;
}
