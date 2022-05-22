package practice_02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class deneme {
   static WebDriver driver;
    WebElement searBox;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");

    }

    @Before
    public void baslangic() {
        searBox =  driver.findElement(By.id("twotabsearchtextbox"));

    }
    @After
    public void bitis(){
        WebElement sonuc = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small'][1]"));
        System.out.println(sonuc.getText());
        //driver.navigate().back();
    }
    @AfterClass
    public static void bitisClass(){
        driver.close();
    }


    @Test
    public void test01() {
        // amazona git iphone sonucu yazdir
       searBox.sendKeys("iphone");
       searBox.submit();
    }

    @Test
    public void test02() {
        // amazona git book sonucu yazdir
        searBox.sendKeys("bücher");
        searBox.submit();

    }

    @Test
    public void test03() {
        // amazona git Stift sonucu yazdir
        searBox.sendKeys("Stift");
        searBox.submit();


    }

    @Test
    public void test04() {
        // amazona git Schuhe sonucu yazdir
        searBox.sendKeys("Schuhe");
        searBox.submit();
    }

}
