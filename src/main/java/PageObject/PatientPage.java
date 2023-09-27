package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import BaseTest.BaseClass;
import TestUtilities.WebDriverUtility;

public class PatientPage extends BaseClass {

	private By addPatient_Button = By.xpath("//a[@data-toggle='tab' and @href='#add']");
	private By name_Field = By.xpath("//input[@name='name']");
	private By email_Field = By.xpath("//input[@name='email']");
	private By password_Field = By.xpath("//input[@name='password']");
	private By address_Field = By.xpath("//input[@name='address']");
	private By phone_Field = By.xpath("//input[@name='phone']");
	private By gender_Field = By.xpath("//select[@name='sex']");
	private By dateOfBirth_Field = By.xpath("//input[@name='birth_date']");
	private By age_Field = By.xpath("//input[@name='age']");
	private By bloodGroup_Field = By.xpath("//select[@name='blood_group']");
	private By toAddPatient_Button = By.xpath("//button[@class='btn btn-success']");
	

	public void goToAddPatientPage() {
		WebDriverUtility.clickOnElement(addPatient_Button);
	}
	public void toAddPatientDetails(String dob,String name,String email,String password,String address,String phone,
			String g_value,String age,String b_value) {
		goToAddPatientPage();
		WebDriverUtility.enterText(dateOfBirth_Field, dob);
		WebDriverUtility.clickOnElement(addPatient_Button);
		WebDriverUtility.enterText(name_Field, name);
		WebDriverUtility.enterText(email_Field, email);
		WebDriverUtility.enterText(password_Field, password);
		WebDriverUtility.enterText(address_Field, address);
		WebDriverUtility.enterText(phone_Field, phone);
		WebDriverUtility.selectDropdown(gender_Field,"Value",g_value);
		WebDriverUtility.enterText(age_Field, age);
		WebDriverUtility.selectDropdown(bloodGroup_Field,"Value",b_value);
	    WebDriverUtility.clickOnElement(toAddPatient_Button);
	}
}