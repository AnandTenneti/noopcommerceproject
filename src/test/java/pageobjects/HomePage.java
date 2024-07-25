package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//input[@placeholder='Search']")
    private WebElement searchBox;
    @FindBy(how = How.XPATH, using = "//p[contains(text(),'Customers')]")
    private List<WebElement> customerMenuItem;

    @FindBy(how = How.XPATH, using = "//a[@href='/Admin/Category/List']")
    private WebElement categoriesMenuItem;

    @FindBy(how = How.XPATH, using = "/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/ul/li[1]/a")
    private WebElement customerMenuOption;

    @FindBy(how = How.XPATH, using = "/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[2]/a/p")
    private WebElement catalogMenuOption;

    @FindBy(how = How.XPATH, using = "//p[contains(text(),'Products')]")
    private List<WebElement> productsMenuItem;

    public void clickOnCustomerMenu() {
        customerMenuItem.get(0).click();
    }

    public void clickOnCustomersMenuItem() {
        customerMenuOption.click();
    }

    public void clickOnCatalogMenu() {
        catalogMenuOption.click();
    }

    public void clickOnProductMenu() {
        productsMenuItem.get(0).click();
    }

    public void clickOnCategoriesMenuItem() {
        categoriesMenuItem.click();
    }
}
