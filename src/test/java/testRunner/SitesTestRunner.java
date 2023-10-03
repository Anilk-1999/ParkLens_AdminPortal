package testRunner;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features/Sites/AddSites.feature",
                             "src/test/resources/features/Sites/UpdateSites.feature",
		                     "src/test/resources/features/Sites/DeleteSites.feature",
		                     "src/test/resources/features/Sites/SitesHomePage.feature"
                             }, 
                 glue = "stepDefinitions", 
                 dryRun = false, 
                 monochrome = true, 
                 plugin = "html:test-output/sites-test-data"
                 )



public class SitesTestRunner 
{

}
