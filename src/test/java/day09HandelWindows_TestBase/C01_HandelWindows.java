package day09HandelWindows_TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_HandelWindows {

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){
        driver.close();
    }
    @Test
    public void test01(){
        //1- amazon anasayfaya gidin
        //2- nutella icin arama yaptirin
        driver.get("https://www.amazon.com");
        String ilkSayfaHandel =driver.getWindowHandle();
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("nutella" + Keys.ENTER);
        /*
        CDwindow-6E215283FCF69322C55CDD43B7DB8CB8
        bu code acilan sayfanin unique hash code dir

        Selenium sayfalar arasi geciste bu window handle degeri kullanilir

        Eger sayfalar arasinda driver imizi gezdiriyorsak ve herhangi bir sayfadan suan
        bulundugumuz sayfaya gecmek istiyorsak
     -->   driver.switchTo().newWindow("CDwindow-6E215283FCF69322C55CDD43B7DB8CB8")-->sayfanin hash kodu **
     ***  driver.getWindowHandle()  *** ile bulunur
   bu sayfanin windows handel degerini girerek bu sayfaya gecisi saglaya biliriz

         */

        //3- ilk ürünün resmini tiklayarak farkli bir tab olarak acin

        WebElement ilkUrunresmi = driver.findElement(By.xpath("//div[@class='a-section aok-relative s-image-square-aspect'][1]"));
        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("nutella" + Keys.ENTER);
        driver.findElement(By.xpath("//div[@class='a-section aok-relative s-image-square-aspect'][1]")).click();

        //4-yeni tabda acilan ürünün titel ini yazdirin
        WebElement urunTitelElementi = driver.findElement(By.xpath("//span[@id='productTitle']"));
        System.out.println(urunTitelElementi.getText());

        //5- ilk sayfaya gecip yeni url i yazdirin
        driver.switchTo().window(ilkSayfaHandel);
        System.out.println(driver.getCurrentUrl());

    }
}
