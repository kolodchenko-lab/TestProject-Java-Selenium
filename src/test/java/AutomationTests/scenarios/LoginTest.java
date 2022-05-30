package AutomationTests.scenarios;

import AutomationTests.pages.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginTest {
    private static WebDriver driver;
    static LoginPage loginPage;

    public LoginTest(){
        System.setProperty("webdriver.chrome.driver", "C:/DRIVERS/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        options.setHeadless(false);

        driver = new ChromeDriver(options);
        loginPage = new LoginPage(driver);

    }
    @Test
    public void LabelEmailHelp(){
        //GIVEN
        //WHEN
        loginPage.openLoginPage();
        loginPage.FindLabelEmailHelp();
    }

    @Test
    public void LabelEmailAddress(){
        //GIVEN
        //WHEN
        loginPage.openLoginPage();
        loginPage.FindLabelEmailAddress();
    }

    @Test
    public void LabelPassword(){
        //GIVEN
        //WHEN
        loginPage.openLoginPage();
        loginPage.FindLabelPassword();
    }

    @Test
    public void byRelativeLocatorTest() throws InterruptedException {
        //GIVEN
        String existingUserEmail = "test@test.com";
        String existingUserPassword = "Test";
        //WHEN
        loginPage.openLoginPage();
        loginPage.setEmail(existingUserEmail);
        loginPage.setPassword(existingUserPassword);

        loginPage.submit();

        //THEN
        checkUserIsRedirectedToProducts();

    }

    private void checkUserIsRedirectedToProducts() {
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals("http://online-sh.herokuapp.com/products",currentUrl);
    }

    @AfterEach
    public void cleanUp() {
        driver.close();
        driver.quit();
    }

}
