package AutomationTests.ScreenshotOnFailure;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseSetUp {
    public static WebDriver driver;

    public BaseSetUp(){
        System.setProperty("webdriver.chrome.driver", "C:/DRIVERS/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        options.setHeadless(false);

        driver = new ChromeDriver(options);
    }

}
