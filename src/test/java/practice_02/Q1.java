package practice_02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q1 {
    /*
     ...Exercise1...
     BeforeClass ile driver ı olusturun ve class icinde static yapin
     Maximize edin, 15 sn bekletin
     http://www.google.com adresine gidin
     arama kutusuna "Green Mile" yazip, cikan sonuc sayisini yazdirin
     arama kutusuna  "Premonition" yazip, cikan sonuc sayisini yazdirin
     arama kutusuna  "The Curious Case of Benjamin Button" yazip, cikan sonuc sayisini yazdirin
     AfterClass ile kapatın

  */
    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Before
    public void testtenOnce(){
        driver.get("http://www.google.com");
    }
    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
    @Test
    public void test01(){
        driver.findElement(By.xpath("//div[text()='Kabul ediyorum']")).click();

        //arama kutusuna "Green Mile" yazip, cikan sonuc sayisini yazdirin
        WebElement aramakutusu = driver.findElement(By.xpath("//input[@name='q']"));
        //aramakutusu.sendKeys("Green Mile"+ Keys.ENTER);
        aramakutusu.sendKeys("Green Mile");
        aramakutusu.submit();//buda veriyi database e gönderiyor ve sonuc döndürüyor
    }
    @Test
    public void test02(){
        //arama kutusuna  "Premonition" yazip, cikan sonuc sayisini yazdirin
        WebElement aramakutusu = driver.findElement(By.xpath("//input[@name='q']"));
        aramakutusu.sendKeys("Premonition"+Keys.ENTER);}
    @Test
    public void test03(){
        //     arama kutusuna  "The Curious Case of Benjamin Button" yazip, cikan sonuc sayisini yazdirin
        WebElement aramakutusu = driver.findElement(By.xpath("//input[@name='q']"));
        aramakutusu.sendKeys("The Curious Case of Benjamin Button"+Keys.ENTER);}



    @After
    public void testdenSonra(){
        WebElement sonucYazisi = driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println("Green Mile icin sonuc: "+sonucYazisi.getText());
    }
}
