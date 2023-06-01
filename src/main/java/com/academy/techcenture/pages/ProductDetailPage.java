package com.academy.techcenture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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


}
