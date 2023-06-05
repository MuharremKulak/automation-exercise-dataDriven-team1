package com.academy.techcenture.TestCase12;

import com.academy.techcenture.baseTest.BaseTest;
import com.academy.techcenture.pages.AllProductPage;
import com.academy.techcenture.pages.HomePage;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class AddProductsInCartTest extends BaseTest {

    private HomePage homePage;
    private AllProductPage allProductPage;


    @Test
    public void AddProductsInCartTest() throws InterruptedException {

        extentTest = extentReports.startTest("AddProductsInCartTest");

        homePage = new HomePage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new Home page");
        homePage.navigateToHomePage();
        extentTest.log(LogStatus.INFO, "Navigated Home Page Object");
        homePage.verifyHomePageTitle();
        extentTest.log(LogStatus.PASS, "Verified Home Page Title");
        homePage.clickProductsButton();
        extentTest.log(LogStatus.PASS, "Clicked product button");
        allProductPage = new AllProductPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new All Product page");
        allProductPage.hoverOverFirstProductAndClickAddToCart();
        extentTest.log(LogStatus.PASS, "Hover Over first product");
        allProductPage.clickOnContinueShoppingButton();
        extentTest.log(LogStatus.PASS, "Clicked continue shopping button");
        allProductPage.hoverOverSecondProductAndClickAddToCart();
        extentTest.log(LogStatus.PASS, "Hover Over second product");
        allProductPage.clickOnViewCartButton();
        extentTest.log(LogStatus.PASS, "Clicked View Cart button");
        allProductPage.verifyBothProductsAddedToCart();
        extentTest.log(LogStatus.PASS, "Verified both products added to cart");
        allProductPage.verifyProductsPrice();
        extentTest.log(LogStatus.PASS, "Verified products price");
        allProductPage.verifyProductsQuantity();
        extentTest.log(LogStatus.PASS, "Verified products quantity");
        allProductPage.verifyProductsTotalPrice();
        extentTest.log(LogStatus.PASS, "Verified products total price");
    }

}