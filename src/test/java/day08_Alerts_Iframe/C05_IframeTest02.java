package day08_Alerts_Iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C05_IframeTest02 {
    //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
    //2) sayfadaki iframe sayısını bulunuz.
    //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
    //4) ilk iframe'den çıkıp ana sayfaya dönünüz
    //5) ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html)
    //tıklayınız
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    public void tearDown(){

        //driver.close();
    }

    @Test
    public void test01(){
        //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");
        driver.findElement(By.xpath("//p[text()='Consent']")).click();

        //2) sayfadaki iframe sayısını bulunuz.
        List<WebElement>iframeList =driver.findElements(By.tagName("iframe"));
        System.out.println(iframeList.size());

        //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        WebElement ilkIframe = driver.findElement(By.xpath("//iframe[@name='__tcfapiLocator']"));
        driver.switchTo().frame(ilkIframe);

        //.findElement(By.linkText())
        //4) ilk iframe'den çıkıp ana sayfaya dönünüz
        //5) ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html)
        //tıklayınız

    }

}
