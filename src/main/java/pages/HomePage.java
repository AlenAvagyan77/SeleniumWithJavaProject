package pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    protected final String HOME_URL = "https://www.amazon.com";

    public void openHomePage() {
        driver.manage().window().maximize();
        driver.get(HOME_URL);
    }

    public String ActualURL(){
        return driver.getCurrentUrl();

    }
    public String ExpectedURL(){
        return "https://www.amazon.com/";
    }

}
