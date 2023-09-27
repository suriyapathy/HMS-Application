package TestRunner;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BaseTest.BaseClass;
import PageObject.DashboardPage;
import PageObject.LoginPage;
import TestUtilities.ConstantUtility;
import TestUtilities.WebDriverUtility;

public class TC_DashboardPage_01 extends BaseClass{
	LoginPage loginpage;
	DashboardPage dashboardPage;
	@BeforeClass
	public void tearUp() {
		initilizeConfig();
		loginpage=new LoginPage();
		loginpage.loginPageVerify();
		loginpage.loginPasitiveCredintial(ConstantUtility.username, ConstantUtility.password,"Value","admin");
		dashboardPage=new DashboardPage();
		
	}
  
	@Test
	public void verifyTitle() {
		String pageTitle=WebDriverUtility.getTitle();
		Assert.assertEquals(pageTitle, "Admin Dashboard | Hospital Management System", "We are Landed into wrong webpage");
	}
	@Test
	public void verifyLoginPage() {
		Assert.assertTrue(dashboardPage.loginPageVerify());
	}
	
	@Test
	public void verifyContentPagination() {
         //dashboardPage.contentPagination();
		dashboardPage.menuNoSubListPagination();
	}
	//@AfterTest
	public void tearDown() {
		WebDriverUtility.closeBrowser();
	}
}
