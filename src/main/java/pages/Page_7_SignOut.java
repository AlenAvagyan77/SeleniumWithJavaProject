package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Page_7_SignOut extends BasePage {

    public Page_7_SignOut(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "nav-link-accountList")
    protected WebElement AccountAndList;
    @FindBy(linkText = "Sign Out")
    protected WebElement SignOut;


    public void openPromptSection() {

        Actions actions = new Actions(driver);
        actions.moveToElement(AccountAndList).perform();
    }

    public void waitUntilToBeVisibleSignOutButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
        wait.until(ExpectedConditions.visibilityOf(AccountAndList));

    }

    public void clickOnTheSignOutButton() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
        wait.until(ExpectedConditions.visibilityOf(SignOut));
        SignOut.click();
    }
}
