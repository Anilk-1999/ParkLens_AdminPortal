package testRunner;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features/Cameras/AddCameras.feature",
                             "src/test/resources/features/Cameras/UpdateCameras.feature",
		                     "src/test/resources/features/Cameras/DeleteCamera.feature",
		                     "src/test/resources/features/Cameras/CameraHomePage.feature"
		                    }, 
                 glue = "stepDefinitions", 
                 dryRun = false, 
                 monochrome = true, 
                 plugin = "html:test-output/Cameras-test-data"
                 )


public class CamerasTestRunner 
{


}
