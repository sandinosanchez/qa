import org.testng.annotations.Test;
import pages.HomePage;
import pages.VisaPage;

public class VisaTest extends AbstractUiTest {

    @Test
    public void searchForVisa(){
    VisaPage visaPage = new HomePage(getDriver()).clickVisaButton();
    visaPage.completeForm();
    }

}
