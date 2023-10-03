package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features/AdminUsers/AddAdminUsers.feature",
                             "src/test/resources/features/AdminUsers/UpdateAdminUsers.feature",
		                     "src/test/resources/features/AdminUsers/DeleteAdminUser.feature",
		                     "src/test/resources/features/AdminUsers/AdminUserHomePage.feature"
		                     },
                 glue = "stepDefinitions",
                 dryRun = false,
                 monochrome = true,
                 plugin = {"pretty","html:test-data","html:Reports/test-data"}
                 )

public class AdminUserTestRunner
{
	
}
