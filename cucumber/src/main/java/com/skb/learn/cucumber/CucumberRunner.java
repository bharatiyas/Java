package com.skb.learn.cucumber;

// The job of runner class is to run the feature file
// Runner class helps to bridge the gap between the feature file and the step definitions
// and thus helps them to work along each other. In other words it marries up feature file
// and step definitions

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
// 'glue' is used to mention the Step-definitions class. So it glues together the feature and step definitions
@CucumberOptions(features = "classpath:cucmber-features/LoginTest.feature", glue = "com.skb.learn.cucumber",
        plugin = {"json:target/test-reports/json-test-report", "html:target/test-reports/html-test-report",
                "junit:target/test-reports/xml-test-report", "pretty:target/test-reports/pretty-test-report"})
public class CucumberRunner {

}
