package test.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import managers.TestContextManager;
import pageObjects.DashBoard;
import pageObjects.HomePage;
import test.basetest.BaseClass;
import test.basetest.baseTwo;
import webUtil.SeleniumActions;

public class LoginTest extends baseTwo{
	DashBoard dp=TestContextManager.getContext().getPageObjectManager().getDashBoard();
	HomePage hp=TestContextManager.getContext().getPageObjectManager().getHomePage();
	public  int count=0;
	
	
	@Test(testName = "Orange HRM Login DDT",priority = 1,dataProvider = "loginData")
	public void login(String userName,String passWord) {
		WebDriver driver=TestContextManager.getContext().getDriver();
		driver.manage().window().maximize();
		SeleniumActions.launchUrl(driver, "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		SeleniumActions.enterValue(driver, hp.userName, userName);
		SeleniumActions.enterValue(driver, hp.password, passWord);
		SeleniumActions.click(driver, hp.submitBtn);
		SeleniumActions.findElement(driver, hp.sucessLogin);
		if(count==0) {
			count=1;
			Assert.assertEquals(false, true);
		}else {
			count=0;
		}
		
	}
	
	
	  @DataProvider(name = "loginData")
	    public Object[][] getData() {
	        return new Object[][]{
	                {"Admin", "admin123"},
	                {"Admin", "admin123"},
	                {"Admin", "admin123"}
	        };
	    }

}
