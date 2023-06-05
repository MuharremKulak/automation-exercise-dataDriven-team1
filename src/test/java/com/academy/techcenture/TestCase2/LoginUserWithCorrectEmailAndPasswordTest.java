package com.academy.techcenture.TestCase2;

import com.academy.techcenture.baseTest.BaseTest;
import com.academy.techcenture.pages.AccountDeletedPage;
import com.academy.techcenture.pages.HomePage;
import com.academy.techcenture.pages.LoginPage;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.util.Map;

public class LoginUserWithCorrectEmailAndPasswordTest extends BaseTest {

    private HomePage homePage;
    private LoginPage loginPage;
    private AccountDeletedPage accountDeletedPage;

    @Test(dataProvider = "CustomerAccountInformation")
    public void loginPositive(Map<String, String> data){

        extentTest = extentReports.startTest("LoginUserWithCorrectEmailAndPasswordTest");

        homePage = new HomePage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new Home page");
        loginPage = new LoginPage(driver);

        accountDeletedPage = new AccountDeletedPage(driver);

        extentTest.log(LogStatus.INFO, "Instantiated new Login page");
        accountDeletedPage = new AccountDeletedPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated account deleted page");
        homePage.verifyHomePageTitle();
        extentTest.log(LogStatus.INFO, "Verified home page title");
        homePage.clickOnSignUpLoginButton();
        extentTest.log(LogStatus.INFO, "Clicked on sign up/ login button");
        loginPage.verifyLoginToYourAccountHeader();
        extentTest.log(LogStatus.INFO, "Verified login to your account header");
        loginPage.enterCustomerEmailForLogin(data);
        extentTest.log(LogStatus.PASS, "Entered customer email for login");
        loginPage.enterCustomerPasswordForLogin(data);
        extentTest.log(LogStatus.PASS, "Entered customer password for login");
        loginPage.clickOnLoginButton();

        extentTest.log(LogStatus.PASS, "Clicked on login button");
        homePage.loggedInAsUsername();
        extentTest.log(LogStatus.INFO, "Logged in as username");
//        homePage.deleteAccountButton();
//        extentTest.log(LogStatus.PASS, "Clicked delete account button");
//        accountDeletedPage.accountDeletedHeader();
//        extentTest.log(LogStatus.INFO, "Verified account deleted header");
//        accountDeletedPage.clickContinueButton();
//        extentTest.log(LogStatus.PASS, "Clicked continue button");
    }

}












