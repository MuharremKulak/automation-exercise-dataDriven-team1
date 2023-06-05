package com.academy.techcenture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AccountCreatedPage {

    private WebDriver driver;

    public AccountCreatedPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy (xpath = "//div[@class='col-sm-9 col-sm-offset-1']//b")
    public WebElement accountCreatedConfirmHeader;
    @FindBy (xpath = "//a[@class='btn btn-primary']")
    public WebElement continueButton;


    public void accountCreatedConfirmHeader(){
        Assert.assertTrue(accountCreatedConfirmHeader.isDisplayed());
    }
    public void clickContinueButton(){
        continueButton.click();

    }
}
