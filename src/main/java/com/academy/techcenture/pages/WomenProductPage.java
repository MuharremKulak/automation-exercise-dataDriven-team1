package com.academy.techcenture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class WomenProductPage {

    private WebDriver driver;

    public WomenProductPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy (xpath = "//h2[@class='title text-center']")
    public WebElement womenProductsHeader;
    @FindBy (xpath = "//a[@href='#Men']")
    public WebElement categorySidebarMens;
    @FindBy (xpath = "//a[@href='/category_products/3']")
    public WebElement menTShirtOption;
    @FindBy (xpath = "//h2[@class='title text-center']")
    public WebElement mensProductsHeader;


    public void verifyWomenProductsHeader(){
        Assert.assertTrue(womenProductsHeader.isDisplayed());
    }
    public void clickCategoriesSideBarMen() throws InterruptedException {
        categorySidebarMens.click();
        Thread.sleep(2000);
        menTShirtOption.click();
        Thread.sleep(2000);
    }
    public void verifyMensProductHeader(){
        Assert.assertTrue(mensProductsHeader.isDisplayed());
    }

}