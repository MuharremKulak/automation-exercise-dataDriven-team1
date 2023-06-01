package com.academy.techcenture.TestCase9;

import com.academy.techcenture.baseTest.BaseTest;
import com.academy.techcenture.pages.HomePage;
import com.academy.techcenture.pages.AllProductPage;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class SearchProduct extends BaseTest {

    private HomePage homePage;
    private AllProductPage allProductPage;


    @Test
    public void SearchProduct() {

        extentTest = extentReports.startTest("VerifyAllProductsAndProductDetailPage");

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
        allProductPage.verifyAllProductPageHeader();
        extentTest.log(LogStatus.PASS, "Verified All product Page Header");
        allProductPage.searchProductAndClickSearchButton();
        extentTest.log(LogStatus.PASS, "Searched and Clicked product");
        allProductPage.verifySearchedProductIsVisible();
        extentTest.log(LogStatus.PASS, "Verified search product header is visible");
        allProductPage.verifyProductsAfterSearched();
        extentTest.log(LogStatus.PASS, "Verified product after searched");
    }


}