package com.academy.techcenture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AccountDeletedPage {

    private WebDriver driver;

    public AccountDeletedPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy (xpath = "//h2[@class='title text-center']//b")
    public WebElement accountDeletedHeader;
    @FindBy (xpath = "//a[@data-qa='continue-button']")
    public WebElement continueButton;

    public void accountDeletedHeader(){
        Assert.assertTrue(accountDeletedHeader.isDisplayed());
    }
    public void clickContinueButton(){
        continueButton.click();
    }
}
