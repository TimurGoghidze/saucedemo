import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertTrue;

public abstract class BasePage {
    WebDriver driver;
    final int waitTimeBeforeClick = 20; //final - для того чтобы никто не влез и ничего не менял

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

    public void refreshPage() { // method refresh the page
        driver.navigate().refresh();
    }

    public void clickOnTheElement(WebElement element) { //если не сработает селениум сообщит что element not click
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeBeforeClick));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }


}
