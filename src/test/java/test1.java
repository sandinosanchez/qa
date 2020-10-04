import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class test1 {
    @Test
    public void test1() throws MalformedURLException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("platform","Linux");
        WebDriver driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), chromeOptions);
        driver.get("https://www.google.com");
        driver.quit();

    }
}
