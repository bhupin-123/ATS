package com.ats_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ats_base.Base;

public class LoginPage extends Base {
	
	//This class contains all the webElements that are on the Login page.  


	public LoginPage() {

		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//input[@name='username']")
	private WebElement username;

	public WebElement username() {
		return username;
	}
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement password;

	public WebElement password() {
		return password;
	}
	
	@FindBy(css = "button[type='submit']")
	private WebElement login_Btn;

	public WebElement login_Btn() {
		return login_Btn;
	}
	
	
	

}
