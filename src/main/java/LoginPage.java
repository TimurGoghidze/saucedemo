import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertTrue;

public class LoginPage extends BasePage {
    //protected WebDriver driver; //к нему можно будет достучаться только наследником либо внутри класса

    //при такой практике будет искать только тогда когда обратимся к WebElement, а не всегда
    //@CacheLookup может закэшировать найденный элемент и потом использовать,а не искать по новой = увеличивает скорость

    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement password; // хорошей практикой private

    @FindBy(id = "login-button")
    private WebElement buttonLogin;
    @FindBy(tagName = "h3")
    private WebElement errorMessage;

    @FindBy(className = "login_password")
    private WebElement listPasswordsForAllUsers;

    @FindBy(id = "login_credentials")
    private WebElement listAcceptedUserNames;



//далее надо это проинициализировать -> вывести конструктор этого класса
//при инициализации передаем драйвер в () драйвер это пульт управления браузером

    public LoginPage(WebDriver driver) {
        super(driver);

        // this.driver = driver; // инициализация  protected WebDriver driver и ему назначаем driver кот. прийдет извне
        // PageFactory.initElements(driver, this); // передаём то, что здесь есть = constructor без неё тесты завалятся
    }

    @Step("Filling in username, password and push the Login button")
    public InventoryPage login(User user) { // InventoryPage  вместо void чтобы можно было образовать цепочку
        enterTextToElement(user.getName(), userName);
        enterTextToElement(user.getPassword(), password);
//        userName.click();// ушло в одну строку
//        userName.clear();
//        userName.sendKeys(user.getName());
//        password.click(); // ушло в одну строку
//        password.clear();
//        password.sendKeys(user.getPassword());
        buttonLogin.click();
        return new InventoryPage(driver);

    }

    public void errorMessageShouldBeDisplayed() {
        assertTrue(errorMessage.isDisplayed());
    }
//    public boolean logoIsDisplayed(){
//        return(logo.isDisplayed());
//    }

   public boolean fieldUserNameIsDisplayed(){assertTrue((userName.isDisplayed())); // тест на наличие значков на странице
       return true;
   }

    public boolean fieldPasswordIsDisplayed(){assertTrue((password.isDisplayed()));

        return true;
    }
    public boolean buttonLoginIsDisplayed(){assertTrue((buttonLogin.isDisplayed()));
        return true;
    }

    public boolean listPasswordsForAllUsersIsDisplayed(){assertTrue((listPasswordsForAllUsers.isDisplayed()));
        return true;
    }
    public boolean listAcceptedUserNamesIsDisplayed(){assertTrue((listAcceptedUserNames.isDisplayed()));
        return true;
    }
public void loginWithValidData(){

}
}
