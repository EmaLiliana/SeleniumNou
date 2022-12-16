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
    @Before
    public void initializationDriver(){
        System.setProperty("web-driver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");

    }
    @Test

    public void loginWithValidData(){


        driver.findElement(By.cssSelector("div.account-cart-wrapper span.label")).click();
        driver.findElement(By.cssSelector("div.links a")).click();
        driver.findElement(By.id("email")).sendKeys("ana@yahoo.com");
        driver.findElement(By.id("pass")).sendKeys("AnaAna1");
        driver.findElement(By.id("send2")).click();

        WebElement welcomeTextElement = driver.findElement(By.cssSelector("p.hello strong"));
        String expectedText = "Hello, Ana Pop!";
        String actualText = welcomeTextElement.getText();
        Assert.assertEquals(expectedText,actualText);

        WebElement myAccount = driver.findElement(By.cssSelector("div.account-cart-wrapper span.label"));
        Assert.assertTrue(myAccount.isDisplayed());


    }
    @After
    public void quit(){
        driver.close();
    }


}

