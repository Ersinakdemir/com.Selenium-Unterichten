package genelTekrar;

import junit.framework.TestCase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.WatchEvent;
import java.util.List;

public class Q4_WebTable extends TestBase {
    @Test
    public void name() {
        //Bir Class olusturun D19_WebtablesHomework
        //1. “https://demoqa.com/webtables” sayfasina gidin
            driver.get("https://demoqa.com/webtables");
        List<WebElement> baslikList = driver.findElements(By.xpath("//div[@class='rt-tr']/div"));
        System.out.println(baslikList.size());
        //2. Headers da bulunan department isimlerini yazdirin
        int index =0;
        for (int i = 0; i < baslikList.size(); i++) {
            if (baslikList.get(i).getText().equals("Department")){
                index=i+1;
            }
        }
        List<WebElement> departmanListe = driver.findElements(By.xpath("//div[@class='rt-tr-group']/div/div[" + (index)+ "]"));

        for (WebElement each : departmanListe
        ) {
            System.out.println(each.getText());
        }

        //3. sutunun basligini yazdirin
        //4. Tablodaki tum datalari yazdirin
        //5. Tabloda kac cell (data) oldugunu yazdirin
        //6. Tablodaki satir sayisini yazdirin
        //7. Tablodaki sutun sayisini yazdirin
        //8. Tablodaki 3.kolonu yazdirin

        //9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        int indexfirstName = 0;
        for (int i = 0; i < baslikList.size(); i++) {
            if (baslikList.get(i).getText().equals("First Name")) {
                indexfirstName = i + 1;
            }
        }
        List<WebElement> firstNameList= driver.findElements(By.xpath("//div[@class='rt-tr-group']/div/div[" + (indexfirstName)+ "]"));
        System.out.println(firstNameList.size());

        int indexSalary = 0;
        for (int i = 0; i < baslikList.size(); i++) {
            if (baslikList.get(i).getText().equals("Salary")){
                indexSalary=i+1;
            }
        }
        List<WebElement>salaryList = driver.findElements(By.xpath("//div[@class='rt-tr-group']/div/div[" +(indexSalary)+ "]"));


        //System.out.println(driver.findElement(By.xpath()));

        //10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini
        //girdigimde bana datayi yazdirsi
    }
}
