package day12_Sekronirarion;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C01_ExplicitlyWait extends TestBase {
    //1. Bir class olusturun : WaitTest
    //2. Iki tane metod olusturun : implicitWait() , explicitWait()
    //     Iki metod icin de asagidaki adimlari test edin.

    @Test
    public void implicitWaitTesti() {
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[text()='Remove']")).click();

        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement itsGoneElementi = driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(itsGoneElementi.isDisplayed());

        //6. Add buttonuna basin
        driver.findElement(By.xpath("//button[@type='button'][1]")).click();

        //7. It’s back mesajinin gorundugunu test edin
        WebElement itsBackElementi= driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(itsBackElementi.isDisplayed());
    }

    @Test
    public void explicitWaitest() {
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();
        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(15));
        /*
        WebElement itsGoneYaziElementi= driver.findElement(By.xpath("//p[text()=\"It's gone!\"]"));
        wait.until(ExpectedConditions.visibilityOf(itsGoneYaziElementi));
        Assert.assertTrue(itsGoneYaziElementi.isDisplayed());

        Yazinin görünür olmasini beklerken yazinin locate ini kullanmak sorun olusturur cunku
        henüz görünmeyen bir yazinin locate edilmesi de mümkün degildir
        (HTML) kodlari yazan developer farkli uygulama yapabilir

        Budurumda bekleme islemi ve locate i birlikte yaomaliyiz
*/
        WebElement itsGoneYaziElementi=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[text()=\"It's gone!\"]")));

        //6. Add buttonuna basin
        driver.findElement(By.xpath("//button[@type='button'][1]")).click();

        //7. It’s back mesajinin gorundugunu test edin
        WebElement itsBackElementi= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));

       //WebElement itsBackElementi= driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(itsBackElementi.isDisplayed());


    }
}
