package utils;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class AssertUtil extends Assert {

    public static final Logger LOGGER = LoggerFactory.getLogger(AssertUtil.class);

    @Autowired
    @Lazy
    private FindUtil findUtil;
    @Autowired
    @Lazy
    private WebDriver webDriver;

    public static void assertEqualText(String actualText, String expectedText) {
        assertEquals("Expected & Actual Text didn't match", actualText, expectedText);
        LOGGER.info("Actual(" + actualText + ") and Expected (" + expectedText + ")Text match");
    }

    public void assertElementVisible(WebElement webElement, String objDesc) {
        assertTrue("Expected:\"" + objDesc
                + "\" should be visible, Found: \"" + objDesc
                + "\" is not visible !!!", findUtil.isElementDisplayed(webElement));
        LOGGER.info("\"" + objDesc + "\" is visible!!!<br>");
    }
}
