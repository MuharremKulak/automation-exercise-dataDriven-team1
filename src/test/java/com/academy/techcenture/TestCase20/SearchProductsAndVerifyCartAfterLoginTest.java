package com.academy.techcenture.TestCase20;

import com.academy.techcenture.baseTest.BaseTest;
import com.academy.techcenture.pages.AllProductPage;
import com.academy.techcenture.pages.HomePage;
import com.academy.techcenture.pages.LoginPage;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.util.Map;

public class SearchProductsAndVerifyCartAfterLoginTest extends BaseTest {

    private HomePage homePage;
    private AllProductPage allProductPage;
    private LoginPage loginPage;


    @Test(dataProvider = "CustomerAccountInformation")
    public void SearchProductsAdnVerifyCartAfterLoginPositiveTest(Map<String, String> data) throws InterruptedException {

        extentTest = extentReports.startTest("SearchProductsAdnVerifyCartAfterLoginPositiveTest");

        homePage = new HomePage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new Home page");
        allProductPage = new AllProductPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated all product page");
        loginPage = new LoginPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated all login page");


        homePage.navigateToHomePage();
        extentTest.log(LogStatus.INFO, "Navigated Home Page Object");
        homePage.clickProductsButton();
        extentTest.log(LogStatus.PASS, "Clicked on Products button");
        allProductPage.verifyAllProductPageHeader();
        extentTest.log(LogStatus.INFO, "All Product Page is visible!");
        allProductPage.searchProductAndClickSearchButton();
        extentTest.log(LogStatus.PASS, "Products entered and searched!");
        allProductPage.verifyProductsAfterSearched();
        extentTest.log(LogStatus.INFO, "Searched Products title is visible!");
        allProductPage.verifyAllProductsAfterSearchJeans();
        extentTest.log(LogStatus.INFO, "First,Second and Third Products are on the page!");
        allProductPage.hoverFirstProductAndClickAddToCart();
        extentTest.log(LogStatus.INFO, "Your First Product is on the cart!");
        allProductPage.clickOnContinueShoppingButton();
        extentTest.log(LogStatus.PASS, "Clicked on continue shopping button");
        allProductPage.hoverSecondProductAndClickAddToCart();
        extentTest.log(LogStatus.INFO, "Your Second Product is on the cart!");
        allProductPage.clickOnContinueShoppingButton();
        extentTest.log(LogStatus.PASS, "Clicked on continue shopping button");
        allProductPage.hoverThirdProductAndClickAddToCart();
        extentTest.log(LogStatus.INFO, "Your Third Product is on the cart!");
        allProductPage.clickOnViewCartButton();
        extentTest.log(LogStatus.PASS, "Clicked on view cart button");
        allProductPage.verifyAllProductBeforeLogin();
        extentTest.log(LogStatus.INFO,"Verified all product is displayed!");
        allProductPage.clickSignupLoginButton();
        extentTest.log(LogStatus.PASS, "Clicked on signUp/Login button");
        loginPage.enterCustomerEmailForLogin(data);
        extentTest.log(LogStatus.PASS, "Entered email for Login");
        loginPage.enterCustomerPasswordForLogin(data);
        extentTest.log(LogStatus.PASS, "Entered password for Login");
        loginPage.clickOnLoginButton();
        extentTest.log(LogStatus.PASS, "Clicked Login button");
        loginPage.verifyLoginAsUsername();
        extentTest.log(LogStatus.INFO,"Verified username is displayed!");
        homePage.clickOnCartButton();
        extentTest.log(LogStatus.PASS, "Clicked on cart button");
        allProductPage.verifyAllProductBeforeLogin();
        extentTest.log(LogStatus.INFO,"Verified all products before login!");
    }

}