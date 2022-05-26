package day15_WriteExcel_screenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class C02_TumSAyfaScreenShot extends TestBase {
    @Test
    public void tumSayfa() throws IOException {
        //amazon sayfasina gidip tüm sayfanin fotorafini cekelim
        driver.get("https://www.amazon.com");

        TakesScreenshot ts = (TakesScreenshot) driver;

        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String tarih =date.format(dtf);
        System.out.println(tarih);

        File tumSayfaScreen =new File("target/ekranGoruntuleri/TumSayfa"+tarih+".jpeg");
        File geciciDosya = ts.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(geciciDosya,tumSayfaScreen);
    }
}
