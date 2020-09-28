package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static utils.SeleniumUtils.selectDatePickerDay;

public class HotelPage extends AbstractPage {

    @FindBy(xpath = "(//span[contains(text(), 'Search by Hotel or City')]/../..)[1]")
    private WebElement destinationWrapper;

    @FindBy(xpath = "(//div[@class='select2-search'])[8]")
    private WebElement destinationInput;

    @FindBy(id = "checkin")
    private WebElement checkInWrapper;

    @FindBy(xpath = "(//div[@class='datepicker--cells datepicker--cells-days'])[1]")
    private List<WebElement> checkIn;

    @FindBy(id = "checkout")
    private WebElement checkoutWrapper;

    @FindBy(xpath = "(//div[@class='datepicker--cells datepicker--cells-days'])[2]")
    private List<WebElement> checkOut;

    @FindBy(xpath = "(//button[contains(text(), 'Search')])[1]")
    private WebElement submitForm;

    public HotelPage(WebDriver driver) {
        super(driver);
    }

    public void completeForm() {
        destinationWrapper.click();
        destinationInput.sendKeys("Tria Hotel Istanbul Especial, Istanbul");
        destinationInput.sendKeys(Keys.ENTER);

        checkInWrapper.click();
        selectDatePickerDay(checkIn, "28");

        checkoutWrapper.click();
        selectDatePickerDay(checkOut, "29");


    }
}
