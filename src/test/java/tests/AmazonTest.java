package tests;

import config.DaggerPageComponent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.assertj.core.api.Assertions.assertThat;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AmazonTest {


    @Test
    public void amazon_search() {
        var title = "House Without Lies (Lily's House Book 1)";
//        AmazonHome amHome = DaggerDriverComponent.create().buildAmazonHome();

        var bookTitle = DaggerPageComponent.create().buildAmazonHome()
                .open()
                .search(title)
                .selectFirstItem().getTitle();

        assertThat(bookTitle).isEqualTo(title);
    }
}
