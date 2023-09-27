package TestRunner;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BaseTest.BaseClass;
import PageObject.LoginPage;
import TestUtilities.ConstantUtility;
import TestUtilities.WebDriverUtility;

public class TC_LoginPage_01 extends BaseClass{
	LoginPage loginpage;
	@BeforeClass
	public void tearUp() {
		initilizeConfig();
		loginpage=new LoginPage();
	}
  
	@Test
	public void verifyTitle() {
		String pageTitle=WebDriverUtility.getTitle();
		Assert.assertEquals(pageTitle, "Login | Hospital Management System", "We are Landed into wrong webpage");
	}
	@Test
	public void verifyLoginPage() {
		Assert.assertTrue(loginpage.loginPageVerify());
	}
	@Test
	public void verifyLanguageSelection() {
		loginpage.selectLangauage("english");
	}
	@Test
	public void verifyLogin() {
		loginpage.loginPasitiveCredintial(ConstantUtility.username, ConstantUtility.password,"Value","admin");
	}
	//@AfterTest
	public void tearDown() {
		WebDriverUtility.closeBrowser();
	}
}
