package parallel;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    monochrome = true,
    features = "@target/rerun.txt", //Cucumber picks the failed scenarios from this file 
    		plugin = {"html:Report/cucumber-html-report-RETRY.html"} //to generate different report types
  )
public class TestFailedRetryRunner {

	
	
}
