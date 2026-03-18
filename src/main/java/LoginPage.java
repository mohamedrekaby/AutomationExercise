import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private final By emailField = By.cssSelector("form[action=\"/login\"]>input[type=\"email\"]");//email for login
    private final By loggedIn = By.cssSelector("i[class=\"fa fa-user\"]"); //logged in as
    private final By logoutBtn = By.linkText("Logout"); //logout button
    private final By error_msg = By.cssSelector("div.login-form>form>p"); //error message in case of invalid login
    private final By passowrdField = By.name("password"); //password for login
    private final By loginBtn = By.cssSelector("form>button[data-qa=\"login-button\"]"); //login button

    protected WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void loginPage() {
        driver.navigate().to("https://automationexercise.com/login");
    }


    public void userCanLogin(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passowrdField).sendKeys(password);
        driver.findElement(loginBtn).click();

    }

    public boolean loggedInSuccessfully() {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(loggedIn));
        return driver.findElement(loggedIn).isDisplayed();
    }
//    public void userCanNotLogin(String email, String password) {
//        driver.findElement(emailField).sendKeys(email);
//        driver.findElement(passowrdField).sendKeys(password);
//        driver.findElement(loginBtn).click();
//
//    }

    public void userCanLogout() {
        driver.findElement(logoutBtn).click();
    }

}
