package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageobjects.CustomerPage;
import pageobjects.HomePage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomerStep {


    HomePage homePage;
    CustomerPage customerPage;

    WebDriver driver = DriverManager.driver;
    static String email = DriverManager.randomString() + "@example.com";

    @When("User clicks on customers menu")
    public void user_clicks_on_customers_menu() throws Exception {
        System.out.println("User clicks on customers menu in the sidebar");
        homePage = new HomePage(driver);
        homePage.clickOnCustomerMenu();
        Thread.sleep(3000);
    }

    @When("click on customers Menu Item")
    public void click_on_customers_menu_item() {
        System.out.println("User clicks on customers menu item in the sidebar");
        homePage.clickOnCustomersMenuItem();
    }

    @When("click on Add new button")
    public void click_on_add_new_button() {
        System.out.println("Click on Add new button");
        customerPage = new CustomerPage(driver);
        customerPage.clickOnAddNewButton();
    }

    @Then("User can view Add new customer page")
    public void user_can_view_add_new_customer_page() {
        System.out.println("User can add new customer page");
        Assert.assertEquals(driver.getTitle(), "Add a new customer / nopCommerce administration", "Title mismatch");
    }

    @When("User enter customer info")
    public void user_enter_customer_info() throws Exception {
        System.out.println("User enter customer info");
        // String email = DriverManager.randomString() + "@example.com";

        String details[] = new String[]{email, "Vincent", "Thomas", "23/07/1981", "This is an admin comment"};
        // Add customer details in an ArrayList
        List<String> CustomerDetails = Arrays.asList(details);
        customerPage = new CustomerPage(driver);
        customerPage.setEmail(CustomerDetails.get(0));
        customerPage.setFirstName(CustomerDetails.get(1));
        customerPage.setLastName(CustomerDetails.get(2));
        customerPage.addDOB(CustomerDetails.get(3));
        customerPage.addComment(CustomerDetails.get(4));
        customerPage.clickOnTaxExemptCheckbox();
        Thread.sleep(3000);
    }

    @When("click on Save button")
    public void click_on_save_button() {
        System.out.println("click on Save button");
        customerPage.clickOnSaveButton();
    }

    @Then("User can view configuration message {string}")
    public void user_can_view_configuration_message(String message) {
        System.out.println("User can view configuration message");
        Assert.assertTrue(customerPage.getMessage().contains(message));
    }

    @Then("User can view validation message {string}")
    public void user_can_view_validation_message(String alertMessage) {
        System.out.println("Vaidation message is " + customerPage.getValidationMessage());
        Assert.assertEquals(customerPage.getValidationMessage(), alertMessage, "Validation message is nt matching");
    }

    @Then("Enter an invalid email")
    public void enter_an_invalid_email() throws Exception {
        customerPage.setEmail("a");
        Thread.sleep(2000);
    }

    @When("User search for an email")
    public void user_search_for_an_email() throws Exception {
        System.out.println("Search for an existing customer email");
        customerPage = new CustomerPage(driver);
        customerPage.searchEmail(email);
        Thread.sleep(3000);
    }

    @When("click on Search button")
    public void click_on_search_button() throws Exception {
        System.out.println("User clicks on Search button");
        customerPage.clickOnSearchButton();
    }


    @Then("User can view message {string}")
    public void user_can_view_message(String message) throws Exception {
        System.out.println("User can viw the results");
        customerPage = new CustomerPage(driver);
        customerPage.scrollIntoView();
        Assert.assertEquals(customerPage.getMessageWhenNoResultsInTable(),
                message, "Message is not matching");
        Thread.sleep(5000);
    }

    @Given("User enters Email {string}")
    public void user_enters_email(String email) {
        System.out.println("User enters Email");
        customerPage.setEmail(email);
    }

    @Given("User enters Firstname {string}")
    public void user_enters_firstname(String firstname) {
        System.out.println("User enters firstname");
        customerPage.setFirstName(firstname);
    }

    @Given("User enters Lastname {string}")
    public void user_enters_lastname(String lastname) {
        System.out.println("User enters lastname");
        customerPage.setLastName(lastname);
    }

    @When("User enters Email firstname and lastname")
    public void user_enters_email_firstname_and_lastname(io.cucumber.datatable.DataTable dataTable) {
        List<List<String>> customerForm = dataTable.asLists(String.class);
        String CustomerEmail = customerForm.get(0).get(0);
        String CustomerFirstName = customerForm.get(0).get(1);
        String CustomerLastName = customerForm.get(0).get(2);
        customerPage = new CustomerPage(driver);
        customerPage.setEmail(CustomerEmail);
        customerPage.setFirstName(CustomerFirstName);
        customerPage.setLastName(CustomerLastName);
    }

    @When("User clicks on the Edit button of a customer row")
    public void user_clicks_on_the_edit_button_of_a_customer_row() throws Exception {
        System.out.println("User clicks on the Edit button of any selected row");
        customerPage = new CustomerPage(driver);
        // Click on Edit button for the second row
        customerPage.clickOnEditButton(2);
        Thread.sleep(10000);
    }

    @Then("User can view the search results")
    public void user_can_view_the_search_results() throws Exception {
        System.out.println("User can view the search results");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        customerPage = new CustomerPage(driver);
        Assert.assertTrue(customerPage.getCustomerList().size() > 0);
        Thread.sleep(5000);
    }
}
