package day14_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C04_readExcel {
    @Test
    public void readExcelTEst() throws IOException {
        //7. Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/resources/ulkeler.xlsx";

        //8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        FileInputStream fis =new FileInputStream(dosyaYolu);

        //10. WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis);

        //ingilizler baskentler sutunu yazdiralim 1. indexte

        int sonSatirNo = workbook.getSheet("Sayfa1").getLastRowNum();
        System.out.println(sonSatirNo); //index no verir
        String satirdakiData = "";

        for (int i = 0; i <= sonSatirNo; i++) {
            satirdakiData =C03_readExcel.banaDataGetir(i,1);
            System.out.println(satirdakiData);
        }

    }
}
