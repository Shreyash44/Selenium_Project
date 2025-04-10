package com_ShoppersStack_GenericUtility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

//import com.Shopperstack_Pom.Home_Page;
//import com.Shopperstack_Pom.Login_Page;
//import com.Shopperstack_Pom.Welcome_Page;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.shopperStack_Pom.Home_Page;
import com.shopperStack_Pom.Login_Page;
import com.shopperStack_Pom.Welcome_Page;

public class Base_Test {
	public WebDriver driver;
	public static WebDriver sDriver;
	public ExtentSparkReporter spark;
	public ExtentReports reports;
	public ExtentTest test;
	public File_Utility fileUtility = new File_Utility();
	public Welcome_Page welcomepage;
	public Login_Page loginPage;
	public WebDriverWait wait;
	public Home_Page homePage;
	public WebDriver_Utility webDriverUtility = new WebDriver_Utility();

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("BeforeSuite");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("BeforeTest");
		spark = new ExtentSparkReporter(FrameWorkConstants.reportsPath);
		reports = new ExtentReports();
		reports.attachReporter(spark);
		test = reports.createTest("Demo");
	}

	@BeforeClass
	public void beforeClass() throws IOException {
		System.out.println("BeforeClass");
		
		
//		String browser = fileUtility.readDataFromPropertyFile("browserName");
//		String url = fileUtility.readDataFromPropertyFile("url");
		
		String browser = System.getProperty("browserName");
	String url = System.getProperty("url");

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			System.out.println("Please enter a valid Browser Name");
			return;
		}

		sDriver = driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(14));
		driver.get(url);
	}

	@BeforeMethod
	public void beforeMethod() throws InterruptedException, IOException {
		System.out.println("BeforeMethod");

		welcomepage = new Welcome_Page(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(14));
		wait.until(ExpectedConditions.elementToBeClickable(welcomepage.getLoginBtn()));
		Thread.sleep(5000);

		welcomepage.getLoginBtn().click();

		loginPage = new Login_Page(driver);
		loginPage.getEmailTextField().sendKeys(fileUtility.readDataFromPropertyFile("username"));
		loginPage.getPasswordTextField().sendKeys(fileUtility.readDataFromPropertyFile("password"));
		loginPage.getLoginBtn().click();

		homePage = new Home_Page(driver);
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("AfterMethod");

		homePage.getAccountSettingBtn().click();
		homePage.getLogOutBtn().click();
	}

	@AfterClass
	public void afterClass() throws InterruptedException {
		System.out.println("AfterClass");
		Thread.sleep(3000);
		driver.quit();
	}

	@AfterTest
	public void afterTest() {
		System.out.println("AfterTest");
		reports.flush();
	}
}