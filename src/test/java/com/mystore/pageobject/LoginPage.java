package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
	WebDriver ldriver;
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	//identify webelement emailaddress
	@FindBy(xpath="//input[@id='input-email']")
	WebElement emailAddress;
	
	//identify webelement password
	@FindBy(xpath="//input[@id='input-password']")
	WebElement password;
	
	//identify webelement loginbutton
	@FindBy(xpath="//input[@type='submit']")
     WebElement loginbutton;
	
	//identify action on emailaddress
	public void enteremailAddress(String lemail)
	{
		emailAddress.sendKeys(lemail);
	}
	public void enterpassword(String lpwd)
	{
		password.sendKeys(lpwd);
	}
	public void clickloginbutton()
	{
		loginbutton.click();
	}
}
