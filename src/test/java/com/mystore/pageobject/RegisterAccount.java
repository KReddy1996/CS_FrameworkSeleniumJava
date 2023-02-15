package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterAccount
{
	WebDriver ldriver;
	public RegisterAccount(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	//identify webelement firstname
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement firstname;
	//identify webelement lastname
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement lastname;
	//identify webelement email
	@FindBy(xpath="//input[@id='input-email']")
	WebElement email;
	//identify webelement telephone
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement telephone;
	//identify webelement password
	@FindBy(xpath="//input[@id='input-password']")
	WebElement password;
	//identify webelement confirm password
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement confirmpassword;
	//identify webelement privacy policy
	@FindBy(xpath="//input[@name='agree']")
	WebElement privacypolicy;
	//identify webelement submit button
	@FindBy(xpath="//input[@type='submit']")
	WebElement submitbutton;
	
	//identify action on first name
	public void enterfirstname(String fname)
	{
		firstname.sendKeys(fname);
	}
	//identify action on last name
	public void enterlastname(String lname)
	{
		lastname.sendKeys(lname);
	}
	//identify action on emailfield
	public void enteremail(String emailaddress)
	{
		email.sendKeys(emailaddress);
	}
	//identify action on telephonefield
	public void entertelephone(String no)
	{
		telephone.sendKeys(no);
	}
	//identify action on password
	public void enterpassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	//identify action on confirm password
	public void enterconfirmpassword(String cpwd)
	{
		confirmpassword.sendKeys(cpwd);
	}
	//identify action on check box
	public void clickOncheckbox()
	{
		privacypolicy.click();
	}
	//identify action on submit button
	public void clickOnSubmitButton()
	{
		submitbutton.click();
	}

}
