package AutomationTests.scenarios;

import AutomationTests.pages.RegistrationPage;
import AutomationTests.pages.StepsAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RegistrationTest{
        private static WebDriver driver;
        private static RegistrationPage registrationPage;
        private static StepsAssertions stepsAssertions;


        public RegistrationTest() {
                System.setProperty("webdriver.chrome.driver", "C:/DRIVERS/chromedriver.exe");

                ChromeOptions options = new ChromeOptions();
                options.addArguments("start-maximized");
                options.setPageLoadStrategy(PageLoadStrategy.EAGER);
                options.setHeadless(false);
                driver =new ChromeDriver(options);
                registrationPage = new RegistrationPage(driver);
                stepsAssertions = new StepsAssertions(driver);
                driver = new ChromeDriver(options);

        }

        @Test
        public void RegistrationPageTest(){
        //GIVEN
        //WHEN
        registrationPage.openRegistrationPage();
        registrationPage.setRegistrationName("orangeTest");
        registrationPage.setRegistrationLastName("orangeTest");
        registrationPage.setRegistrationEmailAddress("orange@test.com");
        registrationPage.setRegistrationPassword("test");
        registrationPage.submitRegistrationButton();
        //THEN
        stepsAssertions.checkingTheTransitionToTheLoginPage();
        }
        @Test
        public void Labels(){
                //GIVEN
                //WHEN
                //THEN
                //Не уверен что так можно делать, на мой взгляд не особо надёжно, что бы все проверки разом делать.
                registrationPage.openRegistrationPage();
                registrationPage.findRegistrationName();
                registrationPage.findRegistrationLastName();
                registrationPage.findRegistrationEmailAddress();
                registrationPage.findRegistrationPassword();
        }
        @Test
        public void ValidationMassage(){
                registrationPage.openRegistrationPage();
                registrationPage.findValidationMassageEmailAddress();
        }

        @AfterEach
        public void cleanUp() {
                driver.close();
                driver.quit();
        }

    }
