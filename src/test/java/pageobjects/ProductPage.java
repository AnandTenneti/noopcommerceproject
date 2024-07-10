package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(how = How.XPATH, using = "//a[@href='/Admin/Product/Create']")
    private WebElement addNewButton;

    @FindBy(how = How.ID, using = "Name")
    private WebElement productName;


    @FindBy(how = How.XPATH, using = "//textarea[@name='ShortDescription']")
    private WebElement shortDescription;

    @FindBy(how = How.NAME, using = "save")
    private WebElement saveButton;

    @FindBy(how = How.XPATH, using = "//h1[contains(text(),'Add a new product')]")
    private WebElement headerElement;

    @FindBy(how = How.CSS, using = "div.alert.alert-success.alert-dismissable")
    private WebElement configurationMessage;

    @FindBy(how = How.XPATH, using = "//span[@class='field-validation-error']")
    private WebElement validationMessage;

    @FindBy(how = How.ID, using = "search-products")
    private WebElement searchProductsButton;

    @FindBy(how = How.ID, using = "SearchProductName")
    private WebElement searchProductName;

    @FindBy(how = How.XPATH, using = "//table[@id='products-grid']//td")
    private WebElement gridMessage;

    public void productDetails() {
        productName.sendKeys("Apple Mac book");
        shortDescription.sendKeys("Brief description about the product");
    }

    public void clickOnSaveButton() {
        saveButton.click();
    }

    public void clickOnAddNewbutton() {
        addNewButton.click();
    }

    public String getHeader() {
        return headerElement.getText();
    }

    public String getMessage() {
        return configurationMessage.getText();
    }

    public String getValidationMessage() {
        return validationMessage.getText();
    }

    public void setProductName(String pName) {
        productName.sendKeys(pName);
    }

    public void setProductShortDescription(String shortDesc) {
        shortDescription.sendKeys(shortDesc);
    }

    public void clickOnSearchProductsButton() {
        searchProductsButton.click();
    }

    public void enterSearchProductName() {
        searchProductName.sendKeys("New Product test123");
    }

    public String viewMessage() {
        return gridMessage.getText();

    }


}
