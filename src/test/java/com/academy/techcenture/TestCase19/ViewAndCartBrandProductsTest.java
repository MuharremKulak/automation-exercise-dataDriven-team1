package com.academy.techcenture.TestCase19;

import com.academy.techcenture.baseTest.BaseTest;
import com.academy.techcenture.pages.HomePage;
import com.academy.techcenture.pages.ProductDetailPage;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class ViewAndCartBrandProductsTest extends BaseTest {

    private HomePage homePage;
    private ProductDetailPage productDetailPage;

    @Test
    public void ViewAndCartBrandProductsTest() throws InterruptedException {

        extentTest = extentReports.startTest("ViewAndCartBrandProductsTest");

        homePage = new HomePage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated Home page");
        productDetailPage = new ProductDetailPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated Product detail page");

        homePage.navigateToHomePage();
        extentTest.log(LogStatus.INFO, "Navigated to Home page");
        homePage.clickProductsButton();
        extentTest.log(LogStatus.PASS, "Clicked on Products Button");
        productDetailPage.scrollDownToBrandList();
        extentTest.log(LogStatus.INFO, "Scrolled down to Brand Header");
        productDetailPage.verifyBrandsAreVisible();
        extentTest.log(LogStatus.INFO, "Verified Brands are visible");
        productDetailPage.selectPoloBrand();
        extentTest.log(LogStatus.INFO, "Selected Polo Brand");
        productDetailPage.verifyPoloHeader();
        extentTest.log(LogStatus.INFO, "Verified Polo brand header");
        productDetailPage.clickOnHMBrand();
        extentTest.log(LogStatus.INFO, "Clicked on H&M brand");
        productDetailPage.verifyHMHeader();
        extentTest.log(LogStatus.INFO, "Verified HM Brand header");
    }
}

