package com.academy.techcenture.TestCase3;

import com.academy.techcenture.baseTest.BaseTest;
import com.academy.techcenture.pages.*;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;
import java.util.Map;

public class LoginTestWithIncorrectCredentials extends BaseTest {

        public static HomePage homePage;
        public static LoginPage loginPage;
        public  static LoginWithIncorrectCredsPage loginWithIncorrectCredsPage;


    @Test(dataProvider = "CustomerAccountInformation")
    public void loginWithIncorrectCreds(Map<String, String> data) throws InterruptedException {

        extentTest = extentReports.startTest("LoginTestWithIncorrectCredentials");

        homePage = new HomePage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new Home page");
        loginPage = new LoginPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new Login page");
        loginWithIncorrectCredsPage = new LoginWithIncorrectCredsPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated login with incorrect credentials page");

        homePage.navigateToHomePage();
        extentTest.log(LogStatus.INFO, "Navigated to home page");
        homePage.verifyHomePageTitle();
        extentTest.log(LogStatus.INFO, "Verified home page title");
        homePage.clickOnSignUpLoginButton();
        extentTest.log(LogStatus.PASS, "Clicked on sign up/ login button");
        loginPage.verifyNavigatedToLoginPage();
        extentTest.log(LogStatus.PASS, "Homepage verified");
        homePage.clickOnSignUpLoginButton();
        extentTest.log(LogStatus.PASS, "Clicked sign up button");
        loginWithIncorrectCredsPage.enterCustomerEmailForLogin(data);
        extentTest.log(LogStatus.PASS, "Entered email for login with incorrect credentials");
        loginWithIncorrectCredsPage.enterCustomerIncorrectPasswordForLogin(data);
        extentTest.log(LogStatus.PASS, "Entered incorrect password for login with incorrect credentials");
        loginWithIncorrectCredsPage.clickOnLoginButton();
        extentTest.log(LogStatus.PASS, "Clicked on login button");
        loginWithIncorrectCredsPage.verifyIncorrectEmailErrorMessage();

        extentTest.log(LogStatus.INFO, "Verified incorrect email error message");

    }

}

