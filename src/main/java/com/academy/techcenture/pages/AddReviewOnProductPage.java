package com.academy.techcenture.pages;

import com.academy.techcenture.utils.ConfigReader;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Map;

public class AddReviewOnProductPage {

    private WebDriver driver;

    public AddReviewOnProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }


    @FindBy(xpath = "//li[2]/a/i[@class='material-icons card_travel']")
    public WebElement productPage;
    @FindBy(xpath="//div//h2[@class='title text-center']" )
    public WebElement verifyProductTitle;
    @FindBy(xpath="//div//ul//li//a[@href='/product_details/1']")
    public WebElement viewProduct;
    @FindBy(xpath ="//section//div//ul//li//a[@href='#reviews']")
    public WebElement writeYourReviewVisible;
    @FindBy(xpath="//section//span//input[@id='name']")
    public WebElement writeYourName;
    @FindBy(xpath="//section//span//input[@id='email']")
    public WebElement writeYourEmail;
    @FindBy(xpath="//section//div//form//textarea[@id='review']")
    public WebElement writeYourReview;
    @FindBy(xpath="//section//div//form//button[@id='button-review']")
    public WebElement submitButton;
    @FindBy(xpath="//div[@id='review-section']/div/div/span")
    public WebElement successMessage;
    @FindBy(id = "review")
    protected WebElement writeReviewWebElement;


    public void navigateToHomePage(){
        driver.get(ConfigReader.getProperty("url"));
    }

    public void clickOnProductPage(){
        productPage.click();
    }

    public void verifyProductPageVisible() {
        String productPageTitle = verifyProductTitle.getText();
        String expectedTitle = "ALL PRODUCTS";
        Assert.assertEquals(productPageTitle, expectedTitle);
    }

    public void clickOnViewProduct(){
        viewProduct.click();
    }

    public void scrollAllTheWayDownToPage() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(2000);
        js.executeScript("arguments[0].scrollIntoView(true);", writeReviewWebElement);
        Thread.sleep(2000);
    }

    public void verifyWriteYourReview(){
        Assert.assertTrue(writeYourReviewVisible.isDisplayed());
    }

    public void enterName(Map<String, String> data){
        writeYourName.sendKeys(data.get("FirstName"));
    }

    public void enterEmail(Map<String, String> data){
        writeYourEmail.sendKeys(data.get("Email"));
    }

    public void enterReview(){
        writeYourReview.sendKeys("Best purchase I have ever made. I would definitely recommend buying this item.");
    }

    public void clickSubmitButton(){
        submitButton.click();
    }

    public void verifySuccessMessage(){
        String actualMessage = successMessage.getText();
        String expectedMessage = "Thank you for your review.";
        Assert.assertEquals(actualMessage, expectedMessage);
    }
}