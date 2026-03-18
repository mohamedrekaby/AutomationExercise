import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    private final By cartBtn = By.linkText("Cart"); //cart button
    private final By cartItemsDeleteBtn = By.cssSelector(".cart_quantity_delete"); //delete button for cart items
    private final By checkoutBtn = By.cssSelector(".col-sm-6>a"); //checkout button
    private final By shoppingCartTitle = By.cssSelector("[class=\"active\"]"); //shopping cart title


    protected WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }


    public void cartActions() {
        driver.findElement(cartBtn).click();
        driver.findElements(cartItemsDeleteBtn).get(0).click();
    }

    public void checkoutAction() {
        driver.findElement(checkoutBtn).click();
    }

    public boolean cartPageVisiblity() {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(shoppingCartTitle));
        return driver.findElement(shoppingCartTitle).isDisplayed();
    }
}
