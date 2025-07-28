package com.exercise.application.elements;

import com.exercise.framework.webcommons.WebCommons;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends WebCommons {
    @FindBy(xpath = "//a[text()=' Signup / Login']")
    protected WebElement signUpTab;

    @FindBy(xpath = "//h2[text()='Login to your account']")
    protected WebElement loginHead;

    @FindBy(xpath = "//div[@class='login-form']//input[@placeholder='Email Address']")
    protected WebElement LoginEmail;

    @FindBy(xpath = "//div[@class='login-form']//input[@placeholder='Password']")
    protected WebElement LoginPassword;

    @FindBy(xpath = "//div[@class='login-form']//button[@type='submit']")
    protected WebElement loginButton;

    @FindBy(xpath = "//a[text()=' Logout']")
    protected WebElement logOut;

}
