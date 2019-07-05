package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(FindUtil.class);

    @Autowired
    private WebDriver webDriver;

    public WebElement findElement(By by) {
        try {
            return webDriver.findElement(by);
        } catch (NoSuchElementException e) {
            LOGGER.info("No such element on page" + String.valueOf(by));
            return null;
        }
    }

    public boolean isElementDisplayed(By by) {
        WebElement element = findElement(by);
        return element != null && element.isDisplayed();
    }
}
