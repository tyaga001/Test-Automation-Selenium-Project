package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import utils.AssertUtil;
import utils.FindUtil;


@Component
public abstract class BasePage {

    @Autowired
    protected WebDriver driver;

    @Autowired
    protected FindUtil findUtil;

    @Autowired
    protected AssertUtil assertUtil;

    public void init() {
        PageFactory.initElements(driver, this);
    }
}

