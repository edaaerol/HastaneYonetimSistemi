
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Hastane Yönetim Sistemi - Ana yönetim sınıfı
 * Tüm hasta, doktor ve randevu işlemlerini yönetir
 */
public class HastaneYonetimSistemi {
    private ArrayList<Hasta> hastalar;       // Hasta listesi
    private ArrayList<Doktor> doktorlar;     // Doktor listesi
    private ArrayList<Randevu> randevular;   // Randevu listesi
    private Scanner scanner;

    /**
     * Constructor - Sistem başlatılır, örnek veriler yüklenir
     */
    public HastaneYonetimSistemi() {
        hastalar = new ArrayList<>();
        doktorlar = new ArrayList<>();
        randevular = new ArrayList<>();
        scanner = new Scanner(System.in);

        ornekVerileriYukle(); // Başlangıç için örnek doktorlar ekle
    }

    /**
     * Başlangıç için örnek doktorları sisteme ekler
     */
    private void ornekVerileriYukle() {
        doktorlar.add(new Doktor("Ahmet", "Yılmaz", "12345678901", "0532-111-1111", "Kardiyoloji"));
        doktorlar.add(new Doktor("Ayşe", "Demir", "12345678902", "0532-222-2222", "Ortopedi"));
        doktorlar.add(new Doktor("Mehmet", "Kaya", "12345678903", "0532-333-3333", "Dahiliye"));
        doktorlar.add(new Doktor("Fatma", "Şahin", "12345678904", "0532-444-4444", "Göz Hastalıkları"));
    }

    /**
     * Ana menü - Sistemin giriş noktası
     * Kullanıcı burada ana işlemleri seçer
     */
    public void anaMenu() {
        while (true) {
            System.out.println("\n" + "=".repeat(60));
            System.out.println("     HASTANE RANDEVU VE KAYIT YÖNETİM SİSTEMİ");
            System.out.println("=".repeat(60));
            System.out.println("1. Hasta İşlemleri");
            System.out.println("2. Doktor İşlemleri");
            System.out.println("3. Randevu İşlemleri");
            System.out.println("4. Listele");
            System.out.println("0. Çıkış");
            System.out.println("=".repeat(60));
            System.out.print("Seçiminiz: ");

            int secim = sayiOku();

            switch (secim) {
                case 1: hastaIslemleriMenu(); break;
                case 2: doktorIslemleriMenu(); break;
                case 3: randevuIslemleriMenu(); break;
                case 4: listeleMenu(); break;
                case 0:
                    System.out.println("\nSistemden çıkılıyor. İyi günler!");
                    return;
                default:
                    System.out.println("\n⚠ Geçersiz seçim! Lütfen tekrar deneyin.");
            }
        }
    }

    /**
     * Hasta işlemleri menüsü
     */
    private void hastaIslemleriMenu() {
        System.out.println("\n--- HASTA İŞLEMLERİ ---");
        System.out.println("1. Yeni Hasta Kaydı");
        System.out.println("2. Hasta Ara");
        System.out.println("0. Geri Dön");
        System.out.print("Seçiminiz: ");

        int secim = sayiOku();

        switch (secim) {
            case 1: hastaKaydet(); break;
            case 2: hastaAra(); break;
            case 0: return;
            default: System.out.println("⚠ Geçersiz seçim!");
        }
    }

    /**
     * Doktor işlemleri menüsü
     */
    private void doktorIslemleriMenu() {
        System.out.println("\n--- DOKTOR İŞLEMLERİ ---");
        System.out.println("1. Yeni Doktor Kaydı");
        System.out.println("2. Doktor Ara");
        System.out.println("0. Geri Dön");
        System.out.print("Seçiminiz: ");

        int secim = sayiOku();

        switch (secim) {
            case 1: doktorKaydet(); break;
            case 2: doktorAra(); break;
            case 0: return;
            default: System.out.println("⚠ Geçersiz seçim!");
        }
    }

    /**
     * Randevu işlemleri menüsü
     */
    private void randevuIslemleriMenu() {
        System.out.println("\n--- RANDEVU İŞLEMLERİ ---");
        System.out.println("1. Yeni Randevu Oluştur");
        System.out.println("2. Randevu İptal Et");
        System.out.println("3. Randevu Ara");
        System.out.println("0. Geri Dön");
        System.out.print("Seçiminiz: ");

        int secim = sayiOku();

        switch (secim) {
            case 1: randevuOlustur(); break;
            case 2: randevuIptal(); break;
            case 3: randevuAra(); break;
            case 0: return;
            default: System.out.println("⚠ Geçersiz seçim!");
        }
    }

    /**
     * Listeleme menüsü
     */
    private void listeleMenu() {
        System.out.println("\n--- LİSTELEME ---");
        System.out.println("1. Tüm Hastaları Listele");
        System.out.println("2. Tüm Doktorları Listele");
        System.out.println("3. Tüm Randevuları Listele");
        System.out.println("4. Aktif Randevuları Listele");
        System.out.println("0. Geri Dön");
        System.out.print("Seçiminiz: ");

        int secim = sayiOku();

        switch (secim) {
            case 1: hastalariListele(); break;
            case 2: doktorlariListele(); break;
            case 3: randevulariListele(false); break;
            case 4: randevulariListele(true); break;
            case 0: return;
            default: System.out.println("⚠ Geçersiz seçim!");
        }
    }

    /**
     * Yeni hasta kaydı oluşturur
     */
    private void hastaKaydet() {
        System.out.println("\n--- YENİ HASTA KAYDI ---");
        scanner.nextLine(); // Buffer temizle

        System.out.print("Ad: ");
        String ad = scanner.nextLine();

        System.out.print("Soyad: ");
        String soyad = scanner.nextLine();

        System.out.print("TC Kimlik No: ");
        String tcNo = scanner.nextLine();

        System.out.print("Telefon: ");
        String telefon = scanner.nextLine();

        Hasta yeniHasta = new Hasta(ad, soyad, tcNo, telefon);
        hastalar.add(yeniHasta);

        System.out.println("\n✓ Hasta başarıyla kaydedildi!");
        System.out.println(yeniHasta);
    }

    /**
     * Hasta numarası ile hasta arar
     */
    private void hastaAra() {
        System.out.println("\n--- HASTA ARA ---");
        System.out.print("Hasta No: ");
        int hastaNo = sayiOku();

        Hasta bulunanHasta = hastaBul(hastaNo);

        if (bulunanHasta != null) {
            System.out.println("\n✓ Hasta bulundu:");
            System.out.println(bulunanHasta);
        } else {
            System.out.println("\n⚠ Hasta bulunamadı!");
        }
    }

    /**
     * Yeni doktor kaydı oluşturur
     */
    private void doktorKaydet() {
        System.out.println("\n--- YENİ DOKTOR KAYDI ---");
        scanner.nextLine(); // Buffer temizle

        System.out.print("Ad: ");
        String ad = scanner.nextLine();

        System.out.print("Soyad: ");
        String soyad = scanner.nextLine();

        System.out.print("TC Kimlik No: ");
        String tcNo = scanner.nextLine();

        System.out.print("Telefon: ");
        String telefon = scanner.nextLine();

        System.out.print("Branş: ");
        String brans = scanner.nextLine();

        Doktor yeniDoktor = new Doktor(ad, soyad, tcNo, telefon, brans);
        doktorlar.add(yeniDoktor);

        System.out.println("\n✓ Doktor başarıyla kaydedildi!");
        System.out.println(yeniDoktor);
    }

    /**
     * Doktor ID ile doktor arar
     */
    private void doktorAra() {
        System.out.println("\n--- DOKTOR ARA ---");
        System.out.print("Doktor ID: ");
        int doktorId = sayiOku();

        Doktor bulunanDoktor = doktorBul(doktorId);

        if (bulunanDoktor != null) {
            System.out.println("\n✓ Doktor bulundu:");
            System.out.println(bulunanDoktor);
        } else {
            System.out.println("\n⚠ Doktor bulunamadı!");
        }
    }

    /**
     * Yeni randevu oluşturur
     * Önce doktor ve hasta seçilir, sonra tarih/saat belirlenir
     */
    private void randevuOlustur() {
        System.out.println("\n--- YENİ RANDEVU OLUŞTUR ---");

        // Önce doktorları listele
        doktorlariListele();

        System.out.print("\nDoktor ID: ");
        int doktorId = sayiOku();
        Doktor doktor = doktorBul(doktorId);

        if (doktor == null) {
            System.out.println("⚠ Doktor bulunamadı!");
            return;
        }

        // Hastaları listele
        hastalariListele();

        System.out.print("\nHasta No: ");
        int hastaNo = sayiOku();
        Hasta hasta = hastaBul(hastaNo);

        if (hasta == null) {
            System.out.println("⚠ Hasta bulunamadı!");
            return;
        }

        scanner.nextLine(); // Buffer temizle

        System.out.print("Tarih (GG.AA.YYYY): ");
        String tarih = scanner.nextLine();

        System.out.print("Saat (HH:MM): ");
        String saat = scanner.nextLine();

        Randevu yeniRandevu = new Randevu(hasta, doktor, tarih, saat);
        randevular.add(yeniRandevu);

        System.out.println("\n✓ Randevu başarıyla oluşturuldu!");
        System.out.println(yeniRandevu);
    }

    /**
     * Randevu iptal eder
     */
    private void randevuIptal() {
        System.out.println("\n--- RANDEVU İPTAL ---");

        // Aktif randevuları listele
        randevulariListele(true);

        System.out.print("\nİptal edilecek Randevu No: ");
        int randevuNo = sayiOku();

        Randevu randevu = randevuBul(randevuNo);

        if (randevu == null) {
            System.out.println("⚠ Randevu bulunamadı!");
            return;
        }

        if (randevu.getDurum().equals("İptal")) {
            System.out.println("⚠ Bu randevu zaten iptal edilmiş!");
            return;
        }

        randevu.iptalEt();
        System.out.println("\n✓ Randevu başarıyla iptal edildi!");
        System.out.println(randevu);
    }

    /**
     * Randevu numarası ile randevu arar
     */
    private void randevuAra() {
        System.out.println("\n--- RANDEVU ARA ---");
        System.out.print("Randevu No: ");
        int randevuNo = sayiOku();

        Randevu randevu = randevuBul(randevuNo);

        if (randevu != null) {
            System.out.println("\n✓ Randevu bulundu:");
            System.out.println(randevu);
        } else {
            System.out.println("\n⚠ Randevu bulunamadı!");
        }
    }

    /**
     * Tüm hastaları listeler
     */
    private void hastalariListele() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("HASTA LİSTESİ");
        System.out.println("=".repeat(60));

        if (hastalar.isEmpty()) {
            System.out.println("Kayıtlı hasta bulunmamaktadır.");
        } else {
            for (Hasta hasta : hastalar) {
                System.out.println(hasta);
            }
        }
        System.out.println("=".repeat(60));
    }

    /**
     * Tüm doktorları listeler
     */
    private void doktorlariListele() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("DOKTOR LİSTESİ");
        System.out.println("=".repeat(60));

        if (doktorlar.isEmpty()) {
            System.out.println("Kayıtlı doktor bulunmamaktadır.");
        } else {
            for (Doktor doktor : doktorlar) {
                System.out.println(doktor);
            }
        }
        System.out.println("=".repeat(60));
    }

    /**
     * Randevuları listeler
     * @param sadecAktif true ise sadece aktif randevular, false ise tümü
     */
    private void randevulariListele(boolean sadecAktif) {
        System.out.println("\n" + "=".repeat(80));
        System.out.println(sadecAktif ? "AKTİF RANDEVU LİSTESİ" : "TÜM RANDEVULAR");
        System.out.println("=".repeat(80));

        boolean bulundu = false;
        for (Randevu randevu : randevular) {
            if (!sadecAktif || randevu.getDurum().equals("Aktif")) {
                System.out.println(randevu);
                bulundu = true;
            }
        }

        if (!bulundu) {
            System.out.println("Randevu bulunmamaktadır.");
        }
        System.out.println("=".repeat(80));
    }

    /**
     * Hasta numarası ile hasta bulur
     * @return Bulunan hasta veya null
     */
    private Hasta hastaBul(int hastaNo) {
        for (Hasta hasta : hastalar) {
            if (hasta.getHastaNo() == hastaNo) {
                return hasta;
            }
        }
        return null;
    }

    /**
     * Doktor ID ile doktor bulur
     * @return Bulunan doktor veya null
     */
    private Doktor doktorBul(int doktorId) {
        for (Doktor doktor : doktorlar) {
            if (doktor.getDoktorId() == doktorId) {
                return doktor;
            }
        }
        return null;
    }

    /**
     * Randevu numarası ile randevu bulur
     * @return Bulunan randevu veya null
     */
    private Randevu randevuBul(int randevuNo) {
        for (Randevu randevu : randevular) {
            if (randevu.getRandevuNo() == randevuNo) {
                return randevu;
            }
        }
        return null;
    }

    /**
     * Güvenli sayı okuma metodu
     * Hatalı girişlerde -1 döner
     */
    private int sayiOku() {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine(); // Hatalı girişi temizle
            return -1;
        }
    }
}