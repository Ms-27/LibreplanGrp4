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
	WebElement calendrier_tab;
	
	@FindBy (xpath="//button[contains(text(), 'Coût')]")
	WebElement cout_btn;
	
	@FindBy (xpath="//td[@class='usuario'][contains(text(), 'utilisateur')]")
	WebElement user_txt;
	
	@FindBy (xpath="//button[contains(text(), 'Ressources')]")
	WebElement ressources_btn;
	
	public PageTypeHeures accessTypeHeures(WebDriver d) {
		Actions a = new Actions (d);
		a.moveToElement(cout_btn).build().perform();
		WebElement typeheures_btn = d.findElement(By.xpath("//a[contains(@href, 'typeOfWorkHours')]"));
		a.moveToElement(typeheures_btn).click().build().perform();
		return PageFactory.initElements(d, PageTypeHeures.class);
	}
		
	public PageCritere accesCritere(WebDriver driver) {
		Actions a = new Actions(driver);
		a.moveToElement(ressources_btn).build().perform();
		WebElement critere_btn = driver.findElement(By.xpath("//a[contains(@href, 'criterions')]"));
		a.moveToElement(critere_btn).click().build().perform();
		return PageFactory.initElements(driver, PageCritere.class);
		}

	public PageCategoriesCout accessCategoriesCout(WebDriver d) {
		Actions a = new Actions (d);
		a.moveToElement(cout_btn).build().perform();
		WebElement categoriescout_btn = d.findElement(By.xpath("//a[contains(@href, 'costCategory')]"));
		a.moveToElement(categoriescout_btn).click().build().perform();
		return PageFactory.initElements(d, PageCategoriesCout.class);
	}

	
	public PageTypeAvancement accesTypeAvancement(WebDriver driver) {
		
		Actions a = new Actions (driver);
		a.moveToElement(ressources_btn).build().perform();
		WebElement TypeAvancement_btn = driver.findElement(By.xpath("//a[contains(@href, 'advanceTypes')]"));
		a.moveToElement(TypeAvancement_btn).click().build().perform();
		return PageFactory.initElements(driver, PageTypeAvancement.class);
	}

}
