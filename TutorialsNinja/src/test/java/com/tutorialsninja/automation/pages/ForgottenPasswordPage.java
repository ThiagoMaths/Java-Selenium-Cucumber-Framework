package com.tutorialsninja.automation.pages;

import com.tutorialsninja.automation.framework.Elements;
import com.tutorialsninja.automation.utils.FakerUtil;
import com.tutorialsninja.automation.utils.SQLiteHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgottenPasswordPage {

    private WebDriver driver;
    private SQLiteHandler sqLiteHandler;
    private FakerUtil fakerUtil;

    public ForgottenPasswordPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        sqLiteHandler = new SQLiteHandler();
        fakerUtil = new FakerUtil();
    }

    @FindBy(id = "input-email")
    public WebElement email;

    @FindBy(xpath = "//input[@value='Continue']")
    public WebElement continueButton;

    @FindBy(css = "div[class$='alert-dismissible']")
    public WebElement mainWarning;

    public void sendEmail() {

        String emailFind = sqLiteHandler.getRandomEmail();

        Elements.TypeText(driver, email, emailFind);
        button();
    }

    public void button() {
        Elements.click(driver, continueButton);
    }

    public void sendEmailInvalid() {

        String emailInvalid = fakerUtil.email();
        Elements.TypeText(driver, email, emailInvalid);
        button();

    }

}
