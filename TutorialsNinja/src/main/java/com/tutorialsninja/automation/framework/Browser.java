package com.tutorialsninja.automation.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import com.tutorialsninja.automation.base.Base;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Browser {

    public static Logger log = LoggerFactory.getLogger(Browser.class);

    private static final String CHROME = "chrome";
    private static final String FIREFOX = "firefox";
    private static final String IE = "ie";

    public static WebDriver startBrowser(String browserName) {

        String browser = System.getProperty("browser.type", Base.reader.getBrowser()).toLowerCase();
        String headless = System.getProperty("browser.headless", "false").toLowerCase();

        log.info("Selected Browser is: {} (Headless: {})", browser, headless);

        WebDriver driver;
        switch (browser) {
            case CHROME:
                WebDriverManager.chromedriver().setup();

                ChromeOptions chromeOptions = new ChromeOptions();
                if ("true".equals(headless)) {
                    chromeOptions.addArguments("--headless");
                    chromeOptions.addArguments("--window-size=1920,1080");

                    chromeOptions.addArguments("--disable-dev-shm-usage");
                }
                driver = new ChromeDriver(chromeOptions);

                log.info("Chrome Browser is Started");
                break;

            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();

                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if ("true".equals(headless)) {
                    firefoxOptions.addArguments("-headless");
                    firefoxOptions.addArguments("-width=1920");
                    firefoxOptions.addArguments("-height=1080");
                }
                driver = new FirefoxDriver(firefoxOptions);

                log.info("Firefox Browser is Started");
                break;

            case IE:
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                log.info("Internet Explorer Browser is Started");
                break;

            default:
                log.error("Invalid browser specified: {}", browser);
                throw new IllegalArgumentException("Invalid browser specified: " + browser);
        }
        return driver;
    }
}