package day11_Faker_File;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_FileUpload extends TestBase {
    @Test
    public void test01() {
        //1.Tests packagenin altina bir class oluşturun : C05_UploadFile
        //2.https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        //3.chooseFile butonuna basalim
        //4.Yuklemek istediginiz dosyayi secelim.
        /*
        Bun islemi selenium ile yapma i,kanimiz yok cunku web tabanli bir uygulama degil budurumdas sedKeys()
        imdadimiza yetisiyor eger chossFile butonun a var olan bir dosyayinin dosya yolunun
         */
        //1. adim chosse file butononu locate edelimm
        WebElement dosyaSecButonu = driver.findElement(By.id("file-upload"));
        //2. Adim yüklenecek dosyanin dosya yolunu olusturalim
        //biz maustundeki text.txt dosyasini yukleyelim
        String farkliKisim =System.getProperty("user.home");
        String ortakKisim ="\\OneDrive\\Masaüstü\\text.txt";
        String gönderilecek =farkliKisim+ortakKisim;
        //3.adim sendKeys ile dosya yolunu secme butonuna yollayalim
        dosyaSecButonu.sendKeys(gönderilecek);

        //5.Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();

        //6.“File Uploaded!” textinin goruntulendigini test edelim.
        WebElement uploadedElementi = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(uploadedElementi.isDisplayed());
    }
}
