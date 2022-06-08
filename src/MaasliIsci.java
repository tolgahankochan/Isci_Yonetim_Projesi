import java.io.*;
import java.util.Scanner;

public class MaasliIsci extends Isci{

    private int haftalikMaas;

    public MaasliIsci(String isim,String soyIsim,int sosyalGuvenlikNumarasi,int haftalikMaas)
    {
        super(isim,soyIsim,sosyalGuvenlikNumarasi);
        this.haftalikMaas=haftalikMaas;
    }

    @Override
    public void toStringOku(){
        try {
            File myObj = new File("C:/Users/tolga/IdeaProjects/DersProje/maasliIsciMetin.txt");
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
        BufferedWriter writer = new BufferedWriter(new FileWriter("maasliIsciMetin.txt"));
        writer.write("Maaşlı İşçi Özet : "+toString());
        writer.close();

    }

    @Override
        public void toStringDosyasiSil()
        {
            try
            {
                File silinecekDosya = new File("C:/Users/tolga/IdeaProjects/DersProje/maasliIsciMetin.txt");

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
        return haftalikMaas;
    }

    public void setHaftalikMaas(int haftalikMaas)
    {
        this.haftalikMaas=haftalikMaas;
    }

    public int getHaftalikMaas()
    {
        return haftalikMaas;
    }

    @Override
    public String toString()
    {
        return super.toString() + " Maaşlı İşçi : { " + " Haftalık Maaş = " +getHaftalikMaas() + " }";
    }

}
