package com.academy.techcenture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Map;

public class LoginWithIncorrectCredsPage {

    private WebDriver driver;

    public LoginWithIncorrectCredsPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//input[@data-qa='login-email']")
    protected WebElement emailInputForLogin;
    @FindBy(xpath = "//input[@data-qa='login-password']")
    protected WebElement passwordInputForLogin;
    @FindBy (xpath = "//form[@action='/login']/p")
    protected WebElement incorrectEmailErrorMsg;
    @FindBy(xpath = "//button[@data-qa='login-button']")
    protected WebElement loginButton;

    public void enterCustomerEmailForLogin(Map<String,String> data){
        emailInputForLogin.sendKeys(data.get("Email"));
    }

    public void enterCustomerIncorrectPasswordForLogin(Map<String,String> data){
        passwordInputForLogin.sendKeys(data.get("IncorrectPassword"));
    }
    public void verifyIncorrectEmailErrorMessage(){
        Assert.assertTrue(incorrectEmailErrorMsg.isDisplayed());
    }

    public void clickOnLoginButton(){
        loginButton.click();
    }

}
