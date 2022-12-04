import initDriver.BrowserType;
import initDriver.DriverFactory;
import org.openqa.selenium.WebDriver;
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
        todayDeals.waitForSelectRandomItemPageLoaded("Watches from Fossil, Anne Klein, Timex, and more");
        todayDeals.waitUntilMenButtonVisible();
        todayDeals.clickOnTheMenButton();
        Thread.sleep(1000);
        todayDeals.waitWhileTheUserClickOnTheWatches("Seiko Men's Japanese Mechanical Automatic Watch");
        todayDeals.clickOnTheBeforePlayVideo();
        todayDeals.waitWhileElementIsNotVisible();
        Thread.sleep(22000);
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
        productPrice.clickOnTheWAtches("Invicta Men's 10640 Pro Diver Diver Buckle 300m Watch");
        Thread.sleep(2000);
        productPrice.clickOnTheDetailsButton();
        Thread.sleep(2000);
        productPrice.getPriceOfWatches();
        productPrice.GetTextOfWatches();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(productPrice.getPriceOfWatches(), productPrice.ThePriceYouExpect("$100.33"));
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
        Page_4_CartSection cartSection = new Page_4_CartSection(DriverFactory.getDriver());
        cartSection.clickAddToCartButton();
        cartSection.clickCartSection();
        cartSection.deleteAllProductOfList();

    }

    @Test(priority = 5)
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

    }

    @Test(priority = 6)
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


