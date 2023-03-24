import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CartPageTests extends TestBase {

    @Test
    public void cardPageIsOpen() {
        User user = new User(validUsername, validPassword);
        new LoginPage(driver).login(user);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.openAndClickOnSideBarIcon();
        inventoryPage.clickOnResetAppState();
        inventoryPage.clickOnButtonCloseSideBar();
        inventoryPage.refreshPage();
        inventoryPage.clickOnAddToCartBackpack();
        inventoryPage.clickOnTheCartIcon();
        CartPage cartPage = new CartPage(driver);
        assertTrue(cartPage.checkoutButtonIsDisplayed());

    }
}
