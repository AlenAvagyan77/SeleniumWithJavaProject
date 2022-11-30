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
    protected WebElement TodayDeals;
    @FindBy(xpath = "/html/body/div[1]/div[21]/div/div/div/div[2]/div[2]/span[3]/ul/li[33]/label/input")
    protected WebElement MensWatches;
    @FindBy(xpath = "//div[@id=\"refinement-department\"]/ul/li/span/ul/li[2]/span/span/span")
    protected WebElement MenButton;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div[5]/div[2]/div[1]/div[2]/div[1]/div/div[1]/div/div/div[1]/ul/li[9]/span/span/span/input")
    protected WebElement BeforePlayVideo;
    @FindBy(xpath = "//div[@id=\"main-video-container\"]/div/div[12]/div/div/div[2]")
    protected WebElement PlayVideo;
    @FindBy(id = "add-to-cart-button")
    protected WebElement AddToCartButton;
    @FindBy(id = "nav-logo-sprites")
    protected WebElement MainPage;
    @FindBy(xpath = "//*[@id=\"altImages\"]/ul/li")
    protected List<WebElement> ListOfImages;
    @FindBy(xpath = "//*[@id=\"altImages\"]/ul/li")
    protected WebElement ButtonOfImages;




    public void clickOnTheTodayDealButton() {
        TodayDeals.click();

    }

    public void scrollDownAndClickOnTheMenWatchesButton(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //Scroll down till the bottom of the page
        js.executeScript("window.scrollBy(0,1000)");
        MensWatches.click();
    }

    public void waitUntilMensWatchesVisible(){
        new WebDriverWait(driver, Duration.ofMinutes(1)).until(ExpectedConditions.visibilityOf(MensWatches));
    }

    public void waitForSelectRandomItemPageLoaded(String TitleOfWatches) {
        new WebDriverWait(driver, Duration.ofMinutes(1)).until(ExpectedConditions.elementToBeClickable(By.linkText(TitleOfWatches)));
        WebElement element = driver.findElement(By.linkText(TitleOfWatches));
        element.click();
    }

    public void clickOnTheMenButton(){
        MenButton.click();
    }
    public void waitUntilMenButtonVisible(){
        new WebDriverWait(driver, Duration.ofMinutes(1)).until(ExpectedConditions.elementToBeClickable(MenButton));
    }

    public void waitWhileTheUserClickOnTheWatches(String TitleOfWatches) {
        new WebDriverWait(driver, Duration.ofMinutes(1)).until(ExpectedConditions.elementToBeClickable(By.linkText(TitleOfWatches)));
        WebElement element = driver.findElement(By.linkText(TitleOfWatches));
        element.click();
    }
    public void clickEveryItem() throws InterruptedException {
        for (int i = 0; i < ListOfImages.size(); i++) {
            ButtonOfImages.click();
            Thread.sleep(1000);
        }
    }

    public void clickOnTheBeforePlayVideo(){
        BeforePlayVideo.click();
    }
    public void waitWhileElementIsNotVisible(){
        new WebDriverWait(driver, Duration.ofMinutes(1)).until(ExpectedConditions.visibilityOf(PlayVideo));
        PlayVideo.click();
    }

    public void clickAddToCartButton(){
        AddToCartButton.click();
    }

    public void clickOnTheMainPageButton(){
        MainPage.click();
    }

}

