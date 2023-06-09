import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class InventoryPageTests extends TestBase {

    @Test
    public void amountOfProducts() {
        User user = new User(validUsername, validPassword);
        new LoginPage(driver).login(user).inventoryListShouldBeDisplayed();
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.checkAllProductsAreDisplayed(); // на наличие карточек
        inventoryPage.checkAmountOfProducts(6); // сверяемся с заявленными количеством
        inventoryPage.checkProductNameIsDisplayed(); // наличие названий
        inventoryPage.checkProductNameIsNotEmpty(); //названия не пусты
        inventoryPage.checkProductCardPictureIsDisplayed(); //наличие картинок
        inventoryPage.checkProductCardPictureIsNotEmpty(6);
        inventoryPage.checkButtonAddToCartIsDisplayed(); //наличие кнопок добавить в корзину
        inventoryPage.checkButtonAddToCartIsNotEmpty(6); //их количество
    }

    @Test
    public void allElementsAreDisplayed() {
        User user = new User(validUsername, validPassword);
        new LoginPage(driver).login(user).inventoryListShouldBeDisplayed();
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.checkTwitterLink();
        inventoryPage.checkFacebookLink();
        inventoryPage.checkLinkedinLink();
        inventoryPage.checkLogoSwagIsDisplayed();
        inventoryPage.checkShoppingCartIsDisplayed();
        inventoryPage.checkSortContainerIsDisplayed();

    }

    @Test
    public void sideBar() {
        User user = new User(validUsername, validPassword);
        new LoginPage(driver).login(user).inventoryListShouldBeDisplayed();
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.openAndClickOnSideBarIcon();
        inventoryPage.allItemsIsDisplayed();
        inventoryPage.aboutIsDisplayed();
        inventoryPage.logoutIsDisplayed();
        inventoryPage.resetAppStateIsDisplayed();
        inventoryPage.clickOnButtonCloseSideBar();
        inventoryPage.allSideBarItemsIsNotDisplayed();
        assertTrue(inventoryPage.AllItemsIsDisplayed());
    }

    @Test
    public void checkSideBarClose() throws InterruptedException {
        User user = new User(validUsername, validPassword);
        new LoginPage(driver).login(user).inventoryListShouldBeDisplayed();
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.openAndClickOnSideBarIcon();
        inventoryPage.clickOnButtonCloseSideBar();
        inventoryPage.checkAllSideBarItemsAreNOTDisplayed(); // проверка на то что при закрытии sideBar items not visible

    }



}
