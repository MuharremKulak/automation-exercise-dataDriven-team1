package com.academy.techcenture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class TestCasesPage {

    private WebDriver driver;

    public TestCasesPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//h2[@class='title text-center']/b")
    protected WebElement testCasesHeader;


    public void verifyTestCasesPage(){
        String actualHeader = testCasesHeader.getText();
        String expectedHeader = "TEST CASES";
        Assert.assertEquals(actualHeader,expectedHeader);
    }



}
