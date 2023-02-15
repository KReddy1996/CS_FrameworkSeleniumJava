package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage
{
	//Create Object of WebDriver
	WebDriver ldriver;
	public IndexPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);

	}
	//identify WebElement My Account
	@FindBy(xpath="//a[@title='My Account']")
	WebElement MyAccount;

	//identify WebElement Dropdown Register Link
	@FindBy(xpath="//a[text()='Register']")
	WebElement Register;
	
	//identify WebElement dropdown login link
	@FindBy(xpath="//a[text()='Login']")
	WebElement login;


	//identify action on WebElement
	public void clickOnMyAccount()
	{
		MyAccount.click();
	}

	//identify action on Register
	public void clickOnRegister()
	{
		Register.click();
	}
	//identify action on login
	public void clickOnLogin()
	{
		login.click();
	}

}
