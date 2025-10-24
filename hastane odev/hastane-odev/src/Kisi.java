
/**
 * Kişi sınıfı - Hasta ve Doktor için temel (parent) sınıf
 * Ortak özellikleri (ad, soyad, tc, telefon) tutar
 */
public class Kisi {
    private String ad;
    private String soyad;
    private String tcNo;
    private String telefon;

    /**
     * Constructor - Yeni bir kişi nesnesi oluşturur
     */
    public Kisi(String ad, String soyad, String tcNo, String telefon) {
        this.ad = ad;
        this.soyad = soyad;
        this.tcNo = tcNo;
        this.telefon = telefon;
    }

    // Getter metodları - Özelliklere erişim sağlar
    public String getAd() { return ad; }
    public String getSoyad() { return soyad; }
    public String getTcNo() { return tcNo; }
    public String getTelefon() { return telefon; }

    // Setter metodu - Telefon güncellenebilir
    public void setTelefon(String telefon) { this.telefon = telefon; }

    /**
     * Tam adı (ad + soyad) döndürür
     */
    public String getTamAd() {
        return ad + " " + soyad;
    }
}
