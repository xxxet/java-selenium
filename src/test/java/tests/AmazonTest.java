package tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import pages.amazon.AmazonHome;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AmazonTest {

    @Test
    public void amazon_search() {
        String title = "House Without Lies (Lily's House Book 1)";

        String bookTitle = new AmazonHome().open()
                .search(title)
                .selectFirstItem().getTitle();

        assertThat(bookTitle).isEqualTo(title);

    }

}
