package rough;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import pageObjects.BasePage;
import utils.AssertUtil;
import utils.FindUtil;

@Component
public class Rough {

    @Autowired
    @Lazy
    private FindUtil findUtil;

    @Autowired
    @Lazy
    private AssertUtil assertUtil;

    public void verifyTitleVisible(String title) {
        WebElement item = findUtil.findElement(By.xpath("abc"));
        if (findUtil.isElementDisplayed(item)) {

            /// do your stuff here

        } else {

            //// do your stuff here
        }


    }


}
