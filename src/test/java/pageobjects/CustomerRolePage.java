package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class CustomerRolePage {
    WebDriver driver;

    public CustomerRolePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//a[@href='/Admin/Customer/Create']")
    private WebElement addNewButton;

    @FindBy(how = How.ID, using = "Email")
    private WebElement customerEmail;

    @FindBy(how = How.ID, using = "Password")
    private WebElement customerPassword;

    @FindBy(how = How.ID, using = "FirstName")
    private WebElement firstName;

    @FindBy(how = How.ID, using = "LastName")
    private WebElement lastName;

    @FindBy(how = How.ID, using = "IsTaxExempt")
    private WebElement taxExemptCheckbox;

    @FindBy(how = How.ID, using = "Gender_Male")
    private WebElement rb_male;

    @FindBy(how = How.ID, using = "Gender_Female")
    private WebElement rb_female;

    @FindBy(how = How.ID, using = "DateOfBirth")
    private WebElement dob;

    @FindBy(how = How.ID, using = "Company")
    private WebElement company;

    @FindBy(how = How.ID, using = "VendorId")
    private WebElement vendor;

    @FindBy(how = How.NAME, using = "save")
    private WebElement saveButton;

    @FindBy(how = How.NAME, using = "save-continue")
    private WebElement saveAndContinueButton;

    @FindBy(how = How.ID, using = "AdminComment")
    private WebElement adminComment;

    @FindBy(how = How.CSS, using = "div.alert.alert-success.alert-dismissable")
    private WebElement alertMessage;

    @FindBy(how = How.XPATH, using = "//span[@class='field-validation-error']")
    private WebElement validationMessage;

    @FindBy(how = How.ID, using = "SearchEmail")
    private WebElement searchEmail;

    @FindBy(how = How.ID, using = "SearchFirstName")
    private WebElement searchFirstName;

    @FindBy(how = How.ID, using = "SearchLastName")
    private WebElement searchLastName;

    @FindBy(how = How.ID, using = "SearchCompany")
    private WebElement searchCompany;

    @FindBy(how = How.ID, using = "SearchLastActivityFrom")
    private WebElement lastActivityFrom;

    @FindBy(how = How.ID, using = "SearchLastActivityTo")
    private WebElement lastActivityTo;

    @FindBy(how = How.ID, using = "SearchRegistrationDateFrom")
    private WebElement registrationDateFrom;

    @FindBy(how = How.ID, using = "SearchRegistrationDateTo")
    private WebElement registrationDateTo;

    @FindBy(how = How.ID, using = "SearchIpAddress")
    private WebElement ipAddress;

    @FindBy(how = How.ID, using = "search-customers")
    private WebElement searchButton;

    @FindBy(how = How.XPATH, using = "//table[@id='customers-grid']//td")
    private WebElement noResultMessage;

    @FindBy(how = How.XPATH, using = "//table[@id='customers-grid']/tbody/tr")
    private List<WebElement> customerList;

    @FindBy(how = How.CSS, using = "span#customer-delete")
    private WebElement customerDeleteButton;

    @FindBy(how = How.XPATH, using = "//div//button[contains(text(),'Delete')]")
    private WebElement confirmCustomerDeleteButton;

    public void setEmail(String email) {
        customerEmail.clear();
        customerEmail.sendKeys(email);
    }

    public void setFirstName(String lastname) {
        firstName.clear();
        firstName.sendKeys(lastname);
    }

    public void setLastName(String firstname) {
        lastName.clear();
        lastName.sendKeys(firstname);
    }

    public void addDOB(String DateOfBirth) {
        dob.sendKeys(DateOfBirth);
    }

    public void addComment(String comment) {
        adminComment.sendKeys(comment);
    }

    public String getMessage() {
        return alertMessage.getText();
    }

    public void clickOnCheckbox(WebElement checkboxElement) {
        if (!checkboxElement.isSelected()) {
            checkboxElement.click();
        }
    }

    public void setNewsLetter() {
        driver.findElements(By.xpath("//input[@role='searchbox']")).get(0).click();
    }

    public void clickOnTaxExemptCheckbox() {
        boolean taxExemptSelected = taxExemptCheckbox.isSelected();
        if (!taxExemptSelected) {
            taxExemptCheckbox.click();
        }
    }

    public List<WebElement> getCustomerList() {
        return customerList;
    }

    public void clickOnSaveButton() {
        saveButton.click();
    }

    public void clickOnAddNewButton() {
        addNewButton.click();
    }

    public String getValidationMessage() {
        return validationMessage.getText();
    }

    public void searchEmail(String email) {
        searchEmail.sendKeys(email);
    }

    public void clickOnSearchButton() {
        searchButton.click();
    }

    public void scrollIntoView() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", noResultMessage);
    }

    public String getMessageWhenNoResultsInTable() {
        return noResultMessage.getText();
    }

    public void clickOnEditButton(Integer rowNo) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        int rowCount = customerList.size();
        System.out.println("Row count is " + rowCount);

        Thread.sleep(5000);

        List<WebElement> rowDetails = driver.
                findElements(By.xpath("//table[@id='customers-grid']//tr/td"));
        for (WebElement rowElement : rowDetails) {
            if (rowElement.getText().equals("Edit")) {
                rowElement.click();
                break;
            }
        }
        Thread.sleep(5000);
    }

    public void clickOnEditButton() {
        driver.findElement(
                        By.xpath("//table[@id='customers-grid']/tbody/tr/td/a[contains(text(),'Edit')]"))
                .click();
    }

    public void clickOnConsumerDelete() throws InterruptedException {
        customerDeleteButton.click();
        Thread.sleep(1000);
        confirmCustomerDeleteButton.click();
        Thread.sleep(3000);
    }

    public String addCustomerInfoAndSave(String email, String firstname, String lastname) {
        setEmail(email);
        setFirstName(firstname);
        setLastName(lastname);
        clickOnSaveButton();
        return email;
    }
}
