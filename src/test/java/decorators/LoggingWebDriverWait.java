package decorators;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import java.util.function.Function;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoggingWebDriverWait extends WebDriverWait {
    private static final Logger log = LogManager.getLogger(LoggingWebDriverWait.class);

    public LoggingWebDriverWait(WebDriver driver, Duration timeout) {
        super(driver, timeout);
    }

    public <V> V until(Function<? super WebDriver, V> isTrue) {
        log.debug("Waiting for condition: {}", isTrue);
        V result = super.until(isTrue);
        log.debug("Condition met: {}", isTrue);
        return result;
    }
}