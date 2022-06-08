import java.io.*;
import java.util.Scanner;

public class KomisyonluIsci extends Isci{

    private int brutSatis ;
    private double komisyonOrani ;

    public KomisyonluIsci(String isim, String soyIsim, int sosyalGuvenlikNumarasi,int brutSatis,double komisyonOrani) {
        super(isim, soyIsim, sosyalGuvenlikNumarasi);
        this.brutSatis=brutSatis;
        this.komisyonOrani=komisyonOrani;
    }

    public String a(){

        return "a";
    }

    @Override
    public void toStringOku(){
        try {
            File myObj = new File("C:/Users/tolga/IdeaProjects/DersProje/komisyonluIsciMetin.txt");
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
        BufferedWriter writer = new BufferedWriter(new FileWriter("komisyonluIsciMetin.txt"));
        writer.write("Komisyonlu İşçi Özet : "+toString());
        writer.close();

    }

    @Override
    public void toStringDosyasiSil()
    {
        try
        {
            File silinecekDosya = new File("C:/Users/tolga/IdeaProjects/DersProje/komisyonluIsciMetin.txt");

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

    @Override
    public double maasHesapla()
    {
        System.out.print("Maaşınız : ");
        return komisyonOrani*brutSatis;
    }

    public int getBrutSatis() {
        return brutSatis;
    }

    public void setBrutSatis(int brutSatis) {
        this.brutSatis = brutSatis;
    }



    public double getKomisyonOrani() {
        return komisyonOrani;
    }

    public void setKomisyonOrani(double komisyonOrani) {
        this.komisyonOrani = komisyonOrani;
    }

    @Override
    public String toString() {
        return super.toString() + " Komisyonlu İşçi : { " +
                " Brüt satış = " + brutSatis +
                ", Komisyon oranı = " + komisyonOrani +
                '}';
    }
}