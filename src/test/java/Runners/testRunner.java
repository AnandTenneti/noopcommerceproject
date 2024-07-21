package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/java/features/categories.feature"}, //"src/test/java/features/product.featuresrc/test/java/features/customer.feature",
        glue = "stepdefinitions",
        monochrome = false,
        dryRun = false,
        tags = "@CategoriesSO",
        plugin = "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        publish = true)

public class testRunner extends AbstractTestNGCucumberTests {

}
