package com.exercise.application.steps;

import com.exercise.application.elements.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomeSteps extends HomePage {

    // Constructor to initialize the elements on the page
    public HomeSteps(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void verifyWomenCategory(){
         waitForElement(womenList);
         scrollElement(womenList);
         clickElement(womenList);

         waitForElement(dressLink);
         clickElement(dressLink);
         //String actualPageUrl= driver.getCurrentUrl();
         Assert.assertEquals(getPageCurrentURL(),prop.getProperty("Home_Women_Dress_Current_Url"));
        // String actualPageTitle= driver.getTitle();
         Assert.assertEquals(getPageTitle(),prop.getProperty("Home_Dress_page_title"));
         String actualDressSubContent=dressPageTitle.getText();
         Assert.assertEquals(actualDressSubContent,prop.getProperty("Home_Women_Dress_Title"));
    }





}
