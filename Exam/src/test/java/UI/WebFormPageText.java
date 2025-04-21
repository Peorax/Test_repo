package UI;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebFormPageText {

    public WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        chromeOptions.setCapability(CapabilityType.PAGE_LOAD_STRATEGY,"eager");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @Test(description = "Перейти на страницу 'WebForm', внести значения в поля 'Text input', 'Password', 'Textarea'.")
    public void step_01(){
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        WebElement textInput = driver.findElement(By.xpath("//input[@id='my-text-id']"));
        textInput.sendKeys("ФИО");

        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='my-password']"));
        passwordInput.sendKeys("Password");

        WebElement textArea = driver.findElement(By.xpath("//textarea[@name='my-textarea']"));
        textArea.sendKeys("Название компании");

        //        Проверить что текст отображается! + assert(?)
        WebElement DefaultRadioButton = driver.findElement(By.xpath("//input[@id='my-radio-2']"));

        DefaultRadioButton.click();
        //        Проверить что выбран нужный радиобаттон! + assert(?)



    }
}
