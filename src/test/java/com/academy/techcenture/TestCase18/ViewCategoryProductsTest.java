package com.academy.techcenture.TestCase18;

import com.academy.techcenture.baseTest.BaseTest;
import com.academy.techcenture.pages.HomePage;
import com.academy.techcenture.pages.WomenProductPage;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class ViewCategoryProductsTest extends BaseTest {

    private HomePage homePage;
    private WomenProductPage womenProductPage;

    @Test
    public void viewCategoryProductsTest() throws InterruptedException {

        extentTest = extentReports.startTest("ViewCategoryProducts");

        homePage = new HomePage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated Home page");
        womenProductPage = new WomenProductPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated Women Product page");

        homePage.navigateToHomePage();
        extentTest.log(LogStatus.INFO, "Navigated to Home page");
        homePage.scrollDownToMakeWomenCategoryVisible();
        extentTest.log(LogStatus.INFO, "Scrolled down to Brand Header");
        homePage.verifyCategoriesVisibleLeft();
        extentTest.log(LogStatus.INFO, "Verified categories on the left side");
        homePage.clickOnWomenDropDown();
        extentTest.log(LogStatus.PASS, "Clicked on Women DropDown");
        womenProductPage.verifyWomenProductsHeader();
        extentTest.log(LogStatus.INFO, "Verified Women Products header");
        womenProductPage.clickCategoriesSideBarMen();
        extentTest.log(LogStatus.PASS, "Clicked on categories side bar men");
        womenProductPage.verifyMensProductHeader();
        extentTest.log(LogStatus.INFO, "Verified Men Products header");
    }
}
