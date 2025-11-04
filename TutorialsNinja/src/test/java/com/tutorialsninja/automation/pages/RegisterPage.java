package com.tutorialsninja.automation.pages;

import com.tutorialsninja.automation.framework.DriverManager;
import com.tutorialsninja.automation.framework.Elements;
import com.tutorialsninja.automation.utils.SQLiteHandler;
import com.tutorialsninja.automation.utils.FakerUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;




public class RegisterPage {

    WebDriver driver;

    private SQLiteHandler sqLiteHandler;
    private FakerUtil util;

    public RegisterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
       
    }


    @FindBy(id = "input-firstname")
    private WebElement firstName;

    @FindBy(id = "input-lastname")
    private WebElement lastName;

    @FindBy(id = "input-email")
    private WebElement email;

    @FindBy(id = "input-telephone")
    private WebElement telephone;

    @FindBy(id = "input-password")
    private WebElement password;

    @FindBy(id = "input-confirm")
    private WebElement confirmPassword;

    @FindBy(xpath = "//input[@name='agree']")
    private WebElement privacyPolity;

    @FindBy(xpath = "//input[@value='Continue']")
    private WebElement continueButton;

    @FindBy(linkText = "Register")
    private WebElement registerBreadCrumb;

    @FindBy(css = "input[id='input-firstname']+div")
    private WebElement firsNameWarning;

    @FindBy(css = "input[id='input-lastname']+div")
    private WebElement lastNameWarning;

    @FindBy(css = "input[id='input-email']+div")
    private WebElement emailWarning;

    @FindBy(css = "input[id='input-telephone']+div")
    private WebElement telephoneWarning;

    @FindBy(css = "input[id='input-password']+div")
    private WebElement passwordWarning;

    @FindBy(css = "div[class$='alert-dismissible']")
    private WebElement mainWarning;

    @FindBy(xpath = "(//input[@name='newsletter'])[1]")
    private WebElement subscribeButton;

    @FindBy(xpath = "(//div[@class='alert alert-danger alert-dismissible'])[1]")
    private WebElement dangerWarning;


    public void enterAllDetails() {

        String firstNameValue = util.firstName();
        String lastNameValue = util.lastName();
        String emailValue = util.email();
        String telephoneValue = util.telephone();
        String passwordValue = util.password();

        sqLiteHandler.insertUser(emailValue, passwordValue);

        Elements.TypeText(driver, firstName, firstNameValue);
        Elements.TypeText(driver, lastName, lastNameValue);
        Elements.TypeText(driver, email, emailValue);
        Elements.TypeText(driver, telephone, telephoneValue);
        Elements.TypeText(driver, password, passwordValue);
        Elements.TypeText(driver, confirmPassword, passwordValue);

    }

    public void enterAllDetailsEmailDuplicate() {

        String firstNameValue = util.firstName();
        String lastNameValue = util.lastName();
        String emailValue = sqLiteHandler.getRandomEmail();
        String telephoneValue = util.telephone();
        String passwordValue = util.password();

        Elements.TypeText(driver, firstName, firstNameValue);
        Elements.TypeText(driver, lastName, lastNameValue);
        Elements.TypeText(driver, email, emailValue);
        Elements.TypeText(driver, telephone, telephoneValue);
        Elements.TypeText(driver, password, passwordValue);
        Elements.TypeText(driver, confirmPassword, passwordValue);

    }

    public void privacyPolicySelect() {
        Elements.click(driver, privacyPolity);
    }

    public void clickContinueButton() {
        Elements.click(driver, continueButton);

    }

    public boolean registerNoCreated() {
        boolean isDisplayed = Elements.isDisplayed(driver, registerBreadCrumb);
        return isDisplayed;

    }

    public boolean isFirstNameWarningDisplayed() {
        return Elements.isDisplayed(DriverManager.getDriver(), firsNameWarning);
    }

    public boolean isLastNameWarningDisplayed() {
        return Elements.isDisplayed(DriverManager.getDriver(), lastNameWarning);
    }

    public boolean isEmailWarningDisplayed() {
        return Elements.isDisplayed(DriverManager.getDriver(), emailWarning);
    }

    public boolean isTelephoneWarningDisplayed() {
        return Elements.isDisplayed(DriverManager.getDriver(), telephoneWarning);
    }

    public boolean isPasswordWarningDisplayed() {
        return Elements.isDisplayed(DriverManager.getDriver(), passwordWarning);
    }

    public boolean isMainWarningDisplayed() {
        return Elements.isDisplayed(DriverManager.getDriver(), mainWarning);
    }
    public void subscribe() {
        Elements.selectRadioButton(subscribeButton);

    }

    public boolean duplicateAccount() {
        return Elements.isDisplayed(driver, registerBreadCrumb);
    }
}
