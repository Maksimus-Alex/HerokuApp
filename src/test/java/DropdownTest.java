import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class DropdownTest {
    /*
    Dropdown - Взять все элементы дроп-дауна и проверить их наличие.
Выбрать первый, проверить, что он выбран, выбрать второй, проверить, что
он выбран
Локатор: By.id(“dropdown”)
     */
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void checkBoxesTest() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropdown = driver.findElement(By.id("dropdown"));// находим элемент
        Select dropdownEl = new Select(dropdown);// Select это класс который дает возможность работать с выпадающими списками, как у нас на сайте
        List<WebElement> options = dropdownEl.getOptions();// Получаем все элементы dropdown
        Assert.assertEquals(options.size(), 3);// проверяем нашел ли он все элементы
        dropdownEl.selectByIndex(1);// выбираем первый элемент
        WebElement selectFirstDropdown = dropdownEl.getFirstSelectedOption();// получаем выбранный элемент
        Assert.assertTrue(selectFirstDropdown.isSelected());// проверяем истинность того что выбрали
        dropdownEl.selectByIndex(2);// повторяем тоже самое со вторым элементом
        WebElement selectSecondDropdown = dropdownEl.getFirstSelectedOption();// получаем выбранный элемент
        Assert.assertTrue(selectSecondDropdown.isSelected());
    }

    @AfterMethod(alwaysRun = true)
    public void treaDown() {
        driver.quit();

    }
}

