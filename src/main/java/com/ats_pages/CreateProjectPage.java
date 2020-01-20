package com.ats_pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ats_base.Base;

public class CreateProjectPage extends Base {
	
	//This class contains all the webElements that are on the Create New Project page.  

	public CreateProjectPage() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//input[contains(@class,'MuiInputBase-input-1')])[1]")
	private WebElement internalNo;

	public WebElement internalNo() {
		return internalNo;
	}
	
	@FindBy(xpath = "//div[@id='react-autowhatever-1']")
	private WebElement dropDown;

	public WebElement dropDown() {
		return dropDown;
	}

	@FindBy(xpath = "(//input[contains(@class,'MuiInputBase-input-1')])[2]")
	private WebElement projectName;

	public WebElement projectName() {
		return projectName;
	}

	@FindBy(xpath = "(//input[contains(@class,'MuiInputBase-input-1')])[3]")
	private WebElement country;

	public WebElement country() {
		return country;
	}

	@FindBy(xpath = "(//input[contains(@class,'MuiInputBase-input-1')])[4]")
	private WebElement province;

	public WebElement province() {
		return province;
	}

	@FindBy(xpath = "(//input[contains(@class,'MuiInputBase-input-1')])[5]")
	private WebElement city;

	public WebElement city() {
		return city;
	}

	@FindBy(xpath = "(//textarea[contains(@class,'MuiInputBase')])[1]")
	private WebElement address;

	public WebElement address() {
		return address;
	}

	@FindBy(xpath = "(//input[contains(@class,'MuiInputBase-input-1')])[6]")
	private WebElement bidDate;

	public WebElement bidDate() {
		return bidDate;
	}

	@FindBy(xpath = "(//input[contains(@class,'MuiInputBase-input-1')])[7]")
	private WebElement area;

	public WebElement area() {
		return area;
	}
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement next;

	public WebElement next_btn() {
		return next;
	}
	@FindBy(xpath = "//div[contains(@class,'ReactVirtualized__Grid React')]/div/div/div[1]")
	private List<WebElement> collaboratorsName;

	public List<WebElement> ListOfCollaborators() {
		return collaboratorsName;
	}

	@FindBy(xpath = "//div[contains(@style,'2px; le')] //div[contains(@style,'10')] //input[@type='checkbox']")
	private List<WebElement> collaboratorsAccess;

	public List<WebElement> giveCollaboratorsAccess() {
		return collaboratorsAccess;
	}

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement finish;

	public WebElement finish_btn() {
		return finish;
	}
	
	@FindBy(xpath = "//div[contains(@class,'MuiCardContent-root')]")
	private List<WebElement> buildingClassTypes;
	
	public List<WebElement> buildingClass() {
		return buildingClassTypes;
	}

	
	@FindBy(xpath = "//div[contains(@class,'MuiGrid-wrap')] //label[contains(@class,'Mui')]")
	private List<WebElement> buildingType;

	public List<WebElement> buildingType() {
		return buildingType;
	}
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement next_btn;

	public WebElement nextbutton() {
		return next_btn;
	}
	
	@FindBy(xpath = "//p[text()='Brian Young']")
	private WebElement next_btn1;


	


}
