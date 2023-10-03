package testRunner;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features/Clients/UpdateClients.feature"
                             },
                 glue = "stepDefinitions",
                 dryRun = false,
                 monochrome = true,
                 plugin = "html:test-output/clients-test-data" 
		        )

public class ClientsTestRunner 
{
	
}
