package Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
/*@CucumberOptions(features = "src/test/java/Features",glue = {"Steps"},tags={"@Mesut"},
        plugin = { "pretty", "json:Report/cucumber-reports/Cucumber.json",
                "junit:Report/cucumber-reports/Cucumber.xml",
                "html:Report/cucumber-reports" }, monochrome = true
        or (@RunWith(Cucumber.class)*/


@CucumberOptions(format={"pretty","html:Report/cucumber-report"},tags= "@Mesut")
public class Runner {

}