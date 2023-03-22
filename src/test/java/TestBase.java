import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.annotation.OverridingMethodsMustInvokeSuper;
import java.time.Duration;

public class TestBase {

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

    @After
    public void tearDown() {
        driver.quit();
    }
    String validUsername = "standard_user";
    String validPassword = "secret_sauce";
    String lockedOutUsername = "locked_out_user";
    String lockedOutPassword = "secret_sauce1";

//    @Rule // не идёт подправить нужно
//    public TestWatcher screenshotOnFailure = new TestWatcher() {
//        @Override
//        protected Object clone() throws CloneNotSupportedException {
//            return super.clone();
//        }
//
//        protected void failed(Throwable e, Description description){
//            makeScreenshotOnFailure();
//            driver.close();
//            driver.quit(); //закрытие вкладок при отриц тесте
//        }
//        @Attachment("Screenshot on failure")
//        public byte[] makeScreenshotOnFailure(){
//            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//        }
//    @Override //ошибка тут
//        protected void succeeded(Description description){
//
//        }
//    };

}
