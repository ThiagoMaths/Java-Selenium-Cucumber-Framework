package com.tutorialsninja.automation.pages;

import com.tutorialsninja.automation.framework.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class MyAccountPage {

    private WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "content")
    public WebElement myAccountBread;

   public boolean isMyAccountBreadDisplayed() {
       return Elements.isDisplayed(driver, myAccountBread);
   }

}
