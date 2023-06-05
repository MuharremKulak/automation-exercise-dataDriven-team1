package com.academy.techcenture.TestCase13;

import com.academy.techcenture.baseTest.BaseTest;
import com.academy.techcenture.pages.AllProductPage;
import com.academy.techcenture.pages.HomePage;
import com.academy.techcenture.pages.ProductDetailPage;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class VerifyProductQuantityInCart extends BaseTest {

    protected HomePage homePage;
    protected ProductDetailPage productDetailPage;


    @Test
    public void VerifyProductQuantityInCartTest() throws InterruptedException {

        extentTest = extentReports.startTest("VerifyProductQuantityInCart");

        productDetailPage = new ProductDetailPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated product details page");
        homePage = new HomePage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new Home page");
        homePage.navigateToHomePage();
        extentTest.log(LogStatus.INFO, "Navigated Home Page Object");
        homePage.verifyHomePageTitle();
        extentTest.log(LogStatus.PASS, "Verified Home Page Title");
        homePage.clickViewProductForAnyProduct();
        extentTest.log(LogStatus.PASS, "Clicked view product button");
        productDetailPage.verifyProductDetailsPage();
        extentTest.log(LogStatus.PASS, "Verified product detail is opened");
        productDetailPage.enterQuantity();
        extentTest.log(LogStatus.PASS, "Entered quantity of 4");
        productDetailPage.clickAddToCartButton();
        extentTest.log(LogStatus.PASS, "Clicked Add to Cart button");
        productDetailPage.clickOnViewCartButton();
        extentTest.log(LogStatus.PASS, "Clicked view cart button");
        productDetailPage.verifyProductQuantityIsDisplayed();
        extentTest.log(LogStatus.PASS, "Verified product quantity");
    }

}
