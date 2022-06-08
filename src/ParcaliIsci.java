import java.io.*;
import java.util.Scanner;

public class ParcaliIsci extends Isci{

    private int satilanUrunSayisi ;

    public ParcaliIsci(String isim, String soyIsim, int sosyalGuvenlikNumarasi, int satilanUrunSayisi) {
        super(isim, soyIsim, sosyalGuvenlikNumarasi);
        this.satilanUrunSayisi = satilanUrunSayisi;
    }

    @Override
    public double maasHesapla() {
            return satilanUrunSayisi*45 ;
    }

    @Override
    public void toStringOku(){
        try {
            File myObj = new File("C:/Users/tolga/IdeaProjects/DersProje/parcaliIsciMetin.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
                System.out.println(myObj);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Bir hata oluştu ! (Dosya konumu hatası olabilir");
            e.printStackTrace();
        }

    }

    @Override
    public void toStringYazdir()

            throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("parcaliIsciMetin.txt"));
        writer.write("Parçalı İşçi Özet : "+toString());
        writer.close();

    }

    @Override
    public void toStringDosyasiSil()
    {
        try
        {
            File silinecekDosya = new File("C:/Users/tolga/IdeaProjects/DersProje/parcaliIsciMetin.txt");

            // Dosyanin mevcut olup olmadigini kontrol et.
            if (!silinecekDosya.exists())
                throw new IllegalArgumentException("İlgili Dosya Bulunamadı! : "
                        + silinecekDosya.getAbsolutePath());

            if (silinecekDosya.delete()) {
                System.out.println("Dosya Başarı İle Silindi.");
            }

            else {
                System.out.println("Silme İşlemi Başarısız!");
            }

        }   catch (Exception e) {
            e.printStackTrace();
        }
    }


    public int getSatilanUrunSayisi() {
        return satilanUrunSayisi;
    }

    public void setSatilanUrunSayisi(int satilanUrunSayisi) {
        this.satilanUrunSayisi = satilanUrunSayisi;
    }

    @Override
    public String toString() {
        return " ParcaliIsci {" +
                " Satilan Urun Sayisi=" + satilanUrunSayisi +
                '}';
    }
}
