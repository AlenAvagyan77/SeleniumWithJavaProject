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
    protected WebElement AccountListButton;
    @FindBy(xpath = "//*[@id=\"a-page\"]/div[2]/div/div[3]/div[3]/a/div/div")
    protected WebElement YourProfileButton;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[2]/div/div/div/div[1]/form")
    protected WebElement YourNameLineButton;
    @FindBy(id = "name-edit-pencil-image")
    protected WebElement NameEditButton;
    @FindBy(id = "profile-name-text-input")
    protected WebElement NameLineButton;
    @FindBy(xpath = "/html/body/div[3]/div/div/div/form/div[2]/span/span/input")
    protected WebElement SaveChangesButton;

    public void clickOnTheAccountList() {
        AccountListButton.click();
    }

    public void clickOnTheYourProfile() {
        YourProfileButton.click();
    }

    public void clickOnTheYourNameLine() {
        YourNameLineButton.click();
    }

    public void waitUntilVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
        wait.until(ExpectedConditions.elementToBeClickable(NameEditButton));

    }

    public void clickOnTheNameEdit() {
        NameEditButton.click();
    }

    public void changeName() {
        NameLineButton.click();
        NameLineButton.getAttribute("value");
        System.out.println("--- What is a username ? ---");
        System.out.println("Name was a : " + NameLineButton.getAttribute("value"));
        NameLineButton.clear();
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String fullName = firstName + " " + lastName;
        NameLineButton.sendKeys(fullName);
        System.out.println("Current name is an : " + fullName);

    }

    public void clickSaveChangesButton() {
        SaveChangesButton.click();
    }

    public void waitUntilSaveChangesVisible() {
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait1.until(ExpectedConditions.elementToBeClickable(SaveChangesButton));

    }
}
