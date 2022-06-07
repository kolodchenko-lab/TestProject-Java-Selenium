package AutomationTests.scenarios;

import AutomationTests.ClientManual.ClientManual;
import AutomationTests.ScreenshotOnFailure.BaseSetUp;
import AutomationTests.ScreenshotOnFailure.ScreenshotOnFailure;
import AutomationTests.pages.LoginPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.support.PageFactory;

@Feature("Login functionality")
public class LoginTest {

    static LoginPage loginPage;

    @BeforeAll
    static void init(){
        BaseSetUp baseSetUp = new BaseSetUp();
        loginPage = PageFactory.initElements(BaseSetUp.driver,LoginPage.class);

    }

    @Test
    @Story("Login successful")
    @Issue("issue- 1234")
    @Description("Check login is successful after entering valid credentials  ")
    public void LabelEmailHelp(){
        //GIVEN
        Long existingClientId = 123L;
        ClientManual clientManual = new ClientManual.ClientBuilder(existingClientId)
                .withName("test")
                .withLastName("tetsLastName")
                .withAddress("testadress")
                .build();
        //WHEN
        loginPage.openLoginPage();
        loginPage.FindLabelEmailHelp();
    }
    @RegisterExtension
    ScreenshotOnFailure watch = new ScreenshotOnFailure(BaseSetUp.driver, "target/surefire-reports");
    @Test
    @Story("Login successful")
    @Description("Check login is successful after entering valid credentials  ")
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
    @RegisterExtension
    ScreenshotOnFailure watcher = new ScreenshotOnFailure(BaseSetUp.driver, "target/surefire-reports");
    @Test
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
        checkUserIsRedirectedToProducts();

    }

    private void checkUserIsRedirectedToProducts() {
        String currentUrl = BaseSetUp.driver.getCurrentUrl();
        Assertions.assertEquals("http://online-sh.herokuapp.com/products",currentUrl);
    }

    @AfterAll
    @Step("Quit browser")
    static void tearDown(){
        BaseSetUp.driver.quit();
    }

}
