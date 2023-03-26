import io.qameta.allure.Story;
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
    @Test @Story("Check that cart is empty option first")
    public void cartIsEmpty1(){ //пуста ли корзина first variant
        User user = new User(validUsername, validPassword);
        new LoginPage(driver).login(user).inventoryListShouldBeDisplayed();
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.clickOnTheCartIcon();
        CartPage cartPage = new CartPage(driver);
        cartPage.cartIsEmpty1();
    }
    @Test @Story("Check that cart is empty option second")
    public void cartIsEmpty2(){ //second variant
        User user = new User(validUsername, validPassword);
        new LoginPage(driver).login(user);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.resetAppState();
        inventoryPage.clickOnTheCartIcon();
        CartPage cartPage = new CartPage(driver);
        assertTrue(cartPage.cartIsEmpty2());
    }
}
