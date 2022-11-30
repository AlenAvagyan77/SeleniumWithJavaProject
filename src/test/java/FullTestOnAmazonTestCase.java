import initDriver.BrowserType;
import initDriver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
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

    @Test(priority = 3)
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

    @Test(priority = 4)
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

    @Test(priority = 5)
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


