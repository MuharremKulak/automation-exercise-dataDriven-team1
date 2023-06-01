package com.academy.techcenture.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class AllProductPage {

    private WebDriver driver;

    public AllProductPage(WebDriver driver){
        this.driver=driver;
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


    public void verifyAllProductPageHeader(){
        Assert.assertTrue(allProductsHeader.isDisplayed());
    }

    public void verifyProductsListIsVisible(){
        List<WebElement> productLists = driver.findElements(By.xpath("//div[@class='features_items']/div"));
        for(int i=1; i<productLists.size(); i++){
            Assert.assertTrue(productLists.get(i).isDisplayed());
        }
    }

    public void clickOnFirstProductViewButton(){
        viewProductButtonForFirstProduct.click();
    }

    public void searchProductAndClickSearchButton(){
        searchProductInbox.sendKeys("Blue Top");
        searchButton.click();
    }

    public void verifySearchedProductIsVisible(){
        Assert.assertTrue(searchedProductsHeader.isDisplayed());
    }

    public void verifyProductsAfterSearched(){
        Assert.assertTrue(productInfoAfterSearched.isDisplayed());
    }

}
