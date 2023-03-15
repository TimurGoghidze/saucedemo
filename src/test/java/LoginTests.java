import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class LoginTests {
    WebDriver driver;

    @Before
    public void setUp() {// для порядка преобразуем так
        System.setProperty("webdriver.chrome.driver", "D:/2 tel run/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        String BASE_URL = "https://www.saucedemo.com/";
        driver.get(BASE_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize(); // разворачивание окна
    }

    @Test
    public void loginWithValidData() { //вызвали метод из LoginPage
        String username = "standard_user";
        String password = "secret_sauce";
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);
        loginPage.login(username, password);
        assertTrue(inventoryPage.inventoryList.isDisplayed());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
