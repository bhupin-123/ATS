package com.ats_helper;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ats_base.Base;
import com.ats_pages.CreateProjectPage;

public class CreateProject extends Base {
	
	//This class contains the common methods needed to automate the test cases of atsspecsolutions.com, These methods can be utilized by other test cases of atsspecsolutions.com.

	//This method read the hash-table and enter the values in the application.
	public void addPrjDetails(Hashtable<String, String> hs) throws InterruptedException {
		CreateProjectPage crtProj = new CreateProjectPage();
		editBox(crtProj.internalNo(), hs.get("InternalNumber"));
		editBox(crtProj.projectName(), hs.get("ProjectName"));
		dynamicDropdown(crtProj.country(), hs.get("Country"));
		dynamicDropdown(crtProj.province(), hs.get("Province"));
		dynamicDropdown(crtProj.city(), hs.get("City"));

		editBox(crtProj.address(), hs.get("Address"));
		editBox(crtProj.bidDate(), hs.get("BidDate"));
		editBox(crtProj.area(), hs.get("Area"));
		Thread.sleep(1000);
		click(crtProj.next_btn());

	}
	
	//This method select the required building class. 
	public void chooseBldClazz(String classType) throws InterruptedException {
		CreateProjectPage crtProj = new CreateProjectPage();
		int bulClassCount = crtProj.buildingClass().size();
		for (int i = 0; i < bulClassCount; i++) {
			String bulClass = crtProj.buildingClass().get(i).getText();
			if (bulClass.equalsIgnoreCase(classType)) {
				click(crtProj.buildingClass().get(i));
				Thread.sleep(1000);
				return;
			}
		}

	}
	
	//This method select the required building type. 
	public void chooseBldType(String bulType) throws InterruptedException {
		CreateProjectPage crtProj = new CreateProjectPage();
		int bulTypeCount = crtProj.buildingType().size();
		for (int i = 0; i < bulTypeCount; i++) {
			String building = crtProj.buildingType().get(i).getText();
			if (building.equalsIgnoreCase(bulType)) {
				click(crtProj.buildingType().get(i));

				return;
			}
		}

	}
	//This method read the data from excel and accordingly give the permissions to the collaborator.
	public void setPermission(String sheetName) throws IOException {

		CreateProjectPage crtProj = new CreateProjectPage();

		int totalCol = excel.getColumnCount(sheetName);
		int totalRow = excel.getRowCount(sheetName);
		int z = 0;
		for (int rNum = 1; rNum < totalRow; rNum++) {

			for (int cNum = 1; cNum < totalCol; cNum++) {

				String persimmsion = excel.getCellData(sheetName, rNum, cNum);

				if (persimmsion.equalsIgnoreCase("Y")) {
					click(crtProj.giveCollaboratorsAccess().get(z));

				}
				z++;

			}

		}

	}
	// This method read the excel sheet and returns the building class against the selected building type.
	public String selectBuildingClass(String sheetName) throws IOException {
		String bulCls = null;
		int totalRow = excel.getRowCount(sheetName);
		for (int rNum = 1; rNum < totalRow; rNum++) {
			String value = excel.getCellData(sheetName, rNum, 2);
			if (value.equalsIgnoreCase("y")) {
				bulCls = excel.getCellData(sheetName, rNum, 0);
				while (bulCls=="") {
					rNum--;
					bulCls = excel.getCellData(sheetName, rNum, 0);
				}
				break;
			}
		}
		return bulCls;
		
	}
	// This method read the excel sheet and returns the selected building type.
	public String selectBuildingType(String sheetName) throws IOException {
		String bulTyp = null;
		int totalRow = excel.getRowCount(sheetName);
		for (int rNum = 1; rNum < totalRow; rNum++) {
			String value = excel.getCellData(sheetName, rNum, 2);
			if (value.equalsIgnoreCase("y")) {
				bulTyp = excel.getCellData(sheetName, rNum, 1);

			}

		}
		return bulTyp;
	}


}
