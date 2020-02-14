package rough;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {

    WebDriver driver;

    @Test
    @Parameters({"env", "browser", "url", "emailId"})
    public void LoginTest(String env, String browser, String url, String emailId) {

        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "/Way2Automation_docs/chromedriver");
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "/Way2Automation_docs/chromedriver");
            driver = new FirefoxDriver();
        }
        driver.get(url);
        driver.findElement(By.xpath("//*[@id='login-username']")).clear();
        driver.findElement(By.xpath("//*[@id='login-username']")).sendKeys(emailId); // enter
        driver.findElement(By.xpath("//*[@id='login-signin']")).click(); // click

    }
}
