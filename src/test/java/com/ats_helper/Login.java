package com.ats_helper;

import com.ats_base.Base;
import com.ats_pages.LoginPage;

public class Login extends Base {
	
	//This method perform the login operation.
	public void doLogin() {
		LoginPage LoginPg = new LoginPage();
		editBox(LoginPg.username(), config.getProperty("username"));
		editBox(LoginPg.password(), config.getProperty("password"));
		click(LoginPg.login_Btn());
	}

}
