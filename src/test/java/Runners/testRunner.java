package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import util.ConfigReader;

@CucumberOptions(features = {"src/test/java/features/login.feature"}, //src/test/java/features/customer.feature",
        glue = "stepdefinitions",
        monochrome = false,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        dryRun = false,
        tags = "@Regression",
//        plugin = {"pretty", "html:target/test-output.html"},
        plugin = "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        publish = true)

public class testRunner extends AbstractTestNGCucumberTests {
//    @DataProvider(parallel = false)
//    public Object[][] scenarios() {
//        return super.scenarios();
//    }
//
//    @BeforeTest
//    @Parameters({"browser"})
//    public void defineBrowser(String browser) throws Throwable {
//        ConfigReader.setBrowserType(browser);
//    }
}
