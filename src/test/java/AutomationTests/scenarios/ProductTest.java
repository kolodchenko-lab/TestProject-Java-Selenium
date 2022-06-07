package AutomationTests.scenarios;

import AutomationTests.ScreenshotOnFailure.BaseSetUp;
import AutomationTests.ScreenshotOnFailure.TestWatcher;
import AutomationTests.pages.LoginPage;
import AutomationTests.pages.ProductsPage;
import AutomationTests.pages.StepsAssertions;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import static AutomationTests.ScreenshotOnFailure.BaseSetUp.driver;


@ExtendWith(TestWatcher.class)
public class ProductTest {
    private static ProductsPage productsPage;
    private static StepsAssertions stepsAssertions;


        @BeforeAll
        static void init() {
            BaseSetUp baseSetUp = new BaseSetUp();
            productsPage = PageFactory.initElements(driver,ProductsPage.class);

            stepsAssertions = new StepsAssertions(driver);
        }


    @Test
    @Step()
    public void byAddProductTest()  {
        //GIVEN
       stepsAssertions.StepsAssertionRegisteredUser();
        //GIVEN
        String existingProductName = "orange";
        String existingProductPrice = "2002";
        //WHEN
        productsPage.openProductPage();
        productsPage.setAddButtonProduct();
        productsPage.setAddProductName(existingProductName);
        productsPage.setAddProductPrice(existingProductPrice);
        productsPage.setSubmitButtonProduct();
        productsPage.setLogOutButtonProduct();
        //THEN
        stepsAssertions.checkingTheTransitionToTheLoginPage();

    }
    @Test
    public void DeleteTestProduct(){
        //GIVEN
        stepsAssertions.StepsAssertionRegisteredUser();
        //WHEN
        productsPage.checkDeleteButtonProduct();
        //THEN
        stepsAssertions.checkingDeleteButton();

    }
    @Test
    public void UpdateButtonTest() throws InterruptedException {
        //GIVEN
        String productNameUpdate = "orangeTest";
        String productPriceUpdate = "202";
       stepsAssertions.StepsAssertionRegisteredUser();
       //WHEN
        productsPage.setUpdateButtonProduct();
        productsPage.setProductNameUpdate(productNameUpdate);
        productsPage.setProductPriceUpdate(productPriceUpdate);
        productsPage.setUpdateSubmitButton();
        //THEN
        stepsAssertions.checkingTheTransitionToTheAllProductsPage();


    }
    @AfterAll
    @Step("Quit browser")
    static void tearDown(){
        driver.quit();
    }
    }


