package tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import pages.amazon.Amazon;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AmazonTest {

    @Test
    public void amazSignup() {
        String title = "House Without Lies (Lily's House Book 1)";
        new Amazon()
                .open()
                .search(title)
                .selectFirstItem();

        String bookTitle = new Amazon().getTitle();
        assertThat(bookTitle).isEqualTo(title);

    }

}
