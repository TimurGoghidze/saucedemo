import org.junit.Test;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class CheckoutTests extends TestBase {

    @Test
    public void checkQuantityOfProducts() {
        User user = new User(validUsername, validPassword);
        new LoginPage(driver).login(user);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.resetAppState();
        inventoryPage.clickOnAddToCartBackpack();
        inventoryPage.clickOnAddToCartBikeLight();
        inventoryPage.clickOnTheCartIcon();
        CartPage cartPage = new CartPage(driver);
        cartPage.clickOnCheckoutButton();
        CheckoutStepOnePage checkoutStepOnePage = new CheckoutStepOnePage(driver);
        checkoutStepOnePage.enterFirstName("Harry");
        checkoutStepOnePage.enterLastName("Potter");
        checkoutStepOnePage.enterZipPostCode("121212");
        checkoutStepOnePage.clickOnContinueButton();
        CheckoutStepTwoPage checkoutStepTwoPage = new CheckoutStepTwoPage(driver);
        assertTrue(checkoutStepTwoPage.checkProductCardQuantity(2));
        assertThat(checkoutStepTwoPage.getProductCards(),hasSize(2));//второй вариант
    }
}
