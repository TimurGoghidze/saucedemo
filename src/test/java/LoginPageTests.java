import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static org.junit.Assert.*;


public class LoginPageTests extends TestBase {

//    @Rule // Screenshot
//    public TestWatcher screenshotOnFailure = new TestWatcher() {
//        @Override
//        private void failed(Throwable e, Description description){
//            makeScreenshotOnFailure();
//        }
//        @Attachment("Screenshot on failure")
//            public byte[] makeScreenshotOnFailure(){
//                return((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
//            }
//        };

    @Test
    @Description("Login with valid data")
    public void loginWithValidData() { //вызвали метод из LoginPage
        User user = new User(validUsername, validPassword);
        new LoginPage(driver).login(user).inventoryListShouldBeDisplayed();

        //assertTrue(inventoryPage.inventoryList.isDisplayed());
    }

    @Test
    public void loginLockedOutUser() {
        User lockOutUser = new User(lockedOutUsername, lockedOutPassword);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(lockOutUser);
        loginPage.errorMessageShouldBeDisplayed();
        // assertTrue(loginPage.errorMessage.isDisplayed());
        // assertTrue(loginPage.errorMessage.getText().contains("Epic sadface: Sorry, this user has been locked out."));
    }

    @Test
    public void allLoginPageElementsAreDisplayed() {
        LoginPage loginPage = new LoginPage(driver);
        assertTrue(loginPage.fieldUserNameIsDisplayed());
        assertTrue(loginPage.fieldPasswordIsDisplayed());
        assertTrue(loginPage.buttonLoginIsDisplayed());
        assertTrue(loginPage.listAcceptedUserNamesIsDisplayed());
        assertTrue(loginPage.listPasswordsForAllUsersIsDisplayed());
    }
}














