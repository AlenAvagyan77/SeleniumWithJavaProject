package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Page_5_ChangeName extends BasePage {
    public Page_5_ChangeName(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "nav-link-accountList")
    protected WebElement AccountList;
    @FindBy(xpath = "//*[@id=\"a-page\"]/div[2]/div/div[3]/div[3]/a/div/div")
    protected WebElement YourProfile;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[2]/div/div/div/div[1]/form")
    protected WebElement YourNameLine;
    @FindBy(id = "name-edit-pencil-image")
    protected WebElement NameEdit;
    @FindBy(id = "profile-name-text-input")
    protected WebElement NameLine;
    @FindBy(xpath = "/html/body/div[3]/div/div/div/form/div[2]/span/span/input")
    protected WebElement SaveChanges;

    public void clickOnTheAccountList() {
        AccountList.click();
    }

    public void clickOnTheYourProfile() {
        YourProfile.click();
    }

    public void clickOnTheYourNameLine() {
        YourNameLine.click();
    }

    public void waitUntilVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
        wait.until(ExpectedConditions.elementToBeClickable(NameEdit));

    }

    public void clickOnTheNameEdit() {
        NameEdit.click();
    }

    public void changeName() {
        NameLine.click();
        NameLine.getAttribute("value");
        System.out.println("--- What is a username ? ---");
        System.out.println("Name was a : " + NameLine.getAttribute("value"));
        NameLine.clear();
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String fullName = firstName + " " + lastName;
        NameLine.sendKeys(fullName);
        System.out.println("Current name is an : " + fullName);

    }

    public void clickSaveChangesButton() {
        SaveChanges.click();
    }

    public void waitUntilSaveChangesVisible() {
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait1.until(ExpectedConditions.elementToBeClickable(SaveChanges));

    }
}
