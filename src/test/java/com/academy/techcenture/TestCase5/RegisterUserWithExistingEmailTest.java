package com.academy.techcenture.TestCase5;

import com.academy.techcenture.baseTest.BaseTest;
import com.academy.techcenture.pages.HomePage;
import com.academy.techcenture.pages.LoginPage;
import com.academy.techcenture.pages.SignUpPage;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.util.Map;

public class RegisterUserWithExistingEmailTest extends BaseTest {

    private HomePage homePage;
    private LoginPage loginPage;


    @Test(dataProvider = "CustomerAccountInformation")
    public void RegisterUserWithExistingEmailTest(Map<String, String> data) throws InterruptedException {

        extentTest = extentReports.startTest("RegisterUserWithExistingEmailTest");

        homePage = new HomePage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new Home page");
        homePage.navigateToHomePage();
        extentTest.log(LogStatus.INFO, "Navigated Home Page Object");
        homePage.verifyHomePageTitle();
        extentTest.log(LogStatus.PASS, "Verified Title");
        homePage.clickOnSignUpLoginButton();
        extentTest.log(LogStatus.PASS, "Clicked SignUp/Login button");
        loginPage = new LoginPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new Login page");
        loginPage.verifyNewUserSignUpHeader();
        extentTest.log(LogStatus.PASS, "Verified New User SignUp Header");
        loginPage.enterNameForSignUp(data);
        extentTest.log(LogStatus.INFO, "Entered name successfully");
        loginPage.enterEmailForSignUp(data);
        extentTest.log(LogStatus.INFO, "Entered email successfully");
        loginPage.clickOnSignUpButton();
        extentTest.log(LogStatus.PASS, "Clicked SignUp button");
        loginPage.verifyErrorMessage();
        extentTest.log(LogStatus.PASS, "Verified Error Message");

    }

}