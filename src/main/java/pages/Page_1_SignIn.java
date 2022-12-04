package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Page_1_SignIn extends BasePage {

    public Page_1_SignIn(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "/html/body/div[1]/header/div/div[4]/div[2]/div[2]/div/a[1]")
    protected WebElement TodayDealButton;
    @FindBy(id = "nav-link-accountList")
    protected WebElement clickLogInField;
    @FindBy(id = "continue")
    protected WebElement clickContinueButton;
    @FindBy(name = "rememberMe")
    protected WebElement checkBoxButton;
    @FindBy(id = "signInSubmit")
    protected WebElement clickSignInButton;

    public void clickLogInField() {
        clickLogInField.click();
    }

    public void writeLogIn(String InputLogin) {
        driver.findElement(By.id("ap_email")).sendKeys(InputLogin);
    }

    public void clickContinueButton() {
        clickContinueButton.click();
    }


    public void clickPasswordField(String InputPassword) {
        driver.findElement(By.id("ap_password")).sendKeys(InputPassword);
    }

    public void clickCheckBoxButton() {
        checkBoxButton.click();
    }

    public void clickSignInButton() {
        clickSignInButton.click();
    }
}
