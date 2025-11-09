package com.tutorialsninja.automation.framework;

import java.time.Duration;
import java.util.function.BooleanSupplier;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Waits {

    private static final Logger log = LoggerFactory.getLogger(Waits.class);

    private static final int DEFAULT_TIMEOUT_SECONDS = 30;

    public static void waitUntilVisible(WebDriver driver, WebElement element, int timeoutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (org.openqa.selenium.TimeoutException e) {
            log.error("Element not visible after {} seconds: {}", timeoutInSeconds, element.toString());
            throw new org.openqa.selenium.TimeoutException("Element not visible after " + timeoutInSeconds + " seconds: " + element.toString(), e);
        }
    }

    public static void waitUntilVisible(WebDriver driver, WebElement element) {
        waitUntilVisible(driver, element, DEFAULT_TIMEOUT_SECONDS);
    }

    public static void waitUntilClickable(WebDriver driver, WebElement element, int timeoutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (org.openqa.selenium.TimeoutException e) {
            log.error("Element not clickable after {} seconds: {}", timeoutInSeconds, element.toString());
            throw new org.openqa.selenium.TimeoutException("Element not clickable after " + timeoutInSeconds + " seconds: " + element.toString(), e);
        }
    }

    public static void waitUntilClickable(WebDriver driver, WebElement element) {
        waitUntilClickable(driver, element, DEFAULT_TIMEOUT_SECONDS);
    }

    public static Object executeJavascript(WebDriver driver, String script, Object... args) {
        try {
            JavascriptExecutor scriptExe = ((JavascriptExecutor) driver);
            return scriptExe.executeScript(script, args);
        } catch (Exception e) {
            log.error("Error executing JavaScript: {}", script, e);
            throw new JavaScriptException("Failed to execute JavaScript: " + script, e);
        }
    }

    public static void waitUntil(WebDriver driver, BooleanSupplier condition, int timeoutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            wait.until((WebDriver d) -> condition.getAsBoolean());
        } catch (org.openqa.selenium.TimeoutException e) {
            log.error("Condition not met after {} seconds: {}", timeoutInSeconds, condition.toString());
            throw new org.openqa.selenium.TimeoutException("Condition not met after " + timeoutInSeconds + " seconds: " + condition.toString(), e);
        }
    }

    public static void waitUntil(WebDriver driver, BooleanSupplier condition) {
        waitUntil(driver, condition, DEFAULT_TIMEOUT_SECONDS);
    }


    public static void waitUntilPageIsLoaded(WebDriver driver, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(d -> ((JavascriptExecutor) d).executeScript("return document.readyState").equals("complete"));
    }

    public static void waitUntilPageIsLoaded(WebDriver driver) {
        waitUntilPageIsLoaded(driver, DEFAULT_TIMEOUT_SECONDS);
    }

    public static class JavaScriptException extends RuntimeException {
        public JavaScriptException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static boolean waitForVisibility(WebDriver driver, WebElement element, int timeoutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}