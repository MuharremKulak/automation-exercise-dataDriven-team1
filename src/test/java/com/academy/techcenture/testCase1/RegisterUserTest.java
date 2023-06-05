package com.academy.techcenture.testCase1;

import com.academy.techcenture.baseTest.BaseTest;
import com.academy.techcenture.pages.*;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.util.Map;

public class RegisterUserTest extends BaseTest {
    private AccountCreatedPage accountCreatedPage;
    private AccountDeletedPage accountDeletedPage;
    private EnterAccountInformationPage enterAccountInformationPage;
    private HomePage homePage;
    private LoginPage loginPage;


    @Test(dataProvider = "CustomerAccountInformation")
    public void registerUser(Map<String, String> data) throws InterruptedException {

        extentTest = extentReports.startTest("registerUserTest");

        homePage = new HomePage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new Home page");
        loginPage = new LoginPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new Login page");
        enterAccountInformationPage = new EnterAccountInformationPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated account information page");
        accountCreatedPage = new AccountCreatedPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated account created page");
        accountDeletedPage = new AccountDeletedPage(driver);

        extentTest.log(LogStatus.INFO, "Instantiated account deleted page");

        homePage.verifyHomePageTitle();
        extentTest.log(LogStatus.PASS, "Homepage verified");
        homePage.clickOnSignUpLoginButton();
        extentTest.log(LogStatus.PASS, "Clicked sign up button");
        loginPage.verifyNewUserSignUpHeader();
        extentTest.log(LogStatus.PASS, "Header is displayed");
        loginPage.enterNameForSignUp(data);
        extentTest.log(LogStatus.INFO, "Entered name for sign up");
        loginPage.enterEmailForSignUp(data);
        extentTest.log(LogStatus.PASS, "Name and email entered");
        loginPage.clickOnSignUpButton();
        extentTest.log(LogStatus.PASS, "Clicked signup button");
        enterAccountInformationPage.verifyEnterAccountInfoHeader();
        extentTest.log(LogStatus.PASS, "Account information Header is displayed");
        enterAccountInformationPage.mrOrMrsRadioButton(data);
        extentTest.log(LogStatus.INFO, "Chosen gender");
        enterAccountInformationPage.fillAccountDetails(data);
        extentTest.log(LogStatus.PASS, "Account details Successfully filled in ");
        enterAccountInformationPage.selectNewsletterOffers();
        extentTest.log(LogStatus.PASS, "Clicked special offers and newsletter button");
        enterAccountInformationPage.fillAddressDetails(data);
        extentTest.log(LogStatus.PASS, "Address information details entered");
        enterAccountInformationPage.clickCreateAccountButton();
        extentTest.log(LogStatus.PASS, "Clicked create account button");
        accountCreatedPage.accountCreatedConfirmHeader();
        extentTest.log(LogStatus.PASS, "Header verified");
        accountCreatedPage.clickContinueButton();
        extentTest.log(LogStatus.PASS, "Continue button clicked");
        homePage.loggedInAsUsername();
        extentTest.log(LogStatus.PASS, "Logged in as <username> is displayed");
//        homePage.deleteAccountButton();
//        extentTest.log(LogStatus.PASS, "Delete account number clicked");
//        accountDeletedPage.accountDeletedHeader();
//        extentTest.log(LogStatus.INFO, "Verified account delete header");
//        accountDeletedPage.clickContinueButton();
//        extentTest.log(LogStatus.PASS, "Clicked continue button");
    }

}
