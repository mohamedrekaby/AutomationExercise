import org.testng.asserts.SoftAssert;

public class Cart extends TestBase {

    public void ValidCart() {

        softAssert = new SoftAssert();

        CartPage cartpage = new CartPage(driver);
        cartpage.cartActions();
        softAssert.assertTrue(cartpage.cartPageVisiblity(), "you are not in the Cart Page");
        cartpage.checkoutAction();

        softAssert.assertAll(); // ensures all soft assertions are checked

    }

}
