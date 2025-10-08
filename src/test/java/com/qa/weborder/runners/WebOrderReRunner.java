package com.qa.weborder.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "@target/uiFailedTests.txt", //location if failed.txt file
        glue = "com/qa/weborder/stepdefinitions",
        tags = "@smoke",
        plugin = {"pretty", "html:target/uiReport.html", "rerun:target/uiFailedTests.txt"}

)

public class WebOrderReRunner {

}
