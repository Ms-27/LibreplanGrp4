package eql.projet1.fr;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageProjet extends PageAbstractMenu {

	@FindBy (xpath="//td[contains(text() , 'Planification de projet')]")
	WebElement plan_project_left_menu;
	
	@FindBy (xpath="//td[contains(text() , 'Détail du projet')]")
	WebElement detail_project_left_menu;
	
	@FindBy (xpath="//td[contains(text() , 'Chargement des ressources')]")
	WebElement resources_project_left_menu;
	
	@FindBy (xpath="//td[contains(text() , 'Allocation avancée')]")
	WebElement allowances_project_left_menu;
	
	@FindBy (xpath="//td[contains(text() , 'Tableau de bord')]")
	WebElement board_project_left_menu;
	
	@FindBy (xpath="//span[contains(text() , 'WBS (tâches)')]")
	WebElement WBS_project_tab;
	
	@FindBy (xpath="//span[contains(text() , 'Données générales')]")
	WebElement data_project_tab;
	
	@FindBy (xpath="//span[contains(text() , 'Coût')]")
	WebElement cost_project_tab;
	
	@FindBy (xpath="//span[contains(text() , 'Avancement')]")
	WebElement advancement_project_tab;
	
	@FindBy (xpath="//span[contains(text() , 'Libellés')]")
	WebElement wording_project_tab;
	
	@FindBy (xpath="//span[contains(text() , 'Exigence de critère')]")
	WebElement requirement_project_tab;

	@FindBy (xpath="//span[contains(text() , 'Matériels')]")
	WebElement material_project_tab;

	@FindBy (xpath="//span[contains(text() , 'Formulaires qualité des tâches')]")
	WebElement task_project_tab;

	@FindBy (xpath="//span[contains(text() , 'Autorisation')]")
	WebElement auth_project_tab;
	
	@FindBy (xpath="//span[@title='Enregistrer le projet']")
	WebElement save_project_ico;
	
	@FindBy (xpath="//span[contains(@title, 'Annuler')]")
	WebElement cancel_project_ico;
}
