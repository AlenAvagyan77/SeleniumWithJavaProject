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
import pages.Page_8_ProductPrice;

public class TestCase_6_ForProductPrice {
    @BeforeMethod
    public void initDriver() {
        DriverFactory.initDriver(BrowserType.CHROME);
    }


    @Test
    public void SignInForAmazon() throws InterruptedException {
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
    public void ProductPrice() throws InterruptedException {
        Page_8_ProductPrice productPrice = new Page_8_ProductPrice(DriverFactory.getDriver());
        productPrice.waitUntilTodayDealButtonToBeVisibleAndClick();
        productPrice.scrollDownAndClickOnTheMenWatchesButton();
        Thread.sleep(1000);
        productPrice.clickOnTheMenWatchesButton();
        Thread.sleep(3000);
        productPrice.srollUpAndClickOnTheFilterButton();
        Thread.sleep(3000);
        productPrice.clickOnTheFilterButton();
        Thread.sleep(1000);
        productPrice.clickOnTheDiscountLowToHighButton();
        productPrice.clickOnTheWAtches("Nautica Men's Quartz Stainless Steel Strap, Silver, 22 Casual Watch (Model: NAPGLF110)");
        Thread.sleep(2000);
        productPrice.clickOnTheDetailsButton();
        Thread.sleep(2000);
        productPrice.GetTextOfWatches();
        productPrice.getPriceOfWatches();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(productPrice.getPriceOfWatches(), productPrice.ThePriceYouExpect("$161.24"));
        softAssert.assertAll("Please enter correct price, Correct  price is a " + productPrice.getPriceOfWatches());
        productPrice.clickAddToCartButton();
        productPrice.clickOnTheMainPageButton();
    }


    @AfterTest
    public void tearDown() {
        WebDriver driver = DriverFactory.getDriver();
        if (driver != null) {
            driver.quit();
        }
    }
}
