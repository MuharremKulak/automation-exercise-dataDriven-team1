package com.academy.techcenture.testCase1;

import com.academy.techcenture.baseTest.BaseTest;
import com.academy.techcenture.pages.*;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class RegisterUserTest extends BaseTest {
    public static AccountCreatedPage accountCreatedPage;
    public static AccountDeletedPage accountDeletedPage;
    public static EnterAccountInformationPage enterAccountInformationPage;
    public static HomePage homePage;
    public static LoginPage loginPage;


    @Test(dataProvider = "CustomerAccountInformation")
    public void registerUser(Map<String, String> data) throws InterruptedException {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        enterAccountInformationPage = new EnterAccountInformationPage();
        accountCreatedPage = new AccountCreatedPage();
        accountDeletedPage = accountDeletedPage;

        homePage.verifyHomePageTitle();
        extentTest.log(LogStatus.PASS, "Homepage verified");
        homePage.clickOnSignUpLoginButton();
        extentTest.log(LogStatus.PASS, "Clicked sign up button");
        loginPage.verifyNewUserSignUpHeader();
        extentTest.log(LogStatus.PASS, "Header is displayed");
        loginPage.nameInputBox.sendKeys(data.get("FirstName"));
        loginPage.emailInputBox.sendKeys(data.get("Email"));
        extentTest.log(LogStatus.PASS, "Name and email entered");
        loginPage.clickOnSignUpButton();
        extentTest.log(LogStatus.PASS, "Clicked signup button");
        Assert.assertTrue(enterAccountInformationPage.enterAccountInformationHeader.isDisplayed());
        extentTest.log(LogStatus.PASS, "Account information Header is displayed");
        if (data.get("Gender").equals("M")) {
            enterAccountInformationPage.radioButtonMR.click();
        } else {
            enterAccountInformationPage.radioButtonMRS.click();
        }
        enterAccountInformationPage.passwordInput.sendKeys(data.get("Password"));
        Select select = new Select(enterAccountInformationPage.monthsDropDown);// Ask team best approach for birthday drop down
        select.selectByVisibleText(data.get("DateOfBirth"));


//        extentTest.log(LogStatus.PASS, "Account details Successfully filled in "); ???
        enterAccountInformationPage.newsLetterCheckBox.click();
        extentTest.log(LogStatus.PASS, "Clicked newsletter button");
        enterAccountInformationPage.specialOffersCheckBox.click();
        extentTest.log(LogStatus.PASS, "Clicked special offers button");
        enterAccountInformationPage.firstNameInfo.sendKeys(data.get("FirstName"));
        enterAccountInformationPage.lastNameInfo.sendKeys(data.get("LastName"));
        enterAccountInformationPage.companyInfo.sendKeys(data.get("Company"));
        enterAccountInformationPage.addressInfo.sendKeys(data.get("StreetAddress"));
        select = new Select(enterAccountInformationPage.countryDropDown);
        select.selectByVisibleText(data.get("Country"));
        enterAccountInformationPage.stateInfo.sendKeys(data.get("State"));
        enterAccountInformationPage.cityInfo.sendKeys(data.get("City"));
        enterAccountInformationPage.zipCodeInfo.sendKeys(data.get("Zip"));
        enterAccountInformationPage.mobileNumber.sendKeys(data.get("PhoneNumber"));
//        extentTest.log(LogStatus.PASS, "Address information details entered");  ??
        enterAccountInformationPage.createAccountButton.click();
        Assert.assertTrue(accountCreatedPage.accountCreatedConfirmHeader.isDisplayed());
        extentTest.log(LogStatus.PASS, "Header verified");
        accountCreatedPage.continueButton.click();
        extentTest.log(LogStatus.PASS, "Continue button clicked");
        Assert.assertTrue(homePage.loggedInAsUsername.isDisplayed());
        extentTest.log(LogStatus.PASS, "Logged in as <username> is displayed");
        homePage.deleteAccountButton.click();
        extentTest.log(LogStatus.PASS, "Delete account number clicked");
        Assert.assertTrue(accountDeletedPage.accountDeletedHeader.isDisplayed());
        accountDeletedPage.continueButton.click();




    }


}


