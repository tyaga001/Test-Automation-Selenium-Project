package configurations;

import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class WebDriverConfigurationManager {

    public static final Logger LOGGER = LoggerFactory.getLogger(WebDriverConfigurationManager.class);
    public static final String BROWSER = "BROWSER";
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();


    public WebDriverConfigurationManager() {
        DriverManagerType driverManagerType = getBrowser();
        WebDriverManager.getInstance(driverManagerType).setup();
    }

    public static void maximizeBrowser(WebDriver driver) {
        driver.manage().window().maximize();
    }

    public static void setImplicitWait(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    private DriverManagerType getBrowser() {
        String browser = System.getProperty(BROWSER);
        if (browser == null) {
            browser = System.getenv(BROWSER);
            if (browser == null)
                browser = "CHROME";
        }
        return getDriverType(browser);

    }

    private DriverManagerType getDriverType(String browser) {
        return DriverManagerType.valueOf(browser.toUpperCase());
    }

    public WebDriver getSeleniumDriver() throws Exception {

        DriverManagerType browser = getBrowser();
        WebDriver driver = null;
        String browserType = System.getenv("BROWSERTYPE");
        switch (browser) {
            case CHROME: {

                if ("headless".equalsIgnoreCase(browserType)) {
                    driver = getHeadlessDriver();
                    break;
                } else {
                    driver = getChromeDriver();
                    break;
                }
            }
            case FIREFOX: {
                driver = new FirefoxDriver();
                break;
            }
            case EDGE: {

                driver = new EdgeDriver();
                break;
            }
        }
        return driver;
    }

    private ChromeDriver getHeadlessDriver() {
        ChromeOptions options = getHeadlessChromeOptions();
        return new ChromeDriver(options);
    }

    private ChromeOptions getHeadlessChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        options.addArguments("--remote-debugging-port=9222");
        return options;
    }

    private ChromeDriver getChromeDriver() {
        ChromeOptions options = getChromeOptions();
        return new ChromeDriver(options);
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, true);
        options.addArguments("--start-maximized");
        options.addArguments("disable-infobars");
        options.addArguments("--no-sandbox");
        return options;
    }
}
