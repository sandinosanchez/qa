package utils;


import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtils {


    public static boolean waitForElementVisibility(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        return wait
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class)
//				.pollingEvery(Duration.ofMillis(200L))
                .until(ExpectedConditions.visibilityOf(element)) != null;
    }

    public static WebElement waitForElementVisibility(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        return wait
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class)
//				.pollingEvery(Duration.ofMillis(200L))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static boolean waitForNewWindow(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        return wait
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class)
//				.pollingEvery(Duration.ofMillis(200L))
                .until(ExpectedConditions.numberOfWindowsToBe(2)) != null;
    }




    public static void switchToWindow(WebDriver driver) {
        String actualWindows = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> iterator = handles.iterator();
        if(iterator.hasNext()) {
            String hash = iterator.next();
            if(actualWindows.equals(hash) && iterator.hasNext()) {
                hash = iterator.next();
            }
            driver.switchTo().window(hash);
        }
    }

    public static void switchToWindow(WebDriver driver, int index) {
        Object[] allWindows = driver.getWindowHandles().toArray();
        driver.switchTo().window(allWindows[index].toString());

    }

    public static void switchToLastWindows(WebDriver driver) {
        String actualWindow = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        for (String string : handles) {
            if (!string.equals(actualWindow)) {
                driver.switchTo().window(string);
            }
        }
    }

    public static WebElement selectDatePickerDay(List<WebElement> days, String dayInput) {
        return days.stream().filter( day -> day.getText().contains(dayInput)).findFirst().get();
    }

    public static WebElement selectFromDropDown(List<WebElement> dropDown, String filter) {
        return dropDown.stream().filter(option -> option.getText().contains(filter)).findFirst().get();
    }


}