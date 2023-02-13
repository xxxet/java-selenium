package pages.amazon;

import elements.Button;
import elements.Input;
import org.openqa.selenium.By;
import pages.BasePage;


public class AmazonResults extends BasePage {
    private final Button firstItemBtn = new Button(By.cssSelector("[cel_widget_id*=SEARCH_RESULTS] div[class*='sg-col']"));
    private final Input ebookTitleInput = new Input(By.cssSelector("[id*=productTitle]"));



    public AmazonResults selectFirstItem() {
        firstItemBtn.click();
        return this;
    }


    public String getTitle() {
        return ebookTitleInput.getText();
    }
}
