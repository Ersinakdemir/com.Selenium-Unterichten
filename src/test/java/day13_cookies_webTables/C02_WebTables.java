package day13_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class C02_WebTables extends TestBase {
    @Test
    public void webTableTest() {

        //● Bir class oluşturun : C02_WebTables
        //● login( ) metodun oluşturun ve oturum açın.
        grisYap();

        //● table( ) metodu oluşturun
        //            ○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
        List<WebElement> sutunNameList =driver.findElements(By.xpath("//thead//tr[1]//th"));
        System.out.println("sutun sayisi : "+sutunNameList.size());

        //            ○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        //Tüm body yi consola get text methoduyla yazdira biliriz

        WebElement tumbody = driver.findElement(By.xpath("//tbody"));
        System.out.println(tumbody.getText()); //Tum body yazdidirir

        //● printRows( ) metodu oluşturun //tr
        //            ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> tumsatirlarList =driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("satir sayisi : "+ tumsatirlarList.size());

        //            ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        for (WebElement each:tumsatirlarList) {
            System.out.println(each.getText());
        }

        //            ○ 4.satirdaki(row) elementleri konsolda yazdırın.
        List<WebElement> satir4CellList = driver.findElements(By.xpath("//tbody//tr[4]//td"));

        for (WebElement obj:satir4CellList) {
            System.out.println(obj.getText());
        }
        //          Email basligindaki tum elementleri(sutun) konsolda yazdırın.
        // once email basliginin kacinci sutunda oldugunu bulalim
        int emailSutunNo =0;
        for (int i = 0; i < sutunNameList.size(); i++) {
            if (sutunNameList.get(i).getText().equals("Email")){
                emailSutunNo=i;
            }
        }
        List<WebElement>emailSutunList = driver.findElements(By.xpath("//tbody//td["+(emailSutunNo+1)+"]"));
        for (WebElement obj:emailSutunList) {
            System.out.println(obj.getText());
        }
    }
    public void grisYap(){
        //● https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin
        //            ○ Username : manager
        //            ○ Password : Manager1!
        driver.get("https://www.hotelmycamp.com");
        driver.findElement(By.linkText("Log in")).click();
        Actions actions = new Actions(driver);
        WebElement username = driver.findElement(By.id("UserName"));
        actions.click(username).
                sendKeys("manager").
                sendKeys(Keys.TAB).
                sendKeys("Manager1!").
                sendKeys(Keys.ENTER).
                perform();
    }
}
