package com.shopperStack_Pom;

import java.io.Closeable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAddresses_Page {

	public MyAddresses_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[text()='Add Address']")
	private WebElement addAddressesBtn;

	@FindBy(xpath ="(//*[name()='svg'])[7]")
	private WebElement deleteBtn;

	@FindBy(xpath = "//button[text()='Yes']")
	private WebElement yesBtn;

	@FindBy(xpath = "//button[@aria-label='close']")
	private WebElement closeBtn;

	public WebElement getAddAddressesBtn() {
		return addAddressesBtn;
	}

	public WebElement getDeleteBtn() {
		return deleteBtn;
	}

	public WebElement getYesBtn() {
		return yesBtn;
	}

	public WebElement getCloseBtn() {
		return closeBtn;
	}

}
