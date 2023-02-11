package tests;
import pages.amazon.AmazonHome;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AmazonTest {


    @Test
    public void amazon_search() {
        var title = "House Without Lies (Lily's House Book 1)";

        // DaggerDriverComponent.create();
        var bookTitle = new AmazonHome().open()
                .search(title)
                .selectFirstItem().getTitle();

        assertThat(bookTitle).isEqualTo(title);

    }

}
