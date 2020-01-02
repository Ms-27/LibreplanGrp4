package eql.projet1.fr;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageLogin {
	@FindBy (xpath="//input[@id='button']")
	WebElement seconnecter_btn;
	
	@FindBy (xpath="//input[@id='textfield']")
	WebElement utilisateur_field;
	
	@FindBy (xpath="//input[@id='textfield2']")
	WebElement mdp_field;
	
	public PageIndex connect() {
		
	}
}
