package drivers.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeBrowserDriver extends BrowserDriver {

    @Override
    public WebDriver createDriver() {
                    /*
                On my local WebDriver Manager for some reason can`t connect to repository with Edge driver,
                so I get "java.net.UnknownHostException: msedgedriver.azureedge.net" exception
                to avoid this exception I downloaded and set WebDriver locally
                If you are facing same issue please download and set up WebDriver locally as well,
                and adjust WebDriver path in setProperty method below
                 */
        System.setProperty("webdriver.edge.driver", "D:\\webdriver\\msedgedriver.exe");
//        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }
}