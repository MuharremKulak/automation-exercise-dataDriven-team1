package com.academy.techcenture.pages;

import com.academy.techcenture.utils.ConfigReader;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//a[@href='/login']")
    public WebElement signUpLoginButton;
    @FindBy(xpath = "//a[@href='/delete_account']")
    public WebElement deleteAccountButton;
    @FindBy(xpath = "//div[@class='shop-menu pull-right']//li[10]/a")
    public WebElement loggedInAsUsername;
    @FindBy(xpath = "//a[@href='/contact_us']")
    protected WebElement contactUsButton;
    @FindBy(xpath = "//a[@href='/test_cases']/i")
    protected WebElement testCasesButton;
    @FindBy(xpath = "//a[@href='/products']")
    protected WebElement productsButton;
    @FindBy(id = "susbscribe_email")
    protected WebElement emailInputForSubs;
    @FindBy(xpath = "//a[@href='/product_details/2']")
    protected WebElement secondProductViewProductButton;
    @FindBy(xpath = "(//a[@href='/view_cart'])[1]")
    protected WebElement cartButton;
    @FindBy(xpath = "//a[@href='#Women']")
    protected WebElement womenCategoryOption;
    @FindBy(xpath = "//div[@class='left-sidebar']")
    protected WebElement leftCategorySidebar;
    @FindBy(xpath = "//a[@href='/category_products/1']")
    protected WebElement womenDressOption;
    @FindBy(xpath = "//div[@class='single-widget']/h2")
    protected WebElement subscriptionHeader;
    @FindBy(xpath = "//div[@class='recommended_items']")
    protected WebElement recommendedItems;
    @FindBy(xpath = "//div[@class='recommended_items'][1]//div[@class='item active']/div[1]//a")
    protected WebElement recommendedItemsAddToCart;
    @FindBy(xpath = "//div[@class='modal-content']//a")
    protected WebElement viewCartButton;
    @FindBy(xpath = "//a[@href='/product_details/4']")
    protected WebElement productNameInCart;
    @FindBy (xpath = "//h2[text()='Subscription']")
    protected WebElement subscriptionHeaderButtomHomePage;
    @FindBy (xpath = "//a[@id='scrollUp']")
    protected WebElement scrollUpArrow;
    @FindBy (xpath = "//h2[text()='Full-Fledged practice website for Automation Engineers']")
    protected WebElement fullFledgedPracticeText2;



    public void navigateToHomePage(){
        driver.get(ConfigReader.getProperty("url"));
    }

    public void verifyHomePageTitle(){
        String homePageTitle = driver.getTitle();
        String expectedTitle = "Automation Exercise";
        Assert.assertEquals(homePageTitle, expectedTitle);
    }

    public void clickOnSignUpLoginButton(){
        signUpLoginButton.click();
    }

    public void clickOnContactUsButton(){
        contactUsButton.click();
    }

    public void clickOnTestCasesButton(){
        testCasesButton.click();
    }

    public void clickProductsButton(){
        productsButton.click();
    }

    public void loggedInAsUsername(){
        Assert.assertTrue(loggedInAsUsername.isDisplayed());
    }
    public void deleteAccountButton(){
        deleteAccountButton.click();
    }

    public void scrollDownToSubscription() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(2000);
        js.executeScript("arguments[0].scrollIntoView(true);", emailInputForSubs);
        Thread.sleep(2000);
    }

    public void clickViewProductForAnyProduct(){
        secondProductViewProductButton.click();
    }

    public void clickOnCartButton() throws InterruptedException {
        cartButton.click();
        Thread.sleep(2000);
    }

    public void scrollDownToMakeWomenCategoryVisible() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(2000);
        js.executeScript("arguments[0].scrollIntoView(true);", womenCategoryOption);
        Thread.sleep(2000);
    }
    public void verifyCategoriesVisibleLeft(){
        Assert.assertTrue(leftCategorySidebar.isDisplayed());
    }
    public void clickOnWomenDropDown() throws InterruptedException {
        womenCategoryOption.click();
        Thread.sleep(2000);
        womenDressOption.click();
        Thread.sleep(2000);
    }

    public void verifySubscriptionHeader(){
        String actualHeader = subscriptionHeader.getText();
        String expectedHeader = ConfigReader.getProperty("subscriptionHeader");
        Assert.assertEquals(actualHeader,expectedHeader);
    }

    public void scrollUpToTheTopOfPage() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0)");
        Thread.sleep(3000);
    }


    public void scrollDownToRecommendedItemsSection() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(2000);
        js.executeScript("arguments[0].scrollIntoView(true);", recommendedItems);
        Thread.sleep(2000);
    }

    public void verifyRecommenededItems(){
        Assert.assertTrue(recommendedItems.isDisplayed());
    }

    public void addRecomendedItemsToCart() throws InterruptedException {
        recommendedItemsAddToCart.click();
    }

    public void viewCart(){
        viewCartButton.click();
    }

    public void verifyProductAdded(){
        Assert.assertEquals(productNameInCart.getText(), "Stylish Dress");
    }

    public void verifySubscriptionTextIsVisible(){
        Assert.assertTrue(subscriptionHeaderButtomHomePage.isDisplayed());
    }

    public void clickOnScrollUpArrow() throws InterruptedException {
        scrollUpArrow.click();
        Thread.sleep(3000);
    }

    public void verifyFullFledgedPracticeTextIsVisible() {
        WebElement element = driver.findElement(By.xpath("(//div[@class='col-sm-6']/h2)[2]"));
        String sentence = element.getText();
        Assert.assertEquals(sentence, ConfigReader.getProperty("activeText"), "The sentence does not match");
    }

}
