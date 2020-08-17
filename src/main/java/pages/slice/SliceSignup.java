package pages.slice;

import config.DriverContainer;
import elements.Button;
import elements.Input;
import org.openqa.selenium.By;
import pages.BasePage;

public class SliceSignup extends BasePage {
    {
        driver = DriverContainer.getInstance().getDriver();
    }

    private Input emailInput = new Input(By.cssSelector("[class=email]"), driver);
    private Button termsCheckbox = new Button(By.id("agreeInput"), driver);
    private Button signUpButton = new Button(By.xpath("//button[contains(text(), 'SIGN UP')]"), driver);
    private Button createPassword = new Button(By.xpath("//button[contains(text(), 'CREATE PASSWORD')]"), driver);
    private Input passwordInput = new Input(By.cssSelector("[type=password]"), driver);
    private Button importPurchases = new Button(By.xpath("//button[contains(text(), 'AUTO IMPORT PURCHASES')]"), driver);
    private Button skipCreditCard = new Button(By.partialLinkText("No thanks"), driver);

    public SliceSignup open() {
        driver.get("https://www.slice.com/signup");
        return this;
    }


    public SliceSignup enterEmail(String email) {
        emailInput.enter(email);
        return this;
    }

    public SliceSignup clickTermsCheckBox() {
        termsCheckbox.click();
        return this;
    }

    public SliceSignup clickSignup() {
        signUpButton.click();
        return this;
    }

    public SliceSignup enterEmailPassword(String passwd) {
        passwordInput.enter(passwd);
        return this;
    }

    public SliceSignup enterSlicePassword(String passwd) {
        passwordInput.enter(passwd);
        return this;
    }

    public SliceSignup clickImportPurchases() {
        importPurchases.waitForAttributeNotPresent("disabled");
        importPurchases.click();
        importPurchases.waitForDisappear();
        return this;
    }

    public SliceSignup clickCreatePassword() {
        createPassword.click();
        return this;
    }

    public SliceBootstrap clickSkipCreditCard() {
        skipCreditCard.click();
        return createInstance(SliceBootstrap.class);
    }

}
