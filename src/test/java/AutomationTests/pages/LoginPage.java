package AutomationTests.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginPage {

    private WebDriver driver;

    By emailInput = By.id("exampleInputEmail1");
    By passwordInput = By.id("exampleInputPassword1");
    By submitButton = By.xpath("//button[@class='btn btn-primary']");
    By labelEmailAddress = By.xpath("//label[text()='Email address']");
    By labelPassword = By.xpath("//label[text()='Password']");
    By emailHelp = By.xpath("//div[@id='emailHelp']");


    public void FindLabelEmailHelp() {
        List<WebElement> elements = driver.findElements(emailHelp);
        boolean elementTru = elements.get(0).getText().contains("We'll never");
        Assertions.assertTrue(elementTru);
    }
        public void FindLabelEmailAddress () {
            List<WebElement> elements = driver.findElements(labelEmailAddress);
            boolean elementTru = elements.get(0).getText().contains("Email address");
            Assertions.assertTrue(elementTru);
            //WebElement elementLabel = driver.findElement(labelEmailAddress);
            //org.assertj.core.api.Assertions.assertThat(elementLabel).isNotNull();
        }

        public void FindLabelPassword () {
            driver.findElement(labelPassword);
            List<WebElement> elements = driver.findElements(labelPassword);
            boolean elementTru = elements.get(0).getText().contains("Password");
            Assertions.assertTrue(elementTru);
            // WebElement elementLabel = driver.findElement(labelPassword);
            // org.assertj.core.api.Assertions.assertThat(elementLabel).isNotNull();
        }



    public LoginPage(WebDriver driver) {
            this.driver = driver;
        }
        public LoginPage setEmail (String emailText){
            driver.findElement(emailInput).sendKeys(emailText);
            return this;
        }

        public LoginPage setPassword (String passwordText){
            driver.findElement(passwordInput).sendKeys(passwordText);
            return this;
        }
        public LoginPage submit () {
            driver.findElement(submitButton).click();
            return this;
        }

        public LoginPage openLoginPage () {
            driver.get("http://online-sh.herokuapp.com/login");
            return this;

        }
    }

