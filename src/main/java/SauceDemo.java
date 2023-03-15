import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SauceDemo {
    ChromeDriver driver;

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
    public void loginWithValidData() {
        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement buttonLogin = driver.findElement(By.id("login-button"));
        buttonLogin.click();

        assertTrue(driver.getTitle().contains("Swag Labs"));
        assertTrue(driver.getCurrentUrl().contains("inventory"));//in URL is inventory

    }




    @After
    public void tearDown() {
        driver.quit();
    }

}
