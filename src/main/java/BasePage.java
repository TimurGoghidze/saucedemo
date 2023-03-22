import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.junit.Assert.assertTrue;

public abstract class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // проинициализируется во всех страницах где будет унаследованно
    }

    public void enterTextToElement(String text, WebElement element) { // все тех.задания вынесли сюда дальше можем использ
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    public boolean allElementsOfCollectionAreDisplayed(List<WebElement> collection) {
        for (WebElement element : collection) { // когда передадим колекци то разберём на отдельные элементы
            if (!element.isDisplayed()) {
                ; //if return false
                return false; //condition
            }
        }
        return true;
    }
}
