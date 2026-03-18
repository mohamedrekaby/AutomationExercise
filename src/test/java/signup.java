import org.testng.asserts.SoftAssert;

public class signup extends TestBase {


    public void ValidSignUp() {
        softAssert = new SoftAssert();

        signupPage signupPage = new signupPage(driver);
        signupPage.SignupPage();
        signupPage.userSignUP("test", "muhamed30@gmail.com");
        softAssert.assertEquals(signupPage.enterAccountTitlePage(), "ENTER ACCOUNT INFORMATION", "The title is not correct");
        signupPage.accountInformation("123456", 1, "March", "2001", "muhamed", "test", "company", "address1", "United States", "state test", "city test", "12345", "0123456789");
        signupPage.clickCreateAccount();
        softAssert.assertEquals(signupPage.getConfirmationMsg(), "ACCOUNT CREATED!", "The account was not created successfully");
        signupPage.continueToHomePage();
        signupPage.userCanLogout();

        softAssert.assertAll(); // ensures all soft assertions are checked

    }

}
