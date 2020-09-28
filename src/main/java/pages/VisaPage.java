package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.JavascriptUtils;

import static utils.SeleniumUtils.*;

import java.util.List;

public class VisaPage extends AbstractPage{

    @FindBy(xpath = "//span[contains(text(), 'India')]/..")
    private WebElement fromCountry;

    @FindBy(xpath = "(//input[@class='chosen-search-input'])[7]")
    private WebElement fromCountryInput;

    @FindBy(xpath = "//span[contains(text(), 'United States')]")
    private WebElement toCountry;

    @FindBy(xpath = "(//input[@class='chosen-search-input'])[8]")
    private WebElement toCountryInput;

    @FindBy(xpath = "//input[@name='date']")
    private WebElement date;

    @FindBy(xpath = "//*[@id='datepickers-container']/div[3]/div/div/div[2]/div")
    private List<WebElement> dataPickerDays;

    @FindBy(xpath = "//button[contains(text(), 'Submit')]")
    private WebElement submitButton;

    public VisaPage(WebDriver driver) {
        super(driver);
    }

    public void completeForm() {
        fromCountry.click();
        fromCountryInput.sendKeys("Argentina");
        fromCountryInput.sendKeys(Keys.ENTER);
        toCountry.click();
        toCountryInput.sendKeys("china");
        toCountryInput.sendKeys(Keys.ENTER);
        date.click();
        waitForElementVisibility(driver, dataPickerDays.get(0));
        JavascriptUtils.click(driver, selectDatePickerDay(dataPickerDays, "28"));
        JavascriptUtils.click(driver, submitButton);

    }

}
