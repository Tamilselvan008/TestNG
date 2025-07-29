package com.exercise.framework.base;

import com.exercise.framework.reports.Reports;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BasePage extends Reports {
// instead of get driver() we use @getter because of lombok
        @Getter
        private static WebDriver driver = null;


    // Common method for browser Launching
        @BeforeMethod(alwaysRun = true)
        @Parameters({"BROWSER"})
        public void launchBrowser(String browserName) {
            if (browserName.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
            } else if (browserName.equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();
            } else if (browserName.equalsIgnoreCase("edge")) {
                driver = new EdgeDriver();
            } else {
                System.out.println("The Browser is not supported: " + browserName);
            }
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
        }

        // common method for close browser
        @AfterMethod(alwaysRun = true)
        public void tearDownBrowser() {
            try {
                Thread.sleep(2000);
                if (driver != null) {
                    Thread.sleep(2000);
                    driver.quit();
                }
            } catch (Exception ignored){
                System.err.println("Error while quitting driver: "+ignored.getMessage());

            }
        }
// common method related to getting the driver instance
// purpose-used to get the driver instance in other classes

// common method related to setting the driver instance
// purpose-used to set the driver instance in other classes



    }
