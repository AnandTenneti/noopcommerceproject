package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.DriverManager;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import pageobjects.LoginPage;
import util.ExcelReader;

import java.io.IOException;
import java.sql.Driver;
import java.util.List;
import java.util.Map;

public class LoginStep {
    WebDriver driver = DriverManager.driver;

    LoginPage loginPage;

    ExcelReader reader = new ExcelReader();


    @Given("User is on Application  Page")
    public void user_is_on_application_page() {
        System.out.println("User is on the application page");
        driver.get("https://admin-demo.nopcommerce.com/login");
        Assert.assertEquals(driver.getTitle(), "Your store. Login", "Login Page title mismatch");
    }

    @When("User enters Username {string} and Password {string}")
    public void user_enters_username_and_password(String Username, String Password) {
        System.out.println("User enters valid username and password");
        loginPage = new LoginPage(driver);
        loginPage.setUserName(Username);
        loginPage.setPassword(Password);

    }

    @When("User clicks on Sign In button")
    public void user_clicks_on_sign_in_button() throws Exception {
        System.out.println("User clicks on Sign In button");
        loginPage = new LoginPage(driver);
        loginPage.clickOnLogin();
        Thread.sleep(2000);
    }

    @Then("User navigates to Home Page")
    public void user_navigates_to_home_page() {
        System.out.println("User navigates to home page");
        Assert.assertEquals(driver.getTitle(), "Dashboard / nopCommerce administration", "testing title match");
    }

    @Then("User navigates to Login Page")
    public void user_navigates_to_login_page() {
        System.out.println("User navigates to login page");
        Assert.assertEquals(driver.getTitle(), "Your store. Login", "testing title match");
    }

    @Then("Verify the title {string}")
    public void verify_the_title(String title) {
        System.out.println("Page title is " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(), title, "Matches the page title");
    }

    @When("User enters valid username and password")
    public void user_enters_valid_username_and_password(io.cucumber.datatable.DataTable dataTable) {
        System.out.println("Enter valid username and password");
        List<List<String>> signInForm = dataTable.asLists(String.class);
        String userName = signInForm.get(0).get(0);
        String passWord = signInForm.get(0).get(1);
        System.out.println("Username is " + userName);
        System.out.println("Password is " + passWord);
        loginPage = new LoginPage(driver);
        loginPage.setUserName(userName);
        loginPage.setPassword(passWord);

    }

    @Given("User enters valid data from sheet {string} and rowNumber {int}")
    public void user_enters_valid_data_from_sheet_and_row_number(String sheetName, Integer rowNumber) throws IOException, InvalidFormatException {
        System.out.println("Read data from sheet ");
        List<Map<String, String>> testdata = reader.getData("Logindata.xlsx", sheetName);
        String heading1 = testdata.get(rowNumber).get("Username");
        System.out.println("Username is " + heading1);
        String heading2 = testdata.get(rowNumber).get("Password");
        System.out.println("Password is " + heading2);
        String heading3 = testdata.get(rowNumber).get("title");
        System.out.println("Page title is " + heading3);
        loginPage = new LoginPage(driver);
        loginPage.setUserName(heading1);
        loginPage.setPassword(heading2);
    }

    @Then("Page title from sheet {string} and rowNumber {int} should be verified")
    public void page_title_from_sheet_and_row_number_should_be_verified(String sheetName, Integer rowNumber) throws IOException, InvalidFormatException {
        System.out.println("Verify the page title");
        List<Map<String, String>> testdata = reader.getData(System.getProperty("user.dir") + "/src/test/resources/Logindata.xlsx", sheetName);
        String pageTitle = testdata.get(rowNumber).get("title");
        System.out.println("Page title is " + pageTitle);
        Assert.assertEquals(driver.getTitle(), pageTitle, "Title mismatch");
    }

    @When("User enters valid credentials")
    public void user_enters_valid_credentials() {
        System.out.println("Enter valid username and password");
        loginPage = new LoginPage(driver);
        loginPage.setUserName("admin@yourstore.com");
        loginPage.setPassword("admin");
    }

}
