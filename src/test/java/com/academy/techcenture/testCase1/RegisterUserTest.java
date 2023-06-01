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
        extentTest = extentReports.startTest("registerUserTest");
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        enterAccountInformationPage = new EnterAccountInformationPage();
        accountCreatedPage = new AccountCreatedPage();
        accountDeletedPage = new AccountDeletedPage();
        homePage.verifyHomePageTitle();
        extentTest.log(LogStatus.PASS, "Homepage verified");
        homePage.clickOnSignUpLoginButton();
        extentTest.log(LogStatus.PASS, "Clicked sign up button");
        loginPage.verifyNewUserSignUpHeader();
        extentTest.log(LogStatus.PASS, "Header is displayed");
        loginPage.enterNameForSignUp(data);
        loginPage.enterEmailForSignUp(data);
        extentTest.log(LogStatus.PASS, "Name and email entered");
        loginPage.clickOnSignUpButton();
        extentTest.log(LogStatus.PASS, "Clicked signup button");
//        enterAccountInformationPage.verifyEnterAccountInfoHeader();
        extentTest.log(LogStatus.PASS, "Account information Header is displayed");
        enterAccountInformationPage.radioButtonMR(data);
        enterAccountInformationPage.fillAccountDetails(data);
        extentTest.log(LogStatus.PASS, "Account details Successfully filled in ");
        enterAccountInformationPage.selectNewsletterOffers();
        extentTest.log(LogStatus.PASS, "Clicked special offers and newsletter button");
        enterAccountInformationPage.fillAddressDetails(data);
        extentTest.log(LogStatus.PASS, "Address information details entered");
        enterAccountInformationPage.clickCreateAccountButton();
        accountCreatedPage.accountCreatedConfirmHeader();
        extentTest.log(LogStatus.PASS, "Header verified");
        accountCreatedPage.clickContinueButton();
        extentTest.log(LogStatus.PASS, "Continue button clicked");
        homePage.loggedInAsUsername();
        extentTest.log(LogStatus.PASS, "Logged in as <username> is displayed");
        homePage.deleteAccountButton();
        extentTest.log(LogStatus.PASS, "Delete account number clicked");
        accountDeletedPage.accountDeletedHeader();
        accountDeletedPage.clickContinueButton();


    }


}


