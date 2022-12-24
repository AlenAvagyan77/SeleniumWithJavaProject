package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Page_3_SearchProduct extends BasePage {

    public Page_3_SearchProduct(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "add-to-cart-button")
    protected WebElement AddToCartButton;
    @FindBy(id = "twotabsearchtextbox")
    protected WebElement productField;
    @FindBy(id = "nav-search-submit-button")
    protected WebElement clickSearchButton;

    public void waitForToBeVisibleSearchField(String enterProductName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
        wait.until(ExpectedConditions.visibilityOf(productField));
        productField.click();
        productField.sendKeys(enterProductName);
        System.out.println("--- What product did the user search for ? ---");
        System.out.println("User has searched : " + enterProductName);
        System.out.println();

    }


    public void clickSearchButton() {
        clickSearchButton.click();
    }

    public void clickOnTheProduct() {
        driver.findElement(By.linkText("2021 Newest Dell Inspiron 15 3000 3501 Laptop, 15.6\" Full HD 1080P Screen, 11th Gen Intel Core i5-1135G7 Quad-Core Processor, 16GB RAM, 256GB SSD + 1TB HDD, Webcam, HDMI, Wi-Fi, Windows 10 Home, Black")).click();

    }
    public void clickAddToCartButton(){
        AddToCartButton.click();
    }
    public void waitForToBeVisibleAddToCartButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
        wait.until(ExpectedConditions.visibilityOf(AddToCartButton));
    }


}
