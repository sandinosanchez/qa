package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.JavascriptUtils;
import utils.SeleniumUtils;

import java.util.List;

import static utils.SeleniumUtils.selectDatePickerDay;
import static utils.SeleniumUtils.waitForElementVisibility;

public class FlightsPage extends AbstractPage {

    //private By dropdownFromCity = By.cssSelector("div.select2-result-label");

    @FindBy(css = "div.select2-result-label")
    private WebElement dropdownFromCity;

    @FindBy(css = "#s2id_location_from>a.select2-choice")
    private WebElement fromCityWrapper;

    @FindBy(css = "#select2-drop>ul.select2-results")
    private WebElement dropdownCitySpan;

    @FindBy(id = "s2id_autogen9")
    private WebElement fromCity;


    @FindBy(css = "#select2-drop>div>input.select2-input")
    private WebElement toCity;


    @FindBy(css = "#s2id_location_to>a>span.select2-chosen")
    private WebElement toCity1;

    @FindBy(id = "s2id_autogen10")
    private WebElement toCityId;

    @FindBy(xpath = "//*[@id='datepickers-container']/div[9]/div/div/div[2]/div")
    private List<WebElement> dataPickerDays;

    @FindBy(id = "FlightsDateStart")
    private WebElement date;

    @FindBy(css = "div.col-lg-1>button.btn-primary.btn.btn-block")
    private WebElement searchButton;

    public FlightsPage(WebDriver driver) {
        super(driver);
    }

    public SearchFlightsPage completeForm(String fromCityParam , String toCityParam){
        JavascriptUtils.click(driver, fromCity);
        fromCity.sendKeys(fromCityParam);
        SeleniumUtils.waitForElementVisibility(driver, dropdownFromCity);

        JavascriptUtils.click(driver, toCityId);
        toCityId.sendKeys(toCityParam);
        SeleniumUtils.waitForElementVisibility(driver, dropdownFromCity);
        toCityId.sendKeys(Keys.ENTER);
       /* JavascriptUtils.click(driver, date);
        waitForElementVisibility(driver, dataPickerDays.get(0));
        JavascriptUtils.click(driver, selectDatePickerDay(dataPickerDays, "28"));
        searchButton.click();*/
        return new SearchFlightsPage(driver);
    }

}
