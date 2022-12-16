import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterTest {
    private WebDriver driver;

    @Before
    public void initializationDriver() {
        System.setProperty("WebDriver.chrome.driver", "resource/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");

    }

    @Test
    public void registrationWithValidData() {
        driver.findElement(By.cssSelector("div.account-cart-wrapper span.label")).click();
        driver.findElement(By.cssSelector("div.links li:nth-child(5) a")).click();
        driver.findElement(By.id("firstname")).sendKeys("Ana");
        driver.findElement(By.id("lastname")).sendKeys("Pop");
        driver.findElement(By.id("email_address")).sendKeys("ana@yahoo.com");
        driver.findElement(By.id("password")).sendKeys("AnaAna1");
        driver.findElement(By.id("confirmation")).sendKeys("AnaAna1");
        driver.findElement(By.cssSelector("li.control label")).click();
        driver.findElement(By.cssSelector("div.buttons-set span span")).click();

        WebElement requiredFields = driver.findElement(By.cssSelector("div.fieldset p.required"));
        Assert.assertTrue(requiredFields.isDisplayed());
    }
    @After
    public void quit () {driver.close();
    }


}






