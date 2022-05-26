package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        // amazon anasayfa'ya gidip
        // account menusunden create a list linkine tiklayalim
        driver.get("https://www.amazon.com");
        Actions actions =new Actions(driver);
        WebElement accountLinki= driver.findElement(By.xpath("//*[text()='Account & Lists']"));
        actions.moveToElement(accountLinki).perform();
        driver.findElement(By.xpath("//*[text()='Create a List']")).click();
        Thread.sleep(5000);// //*[text()='Create a List']
    }
    //➢ doubleClick ( ): WebElement’e çift tıklama yapar
    //
    //➢ clickAndHold ( ): WebElement uzerinde click yapili
    //olarak bizden komut bekler.
    //
    //➢ dragAndDrop ( ): WebElement’i bir noktadan diğerine
    //sürükler ve bırakır
    //
    //➢ moveToElement ( ): Mouse’u istedigimiz WebElement’in
    //uzerinde tutar
    //
    //➢ contextClick ( ): Mouse ile istedigimiz WebElement’e
    //sag tiklama yapar.

}
