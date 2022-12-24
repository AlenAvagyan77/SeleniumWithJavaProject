package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Page_4_CartSection extends BasePage{
    public Page_4_CartSection(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "nav-cart")
    protected WebElement CartSectionButton;
    @FindBy(className = "a-color-link")
    protected WebElement DeleteButton;


    public void clickCartSection(){
        CartSectionButton.click();
    }
    public void deleteAllProductOfList() throws InterruptedException {
       List<WebElement> elements = driver.findElements(By.xpath("//img[@class = \"sc-product-image\"]"));
        System.out.println("--- How many items were in your cart? ---");
        System.out.println("There was" + " " + elements.size() + " " + "item in your cart.");
        System.out.println();
        for (int i = 0; i < elements.size(); i++) {
            DeleteButton.click();
            Thread.sleep(1000);

        }
    }

}
