import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class DinamicControlsTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void testDinamicContol() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//button[text()='Remove']")).click();// Нажать на кнопку Remove около чекбокса
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));  // Дождаться надписи “It’s gone”
        assertFalse(driver.findElements(By.id("checkbox")).size() > 0);   // Проверить, что чекбокса нет
        WebElement input = driver.findElement(By.xpath("//input[@type='text']"));// Найти инпут
        assertTrue(input.isDisplayed());// Проверить, что он disabled
        assertFalse(input.isEnabled());// Проверить, что он disabled
        driver.findElement(By.xpath("//button[text()='Enable']")).click();// Нажать на кнопку
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("message"), "It's enabled!"));// Дождаться надписи “It's enabled!”
        assertTrue(input.isEnabled());// Проверить, что инпут enabled
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
