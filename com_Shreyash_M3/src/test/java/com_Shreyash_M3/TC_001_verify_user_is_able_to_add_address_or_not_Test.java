package com_Shreyash_M3;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.shopperStack_Pom.AddressFrom_Page;
import com.shopperStack_Pom.MyAddresses_Page;
import com.shopperStack_Pom.MyProfile_Page;

import com_ShoppersStack_GenericUtility.Base_Test;

public class TC_001_verify_user_is_able_to_add_address_or_not_Test extends Base_Test {
	@Test
	public void addAddress() throws InterruptedException, EncryptedDocumentException, IOException {
		homePage.getAccountSettingBtn().click();
		homePage.getMyprfileBtn().click();

		MyProfile_Page myProfilePage = new MyProfile_Page(driver);
		myProfilePage.getMyAddressesBtn().click();
		Thread.sleep(2000);
		MyAddresses_Page myAddressesPage = new MyAddresses_Page(driver);
		myAddressesPage.getAddAddressesBtn().click();

		AddressFrom_Page addressFromPage = new AddressFrom_Page(driver);
		addressFromPage.getOfficeRadioButton().click();
		addressFromPage.getNameTestField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 0));
		addressFromPage.getHouseTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 1));
		addressFromPage.getStreetTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 2));
		addressFromPage.getLandmarkTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 3));

		webDriverUtility.selectByValue(addressFromPage.getCountryDropDown(),
				fileUtility.readDataFromPropertyFile("country"));

		webDriverUtility.selectByValue(addressFromPage.getStateDropDown(),
				fileUtility.readDataFromPropertyFile("state"));
		webDriverUtility.selectByValue(addressFromPage.getCityDropDown(), fileUtility.readDataFromPropertyFile("city"));

		addressFromPage.getPincodTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 4));
		addressFromPage.getPhoneNumberTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 5));
		addressFromPage.getAddAddressBtn().click();

		myAddressesPage.getCloseBtn().click();

		webDriverUtility.getWebPageScreenShot(driver);

	}
}
