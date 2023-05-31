package com.academy.techcenture.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountDeletedPage {
    @FindBy (xpath = "//h2[@class='title text-center']//b")
    public WebElement accountDeletedHeader;
    @FindBy (xpath = "//a[@data-qa='continue-button']")
    public WebElement continueButton;

}
