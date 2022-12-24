package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Page_6_TodayDeals extends BasePage {
    public Page_6_TodayDeals(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Today's Deals")
    protected WebElement TodayDealsButton;
    @FindBy(xpath = "//div[@id=\"grid-main-container\"]/div[2]/span[3]/ul/li[31]")
    protected WebElement MensWatchesButton;
    @FindBy(xpath = "//span[@id=\"sorting_dropdown0\"]")
    protected WebElement FirstFilterButton;
    @FindBy(xpath = "//*[@id=\"search\"]/span/div/h1/div/div[2]/div/div/form/span")
    protected WebElement FilterButton;
    @FindBy(linkText = "Discount - High to Low")
    protected WebElement DiscountHighToLow;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div[5]/div[2]/div[1]/div[2]/div[2]/div/div[1]/div/div/div[1]/ul/li[4]")
    protected WebElement BeforePlayVideoButton;
    @FindBy(xpath = "//div[@id=\"unrolledImgNo3\"]/div/div[12]/div/div/div[2]")
    protected WebElement PlayVideoButton;
    @FindBy(id = "add-to-cart-button")
    protected WebElement AddToCartButton;
    @FindBy(id = "nav-logo-sprites")
    protected WebElement MainPageButton;
    @FindBy(xpath = "//div[@id=\"unrolledImgNo3\"]/div/div[4]/div[1]")
    protected WebElement ZoomWindowButton;
    @FindBy(xpath = "//div[@id=\"s-refinements\"]/div[3]/ul/li/span/a/div")
    protected WebElement PrimeButton;
    @FindBy(linkText = "Price: Low to High")
    protected WebElement PriceLowToHighButton;


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
        js.executeScript("window.scrollBy(0,-600)");


    }


    public void clickOnTheFilterButton() {
        new WebDriverWait(driver, Duration.ofSeconds(4)).until(ExpectedConditions.visibilityOf(FirstFilterButton));
        FirstFilterButton.click();
    }

    public void clickOnTheDiscountHighToLow() {
        DiscountHighToLow.click();
    }

    public void waitWhileTheUserClickOnTheWatches(String TitleOfWatches) {
        new WebDriverWait(driver, Duration.ofMinutes(1)).until(ExpectedConditions.elementToBeClickable(By.linkText(TitleOfWatches)));
        WebElement element = driver.findElement(By.linkText(TitleOfWatches));
        element.click();
    }

    public void waitUntilMenButtonVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(4)).until(ExpectedConditions.elementToBeClickable(FilterButton));
    }

    public void clickOnThePrimeButton() {
        new WebDriverWait(driver, Duration.ofSeconds(4)).until(ExpectedConditions.visibilityOf(PrimeButton));
        PrimeButton.click();
    }

    public void clickSecondTimeFilterButton() {
        new WebDriverWait(driver, Duration.ofSeconds(4)).until(ExpectedConditions.visibilityOf(FilterButton));
        FilterButton.click();
    }

    public void clickOnThePriceLowToHigh() {
        PriceLowToHighButton.click();
    }


    public void waitWhileTheUserClickOnTheSecondWatches(String TitleOfWatches) {
        new WebDriverWait(driver, Duration.ofSeconds(4)).until(ExpectedConditions.elementToBeClickable(By.linkText(TitleOfWatches)));
        WebElement element = driver.findElement(By.linkText(TitleOfWatches));
        element.click();
    }

    public void clickOnTheBeforePlayVideo() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(6)).until(ExpectedConditions.visibilityOf(BeforePlayVideoButton));
            BeforePlayVideoButton.click();
        } catch (Exception e) {
            System.out.println("I couldn't click on the BeforePlayVideo");
        }
    }


    public void waitWhileElementIsNotVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(4)).until(ExpectedConditions.visibilityOf(PlayVideoButton));
        PlayVideoButton.click();
    }

    public void clickOnTheZoomWindowButton() {
        new WebDriverWait(driver, Duration.ofSeconds(4)).until(ExpectedConditions.elementToBeClickable(ZoomWindowButton));
        ZoomWindowButton.click();


    }

    public void clickOnTheAfterZoomWindowButton() {
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

