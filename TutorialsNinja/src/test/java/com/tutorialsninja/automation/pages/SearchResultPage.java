package com.tutorialsninja.automation.pages;

import com.tutorialsninja.automation.framework.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SearchResultPage {

    private WebDriver driver;

    public SearchResultPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(linkText = "Search")
    public WebElement searchResults;

    @FindBy(css = "input[id='button-search']+h2+p")
    public WebElement searchEmpty;

    @FindBy(xpath = "//span[text()='Add to Cart'][1]")
    public WebElement firstAddToCartOption;

    public boolean isSearchResult() {
        return Elements.isDisplayed(driver, searchResults);
    }

    public boolean isSearchEmpty() {
        return Elements.isDisplayed(driver, searchEmpty);
    }

}
