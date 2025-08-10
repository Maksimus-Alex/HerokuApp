import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class FileUploadTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testFileUpload() {
        driver.get("https://the-internet.herokuapp.com/upload");
        File file = new File("src/test/resources/Maksimus.txt"); // Загрузить файл
        driver.findElement(By.id("file-upload")).sendKeys(file.getAbsolutePath());
        driver.findElement(By.id("file-submit")).click();// Нажать кнопку Upload
        assertEquals("Maksimus.txt", driver.findElement(By.id("uploaded-files")).getText()); // Проверить, что имя файла на странице совпадает с именем загруженного файла
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
