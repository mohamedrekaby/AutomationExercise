import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class signupPage {
    public final By enterAccountCreationTitle = By.xpath("//h2/b");
    private final By signupName = By.name("name"); //name for sign up
    private final By signupEmail = By.cssSelector("form[action=\"/signup\"]>input[type=\"email\"]"); //email for sign up
    private final By signupBtn = By.cssSelector("form>button[data-qa=\"signup-button\"]"); //sign up button
    private final By title = By.id("id_gender1");
    private final By password = By.id("password");
    private final By dayListSelector = By.id("days");
    private final By monthListSelector = By.id("months");
    private final By yearListSelector = By.id("years");
    private final By firstName = By.id("first_name");
    private final By lastName = By.id("last_name");
    private final By company = By.id("company");
    private final By address1 = By.id("address1");
    private final By countryListSelector = By.id("country");
    private final By state = By.id("state");
    private final By city = By.id("city");
    private final By zipcode = By.id("zipcode");
    private final By mobileNumber = By.id("mobile_number");
    private final By createAccountBtn = By.cssSelector("button[data-qa=\"create-account\"]");
    private final By accountCreatedMsg = By.cssSelector("div[class=\"col-sm-9 col-sm-offset-1\"]>h2");
    private final By continueBtn = By.cssSelector("a[data-qa=\"continue-button\"]");
    private final By logoutBtn = By.linkText("Logout"); //logout button

    protected WebDriver driver;

    public signupPage(WebDriver driver) {
        this.driver = driver;
    }


    public void SignupPage() {
        driver.navigate().to("https://automationexercise.com/login");
    }

    public void userSignUP(String name, String email) {
        driver.findElement(signupName).sendKeys(name);
        driver.findElement(signupEmail).sendKeys(email);
        driver.findElement(signupBtn).click();
    }

    public String enterAccountTitlePage() {
        return driver.findElement(enterAccountCreationTitle).getText();
    }

    public void accountInformation(String Password, int day, String month, String year, String firstName, String lastName, String company, String address1, String country, String state, String city, String zipcode, String mobileNumber) {
        driver.findElement(title).click();
        driver.findElement(password).sendKeys(Password);
        Select selectDay = new Select(driver.findElement(dayListSelector));
        selectDay.selectByValue(String.valueOf(day));
        Select selectMonth = new Select(driver.findElement(monthListSelector));
        selectMonth.selectByVisibleText(month);
        Select selectYear = new Select(driver.findElement(yearListSelector));
        selectYear.selectByValue(year);
        driver.findElement(this.firstName).sendKeys(firstName);
        driver.findElement(this.lastName).sendKeys(lastName);
        driver.findElement(this.company).sendKeys(company);
        driver.findElement(this.address1).sendKeys(address1);
        Select selectCountry = new Select(driver.findElement(countryListSelector));
        selectCountry.selectByValue(country);
        driver.findElement(this.state).sendKeys(state);
        driver.findElement(this.city).sendKeys(city);
        driver.findElement(this.zipcode).sendKeys(zipcode);
        driver.findElement(this.mobileNumber).sendKeys(mobileNumber);
    }

    public void clickCreateAccount() {
        driver.findElement(createAccountBtn).click();
    }

    public String getConfirmationMsg() {
        return driver.findElement(accountCreatedMsg).getText();
    }

    public void continueToHomePage() {
        driver.findElement(continueBtn).click();
    }

    public void userCanLogout() {
        driver.findElement(logoutBtn).click();
    }

}
