import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    public boolean checkoutButtonIsDisplayed() { //visible=true; invisible = false
        return checkoutButton.isDisplayed();
    }

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
public void clickOnCheckoutButton(){
        clickOnTheElement(checkoutButton);
}
}
