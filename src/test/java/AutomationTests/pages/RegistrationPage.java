package AutomationTests.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class RegistrationPage{

    private WebDriver driver;

    By registrationName = By.xpath("//input[@name='name']");
    By registrationLastName = By.xpath("//input[@name='last_Name']");
    By registrationEmailAddress = By.xpath("//input[@id='exampleInputEmail1']");
    By registrationPassword = By.xpath("//input[@id='exampleInputPassword1']");
    By registrationButton   = By.xpath("//button[@class='btn btn-primary']");
    By registrationNameLabel = By.xpath("//label[text()='Name']");
    By registrationLastNameLabel = By.xpath("//label[text()='Last Name']");
    By registrationEmailAddressLabel = By.xpath("//label[@for='exampleInputEmail1']");
    By registrationPasswordLabel = By.xpath("//label[@for='exampleInputPassword1']");


    public RegistrationPage(WebDriver driver){
        this.driver = driver;
    }

    public void setRegistrationName(String nameText){
        driver.findElement(registrationName).sendKeys(nameText);

    }

    public void setRegistrationLastName(String lastNameText){
        driver.findElement(registrationLastName).sendKeys(lastNameText);
    }

    public void setRegistrationEmailAddress (String emailAddressText){
        driver.findElement(registrationEmailAddress).sendKeys(emailAddressText);
    }

    public void setRegistrationPassword (String registrationPasswordText){
        driver.findElement(registrationPassword).sendKeys(registrationPasswordText);
    }
    public void submitRegistrationButton (){
        driver.findElement(registrationButton).click();
    }

    public void openRegistrationPage(){
        driver.get("http://online-sh.herokuapp.com/registration");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(800L));
        wait.until(ExpectedConditions.urlToBe("http://online-sh.herokuapp.com/registration"));
    }

    public void findValidationMassageEmailAddress(){
        WebElement element = driver.findElement(registrationEmailAddress);
        String containsTrue = element.getAttribute("validationMessage");
        org.assertj.core.api.Assertions.assertThat(containsTrue).isNotNull();
        //Assertions.assertTrue(Boolean.parseBoolean(containsTrue));

    }

    public void findRegistrationName (){
        List<WebElement> elementLabelRegistration = driver.findElements(registrationNameLabel);
        boolean nameTrue = elementLabelRegistration.get(0).getText().contains("Name");
        Assertions.assertTrue(nameTrue);
    }

    public void findRegistrationLastName (){
        List<WebElement> elementLabelRegistration = driver.findElements(registrationLastNameLabel);
        boolean nameTrue = elementLabelRegistration.get(0).getText().contains("Last");
        Assertions.assertTrue(nameTrue);
    }
    public void findRegistrationEmailAddress (){
        List<WebElement> elementLabelRegistration = driver.findElements(registrationEmailAddressLabel);
        boolean nameTrue = elementLabelRegistration.get(0).getText().contains("Email");
        Assertions.assertTrue(nameTrue);
    }
    public void findRegistrationPassword (){
        List<WebElement> elementLabelRegistration = driver.findElements(registrationPasswordLabel);
        boolean nameTrue = elementLabelRegistration.get(0).getText().contains("Password");
        Assertions.assertTrue(nameTrue);
    }


    }



