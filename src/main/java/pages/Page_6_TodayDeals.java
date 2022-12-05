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
    @FindBy(xpath = "//div[@id=\"refinement-department\"]/ul/li/span/ul/li[2]/span/span/span")
    protected WebElement MenButton;
    @FindBy(xpath = "//span[@id=\"a-autoid-6\"]/span/input")
    protected WebElement BeforePlayVideoButton;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div[5]/div[2]/div[1]/div[2]/div[1]/div/div[1]/div/div/div[2]/div/div[3]/ul/li[7]/span/span/div/div/div/div[12]/div/div")
    protected WebElement PlayVideoButton;
    @FindBy(id = "add-to-cart-button")
    protected WebElement AddToCartButton;
    @FindBy(id = "nav-logo-sprites")
    protected WebElement MainPageButton;


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

    public void waitForSelectRandomItemPageLoaded(String TitleOfWatches) {
        new WebDriverWait(driver, Duration.ofMinutes(1)).until(ExpectedConditions.elementToBeClickable(By.linkText(TitleOfWatches)));
        WebElement element = driver.findElement(By.linkText(TitleOfWatches));
        element.click();
    }

    public void clickOnTheMenButton() {
        MenButton.click();
    }

    public void waitUntilMenButtonVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(4)).until(ExpectedConditions.elementToBeClickable(MenButton));
    }

    public void waitWhileTheUserClickOnTheWatches(String TitleOfWatches) {
        new WebDriverWait(driver, Duration.ofMinutes(1)).until(ExpectedConditions.elementToBeClickable(By.linkText(TitleOfWatches)));
        WebElement element = driver.findElement(By.linkText(TitleOfWatches));
        element.click();
    }

    public void clickOnTheBeforePlayVideo() {
        BeforePlayVideoButton.click();
    }

    public void waitWhileElementIsNotVisible() {
        new WebDriverWait(driver, Duration.ofMinutes(1)).until(ExpectedConditions.visibilityOf(PlayVideoButton));
        PlayVideoButton.click();
    }

    public void clickAddToCartButton() {
        AddToCartButton.click();
    }

    public void clickOnTheMainPageButton() {
        MainPageButton.click();
    }

}

