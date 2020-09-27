import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utils.WebDriverUtils;

public abstract class AbstractUiTest {

    private WebDriver driver;

    @BeforeMethod
    @Parameters(value = "browser")
    public void initBrowser(@Optional(value = "CHROME") String browser) {
        System.out.println("browser " + browser);
        driver = WebDriverUtils.Driver.valueOf(browser).build();
        driver.get(getBaseUrl());
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
//        if (null != driver) {
//            driver.quit();
//        }
    }

    protected String getBaseUrl() {
        return "https://phptravels.net/";
    }

    protected WebDriver getDriver() {
        return driver;
    }
}