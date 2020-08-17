package pages.amazon;

import config.DriverContainer;
import elements.Button;
import elements.Input;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.RandStrings;

public class AmazonSingUp {
    {
        driver = DriverContainer.getInstance().getDriver();
    }

    private WebDriver driver;

    private Button createAccButtton = new Button(By.id("#createAccountSubmit"), driver);
    private Input nameInput = new Input(By.id("ap_customer_name"), driver);
    private Input emailInput = new Input(By.id("ap_email"), driver);
    private Input paswordInput = new Input(By.id("ap_password"), driver);
    private Input paswordCheckInput = new Input(By.id("ap_password_check"), driver);

    private Button submitButton = new Button(By.cssSelector("[type=submit]"), driver);
    private Input emailCode = new Input(By.cssSelector("[name='code']"), driver);
    private String autoDeliveredMessage = "You can go to your device to start reading";

    public void signUp() {
        String name = RandStrings.getRandom(10);
        String passwd =  RandStrings.getRandom(10);
        nameInput.enter(name);
//        emailInput
        paswordInput.enter(passwd);
        paswordCheckInput.enter(passwd);
        submitButton.click();
//        nextButton.click();
//
//        passwordInput.enter(aolConfig.password());
//        nextButton.click();
    }

    public void selectItem() {
//        nextButton.click();
    }


}
