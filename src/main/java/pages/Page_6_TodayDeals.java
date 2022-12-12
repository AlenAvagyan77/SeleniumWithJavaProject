package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Page_6_TodayDeals extends BasePage {
    public Page_6_TodayDeals(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Today's Deals")
    protected WebElement TodayDealsButton;
    @FindBy(xpath = "//div[@id=\"grid-main-container\"]/div[2]/span[3]/ul/li[33]")
    protected WebElement MensWatchesButton;
    @FindBy(linkText = "Watches from Fossil, Anne Klein, Timex, and more")
    protected WebElement WatchButton;
    @FindBy(id = "octopus-dlp-sort-option")
    protected WebElement FilterButton;
    @FindBy(linkText = "Newest Arrivals")
    protected WebElement NewestArrivals;
    @FindBy(xpath = "//*[@id=\"thumbImages\"]/ul/li[7]")
    protected WebElement BeforePlayVideoButton;
    @FindBy(xpath = "//*[@id=\"unrolledImgNo6\"]/div/div[12]/div/div/div[2]")
    protected WebElement PlayVideoButton;
    @FindBy(id = "add-to-cart-button")
    protected WebElement AddToCartButton;
    @FindBy(id = "nav-logo-sprites")
    protected WebElement MainPageButton;
    @FindBy(xpath = "//*[@id=\"unrolledImgNo6\"]/div/div[4]/div[1]")
    protected WebElement ZoomWindowButton;


    public void clickOnTheTodayDealButton() {
        TodayDealsButton.click();

    }

    public void scrollDownAndClickOnTheMenWatchesButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //Scroll down till the bottom of the page
        js.executeScript("window.scrollBy(0,800)");
    }

    public void waitUntilMensWatchesVisible() {
        MensWatchesButton.click();
    }

    public void scrollUpAndClickOnTheMenWatchesButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //Scroll down till the bottom of the page
        js.executeScript("window.scrollBy(0,-400)");
        WatchButton.click();

    }


    public void clickOnTheFilterButton() {
        FilterButton.click();
    }

    public void waitUntilMenButtonVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(4)).until(ExpectedConditions.elementToBeClickable(FilterButton));
    }

    public void clickOnTheNewestArrivals() {
        NewestArrivals.click();
    }

    public void waitWhileTheUserClickOnTheWatches(String TitleOfWatches) {
        new WebDriverWait(driver, Duration.ofMinutes(1)).until(ExpectedConditions.elementToBeClickable(By.linkText(TitleOfWatches)));
        WebElement element = driver.findElement(By.linkText(TitleOfWatches));
        element.click();
    }

    public void clickOnTheBeforePlayVideo() {
        new WebDriverWait(driver, Duration.ofSeconds(4)).until(ExpectedConditions.visibilityOf(BeforePlayVideoButton));
        BeforePlayVideoButton.click();
    }


    public void waitWhileElementIsNotVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(4)).until(ExpectedConditions.visibilityOf(PlayVideoButton));
        PlayVideoButton.click();
    }

    public void clickOnTheZoomWindowButton(){
        new WebDriverWait(driver, Duration.ofSeconds(4)).until(ExpectedConditions.elementToBeClickable(ZoomWindowButton));
        ZoomWindowButton.click();


    }

    public void clickOnTheAfterZoomWindowButton(){
        new WebDriverWait(driver, Duration.ofSeconds(4)).until(ExpectedConditions.elementToBeClickable(ZoomWindowButton));
        ZoomWindowButton.click();

    }
    public void clickAddToCartButton() {
        AddToCartButton.click();
    }

    public void clickOnTheMainPageButton() {
        MainPageButton.click();
    }

}

