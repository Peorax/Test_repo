package UI;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class TextFormPage {
        private WebDriver driver;
        private WebDriverWait wait;

        @BeforeMethod
        public void setUp() {
            driver = new ChromeDriver(); // или FirefoxDriver()
            wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            driver.manage().window().maximize();
            driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        }

        @Test
        public void testWebFormSubmission() {

            WebElement textInput = driver.findElement(By.id("my-text-id"));
            textInput.sendKeys("ФИО");

            WebElement textarea = driver.findElement(By.name("my-textarea"));
            textarea.sendKeys("Название компании");

            WebElement passwordInput = driver.findElement(By.name("my-password"));
            passwordInput.sendKeys("Password");

            Select dropdown = new Select(driver.findElement(By.name("my-select")));
            dropdown.selectByValue("2");


            WebElement datalistInput = driver.findElement(By.name("my-datalist"));
            datalistInput.sendKeys("Seattle");

            WebElement checkbox1 = driver.findElement(By.id("my-check-1"));
            WebElement checkbox2 = driver.findElement(By.id("my-check-2"));
            if (!checkbox1.isSelected()) checkbox1.click();
            if (!checkbox2.isSelected()) checkbox2.click();


            WebElement radioButton = driver.findElement(By.id("my-radio-2"));
            radioButton.click();


            WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
            submitButton.click();

            WebElement successMessage = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("message"))
            );
        }

        @AfterMethod
        public void tearDown() {
            if (driver != null) {
                driver.quit();
            }
        }
    }
