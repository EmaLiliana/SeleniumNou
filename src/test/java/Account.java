import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Account {
    private WebDriver driver;

    @Before
    public void initializationDriver() {
        System.setProperty("WebDriver.chrome.driver", "resource/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }
    @Test
    public void myAccount(){
        driver.findElement(By.cssSelector(".account-cart-wrapper span.label")).click();
        driver.findElement(By.cssSelector("div.links li.first a")).click();
        driver.findElement(By.cssSelector(".buttons-set span span")).click();
        driver.findElement(By.cssSelector(".input-box #firstname")).sendKeys("leamara");
        driver.findElement(By.cssSelector(".input-box #lastname")).sendKeys("Ana");
        driver.findElement(By.cssSelector(".input-box #email_address")).sendKeys("leamara1234@yahoo.com");
        driver.findElement(By.cssSelector(".input-box #password")).sendKeys("Ana1234");
        driver.findElement(By.cssSelector(".input-box #confirmation")).sendKeys("Ana1234");
        driver.findElement(By.cssSelector(".control label")).click();
        driver.findElement(By.cssSelector(".buttons-set span span")).click();
        driver.findElement(By.cssSelector("li.current strong")).click();

        WebElement changePasswordAccount = driver.findElement(By.cssSelector(".box-content a"));
        Assert.assertTrue(changePasswordAccount.isDisplayed());


    }
    @After
    public void quit(){
        driver.quit();
    }
}