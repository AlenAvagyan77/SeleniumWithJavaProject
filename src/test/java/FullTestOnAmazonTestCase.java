import initDriver.BrowserType;
import initDriver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;

public class FullTestOnAmazonTestCase {
    @BeforeMethod
    public void initDriver() {
        DriverFactory.initDriver(BrowserType.CHROME);
    }

    @Test
    public void SignInForAmazon() throws InterruptedException {
        HomePage homePage = new HomePage(DriverFactory.getDriver());
        homePage.openHomePage();
        homePage.openCorrectPage();
        Assert.assertEquals(homePage.ActualTitle(), homePage.ExpectedTitle());
        System.out.println("--- Opened the correct Amazon page ---");
        Page_1_SignIn signIn = new Page_1_SignIn(DriverFactory.getDriver());
        signIn.clickAccountAndListButton();
        signIn.writeLogIn("043444255");
        signIn.clickContinueButton();
        signIn.clickPasswordField("043444255");
        signIn.clickCheckBoxButton();
        signIn.clickSignInButton();
        Thread.sleep(12000);


    }

    @Test(priority = 1)
    public void UserLocation() throws InterruptedException {
        Page_2_UsersLocation usersLocation = new Page_2_UsersLocation(DriverFactory.getDriver());
        usersLocation.clickDeliverToButton();
        Thread.sleep(2000);
        usersLocation.openChooseSection();
        usersLocation.checkWhereTheUserIsFrom();
        Thread.sleep(2000);
    }

    @Test(priority = 2)
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
        todayDeals.clickOnThePriceLowToHigh();
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


    @Test(priority = 3)
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


    @Test(priority = 4)
    public void SearchProduct() throws InterruptedException {
        Page_3_SearchProduct searchProduct = new Page_3_SearchProduct(DriverFactory.getDriver());
        searchProduct.waitForToBeVisibleSearchField("Dell Vostro 3515 8GB Ram, 256 SSD, Ryzen 5");
        searchProduct.clickSearchButton();
        searchProduct.clickOnTheProduct();
        searchProduct.clickAddToCartButton();

    }

    @Test(priority = 5)
    public void DeleteAllProductsFromCart() throws InterruptedException {
        Page_4_CartSection cartSection = new Page_4_CartSection(DriverFactory.getDriver());
        cartSection.clickCartSection();
        cartSection.deleteAllProductOfList();
    }

    @Test(priority = 6)
    public void ChangeName() {
        Page_5_ChangeName changeName = new Page_5_ChangeName(DriverFactory.getDriver());
        changeName.clickOnTheAccountList();
        changeName.clickOnTheYourProfile();
        changeName.clickOnTheYourNameLine();
        changeName.waitUntilVisible();
        changeName.clickOnTheNameEdit();
        changeName.changeName();
        changeName.waitUntilSaveChangesVisible();
        changeName.clickSaveChangesButton();
        changeName.clickOnTheHomePage();

    }

    @Test(priority = 7)
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


