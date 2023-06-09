import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
@Getter // for all getter
public class CheckoutStepTwoPage extends BasePage{
    public CheckoutStepTwoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "cart_item_label")
    private List<WebElement> productCards;

    public boolean checkProductCardQuantity(int expectedQuantity) {
        return productCards.size() == expectedQuantity;
    }
    }

