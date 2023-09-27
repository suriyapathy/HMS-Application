package BaseTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

import TestUtilities.ConstantUtility;

public class BaseClass {
	   public static WebDriver driver;
	public void initilizeConfig()  {
		if(ConstantUtility.browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if(ConstantUtility.browser.equalsIgnoreCase("chrome")) {
			driver=new EdgeDriver();
		}
		else if(ConstantUtility.browser.equalsIgnoreCase("chrome")) {
			driver=new SafariDriver();
		}
		else {
			throw new IllegalAccessError("Kindly provide correct configuration");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(ConstantUtility.baseURL);
	}

}
