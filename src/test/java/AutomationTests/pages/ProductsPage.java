package AutomationTests.pages;

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


    public void setAddButtonProduct(){
        driver.findElement(addButtonProduct).click();
    }

    public void setAddProductName(String TextProductName){
        driver.findElement(productName).sendKeys(TextProductName);
    }

    public void setAddProductPrice(String TextProductPrice){
        driver.findElement(productPrice).sendKeys(TextProductPrice);
    }
    public void setSubmitButtonProduct(){
        driver.findElement(submitButtonProduct).click();
    }

    public void setUpdateButtonProduct(){
        driver.findElement(updateButtonProduct).click();
    }

    public void checkDeleteButtonProduct(){
        driver.findElement(deleteButtonProduct).click();
    }
    public void setLogOutButtonProduct(){
        driver.findElement(logOutButtonProduct).click();
    }
    public void setProductNameUpdate (String textName){
        driver.findElement(updateProductName).clear();
        driver.findElement(updateProductName).sendKeys(textName);
    }
    public void setProductPriceUpdate (String textPrice){

        driver.findElement(updateProductPrice).clear();
        driver.findElement(updateProductPrice).sendKeys(textPrice);
    }

    public void setUpdateSubmitButton (){
        driver.findElement(updateSubmitButton).click();
    }





}
