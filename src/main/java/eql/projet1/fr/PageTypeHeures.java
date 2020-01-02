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
}
