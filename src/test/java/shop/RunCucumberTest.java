package shop;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources/cucumber/features/shop",
        plugin =  {"pretty", "html:out"},
        glue = "shop"
)
public class RunCucumberTest {
}