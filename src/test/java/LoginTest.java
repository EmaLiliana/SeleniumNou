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

public class LoginTest {
    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;

    @Before
    public void initializationDriver(){
        System.setProperty("web-driver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");

        homePage = new HomePage(driver);
        loginPage=new LoginPage(driver);

    }
    @Test

    public void loginWithValidData(){
        homePage.clickAccountButton();
        homePage.clickLoginLink();
        loginPage.setEmailField("ana@yahoo.com");
        loginPage.setPasswordField("AnaAna1");
        loginPage.clickLoginButton();


        WebElement welcomeTextElement = driver.findElement(By.cssSelector("p.hello strong"));
        String expectedText = "Hello, Ana Pop!";
        String actualText = welcomeTextElement.getText();
        Assert.assertEquals(expectedText, actualText);

        WebElement myAccount = driver.findElement(By.cssSelector("div.account-cart-wrapper span.label"));
        Assert.assertTrue(myAccount.isDisplayed());


    }
    @After
    public void quit(){

        driver.close();
    }


}

