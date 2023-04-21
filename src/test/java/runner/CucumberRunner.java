package runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/feature/UserStepdefinition.feature",
    glue = "StepDefinitions",
    dryRun = false
)
public class CucumberRunner extends AbstractTestNGCucumberTests {

}
