import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertTrue;

public class InventoryPage extends BasePage {
   // protected WebDriver driver; //он в BasePage

    @FindBy(className = "title")
   private WebElement product;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement inventoryList;

    public InventoryPage(WebDriver driver) {
        super(driver);

//        this.driver = driver;//указатель на этот класс //Generate constructor
//        PageFactory.initElements(driver,this);
    }
    public void inventoryListShouldBeDisplayed(){
        assertTrue(inventoryList.isDisplayed());
    }

}
