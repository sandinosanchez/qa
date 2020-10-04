import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FlightsPage;
import pages.HomePage;
import pages.SearchFlightsPage;

public class FlightsTest extends AbstractUiTest {

    @Test
    public void searchForFlight(){
        SearchFlightsPage searchFlightsPage = new HomePage(getDriver())
                .clickFlightsPage()
                .completeForm("BML","BVA");

        Assert.assertEquals(searchFlightsPage.getVerifyGoToText().get(0) + " " +
                        searchFlightsPage.getVerifyGoToText().get(1),
                "BML to BVA");
    }


}
