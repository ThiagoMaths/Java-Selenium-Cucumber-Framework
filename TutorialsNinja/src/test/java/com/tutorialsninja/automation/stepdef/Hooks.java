package com.tutorialsninja.automation.stepdef;

import com.tutorialsninja.automation.base.Base;
import com.tutorialsninja.automation.config.PropertyFileReader;
import com.tutorialsninja.automation.framework.Browser;

import com.tutorialsninja.automation.framework.DriverManager;
import com.tutorialsninja.automation.utils.SQLiteHandler;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hooks {
    private static Logger log = LoggerFactory.getLogger(Hooks.class);

    @Before
    public void setUp(Scenario scenario) {

        log.info("Scenario Started: {}", scenario.getName());
        Base.reader = new PropertyFileReader();
        String browser = Base.reader.getBrowser();
        WebDriver driver = Browser.startBrowser(browser);
        DriverManager.setDriver(driver);
        DriverManager.getDriver().manage().window().maximize();
        SQLiteHandler.getConnection();
    }

    @After
    public void closeBrowser(Scenario scenario) {

        if (scenario.isFailed()) {
            try {

                final byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", scenario.getName());

            } catch (final Exception e) {
                log.error("Error while screenshot: {}", e.getMessage(), e);
            }
        }

        log.info("Scenario Completed: {}", scenario.getName());
        log.info("Scenario Status is: {}", scenario.getName());

        DriverManager.quitDriver();
    }

}
