package tests;

import config.DriverContainer;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;

public class ScreenshotWatcher implements TestExecutionExceptionHandler {

//    @Attachment(value = "Page screenshot", type = "image/png")
//    public byte[] captureScreenshot() {
//        return ((TakesScreenshot) DriverContainer.getInstance()).getScreenshotAs(OutputType.BYTES);
//
//    }

    @Override
    public void handleTestExecutionException(ExtensionContext ctx, Throwable throwable) throws Throwable {
        // handle exception
//        captureScreenshot();
        // failed test shown as green in report
        byte[] scrren = ((TakesScreenshot) DriverContainer.getInstance()).getScreenshotAs(OutputType.BYTES);
        System.out.println("operation not allowed for division");
        Allure.addAttachment("My attachment", "My attachment content");
        Allure.addAttachment("Faield test",  new ByteArrayInputStream(scrren));


    }
}

