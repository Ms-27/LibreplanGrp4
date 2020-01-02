package eql.projet1.fr;

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
	
	@FindBy (xpath="//span/text()[contains(.,'Nom')]")
	WebElement new_project_name;
	
	@FindBy (xpath="//span/text()[contains(.,'Modèle')]")
	WebElement new_project_model;
	
	@FindBy (xpath="//span/text()[contains(.,'Code')]")
	WebElement new_project_code;
	
	@FindBy (xpath="//span/text()[contains(.,'Date')]")
	WebElement new_project_date;
	
	@FindBy (xpath="//span/text()[contains(.,'Echéance')]")
	WebElement new_project_deadline;
	
	@FindBy (xpath="//span/text()[contains(.,'Client')]")
	WebElement new_project_client;
	
	@FindBy (xpath="//span/text()[contains(.,'Calendrier')]")
	WebElement new_project_calendar;
	
	@FindBy (xpath="//div[contains(@id,'-cell')]/input")
	WebElement new_project_name_input;
	
	@FindBy (xpath="//input[contains(@style,'381px')]")
	WebElement new_project_model_input;
	
	@FindBy (xpath="//input[contains(@class,'z-textbox-disd')]")
	WebElement new_project_code_input;
	
	@FindBy (xpath="//input[contains(@id,'Q48')]")
	WebElement new_project_code_checkbox;
	
	@FindBy (xpath="//input[contains(@id,'Qk9')]")
	WebElement new_project_date_input;
	
	@FindBy (xpath="//input[contains(@id,'Qn9')]")
	WebElement new_project_deadline_input;
	
	@FindBy (xpath="//input[contains(@id,'Qs9')]")
	WebElement new_project_client_input;
	
	@FindBy (xpath="//input[contains(@id,'Q0a')]")
	WebElement new_project_calendar_input;
	
	@FindBy (xpath="//span[contains(@class,'save-button')]")
	WebElement new_project_save_btn;
	
	@FindBy (xpath="//span[contains(@class,'cancel-button')]")
	WebElement new_project_cancel_btn;
	
	
}
