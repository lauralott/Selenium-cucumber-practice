package com.lasalle.automation.vueling.web.test;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/features/search/search.feature",
        glue = "com.lasalle.automation.vueling.web")
public class FindFlightTest {}

