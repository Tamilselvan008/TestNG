package com.exercise.framework.webcommons;

import com.exercise.framework.base.BasePage;
import com.exercise.framework.reports.Reports;
import com.exercise.framework.constants.Constants;
import com.exercise.framework.utilities.PropUtil;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public class WebCommons {
    // access the driver
    public WebDriver driver= BasePage.getDriver();
    public Properties prop = PropUtil.readData("Config.properties");

    public void launchApplication(){
        driver.get(prop.getProperty("APP_URL"));
    }

    // scroll to the element
    public void scrollElement(WebElement element){
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);",element);
    }
    // click to the element
    public void clickElement(WebElement element){
        scrollElement(element);
        element.click();
    }

    // find the hidden element
    public void hiddenElement(WebElement element){
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0],click();",element);
    }

    // double click to the element
    public void doubleClickElement(WebElement element){
        scrollElement(element);
        //        Actions action=new Actions(driver);
        //        action.doubleClick(element).perform();
        new Actions(driver).doubleClick(element).perform();
    }

    // right click to the element
    public void rightClickElement(WebElement element){
        scrollElement(element);
        new Actions(driver).contextClick(element).perform();
    }
    // hover to the element
    public void hoverElement(WebElement element){
        scrollElement(element);
        new Actions(driver).moveToElement(element).perform();
    }

    // TEXT
    //enter text
    public void enterText(WebElement element, String text){
        scrollElement(element);
        element.clear();
        element.sendKeys(text);
    }
    // Get Text
//    public void getTextElement(WebElement element){
//        scrollElement(element);
//        element.getText();
//    }
    //Enter text into the element using action class
    public void enterTextUsingActions(WebElement element, String text){
        scrollElement(element);
        new Actions(driver).sendKeys(element,text).perform();
    }

    //select check box and unselected if already selected
    public void checkBoxElement(WebElement checkbox,Boolean Status){
        scrollElement(checkbox);
        if (checkbox.isSelected()!=Status){
            checkbox.click();
        }
    }
    // select OPTION FROM DROPDOWN
    public void selectDropdownOption(WebElement dropdown1, String option, String selectBy) {
        scrollElement(dropdown1);
        Select select = new Select(dropdown1);
        switch (selectBy.toLowerCase()) {
            case "value":
                select.selectByValue(option);
                break;
            case "visible text":
                select.selectByVisibleText(option);
                break;
            case "index":
                select.selectByIndex(Integer.parseInt(option));
                break;
            default: throw new IllegalArgumentException("Invalid selection method: " + selectBy);
        }
    }

    // multi select dropdown
    public void selectMultipleDropdownOptions(WebElement dropdown2, String[] options, String selectBy) {
        scrollElement(dropdown2);
        Select select = new Select(dropdown2);
        for (String option : options) {
            switch (selectBy.toLowerCase()) {
                case "value":
                    select.selectByValue(option);
                    break;
                case "visible text":
                    select.selectByVisibleText(option);
                    break;
                case "index":
                    select.selectByIndex(Integer.parseInt(option));
                    break;
                default: throw new IllegalArgumentException("Invalid selection method: " + selectBy);
            }
        }
    }


    // wait for thread sleep method
    public void normalWait(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // implicit wait -wait given seconds than take the action
    public void implicitWait(long seconds){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

    // explicit wait-once found element do the action
    public void waitForElement(WebElement element){
        new WebDriverWait(driver,Duration.ofSeconds(Constants.WAIT_TIME))
                .until(ExpectedConditions.visibilityOf(element));

    }
    // Explicit for Locator
    public void waitForElement(By locator){
        new WebDriverWait(driver,Duration.ofSeconds(Constants.WAIT_TIME))
                .until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, 0));

    }
    // Screenshot Entire window
    public static String windowScreenshot(WebDriver driver, String fileName) throws IOException {
        String screenshotPath = System.getProperty("user.dir") + "\\Screenshots\\" + fileName + ".png";
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File(screenshotPath));
        return screenshotPath;
    }
    // Screenshot for particular window
    public static String elementScreenshot(WebElement element, String fileName) throws IOException {
        String screenshotPath = System.getProperty("user.dir") + "\\Screenshots\\" + fileName + ".png";
        File screenshotFile = element.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File(screenshotPath));
        return screenshotPath;
    }
    // switch to a frame
    public void switchToFrame(WebElement frameElement) {
        driver.switchTo().frame(frameElement);
    }

    // switch to frame using name or id
    public void switchToFrame(String frameNameOrId) {
        driver.switchTo().frame(frameNameOrId);
    }
    // pull out from the iframe ->back to the main page
    public  void defaultPage(){
        driver.switchTo().defaultContent();
    }

    // get page tittle
    public String getPageTitle() {
        return driver.getTitle();
    }
    //get page current URL
    public String getPageCurrentURL() {
        return driver.getCurrentUrl();
    }

    // refresh the page
    public void refreshBrowser() {
        driver.navigate().refresh();
    }

    // Specific wait for alert
    public void waitForAlert(long seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.alertIsPresent());
    }
    // Accept the alert
    public void acceptAlert() {
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("Alert text: " + alertText);
        alert.accept();
    }
    // Cancel the alert
    public void cancelAlert() {
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("Alert text: " + alertText);
        alert.dismiss();
    }
    //enter text into alert
    public void promptAlert(String text) {
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("Alert text: " + alertText);
        alert.sendKeys(text);
    }
    // file upload using send keys
    public void uploadFile(WebElement element, String filePath) {
        scrollElement(element);
        element.sendKeys(filePath);
    }

    // Switch to new tab
    public void switchNewTab() {
        String originalWindow = driver.getWindowHandle();
        List<String> allTabs = new ArrayList<>(driver.getWindowHandles());
        for (String tab : allTabs) {
            if (!tab.equals(originalWindow)) {
                driver.switchTo().window(tab);
                break;
            }
        }
    }

    // Switch back to Original window
    public void switchToHomeTab() {
        String originalWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(originalWindow)) {
                driver.switchTo().window(originalWindow);
                break;
            }
        }
    }

    // Method to print logs in the report.
    public void log(String status, String message) {
        if (status.equalsIgnoreCase("info")) {
            Reports.logger.info("INFO: " + message);
        } else if (status.equalsIgnoreCase("pass")) {
            Reports.logger.pass("PASS: " + message);
        } else if (status.equalsIgnoreCase("fail")) {
            Reports.logger.fail("FAIL: " + message);
        } else if (status.equalsIgnoreCase("warn")) {
            Reports.logger.warning("WARNING: " + message);
        } else {
            System.out.println("UNKNOWN STATUS: " + message);
        }
    }




}
