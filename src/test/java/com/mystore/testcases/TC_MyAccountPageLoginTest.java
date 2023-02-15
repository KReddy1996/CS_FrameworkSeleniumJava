package com.mystore.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.LoginPage;
import com.mystore.utilities.ReadExcelFile;

public class TC_MyAccountPageLoginTest extends BaseClass
{
	@Test(dataProvider = "LoginDataProvider")
	public void verifyMyAccountLogin(String emailid, String pwd) throws IOException
	{
		driver.get(url);
		logger.info("url opened");
		
		IndexPage ip=new IndexPage(driver);
		ip.clickOnMyAccount();
		ip.clickOnLogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.enteremailAddress(emailid);   //kundanreddy961@gmail.com
		lp.enterpassword(pwd); //kundan1234567
		lp.clickloginbutton();
		  
	String hptitle=	driver.getTitle();
	if(hptitle.equals("My Account"))
	{
		logger.info("VerifyLogin  - Passed");
		Assert.assertTrue(true);
	}
	else
	{
		logger.info("VerifyLogin - Failed");
		captureScreenShot(driver,"verifyMyAccountLogin");
		Assert.assertTrue(false);  
	}
	}
	@DataProvider(name="LoginDataProvider")
	public String[][] LoginDataProvider()
	{
		String fileName=System.getProperty("user.dir")+"\\TestData\\MyStorev2TestData.xlsx";
		
		int ttlRows=ReadExcelFile.getRowCount(fileName, "LoginTestData");
		int ttlColumns=ReadExcelFile.getColCount(fileName, "LoginTestData");
		
		String data[][]=new String[ttlRows-1][ttlColumns];
		for(int i=1;i<ttlRows; i++) //row 1,2
		{
			for(int j=0;j<ttlColumns; j++) //col 0,1,2
			{
				data[i-i][j]=ReadExcelFile.getCellValue(fileName, "LoginTestData", i, j);
			}
		}
		return data;
	}

}
