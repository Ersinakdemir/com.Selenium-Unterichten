package day14_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_readExcel {
    @Test
    public void readExcelTesti() throws IOException {
        //input olarak verilen
        // satir ve sutun no degerlerini parametre olarak alip
        //o cdell deki datayi String olarak bana donduren bir method olusturun

        int satirNo = 12;
        int sutunNo = 2;

        // donen String in Cezayir oldugunu test edin
        String expectedData = "Baku";
        String actualData= banaDataGetir(satirNo-1,sutunNo-1);// cünku excel index ili calisir
        Assert.assertEquals(expectedData,actualData);
    }

    public static String banaDataGetir(int satirIndex, int sutunIndex) throws IOException {
        String istenenData = "";
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        FileInputStream fis =new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

        istenenData =workbook
                .getSheet("Sayfa1")
                .getRow(satirIndex)
                .getCell(sutunIndex)
                .toString();

        return istenenData;
    }
}
