package testRunner;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features/Lots/AddLots.feature",
                             "src/test/resources/features/Lots/UpdateLots.feature",
		                      "src/test/resources/features/Lots/DeleteLots.feature",
		                      "src/test/resources/features/Lots/LotsHomePage.feature"
		                    }, 
                 glue = "stepDefinitions", 
                 dryRun = false, 
                 monochrome = true, 
                 plugin = "html:test-output/Lots-test-data"
                 )

public class LotsTestRunner
{

}
