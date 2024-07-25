package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageobjects.HomePage;
import pageobjects.ProductPage;

import java.util.List;

public class ProductStep {

    HomePage homePage;

    ProductPage productPage;

    WebDriver driver = DriverManager.driver;


    @When("User clicks on Catalog menu")
    public void user_clicks_on_catalog_menu() {
        System.out.println("Click on Catalog Menu in the sidebar");
        homePage = new HomePage(driver);
        homePage.clickOnCatalogMenu();
    }

    @When("click on Products Menu Item")
    public void click_on_products_menu_item() {
        System.out.println("Click on Products menu item");
        homePage.clickOnProductMenu();
    }

    @When("click on Add new product button")
    public void click_on_add_new_product_button() {
        System.out.println("Click on 'Add new' button in the product section");
        productPage = new ProductPage(driver);
        productPage.clickOnAddNewbutton();

    }

    @Then("User can view {string} page")
    public void user_can_view_page(String string) {
        System.out.println("User can view product details page");
        Assert.assertTrue(productPage.getHeader().contains(string));

    }

//    @When("User enter product info and click on Save button")
//    public void user_enter_product_info_and_click_on_save_button() throws Exception {
//        System.out.println("Enter product details and click on Save button");
//        productPage.productDetails();
//        productPage.clickOnSaveButton();
//        Thread.sleep(2000);
//    }

    @Then("User can view product configuration message {string}")
    public void user_can_view_product_configuration_message(String configurationMessage) {
        System.out.println("User can view product configuration message");
        Assert.assertTrue(productPage.getMessage().contains(configurationMessage));
    }

    @Then("User can view product validation message {string}")
    public void user_can_view_product_validation_message(String validationMessage) {
        System.out.println("User can view product validation message");
        Assert.assertEquals(productPage.getValidationMessage(), validationMessage, "Validation message is nt matching");
    }

    @Then("click on Product Save button")
    public void click_on_product_save_button() {
        System.out.println("User clicks on Product save button");
        productPage.clickOnSaveButton();
    }

    @Given("User enters Product name {string}")
    public void user_enters_product_name(String ProductName) {
        System.out.println("User enters Product name");
        productPage.setProductName(ProductName);

    }

    @Given("User enters Short description {string}")
    public void user_enters_short_description(String shortDescription) {
        System.out.println("User enters short description");
        productPage.setProductShortDescription(shortDescription);
    }

    @Given("User enters Full description {string}")
    public void user_enters_full_description(String string) {
        System.out.println("User enters full description");
    }

    @When("User enters productName short description")
    public void user_enters_product_name_short_description(io.cucumber.datatable.DataTable dataTable) {
        System.out.println("User enters product name and short description");
        List<List<String>> productInfo = dataTable.asLists(String.class);
        String productName = productInfo.get(0).get(0);
        String shortDescription = productInfo.get(0).get(1);
        productPage.setProductName(productName);
        productPage.setProductShortDescription(shortDescription);
    }

    @When("User search for a product")
    public void user_search_for_a_product() {
        System.out.println("User enters a product name");
        productPage = new ProductPage(driver);
        productPage.enterSearchProductName();
    }

    @Then("User can view the product message {string}")
    public void user_can_view_the_product_message(String string) {
        System.out.println("User views the message no data available");
        Assert.assertEquals(productPage.viewMessage(), "No data available in table", "Message is not matching");

    }

    @When("click on Product Search button")
    public void click_on_product_search_button() {
        System.out.println("User clicks on product search button");
        productPage.clickOnSearchProductsButton();
    }
}
