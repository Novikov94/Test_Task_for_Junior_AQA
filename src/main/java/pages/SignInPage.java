package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {

    @FindBy(id = "username")
    private WebElement emailTextField;

    public WebElement getPasswordTextField() {
        return passwordTextField;
    }

    @FindBy(xpath = "//button[@type ='submit']")
    private WebElement submitBtn;

    @FindBy(id = "password")
    private WebElement passwordTextField;


    public boolean isEmailTextFieldVisible() {
        emailTextField.isDisplayed();
        return true;
    }

    public boolean isPasswordTextFieldVisible() {
        passwordTextField.isDisplayed();
        return true;
    }

    public void enterEmail(final String email) {
        emailTextField.sendKeys(email);
    }

    public void enterPassword(final String password) {
        passwordTextField.sendKeys(password);
    }

    public void clickOnSubmitBtn() {
        submitBtn.click();
    }

    public SignInPage(WebDriver driver) {
        super(driver);
    }
}
