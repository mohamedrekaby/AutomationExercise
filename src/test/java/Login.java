import org.testng.asserts.SoftAssert;

public class Login extends TestBase {
    public void ValidLogin() {

        softAssert = new SoftAssert();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginPage();
        loginPage.userCanLogin("muhamed45@gmail.com", "123456");
        softAssert.assertTrue(loginPage.loggedInSuccessfully(), "The user was not logged in successfully");
        softAssert.assertAll(); // ensures all soft assertions are checked

    }
}
