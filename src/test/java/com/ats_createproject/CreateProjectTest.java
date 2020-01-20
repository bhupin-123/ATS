package com.ats_createproject;

import java.io.IOException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.ats_base.Base;
import com.ats_helper.CreateProject;
import com.ats_helper.Login;
import com.ats_pages.CreateProjectPage;
import com.ats_pages.DashboardPage;
import com.ats_utilities.Utilities;

public class CreateProjectTest extends Base {

	@Test
	public void createNewProject() throws InterruptedException, IOException {
		try {
			// Performing the login operation.
			CreateProjectPage crtPrjPage = new CreateProjectPage();
			Login lg = new Login();
			lg.doLogin();

			// select the option to create new project
			DashboardPage DBpage = new DashboardPage();
			wait.until(ExpectedConditions.elementToBeClickable(DBpage.newproject()));
			click(DBpage.newproject());

			// First adding the basic project details in the Hash table from the excel then
			// from hash table in the application
			CreateProject createtprj = new CreateProject();
			createtprj.addPrjDetails(Utilities.getExcelData("BasicProjectDetails"));

			// Picking the details (building class and building type) from excel then
			// selecting the same in the application.
			String bulClass = createtprj.selectBuildingClass("BuildingClassAndType");
			String bulType = createtprj.selectBuildingType("BuildingClassAndType");
			createtprj.chooseBldClazz(bulClass);
			createtprj.chooseBldType(bulType);
			click(crtPrjPage.nextbutton());
			Thread.sleep(2000);

			// Selecting collaborators permissions from the excel and settings the same in
			// the application.
			createtprj.setPermission("AddCollaborators");
			click(crtPrjPage.finish_btn());
		} catch (Exception e) {
			log.error("verification failed with Exception : " + e.getMessage());
		} finally {
			driver.quit();
		}
	}

}
