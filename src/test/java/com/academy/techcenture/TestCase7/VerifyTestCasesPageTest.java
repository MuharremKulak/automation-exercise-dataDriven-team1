package com.academy.techcenture.TestCase7;

import com.academy.techcenture.baseTest.BaseTest;
import com.academy.techcenture.pages.ContactUsPage;
import com.academy.techcenture.pages.HomePage;
import com.academy.techcenture.pages.TestCasesPage;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.util.Map;

public class VerifyTestCasesPageTest extends BaseTest {

    private HomePage homePage;
    private TestCasesPage testCasesPage;


    @Test
    public void VerifyTestCasesPageTest() {

        extentTest = extentReports.startTest("VerifyTestCasesPageTest");

        homePage = new HomePage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new Home page");
        homePage.navigateToHomePage();
        extentTest.log(LogStatus.INFO, "Navigated Home Page Object");
        homePage.verifyHomePageTitle();
        extentTest.log(LogStatus.PASS, "Verified Title");
        homePage.clickOnTestCasesButton();
        extentTest.log(LogStatus.INFO, "Clicked Test Cases button");
        testCasesPage = new TestCasesPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new Test Cases page");
        testCasesPage.verifyTestCasesPage();
        extentTest.log(LogStatus.PASS, "Verified Test Cases Page Header");

    }
}