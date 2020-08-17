package tests;

import org.junit.jupiter.api.*;
import pages.slice.SliceBootstrap;
import pages.slice.SliceHeader;
import pages.slice.SliceOrders;
import pages.slice.SliceSignup;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SlicePurchaseTest {

    @BeforeAll
    void createSliceAccount() {
        new SliceSignup().open()
                .enterEmail("asdfg.q@aol.com")
                .clickTermsCheckBox()
                .clickSignup()
                .enterEmailPassword("kae3Aeh7")
                .clickImportPurchases()
                .enterSlicePassword("123qwerty")
                .clickCreatePassword()
                .clickSkipCreditCard();
    }

    @Test
    void checkPurchase() {
        SliceOrders ordersPage = new SliceBootstrap()
                .clickContinue()
                .header()
                .openOrders();

        assertThat(Arrays.asList(
                ordersPage.getMerchant(),
                ordersPage.getStatus(),
                ordersPage.getDescription()))
                .contains("Amazon", "Purchased", "House Without Lies (Lily's House Book 1)"
                ).as("Order doesn't contain expected details");
    }


    @AfterAll
    void deactivateSlice() {
        new SliceHeader()
                .openSettings()
                .deactivateAccount();
    }
}