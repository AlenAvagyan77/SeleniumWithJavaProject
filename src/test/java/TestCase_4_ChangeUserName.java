import initDriver.BrowserType;
import initDriver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;


public class TestCase_4_ChangeUserName {
    @BeforeMethod
    public void initDriver() {
        DriverFactory.initDriver(BrowserType.CHROME);
    }

    @Test
    public void SignInForAmazon() throws InterruptedException {
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
