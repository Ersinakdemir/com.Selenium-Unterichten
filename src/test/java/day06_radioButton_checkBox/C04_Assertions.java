package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Assertions {
    WebDriver driver;
    @Before
    public void seetUp(){
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
        //Eger test methodun da hicbir test yoksa test calistik tan sonra hic bir
        // problemle karsilasilmadigini raporlamak icin "test passed" cikar

        //Eger testleri if ile yaparsak test failed olsa bile kodlar problemsiz calistigin icin
        //kod calismasi bittiginde ekranin sol kösesinde test passed yazacaktir
        driver.get("https://amazon.com");

        //url in https://www.facebook.com oldugunu test edin
      /*  if (driver.getCurrentUrl().equals("https://www.facebook.com")){
            System.out.println("Url testi PASSED");
        }else System.out.println("url testi Failed");
        */

        String expectedUrl = "https://www.facebook.com";
        String actualUrl = driver.getCurrentUrl();
        /*
        Assert ile yaptiginiuz testlerde assertion failed olursa java kodlarinin calismasini durdurur ve Assert classi
        bizi hata konusunda bilgilendirir

        org.junit.ComparisonFailure: Url beklenenden farkli
Expected :https://www.facebook.com
Actual   :https://www.amazon.com/
<Click to see difference>

böylece hatanin ne oldugunu arastirmamiza gerek kalmadan Junit bize raporlamais olacak
         */
        Assert.assertEquals("Url beklenenden farkli",expectedUrl,actualUrl);
    }
}
