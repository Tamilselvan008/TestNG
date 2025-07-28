package com.exercise.application.elements;

import com.exercise.framework.webcommons.WebCommons;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends WebCommons {

    @FindBy(xpath = "//a[@href='#Women']")
    protected WebElement womenList;

    @FindBy(xpath = "//div[@class='panel-body']//li//a[@href='/category_products/1']")
    protected WebElement dressLink;

    @FindBy(xpath = "//h2[@class='title text-center']")
    protected WebElement dressPageTitle;

    @FindBy(xpath = "//div[@class='panel-body']//li//a[@href='/category_products/2']")
    protected WebElement topLink;

    @FindBy(xpath = "//div[@class='panel-body']//li//a[@href='/category_products/7']")
    protected WebElement sareeLink;


}
