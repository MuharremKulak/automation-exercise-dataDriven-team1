package com.academy.techcenture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.time.Duration;
import java.util.Map;

public class PlaceOrderPage {

    private WebDriver driver;

    public PlaceOrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//i[@class='fa fa-user']")
    protected WebElement loggedInAsUserVerification;
    @FindBy(xpath = "//*[contains(text(), 'Add to cart')][1]")
    protected WebElement addToCartBtn;
    @FindBy(xpath = "//h4[@class='modal-title w-100']")
    protected WebElement addedToCartMsg;
    @FindBy(xpath = "//a[@class='btn btn-default check_out']")
    protected WebElement proceedToCheckOutBtn;
    @FindBy(xpath = "//p[@class='text-center'][2]")
    protected WebElement viewCartBtnToProceedCheckOut;
    @FindBy(xpath = "//ul[@id='address_delivery']/li[2]")
    protected WebElement firstNameAndLastNameValue;
    @FindBy(xpath = "//ul[@id='address_delivery']/li[3]")
    protected WebElement companyValue;
    @FindBy(xpath = "//ul[@id='address_delivery']/li[4]")
    protected WebElement addressValue;
    @FindBy(xpath = "//ul[@id='address_delivery']/li[6]")
    protected WebElement address2Value;
    @FindBy(xpath = "//ul[@id='address_delivery']/li[7]")
    protected WebElement countryValue;
    @FindBy(xpath = "//ul[@id='address_delivery']/li[8]")
    protected WebElement phoneNumberValue;
    @FindBy (xpath = "//textarea[@class='form-control']")
    protected WebElement enterCommentTableBtn;
    @FindBy (xpath = "//a[@class='btn btn-default check_out']")
    protected WebElement placeAnOrderBtn;
    @FindBy(xpath = "//div[@class='col-sm-9 col-sm-offset-1']/a")
    protected WebElement downloadInvoiceButton;
    @FindBy(xpath = "//a[@data-qa='continue-button']")
    protected WebElement continueButton;


    public void clickOnAddToCartBtn() throws InterruptedException {
        addToCartBtn.click();
        Thread.sleep(2000);
    }

    public void verifyAddedToCartMsg() {
        Assert.assertEquals(addedToCartMsg.getText(),"Added!");
    }

    public void clickOnViewCartToProceedToCheckOut() {
        viewCartBtnToProceedCheckOut.click();
    }

    public void clickOnProceedToCheckOut() {
        proceedToCheckOutBtn.click();
    }

    public void verifyDeliveryAddressToOriginalInput(Map<String,String> data) {
        String actualFullName = firstNameAndLastNameValue.getText();
        String expectedFullName = data.get("FullName");
        Assert.assertEquals(actualFullName,expectedFullName);

        String actualCompany = companyValue.getText();
        String expectedCompany = data.get("Company");
        Assert.assertEquals(actualCompany,expectedCompany);

        String actualAddress = addressValue.getText();
        String expectedAddress = data.get("StreetAddress");
        Assert.assertEquals(actualAddress,expectedAddress);

        String actualAddress2 = address2Value.getText();
        String expectedAddress2 = "McLean VA 25401.0";
        Assert.assertEquals(actualAddress2,expectedAddress2);

        String actualCountry = countryValue.getText();
        String expectedCountry = data.get("Country");
        Assert.assertEquals(actualCountry, expectedCountry);

        String actualPhoneNumber = phoneNumberValue.getText();
        String expectedPhoneNumber = data.get("PhoneNumber");
        Assert.assertEquals(actualPhoneNumber,expectedPhoneNumber);
    }

    public void enterCommentInTable(){
        enterCommentTableBtn.click();
        enterCommentTableBtn.sendKeys("Leaving comment after adding item into the cart");
    }

    public void clickOnPlaceAnOrderButton(){
        placeAnOrderBtn.click();
    }

    public void downloadInvoice(){
        downloadInvoiceButton.click();
    }

    public void verifyInvoiceIsDownloaded(){
        // Set the download directory path
        String downloadDir = System.getProperty("user.home") + "/Downloads"; // Default download directory on Mac

        // Assuming the file name follows a specific pattern
        String expectedFileName = "invoice.txt";

        // Wait for the file to download
        File downloadedFile = new File(downloadDir + File.separator + expectedFileName);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until((WebDriver d) -> downloadedFile.exists());

        if (downloadedFile.exists()) {
            System.out.println("Invoice downloaded successfully!");
        } else {
            System.out.println("Invoice download failed!");
        }
    }

    public void clickOnContinueButton(){
        continueButton.click();
    }
}