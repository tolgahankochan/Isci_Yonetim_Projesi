import java.io.*;
import java.util.Scanner;

public class TemelIsciVeKomisyonluIsci extends KomisyonluIsci{

        private int tabanMaas ;

        public TemelIsciVeKomisyonluIsci(String isim, String soyIsim, int sosyalGuvenlikNumarasi, int brutSatis, double komisyonOrani,int tabanMaas) {
            super(isim, soyIsim, sosyalGuvenlikNumarasi, brutSatis, komisyonOrani);
            this.tabanMaas=tabanMaas;
        }

    @Override
    public void toStringOku(){
        try {
            File myObj = new File("C:/Users/tolga/IdeaProjects/DersProje/TemelVeKomisyonluIsciMetin.txt");
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
        BufferedWriter writer = new BufferedWriter(new FileWriter("TemelVeKomisyonluIsciMetin.txt"));
        writer.write("Temel Ve Komisyonlu İşçi Özet : "+toString());
        writer.close();

    }

    @Override
    public void toStringDosyasiSil()
    {
        try
        {
            File silinecekDosya = new File("C:/Users/tolga/IdeaProjects/DersProje/TemelVeKomisyonluIsciMetin.txt");

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
            return (super.getKomisyonOrani() * super.getBrutSatis()) + tabanMaas;
        }

        public int getTabanMaas() {
            return tabanMaas;
        }

        public void setTabanMaas(int tabanMaas) {
            this.tabanMaas = tabanMaas;
        }

        @Override
        public String toString() {
            return super.toString() + " Taban Maaş Ve Komisyonlu İşçi : { " +
                    " Taban maaş = " + tabanMaas + this.a()+
                    '}';
        }
    }


