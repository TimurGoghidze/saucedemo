import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CartPageTests extends TestBase {

    @Test
    public void cardPageIsOpen() {
        User user = new User(validUsername, validPassword);
        new LoginPage(driver).login(user);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.resetAppState();// завели один метод по ссылке вкл обновление очищение
        inventoryPage.clickOnAddToCartBackpack();
        inventoryPage.clickOnTheCartIcon();
        CartPage cartPage = new CartPage(driver);
        assertTrue(cartPage.checkoutButtonIsDisplayed());

    }

    @Test
    public void addSeveralItems() {
        User user = new User(validUsername, validPassword);
        new LoginPage(driver).login(user);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.resetAppState();
        inventoryPage.clickOnAddToCartBackpack();
        inventoryPage.clickOnAddToCartBikeLight();
        inventoryPage.clickOnTheCartIcon();
        CartPage cartPage = new CartPage(driver);
        assertTrue(cartPage.checkProductCardQuantity(2));
    }
}
