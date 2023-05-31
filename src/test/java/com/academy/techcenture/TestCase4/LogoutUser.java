package com.academy.techcenture.TestCase4;

import com.academy.techcenture.baseTest.BaseTest;
import com.academy.techcenture.pages.HomePage;
import com.academy.techcenture.pages.LoginPage;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.util.Map;

public class LogoutUser extends BaseTest {

    private HomePage homePage;
    private LoginPage loginPage;

    @Test(dataProvider = "CustomerAccountInformation")
    public void logOutUserTest(Map<String,String> data){

        extentTest = extentReports.startTest("logOutUserTest");

        homePage = new HomePage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new Home page");
        homePage.navigateToHomePage();
        extentTest.log(LogStatus.INFO, "Navigated Home Page Object");
        homePage.verifyHomePageTitle();
        extentTest.log(LogStatus.PASS, "Verified Title");
        homePage.clickOnSignUpLoginButton();
        extentTest.log(LogStatus.PASS, "Clicked logIn button");
        loginPage = new LoginPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new Login page");
        loginPage.verifyLoginToYourAccountHeader();
        extentTest.log(LogStatus.PASS, "Verified Header");
        loginPage.enterCustomerEmailForLogin(data);
        extentTest.log(LogStatus.INFO, "Enter Customer email successfully");
        loginPage.enterCustomerPasswordForLogin(data);
        extentTest.log(LogStatus.INFO, "Enter Customer password successfully");
        loginPage.clickOnLoginButton();
        extentTest.log(LogStatus.PASS, "Clicked Login button");
        loginPage.verifyLoginAsUsername();
        extentTest.log(LogStatus.PASS, "Verified Title");
        loginPage.clickLogOutButton();
        extentTest.log(LogStatus.PASS, "Clicked Logout button");
        loginPage.verifyNavigatedToLoginPage();
        extentTest.log(LogStatus.PASS, "Verified user navigated to Login Page");
    }

}
