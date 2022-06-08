import java.io.*;
import java.util.Scanner;

public abstract class Isci {

    private String isim;
    private String soyIsim;
    private int sosyalGuvenlikNumarasi;



    /*Abstract sınıflar newlenemezler fakat constructor oluştururlar çünkü extend edecek diğer sınıflar özelliklerini kullanmalıdırlar.*/




    public Isci(String isim, String soyIsim, int sosyalGuvenlikNumarasi) {
        this.isim = isim;
        this.soyIsim = soyIsim;
        this.sosyalGuvenlikNumarasi = sosyalGuvenlikNumarasi;
    }

    public void toStringOku(){
        try {
            File myObj = new File("C:/Users/tolga/IdeaProjects/DersProje/fileName.txt");
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

    public void toStringYazdir()

        throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("fileName.txt"));
        writer.write(toString());
        writer.close();

    }

    public void toStringDosyasiSil()
    {
        try
        {
            File silinecekDosya = new File("C:/Users/tolga/IdeaProjects/DersProje/fileName.txt");

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




    abstract public double maasHesapla();




    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getIsim() {
        return isim;
    }

    public void setSoyIsim(String soyIsim) {
        this.soyIsim = soyIsim;
    }

    public String getSoyIsim() {
        return soyIsim;
    }

    public void setSosyalGuvenlikNumarasi(int sosyalGuvenlikNumarasi) {
        this.sosyalGuvenlikNumarasi = sosyalGuvenlikNumarasi;
    }

    public int getSosyalGuvenlikNumarasi() {
        return sosyalGuvenlikNumarasi;
    }




    @Override
    public String toString() {
        return "İşçi {" +
                " İsim = '" + isim + '\'' +
                ", Soyisim = '" + soyIsim + '\'' +
                ", Sosyal Güvenlik Numarası = " + sosyalGuvenlikNumarasi +
                '}'  ;


    }


}
