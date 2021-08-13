package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/TestScenarios/salesforce.feature",
        glue = "TestSteps",
        publish = true,
        plugin = {"pretty", "html:build/reports/cucumber" ,
                "json:target/cucumber.json",
                "pretty:target/cucumber-pretty.txt",
                "usage:target/cucumber-usage.json",
                "junit:target/cucumber-results.xml" }
)
public class Runner {

}
