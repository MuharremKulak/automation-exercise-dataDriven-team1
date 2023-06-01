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
    @FindBy(xpath = "//div[@class='signup-form']/h2")
    protected WebElement newUserSignUpHeader;
//    @FindBy(xpath = "//input[@data-qa='signup-name']")
//    protected WebElement nameInputForSignUp;
//    @FindBy(xpath = "//input[@data-qa='signup-email']")
//    protected WebElement emailInputForSignUp;
    @FindBy(xpath = "//button[@data-qa='signup-button']")
    protected WebElement signUpButton;
    @FindBy(xpath = "//form[@action='/signup']/p")
    protected WebElement errorMessage;


    @FindBy(xpath = "//input[@data-qa='signup-name']")
    public WebElement nameInputForSignUp;
    @FindBy(xpath = "//input[@data-qa='signup-email']")
    public WebElement emailInputForSignUp;



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

    public void verifyNewUserSignUpHeader(){
        Assert.assertTrue(newUserSignUpHeader.isDisplayed());
    }


    public void enterNameForSignUp(Map<String,String> data){
        nameInputForSignUp.sendKeys(data.get("FirstName"));
    }

    public void enterEmailForSignUp(Map<String,String> data){
        emailInputForSignUp.sendKeys(data.get("Email"));
    }

    public void clickOnSignUpButton() throws InterruptedException {
        signUpButton.click();
        Thread.sleep(2000);
    }

    public void verifyErrorMessage(){
        Assert.assertTrue(errorMessage.isDisplayed());
    }




}
