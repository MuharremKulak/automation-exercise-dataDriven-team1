package com.academy.techcenture.TestCase6;

import com.academy.techcenture.baseTest.BaseTest;
import com.academy.techcenture.pages.ContactUsPage;
import com.academy.techcenture.pages.HomePage;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;
import java.util.Map;

public class ContactUsFormTest extends BaseTest {

    private HomePage homePage;
    private ContactUsPage contactUsPage;


    @Test(dataProvider = "CustomerAccountInformation")
    public void ContactUsPageTest(Map<String, String> data) throws InterruptedException {

        extentTest = extentReports.startTest("ContactUsFormTest");

        homePage = new HomePage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new Home page");
        homePage.navigateToHomePage();
        extentTest.log(LogStatus.INFO, "Navigated Home Page Object");
        homePage.verifyHomePageTitle();
        extentTest.log(LogStatus.PASS, "Verified Title");
        homePage.clickOnContactUsButton();
        extentTest.log(LogStatus.INFO, "Clicked Contact Us Button");
        contactUsPage = new ContactUsPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new contact us page");
        contactUsPage.verifyGetInTouchHeader();
        extentTest.log(LogStatus.PASS, "Verified Get In Touch Header");
        contactUsPage = new ContactUsPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new contact us page");
        contactUsPage.enterNameForContactPage(data);
        extentTest.log(LogStatus.INFO, "Entered FirstName successfully");
        contactUsPage.enterEmailForContactPage(data);
        extentTest.log(LogStatus.INFO, "Entered Email successfully");
        contactUsPage.enterSubjectForContactPage();
        extentTest.log(LogStatus.INFO, "Entered subject successfully");
        contactUsPage.enterMessageForContactPage();
        extentTest.log(LogStatus.INFO, "Entered Message successfully");
        contactUsPage.uploadFileForContactPage();
        extentTest.log(LogStatus.INFO, "Uploaded file successfully");
        contactUsPage.clickOnSubmitButtonForContactPage();
        extentTest.log(LogStatus.INFO, "Clicked Submit Button");
        contactUsPage.clickOkButton();
        extentTest.log(LogStatus.INFO, "Clicked Ok Button");
        contactUsPage.verifySuccessMessage();
        extentTest.log(LogStatus.PASS, "Verified success message Header");
        contactUsPage.clickHomeButtonToNavigateHomePage();
        extentTest.log(LogStatus.INFO, "Clicked home Button");
    }

}
