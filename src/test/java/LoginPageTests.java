import io.qameta.allure.Description;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LoginPageTests extends TestBase {

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

    public void allLoginPageElementsAreDisplayed(){

    }
}














