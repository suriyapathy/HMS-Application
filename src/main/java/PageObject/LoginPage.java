package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import BaseTest.BaseClass;
import TestUtilities.WebDriverUtility;

public class LoginPage extends BaseClass{

	private By login_Logo=By.cssSelector(".title");
	private By select_AC_Type=By.xpath("//select[@name='login_type']");
	private By email_Field=By.xpath("//input[@name='email' and @type='text']");
	private By password_Field=By.xpath("//input[@name='password' and @type='password']");
	private By login_Button=By.cssSelector("button.btn-success");
	private By forget_Link=By.xpath("//a[@data-toggle='modal' and @href]");
	private By allLanguage_Field=By.cssSelector(".dropdown-menu li");
	private By selectLanguage_Button=By.xpath("//ul[contains(@class,'nav pull-right')]");
	private WebElement element;

	public boolean loginPageVerify() {
		return WebDriverUtility.displayOrNot(login_Logo);
	}
	public  void selectLangauage(String language) {
		WebDriverUtility.clickOnElement(selectLanguage_Button);
		for (int i = 0; i < WebDriverUtility.getElements(allLanguage_Field).size(); i++) {
			element=WebDriverUtility.getElements(allLanguage_Field).get(i);
			if (language.equalsIgnoreCase(element.getText())) {
				element.click();
				break;
			}
		}
	}
	public void loginPasitiveCredintial(String email,String password, String accountType,String value){
		WebDriverUtility.selectDropdown(select_AC_Type, accountType, value);
		WebDriverUtility.enterText(email_Field, email);
		WebDriverUtility.enterText(password_Field, password);
		WebDriverUtility.clickOnElement(login_Button);

	}
}
