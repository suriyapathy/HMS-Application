package TestRunner;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BaseTest.BaseClass;
import PageObject.DashboardPage;
import PageObject.LoginPage;
import PageObject.PatientPage;
import TestUtilities.ConstantUtility;
import TestUtilities.WebDriverUtility;

public class TC_PatientPage_01 extends BaseClass{
	LoginPage loginpage;
	DashboardPage dashboardPage;
	PatientPage patientPage;
	@BeforeClass
	public void tearUp() {
		initilizeConfig();
		loginpage=new LoginPage();
		loginpage.loginPageVerify();
		loginpage.loginPasitiveCredintial(ConstantUtility.username, ConstantUtility.password,"Value","admin");
		dashboardPage=new DashboardPage();
		dashboardPage.goToPatientPage();
		patientPage=new PatientPage();
	}
  
	@Test
	public void verifyTitle() {
		String pageTitle=WebDriverUtility.getTitle();
		Assert.assertEquals(pageTitle, "Admin Dashboard | Hospital Management System", "We are Landed into wrong webpage");
	}
	@Test
	public void verifyContentPagination() { 
		patientPage.toAddPatientDetails("02/09/2005","surya", "suriya123@gmail.com", "1234567", 
				"tambaram,Chennai", "9087654321", "male", "44", "O+");
	}
	//@AfterTest
	public void tearDown() {
		WebDriverUtility.closeBrowser();
	}
}
