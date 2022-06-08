package AutomationTests.scenarios;

import AutomationTests.ClientManual.ClientManual;
import AutomationTests.ScreenshotOnFailure.BaseSetUp;
import AutomationTests.ScreenshotOnFailure.ScreenshotOnFailure;
import AutomationTests.pages.LoginPage;
import AutomationTests.pages.StepsAssertions;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.support.PageFactory;


@Feature("Login functionality")
public class LoginTest {

    static LoginPage loginPage;
    static StepsAssertions stepsAssertions;

    @BeforeAll
    static void init(){
        BaseSetUp baseSetUp = new BaseSetUp();
        loginPage = PageFactory.initElements(BaseSetUp.driver,LoginPage.class);
        stepsAssertions = PageFactory.initElements(BaseSetUp.driver,StepsAssertions.class);

    }
    @RegisterExtension
    ScreenshotOnFailure watch = new ScreenshotOnFailure(BaseSetUp.driver, "target/surefire-reports");
    @Test
    @Story("Login successful")
    @Description("Check login is successful after entering valid credentials  ")
    public void LabelEmailHelp(){
        //GIVEN
        Long existingClientId = 123L;
        ClientManual clientManual = new ClientManual.ClientBuilder(existingClientId)
                .withName("test")
                .withLastName("testLastName")
                .withAddress("testAddress")
                .build();
        //WHEN
        loginPage.openLoginPage();
        loginPage.FindLabelEmailHelp();
    }

    @Test
    @Story("Check validation massage with screenshot")
    @Description
    public void checkValidationMassageWithScreenshot(){
        //GIVEN
        String notValidationEmail = "testTest";
        //WHEN
        loginPage.openLoginPage();
        loginPage.notCorrectEmailAddress(notValidationEmail);
        loginPage.submit();
        //THEN
        loginPage.checkValidationMassage();


    }

    @Test
    @Story("Check label Email address")
    public void LabelEmailAddress(){
        //GIVEN
        //WHEN
        loginPage.openLoginPage();
        loginPage.FindLabelEmailAddress();
    }

    @Test
    @Story("Check label password")

    public void LabelPassword(){
        //GIVEN
        //WHEN
        loginPage.openLoginPage();
        loginPage.FindLabelPassword();
    }
    @Test
    @Story("Relative locator test")
    public void byRelativeLocatorTest()  {
        //GIVEN
        String existingUserEmail = "test@test.com";
        String existingUserPassword = "Test";
        //WHEN
        loginPage.openLoginPage();
        loginPage.setEmail(existingUserEmail);
        loginPage.setPassword(existingUserPassword);

        loginPage.submit();

        //THEN
        stepsAssertions.checkUserIsRedirectedToProducts();

    }


    @AfterAll
    @Step("Quit browser")
    static void tearDown(){
        BaseSetUp.driver.quit();
    }

}
