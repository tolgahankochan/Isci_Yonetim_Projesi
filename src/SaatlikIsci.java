import java.io.*;
import java.util.Scanner;

public class SaatlikIsci extends Isci{

    private int saatlikUcret ;
    private int calisilanSaat ;

    public SaatlikIsci(String isim,String soyIsim, int sosyalGuvenlikNumarasi,int saatlikUcret,int calisilanSaat)
    {
        super(isim,soyIsim,sosyalGuvenlikNumarasi);
        this.saatlikUcret=saatlikUcret;
        this.calisilanSaat=calisilanSaat;
    }

    @Override
    public void toStringOku(){
        try {
            File myObj = new File("C:/Users/tolga/IdeaProjects/DersProje/saatlikIsciMetin.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
                System.out.println(myObj);
            }
            myReader.close();
        } catch (FileNotFoundException f) {
            System.out.println("Bir hata oluştu ! (Dosya konumu hatası olabilir");
            f.printStackTrace();
        }
        catch (Exception e) {
            System.out.println("Bir hata oluştu ! (Dosya konumu hatası olabilir");
            e.printStackTrace();
        }

    }


    @Override
    public void toStringYazdir()

        throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("saatlikIsciMetin.txt"));
        writer.write("Saatlik İşçi Özet : "+toString());
        writer.close();

    }

    @Override
    public void toStringDosyasiSil()
    {
        try
        {
            File silinecekDosya = new File("C:/Users/tolga/IdeaProjects/DersProje/saatlikIsciMetin.txt");

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
    public double maasHesapla() {

        System.out.print("Maaşınız : ");

        if (this.calisilanSaat <= 40) {
            return saatlikUcret * this.calisilanSaat;
        }
        else if (this.calisilanSaat > 40) {

            return 40 * this.saatlikUcret + (this.calisilanSaat - 40) * this.saatlikUcret * 1.5;
        }

        else{

         return 0 ;

        }


    }

    public void setSaatlikUcret(int saatlikUcret)
    {
        this.saatlikUcret=saatlikUcret;
    }

    public double getSaatlikUcret()
    {
        return saatlikUcret;
    }

    public void setCalisilanSaat(int calisilanSaat)
    {
        this.calisilanSaat=calisilanSaat;
    }

    public int getCalisilanSaat()
    {
        return calisilanSaat;
    }

    @Override
    public String toString()
    {
        return super.toString() + " Saatlik İşçi : { " +  " Saatlik ücret = "+ getSaatlikUcret() + " Çalışılan saat = "+getCalisilanSaat()+"}";
    }


}
