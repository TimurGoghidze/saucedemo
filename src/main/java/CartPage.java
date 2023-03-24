import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage { // при создании будет ругаться но создаём конструктор и всё ОК
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "checkout")
    static
    private WebElement checkoutButton;

    public static boolean checkoutButtonIsDisplayed() { //visible=true; invisible = false
        return checkoutButton.isDisplayed();
    }
}
