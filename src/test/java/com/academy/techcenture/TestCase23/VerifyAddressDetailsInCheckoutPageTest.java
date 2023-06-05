package com.academy.techcenture.TestCase23;

import com.academy.techcenture.baseTest.BaseTest;
import com.academy.techcenture.pages.*;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;
import java.util.Map;

public class VerifyAddressDetailsInCheckoutPageTest extends BaseTest {

    private HomePage homePage;
    private AllProductPage allProductPage;
    private LoginPage loginPage;
    private EnterAccountInformationPage enterAccountInformationPage;
    private AccountCreatedPage accountCreatedPage;
    private ShoppingCartPage shoppingCartPage;
    private PlaceOrderPage placeOrderPage;
    private CheckoutPage checkoutPage;
    private AccountDeletedPage accountDeletedPage;


    @Test(dataProvider = "CustomerAccountInformation")
    public void VerifyAddressDetailsInCheckoutPagePositiveTest(Map<String, String> data) throws InterruptedException {

        extentTest = extentReports.startTest("VerifyAddressDetailsInCheckoutPageTest");

        homePage = new HomePage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new Home page");
        allProductPage = new AllProductPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated all product page");
        loginPage = new LoginPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated all login page");
        enterAccountInformationPage = new EnterAccountInformationPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated Enter Account Information page");
        accountCreatedPage = new AccountCreatedPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated Account Created page");
        shoppingCartPage = new ShoppingCartPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated shopping cart page");
        placeOrderPage = new PlaceOrderPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated place order page");
        checkoutPage = new CheckoutPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated checkout page");
        accountDeletedPage = new AccountDeletedPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated Account deleted page");

        homePage.navigateToHomePage();
        extentTest.log(LogStatus.INFO, "Navigated Home Page Object");
        homePage.verifyHomePageTitle();
        extentTest.log(LogStatus.INFO, "Verified Home Page Title");
        homePage.clickOnSignUpLoginButton();
        extentTest.log(LogStatus.PASS, "Clicked on Signup/Login button");
        loginPage.enterNameForSignUp(data);
        extentTest.log(LogStatus.PASS, "Entered name for signUp");
        loginPage.enterEmailForSignUp(data);
        extentTest.log(LogStatus.PASS, "Entered email for signUp");
        loginPage.clickOnSignUpButton();
        extentTest.log(LogStatus.PASS, "Clicked on signUp button");
        enterAccountInformationPage.mrOrMrsRadioButton(data);
        extentTest.log(LogStatus.PASS, "Chosen gender");
        enterAccountInformationPage.fillAccountDetails(data);
        extentTest.log(LogStatus.PASS, "Entered user account details");
        enterAccountInformationPage.selectNewsletterOffers();
        extentTest.log(LogStatus.PASS, "Selected newspaper letters offer");
        enterAccountInformationPage.fillAddressDetails(data);
        extentTest.log(LogStatus.PASS, "Entered address details");
        enterAccountInformationPage.clickCreateAccountButton();
        extentTest.log(LogStatus.PASS, "Clicked on create account button");
        accountCreatedPage.accountCreatedConfirmHeader();
        extentTest.log(LogStatus.INFO, "Verified user created account");
        accountCreatedPage.clickContinueButton();
        extentTest.log(LogStatus.PASS, "Clicked on continue button");
        loginPage.verifyLoginAsUsername();
        extentTest.log(LogStatus.INFO, "Verified user login as username");
        allProductPage.hoverOverFirstProductAndClickAddToCart();
        extentTest.log(LogStatus.PASS, "Hover first product and added to cart");
        allProductPage.clickOnContinueShoppingButton();
        extentTest.log(LogStatus.PASS, "Clicked on continue shopping button");
        allProductPage.hoverOverSecondProductAndClickAddToCart();
        extentTest.log(LogStatus.PASS, "Hover second product and added to cart");
        allProductPage.clickOnViewCartButton();
        extentTest.log(LogStatus.PASS, "Clicked on view cart button");
        shoppingCartPage.verifyCartPage();
        extentTest.log(LogStatus.INFO, "Verified user navigated to cart page");
        shoppingCartPage.clickProceedToCheckoutButton();
        extentTest.log(LogStatus.PASS, "Clicked on proceed to checkout button");
        placeOrderPage.verifyDeliveryAddressToOriginalInput(data);
        extentTest.log(LogStatus.INFO, "Verified Delivery Address to original data input");
        checkoutPage.verifyBillingAddressWithRegisterInput(data);
        extentTest.log(LogStatus.INFO, "Verified Billing Address with register input");
        checkoutPage.clickOnDeleteAccountButton();
        extentTest.log(LogStatus.PASS, "Clicked on delete account button");
        accountDeletedPage.verifyAccountDeletedHeader();
        extentTest.log(LogStatus.INFO, "Verified Account Deleted Header");
        accountDeletedPage.clickContinueButton();
        extentTest.log(LogStatus.PASS, "Clicked on continue button");
    }
}