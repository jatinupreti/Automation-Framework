package RunnerFiles;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\resources\\Features\\AddToCart.feature", glue="StepDefinitions"
,plugin= {"pretty","html:target/cucumber-reports/report.html"}, monochrome = true)
public class addToCartRunner {

}
