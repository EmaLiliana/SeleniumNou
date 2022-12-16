import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.By.cssSelector;

public class Checkout {
    private WebDriver driver;

    @Before
    public void initializationDriver(){
        System.setProperty("WebDriver.chrome.driver", "resource/chromedriver");
        driver=new ChromeDriver();
        driver.manage().window();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }
    @Test
    public void checkoutProduct() throws InterruptedException {
        driver.findElement(cssSelector("li.nav-5 a")).click();
        driver.findElement(cssSelector(".actions a")).click();
        driver.findElement(cssSelector(".swatch-label img")).click();
        driver.findElement(cssSelector("#configurable_swatch_size span")).click();
        driver.findElement(cssSelector(".add-to-cart-buttons span span")).click();
        driver.findElement(cssSelector(".cart-totals [type=\"button\"]")).click();
        driver.findElement(By.cssSelector("#onepage-guest-register-button > span > span")).click();
        driver.findElement(By.cssSelector("#billing\\:firstname")).sendKeys("Dma");
        driver.findElement(By.cssSelector("#billing\\:lastname")).sendKeys("Ana");
        driver.findElement(By.cssSelector("#billing\\:street1")).sendKeys("Pascu");
        driver.findElement(By.cssSelector("#billing\\:email")).sendKeys("pope@yahoo.com");
        driver.findElement(By.cssSelector("#billing\\:street1")).sendKeys("Pascu");
        driver.findElement(By.cssSelector("#billing\\:city")).sendKeys("Cluj");
        driver.findElement(By.cssSelector(".validate-select.required-entry option[value=\"1\"]")).click();
        driver.findElement(By.cssSelector("#billing\\:postcode")).sendKeys("123456");
        driver.findElement(By.cssSelector("#billing\\:country_id > option:nth-child(212)")).click();
        driver.findElement(By.cssSelector("#billing\\:telephone")).sendKeys("0008845969");
        driver.findElement(By.cssSelector("#billing\\:use_for_shipping_yes")).click();
        driver.findElement(By.cssSelector("#billing-buttons-container span span")).click();

        driver.findElement(By.cssSelector("#shipping-method-buttons-container > button > span > span")).click();

        Thread.sleep(100);
        driver.findElement(By.cssSelector("#payment-buttons-container > button > span > span")).click();
        Thread.sleep(100);
        driver.findElement(By.cssSelector("#checkout-review-submit span span")).click();


    }
    @After
    public void quit(){
        driver.close();
    }
}

