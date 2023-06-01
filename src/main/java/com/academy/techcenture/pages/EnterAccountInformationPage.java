package com.academy.techcenture.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class EnterAccountInformationPage {
    @FindBy (xpath = "//div[@class='login-form']/h2/b")
    public WebElement enterAccountInformationHeader;
    @FindBy (id = "id_gender1")
    public WebElement radioButtonMR;
    @FindBy (id = "uniform-id_gender2")
    public WebElement radioButtonMRS;
    @FindBy (id = "name")
    public WebElement nameInput;
    @FindBy (id = "email")
    public WebElement emailInput;
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


    public void enterCustomerName(Map<String,String> data){
        nameInput.sendKeys(data.get("FirstName"));
    }
}
