package com.academy.techcenture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Map;

public class PaymentPage {

    private WebDriver driver;

    public PaymentPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//input[@data-qa='name-on-card']")
    protected WebElement nameOnCardInput;
    @FindBy(xpath = "//input[@data-qa='card-number']")
    protected WebElement cardNumberInput;
    @FindBy(xpath = "//input[@data-qa='cvc']")
    protected WebElement cvcInput;
    @FindBy(xpath = "//input[@data-qa='expiry-month']")
    protected WebElement expMonthInput;
    @FindBy(xpath = "//input[@data-qa='expiry-year']")
    protected WebElement expYearInput;
    @FindBy(xpath = "//button[@data-qa='pay-button']")
    protected WebElement payAndConfirmButton;
    @FindBy(xpath = "//h2[@data-qa='order-placed']/b")
    protected WebElement orderPlacedHeader;
    @FindBy(xpath = "//a[@href='/delete_account']")
    protected WebElement deleteAccountButton;


    public void fillOutPaymentInformation(Map<String,String> data){
        nameOnCardInput.sendKeys(data.get("NameOnCard"));
        cardNumberInput.sendKeys(data.get("CardNumber"));
        cvcInput.sendKeys(data.get("CVC"));
        expMonthInput.sendKeys(data.get("ExpMonth"));
        expYearInput.sendKeys(data.get("ExpYear"));
        payAndConfirmButton.click();
    }

    public void verifySuccessfulMessage(){
        Assert.assertTrue(orderPlacedHeader.isDisplayed());
    }

    public void clickOnDeleteAccountButton(){
        deleteAccountButton.click();
    }




}
