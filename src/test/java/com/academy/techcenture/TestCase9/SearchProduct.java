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
        allProductPage = new AllProductPage(driver);
        allProductPage.verifyAllProductPageHeader();
        allProductPage.searchProductAndClickSearchButton();
        allProductPage.verifySearchedProductIsVisible();
        allProductPage.verifyProductsAfterSearched();
    }


}