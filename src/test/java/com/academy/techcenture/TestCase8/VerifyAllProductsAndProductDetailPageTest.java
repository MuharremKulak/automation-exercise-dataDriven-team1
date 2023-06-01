package com.academy.techcenture.TestCase8;

import com.academy.techcenture.baseTest.BaseTest;
import com.academy.techcenture.pages.HomePage;
import com.academy.techcenture.pages.ProductDetailPage;
import com.academy.techcenture.pages.AllProductPage;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class VerifyAllProductsAndProductDetailPageTest extends BaseTest {

    private HomePage homePage;
    private AllProductPage productPage;
    private ProductDetailPage productDetailPage;

    @Test
    public void VerifyAllProductsAndProductDetailPageTest() {

        extentTest = extentReports.startTest("VerifyAllProductsAndProductDetailPage");

        homePage = new HomePage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new Home page");
        homePage.navigateToHomePage();
        extentTest.log(LogStatus.INFO, "Navigated Home Page Object");
        homePage.verifyHomePageTitle();
        extentTest.log(LogStatus.PASS, "Verified Title");
        homePage.clickProductsButton();
        extentTest.log(LogStatus.PASS, "Clicked first product button");
        productPage = new AllProductPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new product page");
        productPage.verifyAllProductPageHeader();
        extentTest.log(LogStatus.PASS, "Verified All Product Header");
        productPage.verifyProductsListIsVisible();
        extentTest.log(LogStatus.PASS, "Verified Products List is visible");
        productPage.clickOnFirstProductViewButton();
        extentTest.log(LogStatus.PASS, "Clicked first product view button");
        productDetailPage = new ProductDetailPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new product detail page");
        productDetailPage.verifyProductDetailsPage();
        extentTest.log(LogStatus.PASS, "Verified Product details page");
        productDetailPage.verifyProductDetailsIsVisible();
        extentTest.log(LogStatus.PASS, "Verified Products details is visible");
    }

}