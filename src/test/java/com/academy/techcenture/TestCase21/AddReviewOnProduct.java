package com.academy.techcenture.TestCase21;

import com.academy.techcenture.baseTest.BaseTest;
import com.academy.techcenture.pages.AddReviewOnProductPage;
import com.academy.techcenture.pages.HomePage;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.util.Map;

public class AddReviewOnProduct extends BaseTest {

    private HomePage homePage;
    private AddReviewOnProductPage addReviewOnProductPage;

    @Test(dataProvider = "CustomerAccountInformation")
    public void addReviewOnProductPageTest(Map<String, String> data) throws InterruptedException {

        extentTest = extentReports.startTest("addReviewOnProductPage");

        homePage = new HomePage(driver);
        addReviewOnProductPage = new AddReviewOnProductPage(driver);

        homePage.navigateToHomePage();
        extentTest.log(LogStatus.INFO,"Navigated Home Page");
        addReviewOnProductPage.clickOnProductPage();
        extentTest.log(LogStatus.PASS, "Clicked on Product Page Button");
        addReviewOnProductPage.verifyProductPageVisible();
        extentTest.log(LogStatus.INFO,"Product Page is verified!");
        addReviewOnProductPage.clickOnViewProduct();
        extentTest.log(LogStatus.PASS, "Clicked on View Product");
        addReviewOnProductPage.scrollAllTheWayDownToPage();
        extentTest.log(LogStatus.INFO,"Scrolled all the way down!");
        addReviewOnProductPage.verifyWriteYourReview();
        extentTest.log(LogStatus.INFO,"Write Your Review is verified!");
        addReviewOnProductPage.enterName(data);
        extentTest.log(LogStatus.INFO,"Your name is entered successfully!");
        addReviewOnProductPage.enterEmail(data);
        extentTest.log(LogStatus.INFO,"Your email is entered successfully!");
        addReviewOnProductPage.enterReview();
        extentTest.log(LogStatus.INFO,"Your review has been entered!");
        addReviewOnProductPage.clickSubmitButton();
        extentTest.log(LogStatus.PASS,"Your review has been submitted!");
        addReviewOnProductPage.verifySuccessMessage();
        extentTest.log(LogStatus.INFO,"Your review is successful! Thank you message displayed!");
    }

}