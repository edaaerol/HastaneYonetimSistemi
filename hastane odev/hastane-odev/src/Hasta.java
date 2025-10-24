/**
 * Hasta sınıfı - Kisi sınıfından türetilmiştir
 * Hastaneye kayıtlı hastaları temsil eder
 */
public class Hasta extends Kisi {
    private static int sonHastaNo = 1000; // Statik sayaç - tüm hastalar için ortak
    private int hastaNo;

    /**
     * Constructor - Yeni hasta oluşturur ve otomatik hasta no atar
     */
    public Hasta(String ad, String soyad, String tcNo, String telefon) {
        super(ad, soyad, tcNo, telefon); // Üst sınıfın constructor'ını çağır
        this.hastaNo = ++sonHastaNo; // Otomatik artan hasta numarası
    }

    public int getHastaNo() { return hastaNo; }

    /**
     * Hasta bilgilerini formatlanmış string olarak döndürür
     */
    @Override
    public String toString() {
        return String.format("Hasta No: %d | Ad Soyad: %s | TC: %s | Tel: %s",
                hastaNo, getTamAd(), getTcNo(), getTelefon());
    }
}
