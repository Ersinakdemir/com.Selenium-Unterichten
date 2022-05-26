package day13_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_WebTables extends TestBase {
    @Test
    public void dinamikYazici() {
        //önceki ylassdaki adrese giderek
        //girisyap methodunu kullanarak sayfaya girin
        //input olarak vverilen satirsayisi ve sutun sayisi'na sahip
        //cell'dekitext'i yazdirin

        int satir =3;
        int sutun=5;
        grisYap();
        WebElement aranaCell =driver.findElement(By.xpath("//tbody//tr["+satir+"]//td["+sutun+"]"));
        System.out.println(aranaCell.getText());
    }
    public void grisYap(){
        //● https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin
        //            ○ Username : manager
        //            ○ Password : Manager1!
        driver.get("https://www.hotelmycamp.com");
        driver.findElement(By.linkText("Log in")).click();

        WebElement userNameElement = driver.findElement(By.xpath("//input[@id='UserName']"));
        Actions actions =new Actions(driver);
        actions.click(userNameElement).
                sendKeys("manager").
                sendKeys(Keys.TAB).
                sendKeys("Manager1!").
                sendKeys(Keys.ENTER).
                click().
                perform();
    }

}
