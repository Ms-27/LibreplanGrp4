package eql.projet1.fr;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageLogin extends PageAbstractMenu {
	@FindBy (xpath="//input[@id='button']")
	WebElement seconnecter_btn;
	
	@FindBy (xpath="//input[@id='textfield']")
	WebElement utilisateur_field;
	
	@FindBy (xpath="//input[@id='textfield2']")
	WebElement mdp_field;
	
	public PageIndex connect(WebDriver d, String s, String p) {
		TechnicalTools.fillFiels(utilisateur_field, s);
		TechnicalTools.fillFiels(mdp_field, p);
		seconnecter_btn.click();
		return PageFactory.initElements(d, PageIndex.class);
	}
}
