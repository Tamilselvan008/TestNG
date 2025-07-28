package com.exercise.application.tests;

import com.exercise.application.steps.HomeSteps;
import com.exercise.application.steps.LoginSteps;
import com.exercise.framework.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;


public class BaseTest extends BasePage {

    public LoginSteps LoginPages;
    public HomeSteps HomePages;

    @BeforeMethod(alwaysRun = true,dependsOnMethods = "launchBrowser")
    public void initializePages(){
        WebDriver driver=BasePage.getDriver();
        LoginPages=new LoginSteps(driver);
        HomePages=new HomeSteps(driver);
    }

}
