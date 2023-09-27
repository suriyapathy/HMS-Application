package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import BaseTest.BaseClass;
import TestUtilities.WebDriverUtility;

public class DashboardPage extends BaseClass {

	private By hmsDashboard_Logo = By.xpath("//div[contains(@style,'text-align:')]");
	private By contents_Button = By.xpath("//div[contains(@class,'action-nav-button')]//a");
	private By link_Button = By.xpath(".//a");
	private By content_HeaderName = By.cssSelector("h3.title");
	private By menu_NoSubList = By.xpath("//ul[contains(@class,'nav-collapse-primary')]/li[@class='dark-nav active' or @class='']");
	private By menu_HaveSubList = By.xpath("//ul[contains(@class,'nav-collapse-primary')]/li[(contains(@class,''))]//ul");
	private List<WebElement> list;
	private By patient_ButtonOnDashboard = By.xpath("//div/a[contains(@href,'manage_patient')]");
	public boolean loginPageVerify() {
		return WebDriverUtility.displayOrNot(hmsDashboard_Logo);
	}

	public void contentPagination() {
		list = WebDriverUtility.getElements(contents_Button);
		for (int i = 0; i < list.size(); i++) {
			list = WebDriverUtility.getElements(contents_Button);
				list.get(i).click();
			System.out.println(WebDriverUtility.getText(content_HeaderName)+">>>>>>>>>>"+i);
			WebDriverUtility.negivateBack();
		}
	}
	public void menuNoSubListPagination() {

		list = WebDriverUtility.getElements(menu_NoSubList);
		for (int i = 0; i < list.size(); i++) {
			list = WebDriverUtility.getElements(menu_NoSubList);
				list.get(i).click();
			System.out.println(WebDriverUtility.getText(content_HeaderName)+">>>>>>>>>>"+i);
			WebDriverUtility.negivateBack();
		}
	}

	public void goToPatientPage() {
		WebDriverUtility.clickOnElement(patient_ButtonOnDashboard);
	}
}