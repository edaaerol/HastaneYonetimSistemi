# 🏥 Hastane Yönetim Sistemi (Hospital Management System)

Bu proje, **Java** dilinde geliştirilmiş nesne tabanlı bir **Hastane Yönetim Sistemi** uygulamasıdır.  
Sistem; **hasta**, **doktor** ve **randevu** işlemlerini konsol üzerinden yönetmeyi sağlar.

---

## 🚀 Proje Özeti

Bu uygulama bir hastanede gerçekleşen temel işlemleri yönetmek için tasarlanmıştır.  
Kullanıcı, menü üzerinden şu işlemleri yapabilir:

- Yeni hasta kaydı oluşturma  
- Doktor kaydı ekleme  
- Hasta / doktor arama  
- Randevu oluşturma, iptal etme veya listeleme  
- Tüm kayıtları detaylı şekilde görüntüleme  

Proje nesne yönelimli programlama (OOP) ilkelerine göre tasarlanmıştır.  
Sınıflar arasında **kalıtım (inheritance)** ve **kapsülleme (encapsulation)** kavramları etkin biçimde kullanılmıştır.

---

## 🧩 Sınıf Yapısı

### 🔹 `Kisi`
- Hasta ve Doktor sınıflarının üst sınıfıdır.  
- Ortak özellikleri içerir: `ad`, `soyad`, `tcNo`, `telefon`.

### 🔹 `Hasta`
- `Kisi` sınıfından türetilmiştir.  
- Her hasta için otomatik artan bir `hastaNo` değeri atanır.  
- Metotlar:
  - `getHastaNo()`
  - `toString()` — Hasta bilgilerini biçimli olarak döndürür.

### 🔹 `Doktor`
- `Kisi` sınıfından türetilmiştir.  
- Her doktorun kendine özgü bir `doktorId` ve `brans` (branş) bilgisi vardır.  
- Metotlar:
  - `getDoktorId()`, `getBrans()`
  - `toString()` — Doktor bilgilerini biçimli olarak döndürür.

### 🔹 `Randevu`
- Bir `Hasta` ve bir `Doktor` arasında oluşturulan randevuyu temsil eder.  
- Özellikler:
  - `randevuNo`, `tarih`, `saat`, `durum`  
- Metotlar:
  - `iptalEt()` — Randevunun durumunu "İptal" yapar.  
  - `toString()` — Randevu bilgilerini formatlı olarak döndürür.

### 🔹 `HastaneYonetimSistemi`
- Sistemin merkezidir.  
- Hasta, doktor ve randevu listelerini yönetir.  
- Ana menü üzerinden tüm işlemler bu sınıf aracılığıyla yapılır.

  Ana menü seçenekleri:

