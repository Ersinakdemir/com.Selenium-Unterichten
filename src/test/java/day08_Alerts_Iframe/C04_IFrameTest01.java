package day08_Alerts_Iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_IFrameTest01 {
    //● Bir class olusturun: IframeTest
    //   ● https://the-internet.herokuapp.com/iframe adresine gidin.
    //   ● Bir metod olusturun: iframeTest
    //        ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda    yazdirin.
    //        ○ Text Box’a “Merhaba Dunya!” yazin.
    //        ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu     dogrulayin ve  konsolda yazdirin.
    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    public void tearDown(){
        driver.close();
    }
    @Test
    public void test01() throws InterruptedException {
        //   ● https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

        //   ● Bir metod olusturun: iframeTest
        //        ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda    yazdirin.
        WebElement basliElementi = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(basliElementi.isEnabled());
        System.out.println(basliElementi.getText());

        //        ○ Text Box’a “Merhaba Dunya!” yazin.
        //TextBox i dogru lacate edmemeize ragmen driver bulamadi bunun üzerine HTML kodlarini inceleyince
        //text box un aslinda bir IFrame icerisinde oldugugorduk
        //Bu durumda önce iframe i locate edip sonra awitchTo() ile o iframe gecmeliyiz

        WebElement iframeElement = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframeElement);

        WebElement iframeTextKutusu = driver.findElement(By.xpath("//body[@id='tinymce']"));
        iframeTextKutusu.clear();
        iframeTextKutusu.sendKeys("Merhaba Dünya");

        //        ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
        //        dogrulayin ve  konsolda yazdirin.

        /// link yazi elementini dogru locate etmemize ragmen yazdirmadi
        //        // cunku yukarida iFrame'e gecis yapmistik
        //        // once oradan cikmamiz lazim
        driver.switchTo().defaultContent();
        WebElement linkTwxtElement = driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(linkTwxtElement.isDisplayed());
        System.out.println(linkTwxtElement.getText());
        Thread.sleep(5000);
    }

}
