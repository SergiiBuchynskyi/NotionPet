package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "json:target/cucumber.json", //this one to connect with jira
                "html:target/cucumber-reports.html",
                "rerun:target/rerun.txt"

        },

        features ="src/test/resources/features",
        glue ="Step_Definitions",
        dryRun=false,
        tags = "@SalesFunctionality"
)
public class CukesRunner {
}
