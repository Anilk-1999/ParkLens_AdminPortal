package testRunner;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {
		                      "src/test/resources/features/Stalls/UpdateStalls.feature"
		                    },
                 glue = "stepDefinitions",
                 dryRun = false,
                 monochrome = true,
                 plugin = "html:test-output/stalls-test-data" 
		        )


public class StallsTestRunner
{

	

}
