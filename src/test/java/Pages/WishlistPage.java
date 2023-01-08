package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishlistPage {
    private WebDriver driver;

    public WishlistPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id="email")
    private WebElement emailField;
    @FindBy(id="pass")
    private  WebElement passwordField;
    @FindBy(id="send2")
    private WebElement loginButton;
}
