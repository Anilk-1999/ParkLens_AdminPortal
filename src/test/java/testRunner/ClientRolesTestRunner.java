package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {/*"src/test/resources/features/ClientRole/AddClientRole.feature",
                             "src/test/resources/features/ClientRole/UpdateClientRole.feature",
		                     "src/test/resources/features/ClientRole/DeleteClientRole.feature",*/
		                     "src/test/resources/features/ClientRole/ClientRoleHomePage.feature" 
		                    },
                 glue = "stepDefinitions",
                 dryRun = false,
                 monochrome = true,
                 plugin = "html:test-output/clientrole-test-data" 
		        )

public class ClientRolesTestRunner 
{
  
}
