# iyzico-challenge

Event Management System - **done**

## Uygulama hakkında
iyzico, 27 Mayıs 2018 yılında ücretli bir yazılım konferansı düzenleyecektir. Web tabanlı bir konferans tanıtım ve kayıt sistemi yazılması
gerekmektedir. Katılımcıların konferans hakkında bilgi alabileceği, konuşmacılar hakkında detaylı olarak fikir edinebileceği, bilet alabileceği bir sistem yazılmıştır.

### Kullanılan teknolojiler
* Java 8
* Spring Boot(v1.5.1.RELEASE)
* Spring Data(v1.5.1.RELEASE)
* Spring Test(v1.5.1.RELEASE)
* H2 in-memory db(v1.4.193)
* Maven
* JUnit, Mockito, Hamcrest
* Vue.js(v2) / Bootstrap / JQuery
* iyzico-java(1.5.32.0.41)
* greenmail(v1.5.3)
* swagger(v2.4.0)
* commons-lang(v2.6)

### Uygulama davranışları
Uygulama Spring Boot projesi olarak ayağa kalktığında konferans için gerekli olan bir takım dataları oluşturmaktadır. Bu datalar **src/main/resources/db-init/** dizini altında tanımlanmıştır. Bunlar aşağıdaki gibidir;

#### Speaker Data
Konferans'a konuşmacı olarak katılacak kişilerin in-memory veritabanına aktarılması amaçlanmıştır. **src/main/resources/db-init/speaker/speaker-h2.sql** dosyası ile birlikte toplamda 3 adet konuşmacı tanımlanmıştır. Tanımlanan dosya da; isim/soyisim, resim, konu başlığı ve konu özeti alanlarına yer verilmiştir.

Speaker için oluşturulan test unit'lerine **SpeakerRepositoryTest** sınıfından ulaşabilirsiniz.

#### Price Data
Konferans'a katılacak olan katılımcıların bilet alabilmeleri için gerekli olan dataların in-memory veritabanına aktarılması amaçlanmıştır. **src/main/resources/db-init/price/price-h2.sql** dosyası ile birlikte toplamda 4 adet price tanımlanmıştır. Tanımlanan dosya da; fiyatın geçerli olduğu başlangıç/bitiş tarihi, fiyat için belirlenmiş dönem tipi ve bilet fiyatı alanlarına yer verilmiştir.

Price için oluşturulan test unit'lerine **PriceRepositoryTest** sınıfından ulaşabilirsiniz.

#### Discount Data
Konferans'a katılacak olan katılımcıların bilet alımları sırasında özel günler için gerekli olan indirim kodu dataların in-memory veritabanına aktarılması amaçlanmıştır.
 **src/main/resources/db-init/discount/discount-h2.sql** dosyası ile birlikte toplamda 4 adet indirim kodu tanımlanmıştır. Tanımlanan dosya da; indirim yapılan günün önemi, indirim kodu, indirim yapılabileceği başlangış/bitiş tarihler ve indirim oranı alanlarına yer verilmiştir.

Discount için oluşturulan test unit'lerine **TicketDiscountRepositoryTest** sınıfından ulaşabilirsiniz.






















## Home Screen
![iyzico-challenge sample gui](/dist/images/iyzico-challenge_1.png)

## Register
![iyzico-challenge sample gui](/dist/images/iyzico-challenge_2.png)
