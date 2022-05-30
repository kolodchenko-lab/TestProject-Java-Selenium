package AutomationTests.scenarios;

import AutomationTests.pages.LoginPage;
import AutomationTests.pages.ProductsPage;
import AutomationTests.pages.StepsAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ProductTest {
    private static WebDriver driver;
    private static ProductsPage productsPage;
    private static StepsAssertions stepsAssertions;
    private static LoginPage loginPage;

    private ProductTest() {
        System.setProperty("webdriver.chrome.driver", "C:/DRIVERS/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        options.setHeadless(false);

        driver = new ChromeDriver(options);
        productsPage = new ProductsPage(driver);
        stepsAssertions = new StepsAssertions(driver);
        loginPage = new LoginPage(driver);


    }

    @Test
    public void byAddProductTest() throws InterruptedException {
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
    @AfterEach
    public void cleanUp() {
        driver.close();
        driver.quit();
    }
}

