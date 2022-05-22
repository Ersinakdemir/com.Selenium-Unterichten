package day09HandelWindows_TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class C03_windowHandle {
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
        //driver.close();
    }
    @Test
    public void test01(){
        //● Tests package’inda yeni bir class olusturun: WindowHandle2
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement sayfadkiYaziElemti =driver.findElement(By.xpath("//h3"));
        String expectedText = "Opening a new window";
        String actualText = sayfadkiYaziElemti.getText();
        Assert.assertEquals(actualText,expectedText);

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectTitel =  "The Internet";
        String actualTitel = driver.getTitle();
        Assert.assertEquals(actualTitel,expectTitel);

         /*
        eger kontrolsuz acilan bir tab veya window varsa
        o zaman sayfalarin window handle degerlerini elde etmem gerekir.
        oncelikle 2.sayfa acilmadan once
        ilk sayfanin window handle degerini bir String'e atayalim
         */
        String ilksayfaHadleDegeri = driver.getWindowHandle();
        System.out.println(ilksayfaHadleDegeri);

        //● Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();
         /*
          switchTo().newWindow() demeden link tiklayarak yeni tab veya window olustugunda
          biz driver'a yeni sayfaya gec demedikce, driver eski sayfada kalir
          ve yeni sayfa ile ilgili hicbir islem yapamaz
          yeni sayfada driver'i calistirmak isterseniz
          once driver'i yeni sayfaya yollamalisiniz
            */

        /*
        yeni sayfaya gecebilmek icin oncelikle ikinciSayfaWindowHandleDegeri'ni bulmamiz gerekir
        bunun icin driver.getWindowHandles() method'unu kullanarak
        acik olan tum sayfalarin window handle degerlerini alip bir set'e assign ederiz.
        ilk sayfanin window handle degerini zaten biliyoruz
        Set'deki window handle degerlerini kontrol edip
        ilk sayfanin handle degerine esit olmayan
        ikinci sayfanin woindow handle degeridir deriz
         */

        Set<String> windowsHandleSet = driver.getWindowHandles();
        String ikinciSayfaninHandelsDegeri ="";
        for (String w:windowsHandleSet
             ) {
            if (!w.equals(ilksayfaHadleDegeri)){
                 ikinciSayfaninHandelsDegeri=w;
            }

        }
        // artik ikinci sayfanin window handle degerini biliyoruz
        // rahatlikla sayfalar arasii gecis yapabiliriz
        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        driver.switchTo().window(ikinciSayfaninHandelsDegeri);
        String expectIkiniTitel = "New Window";
        String actualIkinciTitel = driver.getTitle();
        Assert.assertEquals(expectIkiniTitel,actualIkinciTitel);

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement ikincisayfaYazWebElemet = driver.findElement(By.xpath("//h3"));
        String expectIkinciSayfaText = "New Window";
        String actualIkinciSayfaText =ikincisayfaYazWebElemet.getText();
        Assert.assertEquals(actualIkinciSayfaText,expectIkinciSayfaText);

        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(ilksayfaHadleDegeri);
        expectTitel =  "The Internet";
        actualTitel = driver.getTitle();
        Assert.assertEquals(actualTitel,expectTitel);

    }

}
