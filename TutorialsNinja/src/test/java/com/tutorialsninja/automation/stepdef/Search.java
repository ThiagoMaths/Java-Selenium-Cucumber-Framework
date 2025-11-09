package com.tutorialsninja.automation.stepdef;

import com.tutorialsninja.automation.framework.DriverManager;
import com.tutorialsninja.automation.pages.HeadersSectionPage;
import com.tutorialsninja.automation.pages.SearchResultPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;


public class Search {

    HeadersSectionPage headersSectionPage = new HeadersSectionPage(DriverManager.getDriver());
    SearchResultPage searchResultPage = new SearchResultPage(DriverManager.getDriver());

    @When("I search for a product")
    public void i_search_for_a_product() throws IOException {
        headersSectionPage.searchProducts();
    }

    @Then("I should see the product in the search results")
    public void i_should_see_the_product_in_the_search_results() {
        searchResultPage.isSearchResult();
    }

    @When("I search for a product missing")
    public void iSearchForAProductMissing() throws IOException {
        headersSectionPage.searchProductsInvalid();
    }

    @Then("I should see the page displaying the message")
    public void i_should_see_the_page_displaying_the_message() {
        searchResultPage.isSearchEmpty();
    }


}
