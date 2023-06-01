package com.academy.techcenture.TestCase2;

import com.academy.techcenture.baseTest.BaseTest;
import com.academy.techcenture.pages.AccountDeletedPage;
import com.academy.techcenture.pages.HomePage;
import com.academy.techcenture.pages.LoginPage;
import org.testng.annotations.Test;

import java.util.Map;

public class LoginUserWithCorrectEmailAndPasswordTest extends BaseTest {
    public static HomePage homePage;
    public static LoginPage loginPage;
    public static AccountDeletedPage accountDeletedPage;

    @Test(dataProvider = "CustomerAccountInformation")
    public void loginPositive(Map<String, String> data){
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        accountDeletedPage = new AccountDeletedPage();
        homePage.verifyHomePageTitle();
        homePage.clickOnSignUpLoginButton();
        loginPage.verifyLoginToYourAccountHeader();
        loginPage.enterCustomerEmailForLogin(data);
        loginPage.enterCustomerPasswordForLogin(data);
        loginPage.clickOnLoginButton();
      //  homePage.loggedInAsUsername();
      //  homePage.deleteAccountButton();
      //  accountDeletedPage.accountDeletedHeader();

    }
}
