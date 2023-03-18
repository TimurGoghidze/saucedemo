import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertTrue;

public class LoginPage extends BasePage {
    protected WebDriver driver; //к нему можно будет достучаться только наследником либо внутри класса

 //при такой практике будет искать только тогда когда обратимся к WebElement, а не всегда
 //@CacheLookup может закэшировать найденный элемент и потом использовать,а не искать по новой = увеличивает скорость

    @FindBy (id="user-name")
   private WebElement userName;

    @FindBy (id="password")
    private WebElement password; // хорошей практикой private

    @FindBy (id="login-button")
   private WebElement buttonLogin;
    @FindBy (tagName = "h3")
    private WebElement errorMessage;

//далее надо это проинициализировать -> вывести конструктор этого класса
//при инициализации передаем драйвер в () драйвер это пульт управления браузером

public LoginPage (WebDriver driver){
    super(driver);

   // this.driver = driver; // инициализация  protected WebDriver driver и ему назначаем driver кот. прийдет извне
   // PageFactory.initElements(driver, this); // передаём то, что здесь есть = constructor без неё тесты завалятся
}

//@Step("Filling in username, password and push the Login button")
    public void login(User user){
        userName.sendKeys(user.getName());
        password.sendKeys(user.getPassword());
        buttonLogin.click();


    }
    public void errorMessageShouldBeDisplayed(){
    assertTrue(errorMessage.isDisplayed());
    }
}
