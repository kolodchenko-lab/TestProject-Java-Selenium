package AutomationTests.scenarios;

import AutomationTests.ScreenshotOnFailure.BaseSetUp;
import AutomationTests.ScreenshotOnFailure.ScreenshotOnFailure;
import AutomationTests.pages.ProductsPage;
import AutomationTests.pages.StepsAssertions;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.support.PageFactory;

import static AutomationTests.ScreenshotOnFailure.BaseSetUp.driver;

@Feature("Product page functionality")
public class ProductTest {
    private static ProductsPage productsPage;
    private static StepsAssertions stepsAssertions;


        @BeforeAll
        static void init() {
            BaseSetUp baseSetUp = new BaseSetUp();
            productsPage = PageFactory.initElements(driver,ProductsPage.class);
            stepsAssertions = PageFactory.initElements(driver,StepsAssertions.class);
        }

    @RegisterExtension
    ScreenshotOnFailure watch = new ScreenshotOnFailure(BaseSetUp.driver, "target/surefire-reports");
    @Test
    @Story("Add product successful")
       public void byAddProductTest()  {
        //GIVEN
        String existingProductName = "orange";
        String existingProductPrice = "2002";
        //WHEN
        //THEN
        stepsAssertions.StepsAssertionRegisteredUser();
        productsPage.checkAddButtonProduct();
        productsPage.setAddProductName(existingProductName);
        productsPage.setAddProductPrice(existingProductPrice);
        productsPage.checkSubmitButtonProduct();


    }
    @Test
    @Story("Check delete test product")
    public void DeleteTestProduct(){
        //GIVEN
        stepsAssertions.StepsAssertionRegisteredUser();
        //WHEN
        //THEN
        productsPage.checkDeleteButtonProduct();
    }

    @Test
    @Story("Check LogOut button")
    public void CheckLogOutButton() {
        //GIVEN
        stepsAssertions.StepsAssertionRegisteredUser();
        //WHEN
        //THEN
        productsPage.checkLogOutButtonProduct();

    }
    @Test
    @Story("Check update product")

    public void UpdateButtonTest() throws InterruptedException {
        //GIVEN
        String productNameUpdate = "orangeTest";
        String productPriceUpdate = "202";
       stepsAssertions.StepsAssertionRegisteredUser();
       //WHEN
        productsPage.checkUpdateButtonProduct();
        productsPage.setProductNameUpdate(productNameUpdate);
        productsPage.setProductPriceUpdate(productPriceUpdate);
        //THEN
        productsPage.checkUpdateSubmitButton();
        //stepsAssertions.checkTheTransitionToTheAllProductsPage();


    }
    @AfterAll
    @Step("Quit browser")
    static void tearDown(){
        driver.quit();
    }
    }


