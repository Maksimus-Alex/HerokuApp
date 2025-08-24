import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class InputsTest {

    WebDriver driver;
    SoftAssert softAssert;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void ckeckInputsTest() {
        softAssert = new SoftAssert();
        driver.get("https://the-internet.herokuapp.com/inputs");
        WebElement value = driver.findElement(By.tagName("input"));
        value.click();
        value.sendKeys("Maksimus");
        softAssert.assertEquals(value.getAttribute("value"), "");// принимает в качестве аргумента имя атрибута, значение которого нужно получить
        value.click();
        value.sendKeys("101");
        softAssert.assertEquals(value.getAttribute("value"), "101");
        value.sendKeys(Keys.ARROW_UP, Keys.ARROW_UP, Keys.ARROW_UP);// поднимаем значение на 3
        softAssert.assertEquals(value.getAttribute("value"), "104");
        value.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN);
        softAssert.assertEquals(value.getAttribute("value"), "102");
        softAssert.assertAll();
    }

    @AfterMethod(alwaysRun = true)
    public void treaDown() {
        driver.quit();

    }
}
