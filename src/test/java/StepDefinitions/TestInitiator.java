package StepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class TestInitiator extends BaseClass{
	
	@Before
	public void initiateBrowser(Scenario scenario) {
		tearUp();
		System.out.println("********"+scenario.getName()+"*************");
	}
	
	@After
	public void tearBrowser(Scenario scenario) throws IOException {
		if(scenario.isFailed()) {
			TakesScreenshot screenshot= (TakesScreenshot)driver;
			File ss = screenshot.getScreenshotAs(OutputType.FILE);
			File destination = new File("./FailedScenarios/ScreenShot.png");
			FileUtils.copyFile(ss, destination);
			
			byte[] src = screenshot.getScreenshotAs(OutputType.BYTES);
			scenario.attach(src, "image/png", "screenshot");
		}
		System.out.println("********"+scenario.getStatus()+"*************");
		tearDown();
	}

}
