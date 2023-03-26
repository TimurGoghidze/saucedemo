import io.qameta.allure.Step;
import org.openqa.selenium.ScriptTimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutStepOnePage extends BasePage {
    public CheckoutStepOnePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "first-name")
    private WebElement firstName;

    @FindBy(id = "last-name")
    private WebElement lastName;

    @FindBy(id = "postal-code")
    private WebElement postalCodeZip;

    @FindBy(id = "continue")
    private WebElement continueButton;


    @Step("Enter first name") //аннотация чтобы отчет в Allure был читаем и понятен
    public void enterFirstName(String nameValue) {
        enterTextToElement(nameValue, firstName);
    }

    @Step("Enter last name")
    public void enterLastName(String lastNameValue) {
        enterTextToElement(lastNameValue, lastName);
    }

    @Step("Enter Zip or Post code")
    public void enterZipPostCode(String zipValue) {
        enterTextToElement(zipValue, postalCodeZip);
    }

    @Step("Push continue button")
    public void clickOnContinueButton() {
        clickOnTheElement(continueButton);
    }


}
