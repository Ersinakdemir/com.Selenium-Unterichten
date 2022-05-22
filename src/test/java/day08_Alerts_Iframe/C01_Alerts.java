package day08_Alerts_Iframe;

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

public class C01_Alerts {

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
        //Herhangi bir websitesine gidince veya bir websitesinde herhangi bir
        // islem yaptigimizda ortaya cikan uyarilara alert diyoruz

        //eger bir alert inspect yapilabiliyorsa o alert otomation ile kullaniöabilir,
        //butür alertlaa#ra HTML alert denir ve bunlar icin ekstra bir islem yapmaya gerek yoktur

        //Ancak web uygulamalarinda HTML alert yaninda java script alert de bulunabilir js alertler locate edilemez
        //
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();

        driver.switchTo().alert().accept();
        //alert te ok tusuna basin ve result kisminda "You successfully clicked an alert" yazdigini testedin
        String expected ="You successfully clicked an alert";
        WebElement sonucYazisinElement = driver.findElement(By.xpath("//p[@id='result']"));
        String actualResultYazisi =sonucYazisinElement.getText();
        Assert.assertEquals(expected,actualResultYazisi);
        }
}
