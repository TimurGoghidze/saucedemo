import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static java.lang.Thread.sleep;
import static org.junit.Assert.*;

public class InventoryPage extends BasePage {
    // protected WebDriver driver; //он в BasePage

    @FindBy(className = "title")
    private WebElement productsTitle;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement sideBarButton;

    @FindBy(css = "[class='inventory_item']")
    private List<WebElement> productCards; // коллекция карточек товара

    @FindBy(css = "[class='inventory_item_name']")
    private List<WebElement> productCardsName;

    @FindBy(xpath = "//div[@class='inventory_item_img']")
    private List<WebElement> productCardsPicture;

    @FindBy(css = "[class='btn btn_primary btn_small btn_inventory']")
    private List<WebElement> buttonAddToCart;

    @FindBy(xpath = "//a[@href='https://twitter.com/saucelabs']")
    private WebElement twitterIconLink;

    @FindBy(id = "inventory_sidebar_link")
    private WebElement allItems;

    @FindBy(id = "about_sidebar_link")
    private WebElement about;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logOut;

    @FindBy(id = "reset_sidebar_link")
    private WebElement resetAppState;


    public InventoryPage(WebDriver driver) {
        super(driver);

//        this.driver = driver;//указатель на этот класс //Generate constructor
//        PageFactory.initElements(driver,this);
    }

    public void inventoryListShouldBeDisplayed() {
        assertTrue("Element " + "inventoryList" + "is NOT visible", sideBarButton.isDisplayed());
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

    public void checkProductNameIsDisplayed(){
        for (WebElement productname :
                productCardsName) {
            assertTrue(productname.isDisplayed());
        }
    }

    public void checkProductNameIsNotEmpty() {
        for (WebElement productname:
             productCardsName) {
            assertTrue(productname.isDisplayed());
        }

    }

    public void checkProductCardPictureIsDisplayed(){
        for (WebElement picture :
                productCardsPicture) {
            assertTrue(picture.isDisplayed());
        }
    }
    public void checkProductCardPictureIsNotEmpty(int expectedAmount) { //метод подсчёта количества отражаемых карточек товара
        assertEquals("Amount of products is not " + expectedAmount, productCardsPicture.size(), expectedAmount);
    }
    public void checkButtonAddToCartIsDisplayed(){
        for (WebElement addtocart :
                buttonAddToCart) {
            assertTrue(addtocart.isDisplayed());
        }
    }
    public void checkButtonAddToCartIsNotEmpty(int expectedAmount) { //метод подсчёта количества отражаемых карточек товара
        assertEquals("Amount of products is not " + expectedAmount, buttonAddToCart.size(), expectedAmount);
    }
    public void checkTwitterLink(){
        assertTrue(twitterIconLink.isDisplayed());
    }
    public void clickOnSideBarOpenIcon() throws InterruptedException {
        sideBarButton.click();
        sleep(1000);
    }

    public void allItemsIsDisplayed(){
        assertTrue(allItems.isDisplayed());
    }
    public void aboutIsDisplayed(){
        assertTrue(about.isDisplayed());
    }
    public void logoutIsDisplayed(){
        assertTrue(logOut.isDisplayed());
    }
    public void resetAppStateIsDisplayed(){
        assertTrue(resetAppState.isDisplayed());
    }
}
