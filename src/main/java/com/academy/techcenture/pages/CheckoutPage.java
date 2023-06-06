package com.academy.techcenture.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.util.Map;

public class CheckoutPage {

    private WebDriver driver;


    public CheckoutPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }

    @FindBy(xpath = "(//h2[@class='heading'])[1]")
    protected WebElement addressDetailsHeader;
    @FindBy(xpath = "(//h2[@class='heading'])[2]")
    protected WebElement reviewYourOrderHeader;
    @FindBy(xpath = "//div[@id='ordermsg']/textarea")
    protected WebElement commentInputBox;
    @FindBy(xpath = "//a[@href='/payment']")
    protected WebElement placeOrderButton;
    @FindBy(xpath = "//ul[@id='address_invoice']/li[2]")
    protected WebElement fullNameOnBillingAddress;
    @FindBy(xpath = "//ul[@id='address_invoice']/li[3]")
    protected WebElement companyOnBillingAddress;
    @FindBy(xpath = "//ul[@id='address_invoice']/li[4]")
    protected WebElement addressOnBillingAddress;
    @FindBy(xpath = "//ul[@id='address_invoice']/li[6]")
    protected WebElement secondAddressOnBillingAddress;
    @FindBy(xpath = "//ul[@id='address_invoice']/li[7]")
    protected WebElement countryOnBillingAddress;
    @FindBy(xpath = "//ul[@id='address_invoice']/li[8]")
    protected WebElement phoneNumberOnBillingAddress;
    @FindBy(xpath = "//a[@href='/delete_account']")
    protected WebElement deleteAccountButton;


    public void verifyHeadersAtCheckOutPage(){
        Assert.assertTrue(addressDetailsHeader.isDisplayed());
        Assert.assertTrue(reviewYourOrderHeader.isDisplayed());
    }

    public void scrollAllTheWayDownToPage() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", placeOrderButton);
        Thread.sleep(2000);
    }

    public void enterCommentAndClickPlaceOrder() throws InterruptedException {
        commentInputBox.sendKeys("I'd like to get delivery in front of my door please!");
        Thread.sleep(2000);
        placeOrderButton.click();
    }

    public void verifyBillingAddressWithRegisterInput(Map<String,String> data){
        String actualFullName = fullNameOnBillingAddress.getText();
        String expectedFullName = data.get("FullName");
        Assert.assertEquals(actualFullName,expectedFullName);

        String actualCompany = companyOnBillingAddress.getText();
        String expectedCompany = data.get("Company");
        Assert.assertEquals(actualCompany,expectedCompany);

        String actualAddress = addressOnBillingAddress.getText();
        String expectedAddress = data.get("StreetAddress");
        Assert.assertEquals(actualAddress,expectedAddress);

        String actualSecondAddress = secondAddressOnBillingAddress.getText();
        String expectedSecondAddress = "McLean VA 25401.0";
        Assert.assertEquals(actualSecondAddress, expectedSecondAddress);

        String actualCountry = countryOnBillingAddress.getText();
        String expectedCountry = data.get("Country");
        Assert.assertEquals(actualCountry,expectedCountry);

        String actualPhoneNumber = phoneNumberOnBillingAddress.getText();
        String expectedPhoneNumber = data.get("PhoneNumber");
        Assert.assertEquals(actualPhoneNumber, expectedPhoneNumber);
    }

    public void clickOnDeleteAccountButton(){
        deleteAccountButton.click();
    }


}
