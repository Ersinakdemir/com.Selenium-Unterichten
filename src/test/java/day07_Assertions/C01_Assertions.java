package day07_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class C01_Assertions {
    /*
    amazon ana sayfaya gidin
    3- farkli test methodu olusturarak asagidakimgörevleri yapin
      i. Url in amazon icerdigini test edin
      ii. title in facebook icermedigini test edin
      iii. Sol ust kösede amazon logosunun göründügünu testedi
     */
   static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");

    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }
    @Test
    public void test01(){
        //i. Url in amazon icerdigini test edin
        String aranankelime = "amazon";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(aranankelime));

    }
    @Test
    public void test02(){
       // ii. title in facebook icermedigini test edin
        String istenmeyenKelime ="facebook";
        String actualTitel = driver.getTitle();
        Assert.assertTrue(!actualTitel.contains(istenmeyenKelime));

    }
    @Test
    public void test03(){
        //iii. Sol ust kösede amazon logosunun göründügünu testedi
      WebElement logoElementi= driver.findElement(By.id("nav-logo-sprites"));
      logoElementi.isDisplayed();
    }
}
