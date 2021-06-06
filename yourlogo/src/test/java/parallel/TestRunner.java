package parallel;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		 features = "/Users/Arun/git/My-Logo-Project/yourlogo/src/test/resources/parallel",
		 glue={"parallel"},
		 plugin = {"html:Report/cucumber-html-report.html", 
				   "json:Report/cucumber-json-report.json",
				   "junit:Report/cucumber-junit-report.xml",
				   "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				    }, //to generate different report types
		dryRun=false,
		monochrome = true
		 )

public class TestRunner {
	
}
