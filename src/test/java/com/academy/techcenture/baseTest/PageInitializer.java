package com.academy.techcenture.baseTest;

import com.academy.techcenture.pages.*;

public class PageInitializer extends BaseTest{
    public static AccountCreatedPage accountCreatedPage;
    public static AccountDeletedPage accountDeletedPage;
    public static EnterAccountInformationPage enterAccountInformationPage;
    public static HomePage homePage;
    public static LoginPage loginPage;
    public static SubscriptionPage subscriptionPage;

    public static void initialize(){
        accountCreatedPage = new AccountCreatedPage();
        accountDeletedPage = new AccountDeletedPage();
        enterAccountInformationPage = new EnterAccountInformationPage();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        subscriptionPage = new SubscriptionPage();
    }

}
