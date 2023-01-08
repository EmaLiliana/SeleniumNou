import Pages.HomePage;
import Pages.LoginPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WishlistTest {
    private WebDriver driver;

    @Before
    public void initDriver(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }

    @Test
    public void addToWishlistTest(){
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage=new LoginPage(driver);


        homePage.clickAccountButton();
        homePage.clickLoginLink();
        loginPage.setEmailField("ana@yahoo.com");
        loginPage.setPasswordField("AnaAna1");
        loginPage.clickLoginButton();


        driver.findElement(By.cssSelector("#nav li.nav-5 a")).click();
        driver.findElement(By.cssSelector(".actions a")).click();
        driver.findElement(By.cssSelector("ul.add-to-links a")).click();

        WebElement addedToWishlistMsg = driver.findElement(By.cssSelector(".success-msg li"));
        Assert.assertTrue(addedToWishlistMsg.isDisplayed());



    }
    @After
    public void quit(){
        driver.close();
    }
}
