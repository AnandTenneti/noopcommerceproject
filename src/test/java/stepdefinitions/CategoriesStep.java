package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobjects.CategoriesPage;
import pageobjects.HomePage;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static managers.DriverManager.driver;

public class CategoriesStep {
    HomePage homePage;
    CategoriesPage categoriesPage;

    Random random = new Random();

    @When("click on Categories Menu Item")
    public void click_on_categories_menu_item() {
        System.out.println("User clicks on the categories menu item");
        homePage = new HomePage(driver);
        homePage.clickOnCategoriesMenuItem();
    }

    @When("click on Add new Category button")
    public void click_on_add_new_category_button() throws Exception {
        System.out.println("User clicks on the 'Add new' button in categories");
        categoriesPage = new CategoriesPage(driver);
        categoriesPage.clickOnAddNewCategory();
        Thread.sleep(3000);
    }

    @And("enter details in category info section")
    public void enter_details_in_category_info_section() {
        System.out.println("User enter details under category info section");
        String[] info = {"Apple Macbook" + random.nextInt(),
                "This is an Apple Macbook" + random.nextInt(), "2"};
        List<String> category_info = Arrays.asList(info);
        categoriesPage.setCategoryName(category_info.get(0));
        categoriesPage.setCategoryDescription(category_info.get(1));
        categoriesPage.selectParentCategory(Integer.parseInt(category_info.get(2)));
    }

    @And("click on Category Save button")
    public void click_on_category_save_button() {
        System.out.println("User clicks on Save button");
        categoriesPage.clickOnSaveButton();
    }

    @Then("view the message {string}")
    public void view_the_message(String message) {
        Assert.assertTrue(categoriesPage.getConfigurationMessage().contains(message), "Category message is not matching");
    }

    @Given("Search for category name {string}")
    public void search_for_category_name(String category) {
        System.out.println("User searches for category");
        categoriesPage = new CategoriesPage(driver);
        categoriesPage.enterSearchCategoryName(category);
    }

    @Given("click on Search button for categories")
    public void click_on_search_button_for_categories() {
        System.out.println("User clicks on Search button for categories");
        categoriesPage.clickOnSearchCategoriesButton();
    }

    @Then("view the category search results")
    public void view_the_category_search_results() {
        System.out.println("User can view the category search results");
        System.out.println("The total number of results are " + categoriesPage.getCategorySearchResults().size());
        Assert.assertTrue(categoriesPage.getCategorySearchResults().size() > 0, "Category search results count is incorrect");
    }

}
