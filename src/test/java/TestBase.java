import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

public class TestBase {


    protected static WebDriver driver;
    protected SoftAssert softAssert;

    @BeforeSuite
    public void setup() {

        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://automationexercise.com/");


    }


    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}


