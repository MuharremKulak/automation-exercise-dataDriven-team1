package com.academy.techcenture.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class AllProductPage {

    private WebDriver driver;

    public AllProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//div[@class='features_items']/h2")
    protected WebElement allProductsHeader;
    @FindBy(xpath = "//a[@href='/product_details/1']")
    protected WebElement viewProductButtonForFirstProduct;
    @FindBy(id = "search_product")
    protected WebElement searchProductInbox;
    @FindBy(id = "submit_search")
    protected WebElement searchButton;
    @FindBy(xpath = "//div[@class='features_items']/h2")
    protected WebElement searchedProductsHeader;
    @FindBy(xpath = "//div[@class='productinfo text-center']")
    protected WebElement productInfoAfterSearched;
    @FindBy(xpath = "//button[@class='btn btn-success close-modal btn-block']")
    protected WebElement continueShoppingButton;
    @FindBy(xpath = "(//a[@href='/view_cart'])[2]")
    protected WebElement viewCartButton;
    @FindBy(id = "product-1")
    protected WebElement product1ForVerification;
    @FindBy(id = "product-2")
    protected WebElement product2ForVerification;
    @FindBy(xpath = "(//td[@class='cart_quantity']/button)[1]")
    protected WebElement firstProductQuantity;
    @FindBy(xpath = "(//td[@class='cart_quantity']/button)[2]")
    protected WebElement secondProductQuantity;
    @FindBy(xpath = "(//td[@class='cart_price'])[1]/p")
    protected WebElement firstProductPrice;
    @FindBy(xpath = "(//td[@class='cart_price'])[2]/p")
    protected WebElement secondProductPrice;
    @FindBy(xpath = "(//td[@class='cart_total'])[1]/p")
    protected WebElement totalPriceForFirstProduct;
    @FindBy(xpath = "(//td[@class='cart_total'])[2]/p")
    protected WebElement totalPriceForSecondProduct;
    @FindBy(xpath = "(//div[@class='features_items']/div[@class='col-sm-4'])[1]")
    protected WebElement firstSoftStretchJeans;
    @FindBy(xpath = "(//div[@class='features_items']/div[@class='col-sm-4'])[1]")
    protected WebElement secondRegularFitStraightJeans;
    @FindBy(xpath = "(//div[@class='features_items']/div[@class='col-sm-4'])[1]")
    protected WebElement thirdGruntBlueSlimFitJeans;
    @FindBy(xpath = "(//a[@href='/login'])[1]")
    protected WebElement signUpLoginButton;


    public void verifyAllProductPageHeader() {
        Assert.assertTrue(allProductsHeader.isDisplayed());
    }

    public void verifyProductsListIsVisible() {
        List<WebElement> productLists = driver.findElements(By.xpath("//div[@class='features_items']/div"));
        for (int i = 1; i < productLists.size(); i++) {
            Assert.assertTrue(productLists.get(i).isDisplayed());
        }
    }

    public void clickOnFirstProductViewButton() {
        viewProductButtonForFirstProduct.click();
    }

    public void searchProductAndClickSearchButton() {
        searchProductInbox.sendKeys("Jeans");
        searchButton.click();
    }

    public void verifySearchedProductIsVisible() {
        Assert.assertTrue(searchedProductsHeader.isDisplayed());
    }

    public void verifyProductsAfterSearched() {
        Assert.assertTrue(productInfoAfterSearched.isDisplayed());
    }

    public void hoverOverFirstProductAndClickAddToCart() throws InterruptedException {
        // 5. Hover over the first product and click 'Add to cart'
        WebElement firstProduct = driver.findElement(By.xpath("(//div[@class='single-products']/div)[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(firstProduct).perform();
        WebElement addToCartButton = driver.findElement(By.xpath("(//a[@data-product-id='1'])[1]"));
        addToCartButton.click();
        Thread.sleep(2000);
    }

    public void clickOnContinueShoppingButton() throws InterruptedException {
        continueShoppingButton.click();
        Thread.sleep(2000);
    }

    public void hoverOverSecondProductAndClickAddToCart() throws InterruptedException {
        // 5. Hover over the second product and click 'Add to cart'
        WebElement secondProduct = driver.findElement(By.xpath("(//div[@class='single-products'])[2]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(secondProduct).perform();
        WebElement addToCartButton = driver.findElement(By.xpath("(//a[@data-product-id='2'])[1]"));
        addToCartButton.click();
        Thread.sleep(3000);
    }

    public void clickOnViewCartButton() throws InterruptedException {
        viewCartButton.click();
        Thread.sleep(2000);
    }

    public void verifyBothProductsAddedToCart() {
        Assert.assertTrue(product1ForVerification.isDisplayed());
        Assert.assertTrue(product2ForVerification.isDisplayed());
    }


    public void verifyProductsPrice() {
        String actualPriceForFirstProduct = firstProductPrice.getText();
        String expectedPrice = "Rs. 500";
        Assert.assertEquals(actualPriceForFirstProduct, expectedPrice);
        String actualPriceForSecondProduct = secondProductPrice.getText();
        String expectedPrice2 = "Rs. 400";
        Assert.assertEquals(actualPriceForSecondProduct, expectedPrice2);
    }

    public void verifyProductsQuantity() {
        String firstProductQuantityActual = firstProductQuantity.getText();
        String expectedQuantity = "1";
        Assert.assertEquals(firstProductQuantityActual, expectedQuantity);
        String secondProductQuantityActual = secondProductQuantity.getText();
        String expectedQuantity2 = "1";
        Assert.assertEquals(secondProductQuantityActual, expectedQuantity2);
    }

    public void verifyProductsTotalPrice() {
        String actualTotalPrice = totalPriceForFirstProduct.getText();
        String expectedTotalPrice = "Rs. 500";
        Assert.assertEquals(actualTotalPrice,expectedTotalPrice);
        String actualTotalPrice2 = totalPriceForSecondProduct.getText();
        String expectedTotalPrice2 = "Rs. 400";
        Assert.assertEquals(actualTotalPrice2,expectedTotalPrice2);
    }

    public void verifyAllProductsAfterSearchJeans(){
        Assert.assertTrue(firstSoftStretchJeans.isDisplayed());
        Assert.assertTrue(secondRegularFitStraightJeans.isDisplayed());
        Assert.assertTrue(thirdGruntBlueSlimFitJeans.isDisplayed());
    }

    public void hoverFirstProductAndClickAddToCart() throws InterruptedException {
        // Test 20 Step 8.
        WebElement firstProduct = driver.findElement(By.xpath("(//div[@class='single-products']/div)[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(firstProduct).perform();
        WebElement addToCartButton = driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'])[1]"));
        addToCartButton.click();
        Thread.sleep(3000);
    }


    public void hoverSecondProductAndClickAddToCart() throws InterruptedException {
        //  Test 20 Step 8.
        WebElement secondProduct = driver.findElement(By.xpath("(//div[@class='single-products'])[2]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(secondProduct).perform();
        WebElement addToCartButton = driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'])[3]"));
        addToCartButton.click();
        Thread.sleep(3000);
    }

    public void hoverThirdProductAndClickAddToCart() throws InterruptedException {
        //  Test 20 Step 8.
        WebElement secondProduct = driver.findElement(By.xpath("(//div[@class='single-products'])[3]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(secondProduct).perform();
        WebElement addToCartButton = driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'])[5]"));
        addToCartButton.click();
        Thread.sleep(3000);
    }

    public void verifyAllProductBeforeLogin(){
        List<WebElement> allProductsJeanSorted = driver.findElements(By.xpath("//table[@id='cart_info_table']/tbody/tr"));
        for (int i=0; i<allProductsJeanSorted.size(); i++){
            Assert.assertTrue(allProductsJeanSorted.get(i).isDisplayed());
        }
    }

    public void clickSignupLoginButton(){
        signUpLoginButton.click();
    }





}