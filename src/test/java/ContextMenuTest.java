import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class ContextMenuTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testContextMenu() {
        driver.get("https://the-internet.herokuapp.com/context_menu");
        Actions actions = new Actions(driver);
        WebElement square = driver.findElement(By.id("hot-spot"));
        actions.contextClick(square).perform();
        /*
        actions.contextClick(square).perform(); в Selenium означает имитацию правого щелчка мыши по указанному элементу
        square с последующим немедленным выполнением этого действия. Метод contextClick(square) создает действие по
        правому щелчку на элементе, а .perform() выполняет это действие, аналогично методу build() и perform()
        в других контекстах, но в данном случае без промежуточного build(), когда действия выполняются сразу.
         */
        Alert alert = driver.switchTo().alert();// Валидация текста на алерте
        assertEquals("You selected a context menu", alert.getText());// сравнение
        alert.accept();// Закрытие алерта
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
