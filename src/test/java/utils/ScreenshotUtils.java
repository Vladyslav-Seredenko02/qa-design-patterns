package utils;

import drivers.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenshotUtils {
    public static byte[] takeScreenshot() {
        return ((TakesScreenshot) DriverFactory.getDriver())
                .getScreenshotAs(OutputType.BYTES);
    }
}