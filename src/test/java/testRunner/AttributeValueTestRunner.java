package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features/AttributeValue/AddAttributeValues.feature",
                             "src/test/resources/features/AttributeValue/UpdateAttributeValues.feature",
		                     "src/test/resources/features/AttributeValue/DeleteAttributeValues.feature",
		                     "src/test/resources/features/AttributeValue/AttrbuteValueHomePage.feature"
		                    },
                 glue = "stepDefinitions",
                 dryRun = false,
                 monochrome = true,
                 plugin = {"pretty","html:result-data"}
		)
public class AttributeValueTestRunner {
}
