package day08_Alerts_Iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Alert_Class {
    //● Bir class olusturun: Alerts
    //● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    //● Bir metod olusturun: acceptAlert
    //        ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
    //        “You successfully clicked an alert” oldugunu test edin.
    //● Bir metod olusturun: dismissAlert
    //        ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
    //        “successfuly” icermedigini test edin.
    //● Bir metod olusturun: sendKeysAlert
    //        ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
    //        tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.

    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }
    @Test
    public void test01(){
        //        ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        //        “You successfully clicked an alert” oldugunu test edin.

        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();

        driver.switchTo().alert().accept();
        //alert te ok tusuna basin ve result kisminda "You successfully clicked an alert" yazdigini testedin
        String expected ="You successfully clicked an alert";
        WebElement sonucYazisinElement = driver.findElement(By.xpath("//p[@id='result']"));
        String actualResultYazisi =sonucYazisinElement.getText();
        Assert.assertEquals(expected,actualResultYazisi);
    }
    @Test
    public void test02(){
        //        ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        //        “successfuly” icermedigini test edin.
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        driver.switchTo().alert().dismiss();
        String expectResultText = "successfuly";
        WebElement resultElement = driver.findElement(By.xpath("//*[text()='You clicked: Cancel']"));
        String actuelResultText = resultElement.getText();
        Assert.assertFalse(actuelResultText.contains(expectResultText));
    }
    @Test
    public void test03(){
        //        ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        //        tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        driver.switchTo().alert().sendKeys("Ersin");
        driver.switchTo().alert().accept();
        String expectResultText = "Ersin";
        WebElement actualResult = driver.findElement(By.xpath("//p[@id='result']"));
        String actualResultText = actualResult.getText();
        Assert.assertTrue(actualResultText.contains(expectResultText));


    }


}
