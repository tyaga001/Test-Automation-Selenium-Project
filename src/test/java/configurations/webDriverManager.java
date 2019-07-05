package configurations;

import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class webDriverManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(webDriverManager.class);
    private static final String BROWSER = "browser";

    public webDriverManager() {

        DriverManagerType type = getBrowser();
        WebDriverManager.getInstance(type).setup();
    }

    private DriverManagerType getBrowser() {
        String browser = System.getProperty(BROWSER);
        if (browser == null) {
            browser = System.getenv(BROWSER);
            if (browser == null) {
                browser = "Chrome";
            }
        }
        return getDriverType(browser);
    }

    private DriverManagerType getDriverType(String type) {

        return DriverManagerType.valueOf(type.toUpperCase());
    }

}
