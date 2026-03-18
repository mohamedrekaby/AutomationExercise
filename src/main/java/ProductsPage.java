import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductsPage {

    private final By productsBtn = By.cssSelector("a[href=\"/products\"]"); //productButton
    private final By searchBar = By.id("search_product"); //search product field
    private final By submitSearchBtn = By.cssSelector(".container #submit_search"); //submit search button
    private final By allProducts = By.xpath("//*[text()='All Products']"); //all products text
    private final By searchedProducts = By.xpath("//*[text()='Searched Products']"); //searched products text
    private final By productLists = By.cssSelector(".features_items div[class=\"col-sm-4\"]");
    private final By addToCartBtn = By.cssSelector("div[class=\"productinfo text-center\"] >a[class=\"btn btn-default add-to-cart\"]"); //add to cart button list
    private final By continueShoppingBtn = By.cssSelector("button[class=\"btn btn-success close-modal btn-block\"]"); //continue shopping button
    protected WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openProductsPage() {
        driver.findElement(productsBtn).click();
    }

    public void productsPage() {
        driver.findElement(searchBar).sendKeys("T-shirt");
        driver.findElement(submitSearchBtn).click();
    }

    public void addProductsToCart() {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.textToBe(searchedProducts, "Searched Products"));

//        driver.findElements(productLists).get(0);
        driver.findElements(addToCartBtn).get(0).click();
        wait.until(ExpectedConditions.elementToBeClickable(continueShoppingBtn));
        driver.findElement(continueShoppingBtn).click();

//        driver.findElements(productLists).get(2);
        driver.findElements(addToCartBtn).get(2).click();
        wait.until(ExpectedConditions.elementToBeClickable(continueShoppingBtn));
        driver.findElement(continueShoppingBtn).click();

    }

    public boolean allProductsPage() {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(allProducts));
        return driver.findElement(allProducts).isDisplayed();
    }


    public boolean searchedProductsPage() {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchedProducts));
        return driver.findElement(searchedProducts).isDisplayed();
    }
}
