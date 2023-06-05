package com.academy.techcenture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SubscriptionPage {
    private WebDriver driver;


    public SubscriptionPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }


    @FindBy(xpath="//li/a/i[@class='fa fa-home']")
    public WebElement HomePageVisible;
    @FindBy(xpath ="//div[@class='single-widget']//h2 ")
    public WebElement SubsHomePage;
    @FindBy(xpath = "//form/input[2][contains(@type,'email')]")
    public WebElement EnterSubsEmail;
    @FindBy(xpath="//form/button[@id='subscribe']")
    public WebElement SubsButton;
    @FindBy(xpath = "//div[contains(text(),'You have been successfully subscribed!')]")
    public WebElement SuccessSubsText;


    public void verifyHomePageVisible(){
    HomePageVisible.click();
    Assert.assertTrue(HomePageVisible.isDisplayed());

}
    public void verifySubscriptionHomePage(){
        Assert.assertTrue(SubsHomePage.isDisplayed());
    }

    public void enterEmailForSubs(){
    EnterSubsEmail.sendKeys("lee@gmail.com");
    }

    public void clickSubsButton(){
    SubsButton.click();
    }

    public void verifySubsMessage(){
        Assert.assertTrue(SuccessSubsText.isDisplayed());


    }

}
