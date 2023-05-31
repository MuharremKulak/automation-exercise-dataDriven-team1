package com.academy.techcenture.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage {
    @FindBy(xpath = "//div[@class='signup-form']/h2")
    public WebElement newUserSignUpHeader;
    @FindBy(xpath = "//div[@class='signup-form']//input[2]")
    public WebElement nameInputBox;
    @FindBy(xpath = "//div[@class='signup-form']//input[3]")
    public WebElement emailInputBox;
    @FindBy(xpath = "//button[@data-qa='signup-button']")
    public WebElement signUpButton;

}
