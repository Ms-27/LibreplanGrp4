package eql.projet1.fr;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class PageAbstractMenu {
	@FindBy (xpath="//a[contains(@href, 'logout')]")
	WebElement signout_btn;
	
	@FindBy (xpath="//button[contains(text(), 'Calendrier')]")
	WebElement calendrier_btn;
	
	@FindBy (xpath="//button[contains(text(), 'Coût')]")
	WebElement cout_btn;
	
	@FindBy (xpath="//td[@class='usuario'][contains(text(), 'utilisateur')]")
	WebElement user_txt;
}
