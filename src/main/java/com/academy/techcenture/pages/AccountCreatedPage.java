package com.academy.techcenture.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountCreatedPage {
    @FindBy (xpath = "//div[@class='col-sm-9 col-sm-offset-1']//b")
    public WebElement accountCreatedConfirmHeader;
    @FindBy (xpath = "//a[@class='btn btn-primary']")
    public WebElement continueButton;

}
