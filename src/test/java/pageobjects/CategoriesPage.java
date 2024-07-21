package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CategoriesPage {

    WebDriver driver;

    public CategoriesPage(WebDriver driver) {
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    /**
     * Identifying Web Elements
     */

    @FindBy(how = How.XPATH, using = "//a[@href='/Admin/Category/Create']")
    private WebElement addNewCategoryButton;

    @FindBy(how = How.ID, using = "Name")
    private WebElement categoryName;

    @FindBy(how = How.ID, using = "Description_ifr")
    private WebElement descriptionIframe;

    @FindBy(how = How.CSS, using = "body#tinymce")
    private WebElement categoryDescription;

    @FindBy(how = How.ID, using = "ParentCategoryId")
    private WebElement parentCategory;

    @FindBy(how = How.ID, using = "DisplayOrder")
    private WebElement displayOrder;

    @FindBy(how = How.XPATH, using = "//a[@href='/Admin/Category/List']")
    private WebElement backToCategoryList;

    @FindBy(how = How.NAME, using = "save")
    private WebElement saveButton;

    @FindBy(how = How.NAME, using = "save-continue")
    private WebElement saveAndContinueButton;

    @FindBy(how = How.CSS, using = "div.alert.alert-success.alert-dismissable")
    private WebElement configurationMessage;

    @FindBy(how = How.ID, using = "SearchCategoryName")
    private WebElement searchCategoryName;

    @FindBy(how = How.ID, using = "search-categories")
    private WebElement searchCategoriesButton;

    @FindBy(how = How.XPATH, using = "//table[@id='categories-grid']/tbody/tr")
    private List<WebElement> categoriesList;

    /**
     * Adding methods for the different interactions within the Categories page
     **/

    public void clickOnSaveButton() {
        saveButton.click();
    }

    public void clickOnSaveAndContinueButton() {
        saveAndContinueButton.click();
    }

    public void clickOnAddNewCategory() {
        addNewCategoryButton.click();
    }

    public void setCategoryName(String cname) {
        categoryName.clear();
        categoryName.sendKeys(cname);
    }

    public void setCategoryDescription(String description) {
        //Switch to description Frame
        driver.switchTo().frame("Description_ifr");
        //Enter category description
        categoryDescription.clear();
        categoryDescription.sendKeys(description);
        driver.switchTo().defaultContent();
    }

    public void selectParentCategory(int index) {
        Select selectParentCategory = new Select(parentCategory);
        selectParentCategory.selectByIndex(index);
    }

    public String getConfigurationMessage() {
        return configurationMessage.getText();
    }

    public void enterSearchCategoryName(String categoryName) {
        searchCategoryName.sendKeys(categoryName);
    }

    public void clickOnSearchCategoriesButton() {
        searchCategoriesButton.click();
    }

    public List<WebElement> getCategorySearchResults() {
        return categoriesList;

    }
}
