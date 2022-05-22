package day10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C03_Actions extends TestBase {
    @Test
    public void test01(){
        // 1- Yeni bir class olusturalim: MouseActions1
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //3- Cizili alan uzerinde sag click yapalim
        Actions actions =new Actions(driver);
        WebElement cizgiliAlanElementi = driver.findElement(By.id("hot-spot"));
        actions.contextClick(cizgiliAlanElementi).perform();

        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu
        //    test edelim.
        String expectedYazi="You selected a context menu";
        String actualYazi= driver.switchTo().alert().getText();
        Assert.assertEquals(expectedYazi,actualYazi);

        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

        //6- Elemental Selenium linkine tiklayalim
        String ilkSayfaWHDegeri = driver.getWindowHandle();
        driver.findElement(By.linkText("Elemental Selenium")).click();
        Set<String>handleSeti =driver.getWindowHandles();

        String ikinciSayfaWHDegeri = "";
        for (String w:handleSeti
             ) {
            if (!w.equals(ilkSayfaWHDegeri)){
                ikinciSayfaWHDegeri =w;
            }

        }
        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        driver.switchTo().window(ikinciSayfaWHDegeri);
        WebElement yaziElementi= driver.findElement(By.xpath("//h1"));
        String expectedIkinciYazi="Elemental Selenium";
        String actualIkinciYazi=yaziElementi.getText();
        Assert.assertEquals(expectedIkinciYazi,actualIkinciYazi);

    }

}
