package tests;

import config.DaggerPageComponent;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import static org.assertj.core.api.Assertions.assertThat;


public class AmazonSearchTest  {


    @Test
    @Disabled
    public void amazon_search() {
        var title = "House Without Lies (Lily's House Book 1)";

        var bookTitle = DaggerPageComponent.create().amazonHome().open()
                .search(title)
                .selectFirstItem().getTitle();

        assertThat(bookTitle).isEqualTo(title);
    }
}
