package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty","html:target/cucumber",
        "json:target/cucumber.json"},
        features="src/test/resources/uiFeatures",
        glue="ui_automation.step_definitions",
        dryRun = false,
        tags="@nestedFramesHomeWork"
//        monochrome = true
)

public class UITestRunner {

    /**
     * These lines are for documentation purposes
     */
// TODO add more descriptive documentation

}