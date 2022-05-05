package AutomationTests;
import java.time.Duration;

import net.bytebuddy.build.Plugin;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstTest {
    private static WebDriver driver;

    public FirstTest(){
        System.setProperty("webdriver.chromedriver.driver", "C:\\Users\\Igor\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        options.setHeadless(false);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000L));

    }
    @Test
    public void testSearchResultPresent_seleniumInput(){
        //GIVEN
        driver.get("https://www.google.com/");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(500L));
        WebElement input = driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div[1]/div/div[2]/button/input"));
        //WHEN
        input.sendKeys("QA automation ");
        input.sendKeys(Keys.ENTER);
        //THEN
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//ul")));
        driver.close();
        driver.quit();
    }

    @Test
    public void testSearchResultPresent_JsInput(){
        //GIVEN
        driver.get("https://www.google.com/");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofMillis(500L));
        WebElement input = driver.findElement(By.xpath("/html/body/div[1]/div/div/main/div[1]/div/div[2]/button/input"));
        //WHEN
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        // set the text
        jsExecutor.executeScript("arguments[0].value='QA', input");
        input.sendKeys(Keys.ENTER);

        //THEN
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//ul")));
        driver.close();
        driver.quit();
    }

}
