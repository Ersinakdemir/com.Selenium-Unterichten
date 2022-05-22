package day11_Faker_File;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C04_FileDowland extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //1. Tests packagenin altina bir class oluşturalim
        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");

        //3. code.txt dosyasını indirelim
        driver.findElement(By.xpath("//a[text()='dummy.txt']")).click();
        Thread.sleep(5000);
        //4. dosyanın başarıyla indirilip indirilmediğini test edelim
        //downloads a indirilecektir bize downloads on dosya yolu lazim
        String farliKisim =System.getProperty("user.home");
        String ortakKisim = "\\Downloads\\dummy.txt";
        //String ortakDosyaYolu ="\\OneDrive\\Masaüstü\\text.txt";

        String arananDosyaYolu = farliKisim+ortakKisim;
        // geriye o dosya yolunu var oldugunu test edelim

        Assert.assertTrue(Files.exists(Paths.get(arananDosyaYolu)));
    }
}
