package genelTekrar;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Q1_ActionsClassHomeWork extends TestBase {

    @Test
    public void test01() {
        //1. "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        //2. "Hover over Me First" kutusunun ustune gelin
        Actions actions = new Actions(driver);
        WebElement hoverOverMeFirsElement = driver.findElement(By.xpath("//button[text()='Hover Over Me First!']"));
        actions.moveToElement(hoverOverMeFirsElement).perform();

        //3. "Link 1" e tiklayin
        driver.findElement(By.xpath("//a[text()='Link 1']")).click();

        //4. Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());

        //5. Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        //6. "Click and hold" kutusuna basili tutun
        WebElement clickHoldElement = driver.findElement(By.xpath("//div[@id='click-box']"));
        actions.clickAndHold(clickHoldElement).perform();

        //7. "Click and hold" kutusunda cikan yaziyi yazdirin
        WebElement clickHoldElement2 = driver.findElement(By.xpath("//div[@id='click-box']"));
        System.out.println(clickHoldElement2.getText());

        //8. "Double click me" butonunu cift tiklayin
        WebElement doubleClickElement = driver.findElement(By.id("double-click"));
        actions.doubleClick(doubleClickElement).perform();
    }
}
