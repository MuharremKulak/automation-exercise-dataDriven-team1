package com.academy.techcenture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.Map;

public class EnterAccountInformationPage {

    private WebDriver driver;

    public EnterAccountInformationPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy (xpath = "//div[@class='login-form']/h2/b")
    public WebElement enterAccountInformationHeader;
    @FindBy (id = "id_gender1")
    public WebElement radioButtonMR;
    @FindBy (id = "uniform-id_gender2")
    public WebElement radioButtonMRS;
    @FindBy (id = "password")
    public WebElement passwordInput;
    @FindBy (id = "days")
    public WebElement dayDropDown;
    @FindBy (id = "months")
    public WebElement monthsDropDown;
    @FindBy (id = "years")
    public WebElement yearsDropDown;
    @FindBy (id = "newsletter")
    public WebElement newsLetterCheckBox;
    @FindBy (id = "optin")
    public WebElement specialOffersCheckBox;
    @FindBy (id = "first_name")
    public WebElement firstNameInfo;
    @FindBy (id = "last_name")
    public WebElement lastNameInfo;
    @FindBy (id = "company")
    public WebElement companyInfo;
    @FindBy (id = "address1")
    public WebElement addressInfo;
    @FindBy (id = "country")
    public WebElement countryDropDown;
    @FindBy (id = "state")
    public WebElement stateInfo;
    @FindBy (id = "city")
    public WebElement cityInfo;
    @FindBy (id = "zipcode")
    public WebElement zipCodeInfo;
    @FindBy (id = "mobile_number")
    public WebElement mobileNumber;
    @FindBy (xpath = "//button[@data-qa='create-account']")
    public WebElement createAccountButton;



    public void verifyEnterAccountInfoHeader(){
        System.out.println(enterAccountInformationHeader.getText());
        Assert.assertTrue(enterAccountInformationHeader.isDisplayed());
    }

    public void mrOrMrsRadioButton(Map<String,String> data){
        if (data.get("Gender").equals("M")) {
            radioButtonMR.click();
        } else {
            radioButtonMRS.click();
        }
    }

    public void fillAccountDetails(Map<String,String> data){
        passwordInput.sendKeys(data.get("Password"));

        Select select1 = new Select(dayDropDown);
        select1.selectByVisibleText("4");

        Select select2 = new Select(monthsDropDown);
        select2.selectByVisibleText("July");

        Select select3 = new Select(yearsDropDown);
        select3.selectByVisibleText("1991");
    }

    public void selectNewsletterOffers(){
        newsLetterCheckBox.click();
        specialOffersCheckBox.click();
    }

    public void fillAddressDetails(Map<String,String> data){
        firstNameInfo.sendKeys(data.get("FirstName"));
        lastNameInfo.sendKeys(data.get("LastName"));
        companyInfo.sendKeys(data.get("Company"));
        addressInfo.sendKeys(data.get("StreetAddress"));
        Select select = new Select(countryDropDown);
        select.selectByVisibleText(data.get("Country"));
        stateInfo.sendKeys(data.get("State"));
        cityInfo.sendKeys(data.get("City"));
        zipCodeInfo.sendKeys(data.get("Zip"));
        mobileNumber.sendKeys(data.get("PhoneNumber"));
    }

    public void clickCreateAccountButton(){
        createAccountButton.click();
    }

}
