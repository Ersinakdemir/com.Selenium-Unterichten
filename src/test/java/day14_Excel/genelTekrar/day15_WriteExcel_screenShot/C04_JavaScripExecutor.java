package day14_Excel.genelTekrar.day15_WriteExcel_screenShot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_JavaScripExecutor extends TestBase {
    @Test
    public void jsExecutor() throws InterruptedException {
        //Amazon a gidelim
        driver.get("https://www.amazon.com");

        // asagidaki sign in butonu görününceye kadar js ile scroll yapalim
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement signInButonu = driver.findElement(By.xpath("(//span[text()='Sign in'])[2]"));
        Thread.sleep(3000);

        jse.executeScript("arguments[0].scrollIntoView(true);",signInButonu);
        //sign in butonun a js ile click yapalim

        jse.executeScript("arguments[0].click();",signInButonu);
        Thread.sleep(3000);
    }
}
