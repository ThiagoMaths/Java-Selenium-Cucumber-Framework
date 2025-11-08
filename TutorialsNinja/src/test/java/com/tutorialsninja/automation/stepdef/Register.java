package com.tutorialsninja.automation.stepdef;

import com.tutorialsninja.automation.base.Base;
import com.tutorialsninja.automation.framework.DriverManager;
import com.tutorialsninja.automation.framework.Elements;
import com.tutorialsninja.automation.pages.AccountSuccessPage;
import com.tutorialsninja.automation.pages.HeadersSectionPage;
import com.tutorialsninja.automation.pages.RegisterPage;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Register {

    HeadersSectionPage headersSectionPage = new HeadersSectionPage(DriverManager.getDriver());
    RegisterPage registerPage = new RegisterPage(DriverManager.getDriver());
    AccountSuccessPage accountSuccessPage = new AccountSuccessPage(DriverManager.getDriver());


    @Given("^I launch the application$")
    public void i_launch_the_application() {
        DriverManager.getDriver().get(Base.reader.getUrl());

        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(3));

            By cookieBanner = By.xpath("//button[contains(text(),'Accept')] | //button[contains(text(),'Agree')] | //button[contains(text(),'I agree')] | //a[contains(text(),'Accept')]");

            WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(cookieBanner));

            acceptButton.click();

        } catch (Exception e) {

        }
    }


    @And("^I navigate to Account Registration page$")
    public void i_navigate_to_Account_Registration_page() {
        headersSectionPage.myAccountToRegister();
    }

    @When("^I provide all the below valid details$")
    public void i_provide_all_the_below_valid_details() {
        registerPage.enterAllDetails();
    }

    @When("I provide all the below valid details with an existing email")
    public void iProvideAllTheBelowValidDetailsWithAnExistingEmail() {
        registerPage.enterAllDetailsEmailDuplicate();
    }

    @And("^I select the Privacy Policy$")
    public void i_select_the_Privacy_Policy() {
        registerPage.privacyPolicySelect();
    }

    @And("^I click on Continue Button$")
    public void i_click_on_Continue_Button() {
        registerPage.clickContinueButton();
    }

    @Then("^I should see that the User account has successfully created$")
    public void i_should_see_that_the_User_account_has_created() {
        Assert.assertTrue(Elements.isDisplayed(DriverManager.getDriver(), accountSuccessPage.successBread));

    }

    @Then("I should see that the User account is not created")
    public void i_should_see_that_the_user_account_is_not_created() {
        registerPage.registerNoCreated();
    }

    @And("I should see the error message informing the user to fill the mandatory fields")
    public void i_should_see_the_error_message_informing_the_user_to_fill_the_mandatory_fields() {
        RegisterPage registerPage = new RegisterPage(DriverManager.getDriver());

        Assert.assertTrue("First name error message not displayed.", registerPage.isFirstNameWarningDisplayed());
        Assert.assertTrue("Last name error message not displayed.", registerPage.isLastNameWarningDisplayed());
        Assert.assertTrue("Email error message not displayed.", registerPage.isEmailWarningDisplayed());
        Assert.assertTrue("Telephone error message not displayed.", registerPage.isTelephoneWarningDisplayed());
        Assert.assertTrue("Password error message not displayed.", registerPage.isPasswordWarningDisplayed());
        Assert.assertTrue("Main warning message not displayed.", registerPage.isMainWarningDisplayed());    }

    @When("I subscribe to Newsletter")
    public void i_subscribe_to_newsletter() {
        registerPage.subscribe();
    }

    @Then("I should see that the User is restricted from creating duplicate account")
    public void i_should_see_that_the_user_is_restricted_from_creating_duplicate_account() {
        registerPage.duplicateAccount();
    }


}

