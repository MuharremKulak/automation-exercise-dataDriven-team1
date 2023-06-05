package com.academy.techcenture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ShoppingCartPage {

    private WebDriver driver;

    public ShoppingCartPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//ol[@class='breadcrumb']/li[2]")
    protected WebElement shoppingCartHeader;
    @FindBy(xpath = "//a[@class='btn btn-default check_out']")
    protected WebElement proceedToCheckoutButton;
    @FindBy(xpath = "(//a[@href='/login'])[2]")
    protected WebElement registerLoginButton;
    @FindBy (linkText = "View Cart")
    protected WebElement viewCartBtn;
    @FindBy (xpath = "//a[@class='cart_quantity_delete']")
    protected WebElement removeItemFromCartBtn;
    @FindBy (xpath = "//b[text()='Cart is empty!']")
    protected WebElement cartIsEmptyMsg;


    public void verifyCartPage(){
        String actualText = shoppingCartHeader.getText();
        String expectedText = "Shopping Cart";
        Assert.assertEquals(actualText, expectedText);
    }

    public void clickProceedToCheckoutButton(){
        proceedToCheckoutButton.click();
    }

    public void clickOnRegisterLoginButton(){
        registerLoginButton.click();
    }

    public void clickViewCart(){
        viewCartBtn.click();
    }

    public void clickRemoveItemFromTheCart(){
        removeItemFromCartBtn.click();
    }

    public void verifyCartIsEmptyMsgIsDisplayed(){
        cartIsEmptyMsg.isDisplayed();
    }

}
