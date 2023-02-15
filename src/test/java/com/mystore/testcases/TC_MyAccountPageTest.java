package com.mystore.testcases;

import org.testng.annotations.Test;

import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.RegisterAccount;

public class TC_MyAccountPageTest extends BaseClass
{
	@Test
	public void verifyMyAccountRegistration()
	{
	//open url
	driver.get(url);
	logger.info("url opened");
	
	IndexPage pg=new IndexPage(driver);
	pg.clickOnMyAccount();
	pg.clickOnRegister();
	
	RegisterAccount ra=new RegisterAccount(driver);
	ra.enterfirstname("kundan");
	ra.enterlastname("reddy");
	ra.enteremail("kundanreddy961@gmail.com");
	ra.entertelephone("1234567890");
	ra.enterpassword("Kundan1234567");
	ra.enterconfirmpassword("Kundan1234567");
	ra.clickOncheckbox();
	ra.clickOnSubmitButton();
	}

}
