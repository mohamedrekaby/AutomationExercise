import org.testng.annotations.Test;


public class EndToEndScenario extends TestBase {
    @Test
    public void fullScenario() {

        signup sign = new signup();
        Login login = new Login();
        Products products = new Products();
        Cart cart = new Cart();


        sign.ValidSignUp();
        login.ValidLogin();
        products.ValidProducts();
        cart.ValidCart();


    }
}