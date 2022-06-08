import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)throws IOException {

       // getFileInfo(); //


        TemelIsciVeKomisyonluIsci t = new TemelIsciVeKomisyonluIsci("Tolga", "KOÇHAN", 5, 20, 1.5, 1000);

        //System.out.println(t.toString());

        MaasliIsci mIsci = new MaasliIsci("Tolga", "KOÇHAN", 5, 5000);
        /*mIsci.toStringYazdir();

        mIsci.toStringOku();
*/
        SaatlikIsci sIsci = new SaatlikIsci("Ahmet", "XX", 6, 50, 10);
        // sIsci.toStringYazdir();
        // sIsci.toStringOku();

        //sIsci.toStringYazdir();

        //  t.toStringOku();

        ParcaliIsci parcaliIsci = new ParcaliIsci("Tolga", "KOÇHAN", 5, 25);

        parcaliIsci.maasHesapla();
        parcaliIsci.toStringYazdir();
        parcaliIsci.toStringOku();

       // createNewFile();
   // getFileInfo();
    // readFile();


    }

    // EK METOTLAR :

    public static void createNewFile(){

        File file = new File("C:/Users/tolga/IdeaProjects/DersProje/newFile.txt");

        try {
            if (file.createNewFile() /*Yeni "newFile.txt" dosyası oluştur.*/)  //Dosya daha önce oluşturuldu mu diye sorguluyoruz.
            {
                System.out.println("Dosya başarıyla oluşturuldu !");
            }
            else {
                System.out.println("Dosya zaten mevcut !!");
            }


        } catch (IOException ioE) { // Hata olup olmadığını kontrol et. Oluşturulup oluşturulmadı hatası vs.
            ioE.printStackTrace();

        }

    }

    //Exist yapısı önemlidir. Dosyanın varlığını boolean olarak döndürür.
    
    public static void getFileInfo(){
        File file = new File("C:/Users/tolga/IdeaProjects/DersProje/newFile.txt");

        if (file.exists())
        {
            System.out.println("Dosyanın Adı : "+file.getName());
            System.out.println("Dosyanın Yolu : "+file.getAbsolutePath());
            System.out.println("Dosyanın Yazılabilir mi ? T/F : "+file.canWrite());
            System.out.println("Dosyanın Okunabilir mi ? T/F : "+file.canRead());
            System.out.println("Dosyanın Boyutu (byte) : "+file.length());
        }
    }

    public static void readFile(){
        File file = new File("C:/Users/tolga/IdeaProjects/DersProje/newFile.txt");
        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine())
            {
                String line = reader.nextLine();
                System.out.println(line);
            }
            reader.close(); // okuma işlemi bitti.
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
