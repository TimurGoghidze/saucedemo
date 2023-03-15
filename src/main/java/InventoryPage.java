import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage {
    protected WebDriver driver;

    @FindBy(className = "title")
    WebElement product;

    @FindBy(id = "react-burger-menu-btn")
    WebElement inventoryList;

    public InventoryPage(WebDriver driver) {//Generate constructor
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
