package com.exercise.application.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ApplicationTest extends BaseTest{

    @Test(priority = 1)
    @Parameters({"username","password"})
    public void verifyLoginPage(String username,String password){
        LoginPages.launchTheApplication();
        LoginPages.loginCredential(username, password);
        LoginPages.clickLoginButton();
        LoginPages.clickLogoutButton();

    }
    @Test(priority = 2)
    public void verifyHomePageWomenCategory(){
        HomePages.launchApplication();
        HomePages.verifyWomenCategory();
    }


}
