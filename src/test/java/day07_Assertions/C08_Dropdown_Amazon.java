package day07_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class C08_Dropdown_Amazon {
    //● https://www.amazon.com/ adresine gidin.
    //- Test 1
    //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
    //oldugunu test edin
    //-Test 2
    //1. Kategori menusunden Books secenegini secin
    //2. Arama kutusuna Java yazin ve aratin
    //3. Bulunan sonuc sayisini yazdirin
    //4. Sonucun Java kelimesini icerdigini test edin
   static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }
    @Test
    public void test01(){

        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
        //oldugunu test edin
        WebElement ddm= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select =new Select(ddm);
        List<WebElement>optionsList =select.getOptions();
        int optionsElements =optionsList.size();
        int expectElement=45;
        Assert.assertFalse(optionsElements==expectElement);
    }
    @Test
    public void test02(){
        WebElement ddm= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select =new Select(ddm);

        //1. Kategori menusunden Books secenegini secin
        select.selectByVisibleText("Books");

        //2. Arama kutusuna Java yazin ve aratin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java"+ Keys.ENTER);

        //3. Bulunan sonuc sayisini yazdirin
        WebElement sonuc = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String sonucYazisi = sonuc.getText();
        System.out.println(sonucYazisi);
        String sonucSayisi = sonucYazisi.substring(sonucYazisi.indexOf("ov"),sonucYazisi.indexOf("result"));

        System.out.println(sonucSayisi);
        System.out.println(sonucYazisi);

        //4. Sonucun Java kelimesini icerdigini test edin

        Assert.assertTrue(sonucYazisi.contains("Java"));

    }
}
