import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
WebDriver  driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this); // проинициализируется во всех страницах где будет унаследованно
    }

    public void enterTextToElement(String text, WebElement element){ // все тех.задания вынесли сюда дальше можем использ
        element.click();
        element.clear();
        element.sendKeys(text);

    }
}
