package day14_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C06_readExcel {
    @Test
    public void readExcelTest() throws IOException {
        //Excel dosyasindaki tüm veri leri clasimiza alip bir java objesine store edelim
        // böylece her seferinde excel esatir, sutun, vs ugrasmayalim

        //Database yapisi olan Excel i
        //koyabilecegimiz en uygun Java objesi mapdir

        Map<String,String>ulkelerMap =new HashMap<>();
        //7. Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/resources/ulkeler.xlsx";

        //8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        FileInputStream fis =new FileInputStream(dosyaYolu);

        //10. WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis);
        int sonSatirIndexi=workbook.getSheet("Sayfa1").getLastRowNum();

        for (int i = 0; i < sonSatirIndexi; i++) {
            //key i. satirdaki 0 indexindeki datadir
            String key =workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();

            // value ise i. satirdaki 1,2 ve 3 indexdeki datalari birlesimi olacak
            String value = workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString()
                    +", "+
                    workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString()
                    +", "+
                    workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();
            ulkelerMap.put(key,value);
        }
        System.out.println(ulkelerMap);

        //Listede  Ghana oldugunu test edelim
        Assert.assertTrue(ulkelerMap.keySet().contains("Ghana"));
    }
}
