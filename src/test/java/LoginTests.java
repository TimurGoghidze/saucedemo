import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LoginTests extends TestBase {

    @Test
    public void loginWithValidData() { //вызвали метод из LoginPage
        User user = new User(validusername, validpassword);
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);
        loginPage.login(user);
        assertTrue(inventoryPage.inventoryList.isDisplayed());
    }
    @Test
    public void loginLockedOutUser(){
        User lockOutUser = new User(lockedOutUsername, lockedOutPassword);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(lockOutUser);
        assertTrue(loginPage.errorMessage.isDisplayed());
       // assertTrue(loginPage.errorMessage.getText().contains("Epic sadface: Sorry, this user has been locked out."));
    }
}














