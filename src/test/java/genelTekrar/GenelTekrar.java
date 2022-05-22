package genelTekrar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;
import java.util.Map;

public class GenelTekrar extends TestBase {
    //Test01 :
    //1- amazon gidin
    //2- Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
    //3- dropdown menude 40 eleman olduğunu doğrulayın
    //
    //Test02
    //
    //1- dropdown menuden elektronik bölümü seçin
    //2- arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
    //3- sonuc sayisi bildiren yazinin iphone icerdigini test edin
    //4- ikinci ürüne relative locater kullanarak tıklayin
    //5- ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim
    //
    //Test03
    //
    //1- yeni bir sekme açarak amazon anasayfaya gidin
    //2-dropdown’dan bebek bölümüne secin
    //3-bebek puset aratıp bulundan sonuç sayısını yazdırın
    //4-sonuç yazsının puset içerdiğini test edin
    //5-üçüncü ürüne relative locater kullanarak tıklayin
    //6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
    //
    //Test 4
    //
    //1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın

    @Test
    public void test01() {
        //TEST1

        //1- amazon gidin
        driver.get("https://www.amazon.com");
        //2- Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement aramaMenusu = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select =new Select(aramaMenusu);
        List<WebElement>tumOptions = select.getOptions();
        for (WebElement obj:tumOptions
             ) {
            System.out.println(obj.getText());
        }
        System.out.println(select.getOptions().size());
        //3- dropdown menude 28 eleman olduğunu doğrulayın
        int expectSize =28;
        int actualSize = tumOptions.size();
        Assert.assertEquals(expectSize,actualSize);

        //TEST02
        //
        //1- dropdown menuden elektronik bölümü seçin
        select.selectByVisibleText("Electronics");
        //2- arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("iphone" + Keys.ENTER);

        WebElement sonuc = driver.findElement(By.xpath("//div [@class='a-section a-spacing-small a-spacing-top-small'][1]"));
        String sonucYazisi = sonuc.getText();
        String sonucSayisi = sonucYazisi.substring(sonucYazisi.indexOf("of"),sonucYazisi.indexOf("result"));
        System.out.println("Sonuc sayisi : "+ sonucSayisi);

        //3- sonuc sayisi bildiren yazinin iphone icerdigini test edin
        String expectText = "iphone";
        Assert.assertTrue(sonucYazisi.contains(expectText));

        //4- ikinci ürüne relative locater kullanarak tıklayin
        WebElement ilkUrun = driver.findElement(By.xpath("//div[@class='a-section a-spacing-none a-spacing-top-micro'][1]"));
        WebElement ikinciUrun = driver.findElement(RelativeLocator.with(By.tagName("img")).below(ilkUrun));
        ikinciUrun.click();
        //5- ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim
        String ikinciurunTitel = driver.getTitle();
        WebElement preisElement = driver.findElement(By.xpath("//span[@class='a-price a-text-price a-size-medium apexPriceToPay']"));
        String ikinciUrunPreis = preisElement.getText();

        WebElement sepetEkle = driver.findElement(By.id("add-to-cart-button"));
        sepetEkle.click();
        System.out.println(ikinciurunTitel+" "+ikinciUrunPreis);

        //Test03
        //
        //1- yeni bir sekme açarak amazon anasayfaya gidin
        String ilkSayfaHandleDegeri = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");
        String ikinciSayfaHandleDegeri = driver.getWindowHandle();

        //2-dropdown’dan bebek bölümüne secin
        WebElement aramaMenusuIki = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select2 = new Select(aramaMenusuIki);
        select2.selectByVisibleText("Baby");
        //3-bebek puset aratıp bulundan sonuç sayısını yazdırın
        WebElement searchBox2 = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox2.sendKeys("buggy"+ Keys.ENTER);

        WebElement sonuc2 = driver.findElement(By.xpath("//div [@class='a-section a-spacing-small a-spacing-top-small'][1]"));
        String sonucYazisi2 = sonuc2.getText();

        String sonucSayisi2 = sonucYazisi2.substring(sonucYazisi2.indexOf("of"),sonucYazisi2.indexOf("result"));
        System.out.println("Puset icin sonuc sayisi : "+ sonucSayisi2);

        //4-sonuç yazsının puset içerdiğini test edin
        String arananKelime = "buggy";
        Assert.assertTrue(sonucYazisi2.contains(arananKelime));

        //5-üçüncü ürünün ikinci optionunu   locate ederek tıklayin
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[1]/div/span[3]/div[2]/div[4]/div/div/div/div/div[1]/span/a/div/img")).click();

        //6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
        String titel3 = driver.getTitle();
        System.out.println(titel3);
       // WebElement ikinciOption = driver.findElement(By.xpath("//button[@id='a-autoid-17-announce']"));
        //ikinciOption.click();
        WebElement preisElement3 = driver.findElement(By.xpath("//span[@class='a-price a-text-price a-size-medium apexPriceToPay']"));
        String preis3 =preisElement3.getText();

        WebElement sepetEkle2 = driver.findElement(By.id("add-to-cart-button"));
        sepetEkle2.click();
        System.out.println(titel3+" "+preis3);

        //Test 4
        //
        //1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın
        driver.findElement(By.id("nav-cart-count-container")).click();




    }

}
