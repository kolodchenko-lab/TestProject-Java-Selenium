package AutomationTests.pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class RegistrationPage {

    private WebDriver driver;

    By registrationName = By.xpath("//input[@name='name']");
    By registrationLastName = By.xpath("//input[@name='last_Name']");
    By registrationEmailAddress = By.xpath("//input[@id='exampleInputEmail1']");
    By registrationPassword = By.xpath("//input[@id='exampleInputPassword1']");
    By registrationButton = By.xpath("//button[@class='btn btn-primary']");
    By registrationNameLabel = By.xpath("//label[text()='Name']");
    By registrationLastNameLabel = By.xpath("//label[text()='Last Name']");
    By registrationEmailAddressLabel = By.xpath("//label[@for='exampleInputEmail1']");
    By registrationPasswordLabel = By.xpath("//label[@for='exampleInputPassword1']");
    By registrationHelpLabel = By.xpath("//div[@id='emailHelp']");


    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Set name as {nameText}")
    public void setRegistrationName(String nameText) {
        driver.findElement(registrationName).sendKeys(nameText);
    }

    @Step("Set lastname as {lastNameText}")
    public void setRegistrationLastName(String lastNameText) {
        driver.findElement(registrationLastName).sendKeys(lastNameText);
    }

    @Step("Set email address as {emailAddressText}")
    public void setRegistrationEmailAddress(String emailAddressText) {
        driver.findElement(registrationEmailAddress).sendKeys(emailAddressText);
    }

    @Step("Set password as {registrationPasswordText}")
    public void setRegistrationPassword(String registrationPasswordText) {
        driver.findElement(registrationPassword).sendKeys(registrationPasswordText);
    }

    @Step("Click register button")
    public void checkRegistrationButton() {
        driver.findElement(registrationButton).click();
    }

    @Step("Open registration page")
    public void openRegistrationPage() {
        driver.get("http://online-sh.herokuapp.com/registration");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(800L));
        wait.until(ExpectedConditions.urlToBe("http://online-sh.herokuapp.com/registration"));
    }

    @Step("Check label 'Name'")
    public void findRegistrationName() {
        List<WebElement> elementLabelRegistration = driver.findElements(registrationNameLabel);
        boolean nameTrue = elementLabelRegistration.get(0).getText().contains("Name");
        Assertions.assertTrue(nameTrue);
    }

    @Step("Check label 'Last name'")
    public void findRegistrationLastName() {
        List<WebElement> elementLabelRegistration = driver.findElements(registrationLastNameLabel);
        boolean nameTrue = elementLabelRegistration.get(0).getText().contains("Last");
        Assertions.assertTrue(nameTrue);
    }

    @Step("Check label 'Email Address'")
    public void findRegistrationEmailAddress() {
        List<WebElement> elementLabelRegistration = driver.findElements(registrationEmailAddressLabel);
        boolean nameTrue = elementLabelRegistration.get(0).getText().contains("Email");
        Assertions.assertTrue(nameTrue);
    }

    @Step("Check label 'Registration Password'")
    public void findRegistrationPassword() {
        List<WebElement> elementLabelRegistration = driver.findElements(registrationPasswordLabel);
        boolean nameTrue = elementLabelRegistration.get(0).getText().contains("Password");
        Assertions.assertTrue(nameTrue);
    }

    @Step("Check label 'We'll never share your email with anyone else.'")
    public void findRegistrationHelpLabel() {
        List<WebElement> elementLabelRegistration = driver.findElements(registrationHelpLabel);
        boolean nameTrue = elementLabelRegistration.get(0).getText().contains("We'll never share");
        Assertions.assertTrue(nameTrue);

    }
}



