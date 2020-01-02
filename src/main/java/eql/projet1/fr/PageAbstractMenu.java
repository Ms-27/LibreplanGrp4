package eql.projet1.fr;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class PageAbstractMenu {
	@FindBy (xpath="//a[@class, 'cerrar_session']")
	WebElement signout_btn;
	
	
}
