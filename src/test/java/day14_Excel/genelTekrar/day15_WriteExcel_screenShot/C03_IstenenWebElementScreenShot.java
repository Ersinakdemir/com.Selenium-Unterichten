package day14_Excel.genelTekrar.day15_WriteExcel_screenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C03_IstenenWebElementScreenShot extends TestBase {
    @Test
    public void webElementScreenShot() throws IOException {
        //Amazona gidip nutella aratalim
        //sonuc sayisinin oldugu web elementiin fotografini cekelim

        driver.get("https://www.amazon.com");
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        WebElement sonucYaziElement = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        File sonucYaziElementiScreen = new File("target/ekranGoruntuleri/sonucYazisiScreen.jpeg");
        File temp = sonucYaziElement.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(temp,sonucYaziElementiScreen);

    }
}
