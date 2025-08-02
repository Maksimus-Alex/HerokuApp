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

public class AddRemoveElementsTest {
    /*
Add/Remove Elements - добавить 2 элемента, удалить элемент,
проверить количество элементов DELETE
Локаторы xpath:
a. By.xpath("//button[text()='Add Element']")
b. By.xpath("//button[text()='Delete']")
     */
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void checkAddRemoveElements() {
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");// перешли на сайт
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/button")).click();// первый клик
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/button")).click();// второй клик
        List<WebElement> deleteElements = driver.findElements(By.xpath("//button[text()='Delete']"));// получаю коллекцию элементов Delete
        Assert.assertEquals(deleteElements.size(), 2);//Размер коллекции равен 2, проверка
        deleteElements.get(1).click();// удаляю элемент
        List<WebElement> deleteElement = driver.findElements(By.xpath("//button[text()='Delete']"));// снова запрашиваю коллекцию всех элементов на странице
        Assert.assertEquals(deleteElement.size(), 1);// проверяю размер коллекции
    }

    @AfterMethod(alwaysRun = true)
    public void treaDown() {
        driver.quit();

    }
}
