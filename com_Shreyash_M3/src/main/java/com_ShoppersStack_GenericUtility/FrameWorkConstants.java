package com_ShoppersStack_GenericUtility;

public class FrameWorkConstants {

	static Java_Utility javaUtility = new Java_Utility();

	final static String propertyFilepath = "./src/test/resources/testData/shoperProperty.properties";
	final static String excelFilePath = "./src/test//resources/testData/testdataExcelfile.xlsx";
	final static String screenshotPath = "./screenshot/" + javaUtility.getLocalDateTime() + ".png";
	final static String reportsPath = "./reports/" + javaUtility.getLocalDateTime() + ".html";

	final static String chromekey = "webdriver.chrome.driver";

	final static String chromeValue = "./src/main/resources/driver/chromedriver.exe";

}
