package eql.projet1.fr;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class PageAbstractMenu {
	@FindBy (xpath="//a[contains(@href, 'logout')]")
	WebElement signout_btn;
	
	@FindBy (xpath="//button[contains(text(), 'Calendrier')]")
	WebElement calendrier_btn;
	
	@FindBy (xpath="//button[contains(text(), 'Coût')]")
	WebElement cout_btn;
	
	@FindBy (xpath="//td[@class='usuario'][contains(text(), 'utilisateur')]")
	WebElement user_txt;
	
	public PageTypeHeures accessTypeHeures(WebDriver d) {
		Actions a = new Actions (d);
		a.moveToElement(cout_btn).build().perform();
		WebElement typeheures_btn = d.findElement(By.xpath("//a[contains(@href, 'typeOfWorkHours')]"));
		a.moveToElement(typeheures_btn).click().build().perform();
		return PageFactory.initElements(d, PageTypeHeures.class);
	}
}
