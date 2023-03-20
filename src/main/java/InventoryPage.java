import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.junit.Assert.*;

public class InventoryPage extends BasePage {
    // protected WebDriver driver; //он в BasePage

    @FindBy(className = "title")
    private WebElement productsTitle;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement inventoryList;

    @FindBy(css = "[class='inventory_item']")
    private List<WebElement> productCards; // коллекция карточек товара

    public InventoryPage(WebDriver driver) {
        super(driver);

//        this.driver = driver;//указатель на этот класс //Generate constructor
//        PageFactory.initElements(driver,this);
    }

    public void inventoryListShouldBeDisplayed() {
        assertTrue("Element " + "inventoryList" + "is NOT visible", inventoryList.isDisplayed());
    }

    public void checkAllProductsAreDisplayed() { //проверка списка товаров
        for (WebElement product :
                productCards) {
            assertTrue(product.isDisplayed());
        }
    }

    public void checkAmountOfProducts(int expectedAmount) { //метод подсчёта количества отражаемых карточек товара
        assertEquals("Amount of products is not " + expectedAmount, productCards.size(), expectedAmount);
    }

}
