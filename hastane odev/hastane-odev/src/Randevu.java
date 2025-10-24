/**
 * Randevu sınıfı - Hasta ve doktor arasındaki randevuları temsil eder
 */
public class Randevu {
    private static int sonRandevuNo = 1; // Statik sayaç
    private int randevuNo;
    private Hasta hasta;
    private Doktor doktor;
    private String tarih;
    private String saat;
    private String durum; // "Aktif" veya "İptal"

    /**
     * Constructor - Yeni randevu oluşturur
     */
    public Randevu(Hasta hasta, Doktor doktor, String tarih, String saat) {
        this.randevuNo = sonRandevuNo++;
        this.hasta = hasta;
        this.doktor = doktor;
        this.tarih = tarih;
        this.saat = saat;
        this.durum = "Aktif";
    }

    // Getter metodları
    public int getRandevuNo() { return randevuNo; }
    public Hasta getHasta() { return hasta; }
    public Doktor getDoktor() { return doktor; }
    public String getTarih() { return tarih; }
    public String getSaat() { return saat; }
    public String getDurum() { return durum; }

    /**
     * Randevuyu iptal eder - durum "İptal" olarak güncellenir
     */
    public void iptalEt() {
        this.durum = "İptal";
    }

    /**
     * Randevu bilgilerini formatlanmış string olarak döndürür
     */
    @Override
    public String toString() {
        return String.format("Randevu No: %d | Hasta: %s | Doktor: Dr. %s (%s) | Tarih: %s %s | Durum: %s",
                randevuNo, hasta.getTamAd(), doktor.getTamAd(), doktor.getBrans(),
                tarih, saat, durum);
    }
}
