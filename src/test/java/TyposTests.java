import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.naming.Context;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class TyposTests {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void checkSpellTypos () {
        driver.get("https://the-internet.herokuapp.com/typos");
        for (int i = 0; i < 50; i++) {
            driver.navigate().refresh();// обновлять страницу несколько раз
            WebElement wrongText = driver.findElement(By.xpath("/html/body/div[2]/div/div/p[2]"));
            Assert.assertEquals(wrongText.getText(), "Sometimes you'll see a typo, other times you won't.");
        }
    }

    @AfterMethod(alwaysRun = true)
    public void treaDown() {
        driver.quit();

    }
}
