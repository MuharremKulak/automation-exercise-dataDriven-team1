package com.academy.techcenture.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Map;

public class ContactUsPage {

    private WebDriver driver;

    public ContactUsPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//div[@class='contact-form']/h2[@class='title text-center']")
    protected WebElement getInTouchHeader;
    @FindBy(xpath = "//input[@data-qa='name']")
    protected WebElement nameInputForContactPage;
    @FindBy(xpath = "//input[@data-qa='email']")
    protected WebElement emailInputForContactPage;
    @FindBy(xpath = "//input[@data-qa='subject']")
    protected WebElement subjectInputForContactPage;
    @FindBy(id = "message")
    protected WebElement messageInputForContactPage;
    @FindBy(xpath = "//input[@data-qa='submit-button']")
    protected WebElement submitButton;
    @FindBy(xpath = "//input[@name='upload_file']")
    protected WebElement fileInput;
    @FindBy(xpath = "//div[@class='status alert alert-success']")
    protected WebElement successMessageForContactPage;
    @FindBy(xpath = "//a[@class='btn btn-success']")
    protected WebElement homeButtonToNavigateBack;

    public void verifyGetInTouchHeader(){
        Assert.assertTrue(getInTouchHeader.isDisplayed());
    }

    public void enterNameForContactPage(Map<String,String>data){
        nameInputForContactPage.sendKeys(data.get("FirstName"));
    }

    public void enterEmailForContactPage(Map<String,String>data){
        emailInputForContactPage.sendKeys(data.get("Email"));
    }

    public void enterSubjectForContactPage() throws InterruptedException {
        subjectInputForContactPage.sendKeys("Request promotion from Omonjon! :)");
        Thread.sleep(3000);
    }

    public void enterMessageForContactPage() throws InterruptedException {
        messageInputForContactPage.sendKeys("Hi everybody, Team 1 is amazing!!!! We believe we did a great job!" +
                " *** Members: Muharrem, Valerie, Oleysa, Pelin, Dulma");
        Thread.sleep(6000);
    }

    public void uploadFileForContactPage() throws InterruptedException {
        //Todo have some kind of file under this project
        String filePath = System.getProperty("user.dir") + "/src/main/resources/Test.png";
        fileInput.sendKeys(filePath);
        Thread.sleep(3000);
    }

    public void clickOnSubmitButtonForContactPage() throws InterruptedException {
        submitButton.click();
        Thread.sleep(2000);
    }

    public void clickOkButton(){
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void verifySuccessMessage(){
        Assert.assertTrue(successMessageForContactPage.isDisplayed());
    }

    public void clickHomeButtonToNavigateHomePage(){
        homeButtonToNavigateBack.click();
    }

}
