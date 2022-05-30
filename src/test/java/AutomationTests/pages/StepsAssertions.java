package AutomationTests.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StepsAssertions {
    private WebDriver driver;

    public StepsAssertions(WebDriver driver) {
        this.driver = driver;
    }

    public void StepsAssertionRegisteredUser() {
            driver.get("http://online-sh.herokuapp.com/login");
            driver.findElement(By.id("exampleInputEmail1")).sendKeys("test@test.com");
            driver.findElement(By.id("exampleInputPassword1")).sendKeys("Test");
            driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();

    }


    public void checkingTheTransitionToTheLoginPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(500L));
        wait.until(ExpectedConditions.urlToBe("http://online-sh.herokuapp.com/login"));
    }
    public void checkingTheTransitionToTheAllProductsPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(500L));
        wait.until(ExpectedConditions.urlToBe("http://online-sh.herokuapp.com/products"));
    }

    public void checkingDeleteButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(500L));
        WebElement elementDeleteDuton = driver.findElement(By.xpath("//button[@class='btn btn-outline-danger']"));
        wait.until(ExpectedConditions.elementToBeClickable(elementDeleteDuton));

    }



}