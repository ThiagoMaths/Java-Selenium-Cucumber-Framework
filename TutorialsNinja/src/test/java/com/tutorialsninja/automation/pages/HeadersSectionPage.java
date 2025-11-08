package com.tutorialsninja.automation.pages;

import com.tutorialsninja.automation.framework.Elements;
import com.tutorialsninja.automation.utils.CSVReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;


public class HeadersSectionPage {

    private WebDriver driver;

    public HeadersSectionPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[title='My Account']")
    public WebElement myAccountLink;

    @FindBy(linkText = "Register")
    public WebElement register;

    @FindBy(linkText = "Login")
    public WebElement login;

    @FindBy(xpath = "//input[@name='search']")
    public WebElement searchField;

    @FindBy(css = "button[class*='btn-lg']")
    public WebElement buttonSearch;


    public void myAccountLinkClick() {
        Elements.click(driver, myAccountLink);
    }

    public void myAccountToRegister() {
        myAccountLinkClick();
        Elements.click(driver, register);
    }

    public void MyAccountToLogin() {
        myAccountLinkClick();
        Elements.click(driver, login);
    }

    public void searchProducts() throws IOException {
        String product = CSVReader.readCSVFile();

        Elements.TypeText(driver, searchField, product);
        Elements.click(driver, buttonSearch);
    }

    public void searchProductsInvalid() throws IOException {
        String productInvalid = CSVReader.readInvalidCSVFile();

        Elements.TypeText(driver, searchField, productInvalid);
        Elements.click(driver, buttonSearch);
    }

}
