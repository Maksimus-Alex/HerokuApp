import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;


public class CheckboxesTets {
    /*
    Checkboxes - проверить, что первый чекбокс unchecked, отметить
первый чекбокс, проверить что он checked. Проверить, что второй чекбокс
checked, сделать unheck, проверить, что он unchecked
Локатор: By.cssSelector("[type=checkbox]”)
     */
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void checkBoxesTest() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        List<WebElement> checkBoxes = driver.findElements(By.cssSelector("[type=checkbox]"));// нахожу все Checkdox на сайте
        WebElement firstBox = driver.findElement(By.xpath("/html/body/div[2]/div/div/form/input[1]"));
        Assert.assertFalse(firstBox.isSelected());//assertFalse предназначен для проверки того, что определенное условие в тесте является ложным.
        firstBox.click();// Клик по первому чекбоксу
        Assert.assertTrue(firstBox.isSelected());// проверка что его выбрали, использую assertTrue что просто проверить истинность
        WebElement secondBox = driver.findElement(By.cssSelector("#checkboxes > input:nth-child(3)"));
        Assert.assertTrue(secondBox.isSelected());
        secondBox.click();
        Assert.assertFalse(secondBox.isSelected());
    }

    @AfterMethod(alwaysRun = true)
    public void treaDown() {
        driver.quit();

    }
}
