package com.exercise.application.steps;

import com.exercise.application.elements.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginSteps extends LoginPage {

    // Constructor to initialize the elements on the page
    public LoginSteps(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    // Launch the application
    public  void launchTheApplication(){
        launchApplication();
        Assert.assertEquals(getPageTitle(),prop.getProperty("APP_HOMEPAGE_TITLE"));
        log("pass", "Application launched successfully");
    }

    // Verify The Login Scenario
    public void loginCredential(String username,String password){
        waitForElement(signUpTab);
        clickElement(signUpTab);

        waitForElement(LoginEmail);
        clickElement(LoginEmail);
        enterText(LoginEmail,"puratamilan17@gmail.com");
        log("info", "Username entered: " + username);

        waitForElement(LoginPassword);
        clickElement(LoginPassword);
        enterText(LoginPassword,"Tamil@2025");
        log("info", "Password entered: " + password);

    }
    // click Login button
    public void clickLoginButton(){
        waitForElement(loginButton);
        clickElement(loginButton);
        log("info", "Login button clicked");
    }

    // click Logout button
    public void clickLogoutButton(){
        waitForElement(logOut);
        clickElement(logOut);
        log("info", "Logouts button clicked");
    }



}
