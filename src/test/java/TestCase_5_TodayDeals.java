import initDriver.BrowserType;
import initDriver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
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
        Page_1_SignIn signIn = new Page_1_SignIn(DriverFactory.getDriver());
        signIn.clickLogInField();
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
        todayDeals.waitUntilMensWatchesVisible();
        todayDeals.waitForSelectRandomItemPageLoaded("Watches from Fossil, Anne Klein, Timex, and more");
        todayDeals.waitUntilMenButtonVisible();
        todayDeals.clickOnTheMenButton();
        todayDeals.waitWhileTheUserClickOnTheWatches("Seiko Men's Japanese Mechanical Automatic Watch");
        todayDeals.clickOnTheBeforePlayVideo();
        todayDeals.waitWhileElementIsNotVisible();
        Thread.sleep(22000);
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
