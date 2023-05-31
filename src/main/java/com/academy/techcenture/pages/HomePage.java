package com.academy.techcenture.pages;

import com.academy.techcenture.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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







}
