package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {/*"src/test/resources/features/Attributes/AddAttributes.feature",
                             "src/test/resources/features/Attributes/UpdateAttributes.feature",
		                     "src/test/resources/features/Attributes/DeleteAttributes.feature",*/
		                     "src/test/resources/features/Attributes/AttributesHomePage.feature"
		                    },
glue = "stepDefinitions",
dryRun = false,
monochrome = true,
plugin = {"pretty","html:target/Attribute-test-data"}
)


public class AttributeTestRunner 
{
	
}
