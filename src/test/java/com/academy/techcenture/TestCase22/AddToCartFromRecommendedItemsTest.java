package com.academy.techcenture.TestCase22;

import com.academy.techcenture.baseTest.BaseTest;
import com.academy.techcenture.pages.HomePage;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class AddToCartFromRecommendedItemsTest extends BaseTest {

    private HomePage homePage;

    @Test
    public void addToCartFromRecommendedItemsTest() throws InterruptedException {
        extentTest = extentReports.startTest("AddToCartFromRecommenededItems");

        homePage = new HomePage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated Home page");
        homePage.navigateToHomePage();
        homePage.scrollDownToRecommendedItemsSection();
        extentTest.log(LogStatus.INFO, "Scrolled To Recommended Items");
        homePage.verifyRecommenededItems();
        extentTest.log(LogStatus.PASS, "Verified Items Displayed");
        homePage.addRecomendedItemsToCart();
        extentTest.log(LogStatus.INFO, "Added items to page");
        homePage.viewCart();
        extentTest.log(LogStatus.PASS, "Viewed Cart");
        homePage.verifyProductAdded();
        extentTest.log(LogStatus.INFO, "Verified Products Added");
    }
}

