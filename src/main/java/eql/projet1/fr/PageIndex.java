package eql.projet1.fr;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageIndex {
	@FindBy (xpath="//img[contains(@src,'ico_add.png')]")
	WebElement new_project_btn;
}
