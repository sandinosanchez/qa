package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage{


    @FindBy(css = "a.text-center.visa")
    private WebElement visaButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public VisaPage clickVisaButton() {
       visaButton.click();
       return new VisaPage(driver);
    }
}
