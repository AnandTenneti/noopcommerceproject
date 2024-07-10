package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import managers.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import util.ConfigReader;

import java.sql.Driver;

public class MyHooks extends DriverManager {

    DriverManager driverManager;

    @Before
    public void setUp() throws Throwable {
        driver = DriverManager.getDriver("chrome");
        System.out.println("User is on the application page");
    }

    @After(order = 1)
    public void takeScreenshotOnFailure(Scenario sc) {
        if (sc.isFailed()) {
            TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] src = ts.getScreenshotAs(OutputType.BYTES);
            sc.attach(src, "image/png", "screenshot");
        }
    }

    @After(order = 0)
    public void tearDown() {
        DriverManager.closeBrowser();
    }
}
