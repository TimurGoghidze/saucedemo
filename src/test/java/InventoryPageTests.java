import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class InventoryPageTests extends TestBase {

    @Test
    public void amountOfProducts() {
        User user = new User(validUsername, validPassword);
        new LoginPage(driver).login(user).inventoryListShouldBeDisplayed();
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.checkAllProductsAreDisplayed(); // на наличие карточек
        inventoryPage.checkAmountOfProducts(6); // сверяемся с заявленными количеством
    }

}
