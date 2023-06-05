package com.academy.techcenture.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class ProductDetailPage {

    private WebDriver driver;

    public ProductDetailPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//div[@class='product-information']/h2")
    protected WebElement productName;
    @FindBy(xpath = "//div[@class='product-information']/p[1]")
    protected WebElement productCategory;
    @FindBy(xpath = "//div[@class='product-information']/span/span")
    protected WebElement productPrice;
    @FindBy(xpath = "//div[@class='product-information']/p[2]/b")
    protected WebElement productAvailability;
    @FindBy(xpath = "//div[@class='product-information']/p[3]/b")
    protected WebElement productCondition;
    @FindBy(xpath = "//div[@class='product-information']/p[4]/b")
    protected WebElement productBrand;
    @FindBy(id = "quantity")
    protected WebElement quantityInput;
    @FindBy(xpath = "//div[@class='product-information']/span/button")
    protected WebElement addToCartInProductDetailsPage;
    @FindBy(xpath = "(//a[@href='/view_cart'])[2]")
    protected WebElement viewCartButton;
    @FindBy(xpath = "//td[@class='cart_quantity']")
    protected WebElement quantityOfProduct;
    @FindBy(xpath = "//a[@href='/brand_products/Polo']")
    protected WebElement poloBrandOption;
    @FindBy(xpath = "//h2[@class='title text-center']")
    protected WebElement poloBrandHeader;
    @FindBy(xpath = "//div[@class='brands_products']")
    protected WebElement welElementForScrollDown;
    @FindBy(xpath = "//a[@href='/brand_products/H&M']")
    protected WebElement HMBrand;
    @FindBy(xpath = "//h2[@class='title text-center']")
    protected WebElement HMBrandHeader;


    public void verifyProductDetailsPage(){
        String actualTitle = driver.getTitle();
        String expectedTitle = "Automation Exercise - Product Details";
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    public void verifyProductDetailsIsVisible(){
        Assert.assertTrue(productName.isDisplayed());
        Assert.assertTrue(productCategory.isDisplayed());
        Assert.assertTrue(productPrice.isDisplayed());
        Assert.assertTrue(productAvailability.isDisplayed());
        Assert.assertTrue(productCondition.isDisplayed());
        Assert.assertTrue(productBrand.isDisplayed());
    }

    public void enterQuantity() throws InterruptedException {
        quantityInput.clear();
        Thread.sleep(2000);
        quantityInput.sendKeys("4");
        Thread.sleep(2000);
    }

    public void clickAddToCartButton(){
        addToCartInProductDetailsPage.click();
    }

    public void clickOnViewCartButton(){
        viewCartButton.click();
    }

    public void verifyProductQuantityIsDisplayed(){
        Assert.assertTrue(quantityOfProduct.isDisplayed());
    }

    public void scrollDownToBrandList() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(2000);
        js.executeScript("arguments[0].scrollIntoView(true);", welElementForScrollDown);
        Thread.sleep(2000);
    }
    public void verifyBrandsAreVisible(){
        List<WebElement> brands = driver.findElements(By.xpath("//div[@class='brands-name']/ul/li"));
        for (int i=0; i<brands.size(); i++){
            Assert.assertTrue(brands.get(i).isDisplayed());
        }
    }
    public void selectPoloBrand(){
        poloBrandOption.click();
    }
    public void verifyPoloHeader(){
        Assert.assertTrue(poloBrandHeader.isDisplayed());
    }

    public void clickOnHMBrand(){
        HMBrand.click();
    }

    public void verifyHMHeader(){
        String actualHMHeader = HMBrandHeader.getText();
        String expectedHMHeader = "BRAND - H&M PRODUCTS";
        Assert.assertEquals(actualHMHeader,expectedHMHeader);
    }
}
