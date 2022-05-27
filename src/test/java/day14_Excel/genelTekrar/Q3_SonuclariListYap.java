package day14_Excel.genelTekrar;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q3_SonuclariListYap extends TestBase {
    @Test
    public void test01(){
        //Notes: It may also be necessary to write code to accept the accept cookies warning.
        //1. Go to 'https://www.amazon.com.tr/'
        driver.get("https://www.amazon.com");
        //2. Search iPhone13 512
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("iPhone13 512"+ Keys.ENTER);
        //3. Check that the results are listed
        List<WebElement> sonucList = driver.findElements(By.cssSelector("ul a"));
        System.out.println(sonucList.size());
        System.out.println(sonucList.get(1));
        //WebElement ikinciElement = sonucList.get(1).findElement(By.xpath()));


        //4. Click iPhone13 at the top of the list

        //5. Log the following values for each size
       /* for (WebElement obj:sonucList
        ) {

            System.out.println(obj.getSize());

        }
*/

        //.Size information .Price .Color .Stock status


    }
    public void textyazdir(){

    }
}
