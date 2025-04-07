package com_ShoppersStack_GenericUtility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;
import org.testng.internal.ITestResultNotifier;

public class Listeners_Utility implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
	  
		
		TakesScreenshot ts=(TakesScreenshot) Base_Test.sDriver;
		File temp=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("");
		try {
			FileHandler.copy(temp, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}