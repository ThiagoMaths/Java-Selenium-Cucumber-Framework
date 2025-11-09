package com.tutorialsninja.automation.pages;

import com.tutorialsninja.automation.framework.Elements;
import com.tutorialsninja.automation.utils.FakerUtil;
import com.tutorialsninja.automation.utils.SQLiteHandler;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;


public class LoginPage {

    private SQLiteHandler sqLiteHandler;
    private WebDriver driver;
    private FakerUtil fakerUtil;

    public LoginPage(WebDriver driver, SQLiteHandler sqLiteHandler) {
        this.driver = driver;
        this.sqLiteHandler = sqLiteHandler;
        PageFactory.initElements(driver, this);

    }


    @FindBy(id = "input-email")
    public WebElement emailField;

    @FindBy(id = "input-password")
    public WebElement passwordField;

    @FindBy(xpath = "//input[@value='Login']")
    public WebElement loginButton;

    @FindBy(css = "div[class$='alert-dismissible']")
    public WebElement mainWarning;

    @FindBy(linkText = "Forgotten Password")
    public WebElement forgottenLink;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        sqLiteHandler = new SQLiteHandler();
        fakerUtil = new FakerUtil();
    }

    public void detailEmail() {

        Map<String, String> credentials = sqLiteHandler.getRandomEmailAndPassword();
        String emailFind = credentials.get("email");
        String passwordFind = credentials.get("password");

        Elements.TypeText(driver, emailField, emailFind);
        Elements.TypeText(driver, passwordField, passwordFind);

    }

    public void loginButton() {
        Elements.click(driver, loginButton);

    }

    public void detailEmailInvalid() {

        Map<String, String> credentials = sqLiteHandler.getRandomEmailAndPassword();
        String emailFind = credentials.get("email");
        String passwordFind = fakerUtil.password();

        Elements.TypeText(driver, emailField, emailFind);
        Elements.TypeText(driver, passwordField, passwordFind);

    }

    public void emailAndPasswordEmpty() {
        String emailEmpty = "";
        String passwordEmpty = "";

        Elements.TypeText(driver, emailField, emailEmpty);
        Elements.TypeText(driver, passwordField, passwordEmpty);
    }

    public void forgottenLink() {
        Elements.click(driver, forgottenLink);
    }

}
