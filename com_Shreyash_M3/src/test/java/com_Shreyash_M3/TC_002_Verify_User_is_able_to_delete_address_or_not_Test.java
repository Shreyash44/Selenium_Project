package com_Shreyash_M3;

import java.io.IOException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.shopperStack_Pom.MyAddresses_Page;
import com.shopperStack_Pom.MyProfile_Page;

import com_ShoppersStack_GenericUtility.Base_Test;

public class TC_002_Verify_User_is_able_to_delete_address_or_not_Test extends Base_Test {
@Test
public void deleteAddress() throws IOException {
	
	homePage.getAccountSettingBtn().click();
	homePage.getMyprfileBtn().click();
	
	MyProfile_Page myProfilePage=new MyProfile_Page(driver);
	myProfilePage.getMyAddressesBtn().click();
	
	MyAddresses_Page myAddressesPage=new MyAddresses_Page(driver);
	wait.until(ExpectedConditions.elementToBeClickable(myAddressesPage.getDeleteBtn())).click();
	wait.until(ExpectedConditions.elementToBeClickable(myAddressesPage.getYesBtn())).click();
	
	wait.until(ExpectedConditions.alertIsPresent());
	driver.switchTo().alert().accept();
	
	webDriverUtility.getWebPageScreenShot(driver);
	
}
}
