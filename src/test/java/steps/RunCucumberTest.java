package steps;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions( features = "src/test/java/resources/scenarios",
        plugin = "pretty",
        glue = "steps")

public class RunCucumberTest {

}