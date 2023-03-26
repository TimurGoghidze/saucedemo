import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class CartPage extends BasePage { // при создании будет ругаться но создаём конструктор и всё ОК
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "checkout")
    private WebElement checkoutButton;
    @FindBy(className = "cart_item_label")
    private List<WebElement> productCards;
    @FindBy(className = "inventory_item_name")
    private List<WebElement> productNames;

    @Step("Checkout Button is Displayed")
    public boolean checkoutButtonIsDisplayed() { //visible=true; invisible = false
        return checkoutButton.isDisplayed();
    }
    @Step("Get quantity of products")
    public boolean checkProductCardQuantity(int expectedQuantity) {
//        allElementsOfCollectionAreDisplayed(productCards); //первый вариант
//        assertEquals("Product card quantity is not equal  " + expectedQuantity, productCards.size(), expectedQuantity);
//        if (productCards.size() == expectedQuantity) { // второй вариант
//            return true;
//        } else {
//            return false;
//        }
//        и третий короткий вариант
        return productCards.size() == expectedQuantity;
    }
    @Step("Click on checkout button")
    public void clickOnCheckoutButton() {
        clickOnTheElement(checkoutButton);
    }
    @Step("Card is empty first option")
    public void cartIsEmpty1() {
        productNames.isEmpty();
    }
    @Step("Card is empty second option")
    public boolean cartIsEmpty2() { //изначально если корзина не пуста
        //заводим переменную
        boolean empty = false;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1)); //явное ожидание
            wait.until(ExpectedConditions.visibilityOf(productCards.get(0)));
        } catch (Exception e) { //если пуста то
            empty = true;
        }
        return empty;
    }
}
