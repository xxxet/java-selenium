package pages.amazon;

import elements.Button;
import elements.Input;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

import javax.inject.Inject;


public class AmazonResults extends BasePage {

    private final Button firstItemBtn = elBuilder.locator(By.cssSelector("[cel_widget_id*=SEARCH_RESULTS] div[class*='sg-col']")).build().buildButton();

    private final Input ebookTitleInput = elBuilder.locator(By.cssSelector("[id*=productTitle]")).build().buildInput();

    @Inject
    public AmazonResults(WebDriver driver) {
        super(driver);
    }


    public AmazonResults selectFirstItem() {
        firstItemBtn.click();
        return this;
    }


    public String getTitle() {
        return ebookTitleInput.getText();
    }
}
