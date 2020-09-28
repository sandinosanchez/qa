package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;


public class SearchFlightsPage extends AbstractPage {
 @FindBy(css = "h3.heading-title>span")
 private List <WebElement> text;
    public SearchFlightsPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getVerifyGoToText(){
        List<String> list = driver.findElements(By.cssSelector("h3.heading-title>span")).stream()
                .map(WebElement::getText).collect(Collectors.toList());
        return list;
    }


}
