package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features/AdminRole/AddAdminRoles.feature",
		                     "src/test/resources/features/AdminRole/UpdateAdminRole.feature",
		                     "src/test/resources/features/AdminRole/DeleteAdminRole.feature",
		                     "src/test/resources/features/AdminRole/AdminRoleHomePage.feature"
		                    },
                 glue = "stepDefinitions",
                 dryRun = false,
                 monochrome = true,
                 plugin = "html:test-output/clientrole-test-data" 
		        )

public class AdminRoleTestRunner 
{
  
}
