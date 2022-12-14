package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Page_1_SignIn extends BasePage {

    public Page_1_SignIn(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "nav-link-accountList")
    protected WebElement AccountAndListButton;
    @FindBy(id = "continue")
    protected WebElement ContinueButton;
    @FindBy(name = "rememberMe")
    protected WebElement CheckBoxButton;
    @FindBy(id = "signInSubmit")
    protected WebElement SignInButton;

    public void clickAccountAndListButton() {
        AccountAndListButton.click();
    }

    public void writeLogIn(String InputLogin) {
        driver.findElement(By.id("ap_email")).sendKeys(InputLogin);
    }

    public void clickContinueButton() {
        ContinueButton.click();
    }


    public void clickPasswordField(String InputPassword) {
        driver.findElement(By.id("ap_password")).sendKeys(InputPassword);
    }

    public void clickCheckBoxButton() {
        CheckBoxButton.click();
    }

    public void clickSignInButton() {
        SignInButton.click();
    }
}
