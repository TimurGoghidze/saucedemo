import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    protected WebDriver driver; //к нему можно будет достучаться только наследником либо внутри класса

 //при такой практике будет искать только тогда когда обратимся к WebElement, а не всегда
 //@CacheLookup может закэшировать найденный элемент и потом использовать,а не искать по новой = увеличивает скорость

    @FindBy (id="user-name")
    WebElement userName;

    @FindBy (id="password")
    WebElement password; // хорошей практикой private

    @FindBy (id="login-button")
    WebElement buttonLogin;

//далее надо это проинициализировать -> вывести конструктор этого класса
//при инициализации передаем драйвер в () драйвер это пульт управления браузером

    public LoginPage (WebDriver driver){
        this.driver = driver; // инициализация  protected WebDriver driver и ему назначаем driver кот. прийдет извне
        PageFactory.initElements(driver, this); // передаём то, что здесь есть
    }

    public void login(String usernameParam, String passwordParam){
        userName.sendKeys(usernameParam);
        password.sendKeys(passwordParam);
        buttonLogin.click();


    }
}
