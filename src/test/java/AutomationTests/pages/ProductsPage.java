package AutomationTests.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ProductsPage {
    private WebDriver driver;

    public ProductsPage(WebDriver driver){
        this.driver = driver;
    }
    By addButtonProduct = By.xpath("//a[@class = 'btn btn-outline-success']");
    By productName = By.xpath("//input[@id='exampleInputProduct1']");
    By productPrice = By.xpath("//input[@id='exampleInputPrice1']");
    By submitButtonProduct = By.xpath("//button[@class='btn btn-outline-success']");
    By updateButtonProduct = By.xpath("//button[@class='btn btn-outline-warning']");
    By deleteButtonProduct = By.xpath("//button[@class='btn btn-outline-danger']");
    By logOutButtonProduct = By.xpath("//a[@class='btn btn-dark']");
    By updateProductName = By.id("exampleInputProduct1");
    By updateProductPrice = By.id("exampleInputPrice1");
    By updateSubmitButton = By.xpath(("//button[@class='btn btn-outline-warning']"));

    public void openProductPage(){
        driver.get("http://online-sh.herokuapp.com/products");
    }

    @Step("Click add button")
    public void checkAddButtonProduct(){
        driver.findElement(addButtonProduct).click();
    }
    @Step("Set product name {TextProductName}")
    public void setAddProductName(String TextProductName){
        driver.findElement(productName).sendKeys(TextProductName);
    }
    @Step("Set product price {TextProductPrice}")
    public void setAddProductPrice(String TextProductPrice){
        driver.findElement(productPrice).sendKeys(TextProductPrice);
    }
    @Step("Click submit button")
    public void checkSubmitButtonProduct(){
        driver.findElement(submitButtonProduct).click();
    }
    @Step("Click update button")
    public void checkUpdateButtonProduct(){
        driver.findElement(updateButtonProduct).click();
    }

    @Step("Click delete button")
    public void checkDeleteButtonProduct(){
        driver.findElement(deleteButtonProduct).click();
    }
    @Step("Click logout button")
    public void checkLogOutButtonProduct(){
        driver.findElement(logOutButtonProduct).click();
    }
    @Step("Set update product name {TextProductName}")
    public void setProductNameUpdate (String textName){
        driver.findElement(updateProductName).clear();
        driver.findElement(updateProductName).sendKeys(textName);
    }
    @Step("Set update product price {TextProductPrice}")
    public void setProductPriceUpdate (String textPrice){
        driver.findElement(updateProductPrice).clear();
        driver.findElement(updateProductPrice).sendKeys(textPrice);
    }
    @Step("Click submit button")
    public void checkUpdateSubmitButton(){
        driver.findElement(updateSubmitButton).click();
    }





}
