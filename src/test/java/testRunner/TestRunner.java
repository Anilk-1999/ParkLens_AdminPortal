package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = {
    		     "src/test/resources/features"
    		   },
    glue = "stepDefinitions",
    dryRun = false,
    monochrome = true,
    plugin = {"pretty","html:test-data",
    		"html:Reports/test-data",
    		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
   
)
public class TestRunner  
{
	
}
