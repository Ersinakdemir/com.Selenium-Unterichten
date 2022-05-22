package day09HandelWindows_TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_handleWindows {
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
        driver.quit();
    }
    @Test
    public void test01(){
        // 1- amazon anasayfaya gidelim
        driver.get("https://www.amazon.com");
        String ilkSayfaninWindowsHandleDegeri = driver.getWindowHandle();
// 2- url'in  amazon icerdigini test edelim
        String urlActual = driver.getCurrentUrl();
        Assert.assertTrue(urlActual.contains("amazon"));

// 3- yeni bir pencere acip bestbuy ana sayfaya gidelim
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        String ikinciSayfaninWindownsHandleDegeri = driver.getWindowHandle();

// 4- title'in BestBuy icerdigini test edelim
        String actualTitel = driver.getTitle();
        String expectTitel = "Best Buy";
        Assert.assertTrue(actualTitel.contains(expectTitel));

// 5- ilk sayfaya donup sayfada java aratalim
        driver.switchTo().window(ilkSayfaninWindowsHandleDegeri);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java"+ Keys.ENTER);

// 6- arama sonuclarinin Java icerdigini test edelim
        WebElement sonucYaziElemeti= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String actualSonucYaziText =sonucYaziElemeti.getText();
        String istenenText="java";
        Assert.assertTrue(actualSonucYaziText.contains(istenenText));

// 7- yeniden bestbuy'in acik oldugu sayfaya gidelim
        driver.switchTo().window(ikinciSayfaninWindownsHandleDegeri);
// 8- logonun gorundugunu test edelim
       WebElement logoElement =driver.findElement(By.xpath("//img[@class='logo'][1]"));
       Assert.assertTrue(logoElement.isDisplayed());
    }

}
