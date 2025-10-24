/**
 * Doktor sınıfı - Kisi sınıfından türetilmiştir
 * Hastanedeki doktorları temsil eder
 */
public class Doktor extends Kisi {
    private String brans;
    private static int sonDoktorId = 100; // Statik sayaç
    private int doktorId;

    /**
     * Constructor - Yeni doktor oluşturur
     */
    public Doktor(String ad, String soyad, String tcNo, String telefon, String brans) {
        super(ad, soyad, tcNo, telefon);
        this.brans = brans;
        this.doktorId = ++sonDoktorId; // Otomatik artan doktor ID
    }

    public String getBrans() { return brans; }
    public int getDoktorId() { return doktorId; }

    /**
     * Doktor bilgilerini formatlanmış string olarak döndürür
     */
    @Override
    public String toString() {
        return String.format("Dr ID: %d | Dr. %s | Branş: %s | Tel: %s",
                doktorId, getTamAd(), brans, getTelefon());
    }
}
