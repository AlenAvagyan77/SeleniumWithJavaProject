import initDriver.BrowserType;
import initDriver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.Page_1_SignIn;
import pages.Page_6_TodayDeals;
import pages.Page_7_SignOut;

public class TestCase_5_TodayDeals {
    @BeforeMethod
    public void initDriver() {
        DriverFactory.initDriver(BrowserType.CHROME);
    }

    @Test
    public void SignInForAmazon() {
        HomePage homePage = new HomePage(DriverFactory.getDriver());
        homePage.openHomePage();
        Assert.assertEquals(homePage.ActualTitle(), homePage.ExpectedTitle());
        System.out.println("--- Opened the correct Amazon page ---");
        Page_1_SignIn signIn = new Page_1_SignIn(DriverFactory.getDriver());
        signIn.clickAccountAndListButton();
        signIn.writeLogIn("043444255");
        signIn.clickContinueButton();
        signIn.clickPasswordField("043444255");
        signIn.clickCheckBoxButton();
        signIn.clickSignInButton();
    }

    @Test(priority = 1)
    public void TodayDeals() throws InterruptedException {
        Page_6_TodayDeals todayDeals = new Page_6_TodayDeals(DriverFactory.getDriver());
        todayDeals.clickOnTheTodayDealButton();
        todayDeals.scrollDownAndClickOnTheMenWatchesButton();
        Thread.sleep(1000);
        todayDeals.waitUntilMensWatchesVisible();
        Thread.sleep(2000);
        todayDeals.scrollUpAndClickOnTheMenWatchesButton();
        Thread.sleep(2000);
        todayDeals.clickOnTheFilterButton();
        Thread.sleep(1000);
        todayDeals.clickOnTheDiscountHighToLow();
        Thread.sleep(2000);
        todayDeals.waitWhileTheUserClickOnTheWatches("Save on Nautica Men's NAPOBS110 Ocean Beach Yellow-Gold/Black/Black Silicone Strap Watch and more");
        Thread.sleep(2000);
        todayDeals.clickOnThePrimeButton();
        todayDeals.clickSecondTimeFilterButton();
        todayDeals.clickOnThePriceHighToLow();
        todayDeals.waitWhileTheUserClickOnTheSecondWatches("Nautica Men's Quartz Resin Silicone Watch");
        todayDeals.clickOnTheBeforePlayVideo();
        Thread.sleep(2000);
        todayDeals.waitWhileElementIsNotVisible();
        todayDeals.clickOnTheZoomWindowButton();
        Thread.sleep(22000);
        todayDeals.clickOnTheAfterZoomWindowButton();
        todayDeals.clickAddToCartButton();
        todayDeals.clickOnTheMainPageButton();

    }
    @Test(priority = 2)
    public void SignOut() throws InterruptedException {
        Page_7_SignOut signOut = new Page_7_SignOut(DriverFactory.getDriver());
        signOut.openPromptSection();
        Thread.sleep(1500);
        signOut.clickOnTheSignOutButton();
    }


    @AfterTest
    public void tearDown() {
        WebDriver driver = DriverFactory.getDriver();
        if (driver != null) {
            driver.quit();
        }
    }
}
