import Pages.HomePage;
import Pages.SearchResultsPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchTest {
    private WebDriver driver;

    @Before
    public void initializationDriver() {
        System.setProperty("WebDriver.chrome.driver", "resource/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");

    }
    @Test
    public void searchByKeywordTest(){
        HomePage homePage=new HomePage(driver);
        SearchResultsPage searchResultsPage=new SearchResultsPage(driver);
        homePage.setSearchField("neck");
        Assert.assertTrue(searchResultsPage.isProductInList("SILVER DESERT NECKLACE"));
        homePage.setSearchField("dress");
        Assert.assertTrue(searchResultsPage.isProductInList("LAFAYETTE CONVERTIBLE DRESS"));
    }

    @After
    public void quit() {
        driver.close();
    }
}
