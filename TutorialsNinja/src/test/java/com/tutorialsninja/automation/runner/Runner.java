package com.tutorialsninja.automation.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:FeatureFiles/"},
        glue = {"com.tutorialsninja.automation.stepdef"},
        plugin = {"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        tags = "",
        monochrome = true)

public class Runner {

}
