package day07_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C05_DropDownMenu {
    /* amazon'a gidip
   dropdown'dan books secenegini secip
   Java aratalim
   ve arama sonuclarinin Java icerdigini test edelim
 */
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
    public void test01() throws InterruptedException {
        driver.get("https://www.amazon.com");

        WebElement dropDownElement = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        //2 bir select objesi oliusturalim

        Select select = new Select(dropDownElement);

        //3- DropDown da var olan lardan istedigimiz birtaneyi secelim
        //select.selectByValue();
        //select.selectByIndex();
        select.selectByVisibleText("Books");

        //Arama kutusuna java yazdiralaim
        //önce locate edelim

        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("java"+ Keys.ENTER);
        Thread.sleep(3000);

        //   ve arama sonuclarinin Java icerdigini test edelim

       WebElement sonucYazisiElementi=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String sonucYazisiStr=sonucYazisiElementi.getText();
        String arananKelime="java";
        Assert.assertTrue(sonucYazisiStr.contains(arananKelime));
        Thread.sleep(5000);
    }
}
