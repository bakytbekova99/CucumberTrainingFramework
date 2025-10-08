package com.qa.weborder.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/weborder", //location of feature files
        glue = "com/qa/weborder/stepdefinitions", //location of step definition classes
        dryRun = false, // to get snips without executing the steps
        tags = "@smoke", //all about filtration of scenarios
        plugin = {"pretty", "html:target/uiReport.html", "rerun:target/uiFailedTests.txt"}
)

public class WebOrderRunner {

}
