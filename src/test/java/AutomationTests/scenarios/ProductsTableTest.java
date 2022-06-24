package AutomationTests.scenarios;


import AutomationTests.ScreenshotOnFailure.BaseSetUp;
import TableTest.TableTest;
import AutomationTests.pages.LoginPage;
import AutomationTests.pages.ProductsTable;
import AutomationTests.pages.StepsAssertions;
import io.qameta.allure.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static AutomationTests.ScreenshotOnFailure.BaseSetUp.driver;

@Feature("Products table")
public class ProductsTableTest {
    static ProductsTable productsTable;
    static LoginPage loginPage;
    static StepsAssertions stepsAssertions;

    @BeforeAll
    static void init(){
        BaseSetUp baseSetUp = new BaseSetUp();
        productsTable = PageFactory.initElements(BaseSetUp.driver, ProductsTable.class);
        loginPage = PageFactory.initElements(BaseSetUp.driver,LoginPage.class);
        stepsAssertions = PageFactory.initElements(BaseSetUp.driver,StepsAssertions.class);
    }

   /* @BeforeEach
    void cleanUp(){
        //dbSteps.cleanProducts();
    }*/

    @Test
    @Story("Check products in table")
    public void checkProductsInTable() {
        //GIVEN
        TableTest product1 = TableTest.builder().id(1L)
                .name("orange")
                .price(2002F).build();
        TableTest product2 = TableTest.builder().
                id(1L).build();
        List<TableTest> products = List.of(product1, product2);
        //dbSteps.setProductsToDb(products);

        //WHEN
       stepsAssertions.StepsAssertionRegisteredUser();
       //THEN
        productsTable.checkAllProductsIsPresent();
        String firstRowText = productsTable.checkAllProductsCountIsEqualToExpected(7);
        System.out.println(firstRowText);
        Assertions.assertThat(firstRowText).contains(product1.getName());
    }
    @AfterAll
    @Step("Quit browser")
    static void tearDown(){
        driver.quit();
    }


}
