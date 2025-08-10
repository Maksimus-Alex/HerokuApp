import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class FramesTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void checkFramesTest() {
        driver.get("https://the-internet.herokuapp.com/frames");
        driver.findElement(By.xpath("/html/body/div[2]/div/div/ul/li[2]/a")).click();
        driver.switchTo().frame("mce_0_ifr"); // Открыть iFrame , переключения контекста на iframe (встраиваемый фрейм) с идентификатором "mce_0_ifr".
        // честно говоря недоконца разобрался ...
        WebElement paragraph = driver.findElement(By.xpath("//body/p"));
        assertEquals("Your content goes here.", paragraph.getText());
        driver.switchTo().defaultContent();// Вернуться в основной контент
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
