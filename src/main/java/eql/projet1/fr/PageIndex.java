package eql.projet1.fr;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageIndex extends PageAbstractMenu {
	
	
	
	@FindBy (xpath="//img[contains(@src,'ico_add.png')]")
	WebElement new_project_btn;

	//popup project
	
	@FindBy (xpath="//div[contains(@id,'Qh7-cave')]")
	WebElement new_project_popup;
	
	@FindBy (xpath="//div[contains(@class,'z-window-modal-header')]")
	WebElement name_popup;
	
	@FindBy (xpath="//div[contains(@id,'-cell')]/input")
	WebElement new_project_name_input;
	
	@FindBy (xpath="//input[contains(@style,'381px')]")
	WebElement new_project_model_input;
	
	@FindBy (xpath="//table[@class='z-hbox']//input[contains(@class,'z-textbox')]")
	WebElement new_project_code_input;
	
	@FindBy (xpath="//input[@type='checkbox' and @checked='checked']")
	WebElement new_project_code_checkbox;
	
	@FindBy (xpath="//tr[@class='z-row z-grid-odd']//input[@class='z-datebox-inp']")
	WebElement new_project_date_input;
	
	@FindBy (xpath="//tr[@class='z-row']//input[@class='z-datebox-inp']")
	WebElement new_project_deadline_input;
	
	@FindBy (xpath="//tr[@class='z-row z-grid-odd']//input[@style='width: 466px;']")
	WebElement new_project_client_input;
	
	@FindBy (xpath="//tr[@class='z-row']//input[@class='z-combobox-inp']")
	WebElement new_project_calendar_input;
	
	@FindBy (xpath="//span[contains(@class,'save-button')]")
	WebElement new_project_save_btn;
	
	@FindBy (xpath="//span[contains(@class,'cancel-button')]")
	WebElement new_project_cancel_btn;
	
	@FindBy (xpath="//tr[@class='z-row z-grid-odd']//i[@class='z-datebox-btn']")
	WebElement new_project_start_calendar_btn;
	
	@FindBy (xpath="//div[@class='z-datebox-pp z-datebox-shadow']//td[@class='z-calendar-wkday z-calendar-seld']")
	WebElement new_project_date_selected;
	
	@FindBy (xpath="//tr[@class='z-row']//i[@class='z-datebox-btn']")
	WebElement new_project_end_calendar_btn;
	
	public void dayWanted(WebDriver driver, int day_date_wanted) {
		WebElement date_wanted = driver.findElement(By.xpath("//div[@class='z-datebox-pp z-datebox-shadow']//td[contains(@class, 'z-calendar-wk') and @_dt='"+day_date_wanted+"']"));
		date_wanted.click();
	}
	
	
	@FindBy (xpath="//td[contains(text() , 'Liste des projets')]")
	WebElement list_project_left_menu;
	
	@FindBy (xpath="//img[contains(@src, 'print.png')]")
	WebElement print_ico;
	
	//popup impression
	
	@FindBy (xpath="//div[@class='z-window-modal-header z-window-modal-header-move']")
	WebElement name_print_popup;
	
	@FindBy (xpath="//legend/span")
	WebElement legend_print_popup;
	
	@FindBy (xpath="//label[.='Afficher les libellés']/preceding-sibling::*")
	WebElement checkbox1_print_popup;
	
	@FindBy (xpath="//label[.='Montrer les affectations de ressource']/preceding-sibling::*")
	WebElement checkbox2_print_popup;
	
	@FindBy (xpath="//label[.='Etendre les groupes de tâches']/preceding-sibling::*")
	WebElement checkbox3_print_popup;
	
	@FindBy (xpath="//label[contains(text(),'avancement')]/preceding-sibling::*")
	WebElement checkbox4_print_popup;
	
	@FindBy (xpath="//label[.='Afficher toutes les heures rapportées']/preceding-sibling::*")
	WebElement checkbox5_print_popup;
	
	@FindBy (xpath="//label[.='Afficher la barre de coût monétaire']/preceding-sibling::*")
	WebElement checkbox6_print_popup;
	
	@FindBy (xpath="//span[contains(text(),'Merci')]")
	WebElement text_print_popup;
	
	@FindBy (xpath="//td[.='Imprimer']")
	WebElement validate_print_popup_btn;
	
	@FindBy (xpath="//td[.='Annuler']")
	WebElement cancel_print_popup_btn;
	
	//fin popup impression
	
	@FindBy (xpath="//div[@class='z-panel-header ']")
	WebElement error_title_popup;
	
	@FindBy (xpath="//textarea")
	WebElement error_text_popup;
	
	@FindBy (xpath="//tr[@class='z-row z-grid-odd']/td[2]//span")
	WebElement error_code_popup;
	
}
