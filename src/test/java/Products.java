import org.testng.asserts.SoftAssert;

public class Products extends TestBase {


    public void ValidProducts() {
        softAssert = new SoftAssert();

        ProductsPage productpage = new ProductsPage(driver);
        productpage.openProductsPage();
        softAssert.assertTrue(productpage.allProductsPage(), "The user is not in the products page");
        productpage.productsPage();
        softAssert.assertTrue(productpage.searchedProductsPage(), "The user is not in the searched products page");
        productpage.addProductsToCart();

        softAssert.assertAll(); // ensures all soft assertions are checked

    }
}
