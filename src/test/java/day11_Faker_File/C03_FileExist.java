package day11_Faker_File;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist {
    @Test
    public void test01() {
        System.out.println(System.getProperty("user.dir"));//bana icinde oldugum projenin dosya yolunu(path) verir
        System.out.println(System.getProperty("user.home"));// C:\Users\Ersin Akdemir  benim bilgisayarimin bana özel kismini verdi

        //"C:\Users\Ersin Akdemir\Downloads²
        //C:\Users\Ersin Akdemir\Desktop
        //C:\com.Batch59JUnit\src\test\java\day07_Assertions

        //Masaüstünde ki text dosyasinin varligini test edelim
        //"C:\Users\Ersin Akdemir\OneDrive\Masaüstü\text.txt"
        String dosyaYolu = System.getProperty("user.home") + "\\Desktop\\text.txt";
        System.out.println(dosyaYolu);

        /*
        bilgisayarimizda ki bir dosyanin varligini test etmek icin once o dosyaya
        ulasmak gerekir
        Java da dosyaya erisim icin dosya yoluna ()path ihtiya vardir
        Her bilgisayarin kullanici adi farkli olacagindan masaustu dosya yolunu da bir birinden farkli olacaktir
        Trstlerimizin tüm biölgisayarlarda calismasi icin dosya yolunu DINAMIK yapmak zorundayiz

        Bunu  icin
        her bilgisayarin birbirinden farkli olan yolunun bulmak icin
         */
        String farkliKisim =System.getProperty("user.home");

        //herkesin bilgisayarinda ortak olan kisim ise
        String ortakKisim ="\\OneDrive\\Masaüstü\\text.txt";
        // mac icin "/Desktop/text"

        String masaUstuDosyaYolu = farkliKisim+ortakKisim;
       // System.out.println(Files.exists(Paths.get(masaUstuDosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(masaUstuDosyaYolu)));

    }
}
