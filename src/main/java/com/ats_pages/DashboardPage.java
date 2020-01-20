package com.ats_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ats_base.Base;

public class DashboardPage extends Base {
	
	//This class contains all the webElements that are on the Dashboard page.  


	public DashboardPage() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[text()='New Project']")
	private WebElement newproject;

	public WebElement newproject() {
			return newproject;
		}
}
