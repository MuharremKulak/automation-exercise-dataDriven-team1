package com.academy.techcenture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.util.Map;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//div[@class='login-form']/h2")
    protected WebElement loginToYourAccountHeader;
    @FindBy(xpath = "//input[@data-qa='login-email']")
    protected WebElement emailInputForLogin;
    @FindBy(xpath = "//input[@data-qa='login-password']")
    protected WebElement passwordInputForLogin;
    @FindBy(xpath = "//button[@data-qa='login-button']")
    protected WebElement loginButton;
    @FindBy(xpath = "//a[@href='/logout']")
    protected WebElement logOutButton;
    @FindBy(xpath = "//ul[@class='nav navbar-nav']/li[10]/a")
    protected WebElement loggedInAsUsername;


    public void verifyLoginToYourAccountHeader(){
        Assert.assertTrue(loginToYourAccountHeader.isDisplayed());
    }

    public void enterCustomerEmailForLogin(Map<String,String> data){
        emailInputForLogin.sendKeys(data.get("Email"));
    }

    public void enterCustomerPasswordForLogin(Map<String,String> data){
        passwordInputForLogin.sendKeys(data.get("Password"));
    }

    public void clickOnLoginButton(){
        loginButton.click();
    }

    public void verifyLoginAsUsername(){
        Assert.assertTrue(loggedInAsUsername.isDisplayed());
    }

    public void clickLogOutButton(){
        logOutButton.click();
    }

    public void verifyNavigatedToLoginPage(){
        Assert.assertTrue(loginToYourAccountHeader.isDisplayed());
    }



}
