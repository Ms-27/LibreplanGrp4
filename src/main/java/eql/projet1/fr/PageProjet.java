package eql.projet1.fr;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageProjet extends PageAbstractMenu {
	
	@FindBy (xpath="//td[contains(text() , 'Planification')]")
	WebElement plan_project_left_menu;
	
	@FindBy (xpath="//td[contains(text() , 'Détail du projet')]")
	WebElement detail_project_left_menu;
	
	@FindBy (xpath="//td[contains(text() , 'Liste des projets')]")
	WebElement list_project_left_menu;
	
	@FindBy (xpath="//td[contains(text() , 'Chargement des ressources')]")
	WebElement resources_project_left_menu;
	
	@FindBy (xpath="//td[contains(text() , 'Allocation avancée')]")
	WebElement allowances_project_left_menu;
	
	@FindBy (xpath="//td[contains(text() , 'Tableau de bord')]")
	WebElement board_project_left_menu;
	
	@FindBy (xpath="//div[@class='z-tabs-header z-tabs-header-scroll']")
	WebElement project_tab_menu;
	
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
	
	//popup
	
	@FindBy (xpath="//div[@class='z-window-modal-header z-window-modal-header-move']")
	WebElement cancel_conf_name_popup;
	
	@FindBy (xpath="//div[@class='z-messagebox']")
	WebElement cancel_conf_msg_popup;
	
	@FindBy (xpath="//td[contains(text(), 'OK')]")
	WebElement cancel_conf_ok_btn_popup;
	
	@FindBy (xpath="//span[@class=\"z-messagebox-btn z-button\"]//td[contains(text(), 'Annuler')]")
	WebElement cancel_conf_cancel_btn_popup;
	
	//fin popup
	
	@FindBy (xpath="//tr[@class='clickable-rows projects-list z-row']")
	WebElement first_project;
	
	@FindBy (xpath="//tr[@class='clickable-rows projects-list z-row']/td[1]//span")
	WebElement project_name;
	
	@FindBy (xpath="//tr[@class='clickable-rows projects-list z-row']/td[2]//span")
	WebElement project_code;
	
	@FindBy (xpath="//tr[@class='clickable-rows projects-list z-row']/td[3]//span")
	WebElement project_start_date;
	
	@FindBy (xpath="//tr[@class='clickable-rows projects-list z-row']/td[4]//span")
	WebElement project_end_date;
	
	@FindBy (xpath="//tr[@class='clickable-rows projects-list z-row']/td[5]//span")
	WebElement project_client;
	
	@FindBy (xpath="//tr[@class='clickable-rows projects-list z-row']/td[6]//span")
	WebElement project_budget;
	
	@FindBy (xpath="//tr[@class='clickable-rows projects-list z-row']/td[7]//span")
	WebElement project_hour;
	
	@FindBy (xpath="//tr[@class='clickable-rows projects-list z-row']/td[8]//span")
	WebElement project_state;
}
