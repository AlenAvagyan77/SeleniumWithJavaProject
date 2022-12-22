package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Page_8_ProductPrice extends BasePage {

    public Page_8_ProductPrice(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "nav-logo-sprites")
    protected WebElement MainPageButton;
    @FindBy(xpath = "/html/body/div[1]/header/div/div[4]/div[2]/div[2]/div/a[1]")
    protected WebElement TodayDealButton;
    @FindBy(xpath = "//div[@id=\"grid-main-container\"]/div[2]/span[3]/ul/li[32]")
    protected WebElement MensWatchesButton;
    @FindBy(className = "a-dropdown-container")
    protected WebElement FilterButton;
    @FindBy(linkText = "Price - High to Low")
    protected WebElement PriceHighToLow;
    @FindBy(xpath = "//div[@id=\"amazonGlobal_feature_div\"]/span[2]/a")
    protected WebElement DetailsButton;
    @FindBy(xpath = "//*[@id=\"a-popover-content-3\"]/table/tbody/tr[1]/td[3]/span")
    protected WebElement PriceOfWatche;
    @FindBy(id = "add-to-cart-button")
    protected WebElement AddToCartButton;
    @FindBy(xpath = "//div[@id=\"grid-main-container\"]/div[3]/div/div[1]")
    protected WebElement WatchesButton;

    public void waitUntilMainPageButtonToBeVisibleAndClick() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(4));
        wait.until(ExpectedConditions.visibilityOf(MainPageButton));
        MainPageButton.click();
    }

    public void waitUntilTodayDealButtonToBeVisibleAndClick() {
        new WebDriverWait(driver, Duration.ofMinutes(1)).until(ExpectedConditions.visibilityOf((TodayDealButton)));
        TodayDealButton.click();
    }

    public void scrollDownAndClickOnTheMenWatchesButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //Scroll down till the bottom of the page
        js.executeScript("window.scrollBy(0,1000)");
    }


    public void clickOnTheMenWatchesButton() {
        new WebDriverWait(driver, Duration.ofMinutes(1)).until(ExpectedConditions.visibilityOf((MensWatchesButton)));
        MensWatchesButton.click();
    }

    public void srollUpAndClickOnTheFilterButton() {
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        //Scroll up till the bottom of the page
        js1.executeScript("window.scrollBy(0,-800)");

    }

    public void clickOnTheFilterButton() {
        new WebDriverWait(driver, Duration.ofSeconds(4)).until(ExpectedConditions.elementToBeClickable(FilterButton));
        FilterButton.click();
    }

    public void clickOnTheDiscountLowToHighButton() {
        PriceHighToLow.click();
    }
    public void clickOnTheWAtches(String enterWatches){
        new WebDriverWait(driver, Duration.ofMinutes(1)).until(ExpectedConditions.elementToBeClickable(By.linkText(enterWatches)));
        WebElement element = driver.findElement(By.linkText(enterWatches));
        element.click();

    }


    public void clickOnTheDetailsButton() {
        DetailsButton.click();
    }

    public void GetTextOfWatches() {
        System.out.println("--- How much to price of watch ? ---");
        System.out.println("Price is a " + PriceOfWatche.getText());
        System.out.println();
    }

    public String getPriceOfWatches() {
        return PriceOfWatche.getText();
    }

    public String ThePriceYouExpect(String enterThePrice) {
        return enterThePrice;
    }
    public void clickAddToCartButton(){
        AddToCartButton.click();
    }
    public void clickOnTheMainPageButton(){
        MainPageButton.click();
    }
}














































