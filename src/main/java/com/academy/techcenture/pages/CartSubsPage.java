package com.academy.techcenture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Map;

public class CartSubsPage {

    private WebDriver driver;


    public CartSubsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }


    @FindBy(xpath = "//li/a/i[@class='fa fa-home']")
    public WebElement HomePageVisible;
    @FindBy(xpath ="//li[3]/a/i[@class='fa fa-shopping-cart'] ")
    public WebElement CartPage;
    @FindBy(xpath = "//div[@class='single-widget']//h2 ")
    public WebElement SubsCartPage;
    @FindBy(xpath = "//form/input[2][contains(@type,'email')]")
    public WebElement EnterSubsEmail;
    @FindBy(xpath = "//form/button[@id='subscribe']")
    public WebElement SubsButton;
    @FindBy(xpath = "//div[contains(text(),'You have been successfully subscribed!')]")
    public WebElement SuccessSubsText;



    public void navigateToCartPage(){
        CartPage.click();
        Assert.assertTrue(CartPage.isDisplayed());
    }
    public void verifySubscriptionHomePage() {
        Assert.assertTrue(SubsCartPage.isDisplayed());
    }

    public void enterEmailForSubs(Map<String, String> data) {
        EnterSubsEmail.sendKeys(data.get("Email"));
    }

    public void clickSubsButton() {
        SubsButton.click();
    }

    public void verifySubsMessage() {
        Assert.assertTrue(SuccessSubsText.isDisplayed());}

}