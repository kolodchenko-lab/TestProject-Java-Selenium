package AutomationTests.pages;

import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductsTable {

    private WebDriver driver;
    public ProductsTable(WebDriver driver){
        this.driver = driver;
    }
    @FindBy(tagName = "table")
    private List<WebElement> allProductsView;

    @Step
    public ProductsTable checkAllProductsIsPresent(){
        Assertions.assertThat(allProductsView.size()).isEqualTo(1);
        return this;
    }
    @Step
    public String checkAllProductsCountIsEqualToExpected(int expectedProductsCount){
        List<WebElement> actualTableRows = allProductsView.get(0).findElements(By.tagName("tbody"))
                .get(0).findElements(By.tagName("tr"));
        String firstRowText = actualTableRows.get(5).getText();
        Assertions.assertThat(actualTableRows.size()).isEqualTo(expectedProductsCount);

        return firstRowText;

    }


}
