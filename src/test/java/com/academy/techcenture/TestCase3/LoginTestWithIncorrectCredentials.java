package com.academy.techcenture.TestCase3;
<<<<<<< HEAD
=======

>>>>>>> 5cc922d (added some extentTest and log status for Test 9. It's done!)
import com.academy.techcenture.baseTest.BaseTest;
import com.academy.techcenture.pages.*;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;
import java.util.Map;

public class LoginTestWithIncorrectCredentials extends BaseTest {
<<<<<<< HEAD
        public static HomePage homePage;
        public static LoginPage loginPage;
        public  static LoginWithIncorrectCredsPage loginWithIncorrectCredsPage;


    @Test(dataProvider = "CustomerAccountInformation")

=======
    private HomePage homePage;
    private LoginPage loginPage;
    private LoginWithIncorrectCredsPage loginWithIncorrectCredsPage;


    @Test(dataProvider = "CustomerAccountInformation")
>>>>>>> 5cc922d (added some extentTest and log status for Test 9. It's done!)
    public void loginWithIncorrectCreds(Map<String, String> data) throws InterruptedException {
        extentTest = extentReports.startTest("VerifyTestCasesPageTest");

        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        loginWithIncorrectCredsPage = new LoginWithIncorrectCredsPage(driver);

        homePage.navigateToHomePage();
        homePage.verifyHomePageTitle();
        homePage.clickOnSignUpLoginButton();
        loginPage.verifyNavigatedToLoginPage();
        extentTest.log(LogStatus.PASS, "Homepage verified");
        homePage.clickOnSignUpLoginButton();
        extentTest.log(LogStatus.PASS, "Clicked sign up button");
        loginWithIncorrectCredsPage.enterCustomerEmailForLogin(data);
        loginWithIncorrectCredsPage.enterCustomerIncorrectPasswordForLogin(data);
        loginWithIncorrectCredsPage.clickOnLoginButton();
        loginWithIncorrectCredsPage.verifyIncorrectEmailErrorMessage();





    }
<<<<<<< HEAD
}

=======
}
>>>>>>> 5cc922d (added some extentTest and log status for Test 9. It's done!)
