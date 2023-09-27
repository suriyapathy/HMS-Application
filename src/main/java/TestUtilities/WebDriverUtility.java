package TestUtilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import BaseTest.BaseClass;

public class WebDriverUtility extends BaseClass {

	static List<WebElement> list;
	static WebElement element;
	static boolean yesOrNo;
	static String text;
	static Select select;

	public static String getTitle() {
		return driver.getTitle();
	}

	public static WebElement getElement(By locator) {
		element = driver.findElement(locator);
		return element;
	}

	public static List<WebElement> getElements(By locator) {
		list = driver.findElements(locator);
		return list;
	}

	public static void getWindow() {
		driver.switchTo().window(driver.getWindowHandle());
	}

	public static void closeBrowser() {
		driver.close();
	}

	public static boolean displayOrNot(By locator) {
		yesOrNo = driver.findElement(locator).isDisplayed();
		return yesOrNo;
	}

	public static boolean enabledOrNot(By locator) {
		yesOrNo = driver.findElement(locator).isEnabled();
		return yesOrNo;
	}

	public static boolean selectedOrNot(By locator) {
		yesOrNo = driver.findElement(locator).isSelected();
		return yesOrNo;
	}

	public static void clickOnElement(By locator) {
		driver.findElement(locator).click();

	}

	public static String getText(By locator) {
		text = driver.findElement(locator).getText();
		return text;
	}

	public static void enterText(By locator, String value) {
		driver.findElement(locator).sendKeys(value);
	}

	public static void selectDropdown(By locator,String type,String value) {
		select = new Select(WebDriverUtility.getElement(locator));
		switch (type) {
		case "Value":
			select.selectByValue(value);
			break;
		case "Index":
			select.selectByIndex(Integer.parseInt(value));
			break;
		case "VisibleText":
			select.selectByValue(value);
			break;
		default:
			break;
		}
	}

	public static void negivateBack() {
		driver.navigate().back();		
	}
	public static void clickOnWebElemnt(WebElement element) {
		driver.findElement((By) element).click();		
	}
}
