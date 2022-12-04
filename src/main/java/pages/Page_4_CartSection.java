package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Page_4_CartSection extends BasePage{
    public Page_4_CartSection(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "add-to-cart-button")
    protected WebElement AddToCartButton;
    @FindBy(id = "nav-cart")
    protected WebElement CartSectionButton;
    @FindBy(className = "a-color-link")
    protected WebElement DeleteButton;

    public void clickAddToCartButton(){
        AddToCartButton.click();
    }
    public void waitForToBeVisibleAddToCartButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
        wait.until(ExpectedConditions.visibilityOf(AddToCartButton));
    }

    public void clickCartSection(){
        CartSectionButton.click();
    }
    public void deleteAllProductOfList() throws InterruptedException {
       List<WebElement> elements = driver.findElements(By.xpath("//img[@class = \"sc-product-image\"]"));
        for (int i = 0; i < elements.size(); i++) {
            DeleteButton.click();
            Thread.sleep(1000);

        }
    }

}
