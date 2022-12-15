package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Page_2_UsersLocation extends BasePage {
    public Page_2_UsersLocation(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "nav-global-location-data-modal-action")
    protected WebElement DeliverToButton;
    @FindBy(xpath = "//*[@id=\"GLUXCountryValue\"]")
    protected WebElement openChooseSection;
    @FindBy(id = "GLUXCountryList_6")
    protected WebElement UnitedKingdomButton;
    @FindBy(name = "glowDoneButton")
    protected WebElement DoneButton;

    public void clickDeliverToButton() {
        DeliverToButton.click();
    }

    public void openChooseSection() {
        System.out.println();
        System.out.println("--- Where is the user from ? ---");
        openChooseSection.click();
        openChooseSection.getText();
        String Title = openChooseSection.getText();
        System.out.println("The user location is a : " + Title);
    }


    public void checkWhereTheUserIsFrom() throws InterruptedException {
        String Title = openChooseSection.getText();
        if (Title.equals("Armenia")) {
            UnitedKingdomButton.click();
            Thread.sleep(2000);
            System.out.println("It has changed because he is from : " + Title);
            DoneButton.click();
        } else {
            DoneButton.click();
            System.out.println("It has not changed because He is from the : United Kingdom");

        }
        Thread.sleep(2000);
        System.out.println();
    }

}
