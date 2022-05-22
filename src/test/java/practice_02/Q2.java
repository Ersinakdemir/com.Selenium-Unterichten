package practice_02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class Q2 {
     /*
    ...Exercise2...
    http://www.bestbuy.com 'a gidin,
    Sayfa basliginin "Best" icerdigini(contains) dogrulayin
    Ayrica Relative Locator kullanarak;
        logoTest => BestBuy logosunun gorunutulenip goruntulenmedigini dogrulayin
        mexicoLinkTest => Linkin gorunutulenip goruntulenmedigini dogrulayin
 */

    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bestbuy.com");
    }
    /*
    @Before
    public void testtenOnce(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bestbuy.com");
    }*/
    @Test
    public void testTitel(){
        //    Sayfa basliginin "Best" icerdigini(contains) dogrulayin
        Assert.assertTrue(driver.getTitle().contains("Best"));
    }
    @Test
    public void testLogo(){
        //    Ayrica Relative Locator kullanarak;
        //        logoTest => BestBuy logosunun gorunutulenip goruntulenmedigini dogrulayin
       // WebElement logoElement = driver.findElement(By.xpath("//img[@class='logo'][1]")); driken böyle locater yapabiliriz
        WebElement helloElement = driver.findElement(By.xpath("//div[text()='Hello!']"));
        WebElement logoElement = driver.findElement(RelativeLocator.with(By.tagName("img")).above(helloElement));
        Assert.assertTrue(logoElement.isDisplayed());
    }
    public void testMeyicoLinkTest(){
        //        mexicoLinkTest => Linkin gorunutulenip goruntulenmedigini dogrulayin
        WebElement usaLink = driver.findElement(By.xpath("(//img[@alt='United States'])[1]"));
        WebElement mexicoLink = driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(usaLink));
        Assert.assertTrue(mexicoLink.isEnabled());
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }
}
