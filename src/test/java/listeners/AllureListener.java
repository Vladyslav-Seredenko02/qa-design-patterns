package listeners;

import io.qameta.allure.Allure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ScreenshotUtils;

import java.io.ByteArrayInputStream;

public class AllureListener implements ITestListener {
    private static final Logger log = LogManager.getLogger(AllureListener.class);

    @Override
    public void onTestFailure(ITestResult result) {
        log.error("Test failed: {}", result.getName());

        byte[] screenshot = ScreenshotUtils.takeScreenshot();
        Allure.addAttachment("Screenshot", "image/png", new ByteArrayInputStream(screenshot), ".png");
    }
}