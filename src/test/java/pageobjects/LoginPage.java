package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    @FindBy(how = How.ID, using = "Email")
    private WebElement userName;

    @FindBy(how = How.ID, using = "Password")
    private WebElement passWord;

    @FindBy(how = How.XPATH, using = "//button[contains(normalize-space(), 'Log in')]")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setUserName(String email) {
        userName.clear();
        userName.sendKeys(email);
    }

    public void setPassword(String password) {
        passWord.clear();
        passWord.sendKeys(password);
    }

    public void clickOnLogin() {
        loginButton.click();
    }

}
