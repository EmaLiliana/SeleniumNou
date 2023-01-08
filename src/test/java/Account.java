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
    public void myAccount() throws InterruptedException {
        driver.findElement(By.cssSelector(".account-cart-wrapper span.label")).click();
        driver.findElement(By.cssSelector("div.links li.first a")).click();
        driver.findElement(By.cssSelector(".buttons-set span span")).click();
        driver.findElement(By.cssSelector(".input-box #firstname")).sendKeys("Evla");

        driver.findElement(By.cssSelector(".input-box #lastname")).sendKeys("Ona");
        driver.findElement(By.cssSelector(".input-box #email_address")).sendKeys("hrcaa@yahoo.com");
        driver.findElement(By.cssSelector(".input-box #password")).sendKeys("Ana1234");
        driver.findElement(By.cssSelector(".input-box #confirmation")).sendKeys("Ana1234");
        driver.findElement(By.cssSelector("li.control input")).click();
        driver.findElement(By.cssSelector(".buttons-set span span")).click();
        Thread.sleep(15000);


        WebElement myOrders =driver.findElement(By.cssSelector(".block.block-account ul li:nth-child(4) a"));
        Assert.assertTrue(myOrders.isDisplayed());


    }
    @After
    public void quit(){
        driver.quit();
    }
}