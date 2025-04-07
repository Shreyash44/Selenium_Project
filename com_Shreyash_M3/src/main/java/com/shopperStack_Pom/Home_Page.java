package com.shopperStack_Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {

	public Home_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath = "//span[contains(@class,'BaseBadge-badge MuiBadge-badge MuiBadge')]")
	private WebElement accountSettingBtn;
	
	@FindBy(xpath = "//li[text()='My Profile']")
	private WebElement myprfileBtn;
	
	@FindBy(xpath = "//li[text()='Logout']")
	private WebElement logOutBtn;

	public WebElement getAccountSettingBtn() {
		return accountSettingBtn;
	}

	public WebElement getMyprfileBtn() {
		return myprfileBtn;
	}

	public WebElement getLogOutBtn() {
		return logOutBtn;
	}
	
	
	
	
}
