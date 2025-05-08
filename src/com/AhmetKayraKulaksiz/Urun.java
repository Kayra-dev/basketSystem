package com.AhmetKayraKulaksiz;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Urun {

    private Map<Integer, String> urunAdi;
    private int urunId;
    private int urunFiyat;
    private String urunTarihi;

    public Urun(String urunAdi, int urunId, int urunFiyat, String urunTarihi) {

        this.urunAdi = new TreeMap<>();
        this.urunAdi.put(urunId, urunAdi);
        this.urunId = urunId;
        this.urunFiyat = urunFiyat;
        this.urunTarihi = urunTarihi;
    }

    public Map<Integer, String> getUrunAdi() {
        return urunAdi;
    }

    public void setUrunAdi(Map<Integer, String> urunAdi) {
        this.urunAdi = urunAdi;
    }

    public int getUrunId() {
        return urunId;
    }

    public void setUrunId(int urunId) {
        this.urunId = urunId;
    }

    public int getUrunFiyat() {
        return urunFiyat;
    }

    public void setUrunFiyat(int urunFiyat) {
        this.urunFiyat = urunFiyat;
    }

    public String getUrunTarihi() {
        return urunTarihi;
    }

    public void setUrunTarihi(String urunTarihi) {
        this.urunTarihi = urunTarihi;
    }

    @Override
    public String toString() {
        return " Urun {" +
                " urunAdi =" + urunAdi +
                ", urunId =" + urunId +
                ", urunFiyat =" + urunFiyat +
                ", urunTarihi ='" + urunTarihi + '\'' +
                '}';
    }

    public void urunEkleme() {
        if (urunAdi == null || urunAdi.isEmpty()) {
            System.out.println("Lütfen ürün ekleyiniz");
        } else {
            System.out.println("Zaten böyle bir ürün var " + urunAdi);
        }
    }

    public void urunSil() {
        if (!urunAdi.isEmpty()) {
            urunAdi.clear();
            System.out.println("Ürün silinmiştir ");
        } else {
            System.out.println("Ürün zaten boş ");
        }
    }

    public void urunListe(Map<Integer, String> urunAdi) {
        urunAdi.put(1001,"Elma");
        urunAdi.put(1002,"Armut");
        urunAdi.put(1003,"Kiraz");
        urunAdi.put(1004,"Karpuz");
        urunAdi.put(1005,"Çilek");
        urunAdi.put(1006,"Kayısı");
        urunAdi.put(2001,"Cips");
        urunAdi.put(2002,"Kola");
        urunAdi.put(2003,"Kraker");

        for (Map.Entry<Integer,String> temp : urunAdi.entrySet()) {
            System.out.println("{Ürün Id  :" + temp.getKey() + "}" + "{Ürün Adı : " + temp.getValue() + "}");
        }
    }



    public static void main(String[] args) {

        Scanner tara = new Scanner(System.in);


        Urun urun = new Urun("Başlangıç Ürünü", 1000, 25, "2024-01-20");
        urun.setUrunAdi(new TreeMap<>());


        while (true) {
            System.out.println("\nÜrün Yönetim Sistemi");
            System.out.println("1. Ürün Ekle");
            System.out.println("2. Ürün Sil");
            System.out.println("3. Ürün Listele");
            System.out.println("4. Çıkış");
            System.out.print("Seçiminizi girin: ");
            int secim = tara.nextInt();
            tara.nextLine();

            switch (secim) {
                case 1:
                    System.out.print("Ürün adını girin: ");
                    String ad = tara.nextLine();
                    System.out.print("Ürün ID'sini girin: ");
                    int id = tara.nextInt();
                    tara.nextLine();

                    urun.getUrunAdi().put(id, ad);
                    System.out.println("Ürün eklendi.");
                    break;
                case 2:
                    if (urun.getUrunAdi().isEmpty())
                    {
                        System.out.println("Silinecek ürün yok");
                        break;
                    }
                    System.out.print("Silmek istediğiniz ürün ID'sini girin: ");
                    int silId = tara.nextInt();
                    tara.nextLine();

                    if (urun.getUrunAdi().containsKey(silId)) {
                        urun.getUrunAdi().remove(silId);
                        System.out.println("Ürün silindi.");
                    } else {
                        System.out.println("Bu ID'ye sahip bir ürün bulunamadı.");
                    }
                    break;
                case 3:
                    urun.urunListe(urun.getUrunAdi());
                    break;
                case 4:
                    System.out.println("Çıkış yapılıyor...");
                    tara.close();
                    return;
                default:
                    System.out.println("Geçersiz seçim. Lütfen tekrar deneyin.");
            }
        }

    }
}