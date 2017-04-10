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

Uygulamaya heroku üzerinden erişebilirsiniz :

### Uygulama davranışları

#### Database Initialization

Uygulama Spring Boot projesi olarak ayağa kalktığında konferans için gerekli olan bir takım dataları oluşturmaktadır. Bu datalar **src/main/resources/db-init/** dizini altında tanımlanmıştır. Bunlar aşağıdaki gibidir;

> ##### Speaker Data
Konferans'a konuşmacı olarak katılacak kişilerin in-memory veritabanına aktarılması amaçlanmıştır. **src/main/resources/db-init/speaker/speaker-h2.sql** dosyası ile birlikte toplamda 3 adet konuşmacı tanımlanmıştır. Tanımlanan dosya da; isim/soyisim, resim, konu başlığı ve konu özeti alanlarına yer verilmiştir.

* Speaker için oluşturulan test unit'lerine **SpeakerRepositoryTest** sınıfından ulaşabilirsiniz.

> ##### Price Data
Konferans'a katılacak olan katılımcıların bilet alabilmeleri için gerekli olan dataların in-memory veritabanına aktarılması amaçlanmıştır. **src/main/resources/db-init/price/price-h2.sql** dosyası ile birlikte toplamda 4 adet price tanımlanmıştır. Tanımlanan dosya da; fiyatın geçerli olduğu başlangıç/bitiş tarihi, fiyat için belirlenmiş dönem tipi ve bilet fiyatı alanlarına yer verilmiştir.

* Price için oluşturulan test unit'lerine **PriceRepositoryTest** sınıfından ulaşabilirsiniz.

> ##### Discount Data
Konferans'a katılacak olan katılımcıların bilet alımları sırasında özel günler için gerekli olan indirim kodu dataların in-memory veritabanına aktarılması amaçlanmıştır.
 **src/main/resources/db-init/discount/discount-h2.sql** dosyası ile birlikte toplamda 4 adet indirim kodu tanımlanmıştır. Tanımlanan dosya da; indirim yapılan günün önemi, indirim kodu, indirim yapılabileceği başlangış/bitiş tarihler ve indirim oranı alanlarına yer verilmiştir.

* Discount için oluşturulan test unit'lerine **TicketDiscountRepositoryTest** sınıfından ulaşabilirsiniz.

#### Ticket Registeration

Bilet almak için kullanılacak kart'lari için bazı kısıtlamalar bulunmaktadır. Bunlar aşağıdaki gibidir;
* Kredi kartları için sadece **Garanti Bankası, İş Bankası, Akbank ve Finansbank** 'a ait kredi kartları kullanılabilir.
* Debit kartları için sadece **Halk Bankası** 'a ait kredi kartları kullanılabilir.

Bu kısıtlamalara uymayan kartlar kullanıldığında aşağıdaki hatalara benzer bir hata alınabilmektedir;
  ![iyzico-challenge conference speakers](/dist/images/conference-register-3.png)

  ![iyzico-challenge conference speakers](/dist/images/conference-register-4.png)

Kullanıcı uygulamayı açtığında(context path'e browserdan girildiğinde) Spring controller'a istekler yapılarak **Database Initialization** kısmında oluşturulan veriler client-side tarafına alınmaktadır. Burada vue.js javascript framework'ü kullanılmıştır. Alınan veriler ile birlikte ekranlar otomatik olarak oluşturulmaktadır.

Ekran üzerinde görülebilecek alanlar;
* Konferans hakkında genel bilgiler;

  ![iyzico-challenge conference carousel](/dist/images/conference-carousel.png)

* Konuşmacılar hakkında genel bilgiler;

  ![iyzico-challenge conference speakers](/dist/images/conference-speakers.png)
  > Konuşmacıların resmi, konu başlığı ve özeti görüntülenebilir. Konuşmacı adı ile arama yapılabilir.

* Konferans için bilet alımda kullanılabilecek biletler hakkında genel bilgiler;

  ![iyzico-challenge conference prices](/dist/images/conference-prices.png)

* Konferans için bilet alma. Örnek bir kullanım aşağıdaki gibidir;

  ![iyzico-challenge conference register](/dist/images/conference-register-1.png)

  ![iyzico-challenge conference register](/dist/images/conference-register-2.png)
* Konferans yeri ve ulaşım bilgieri hakkında genel bilgiler;

  ![iyzico-challenge conference register](/dist/images/conference-venue.png)

#### Ticket Registering Notification
Bilet alma işlemi başarıyla tamamlandığı taktirde mail ile ticket'ın tamamlandığına dair bildirim gönderilir.

> Ticket alma işleminde mail gönderme işlevi uygulamanın properties dosyasından enable/disable edilebilir.

Bildirim gönderebilmek için gmail smtp sunucusu kullanılmıştır. **iyzico-challenge** için bir kullanıcı hesapı oluşturulmuş olup, properties dosyasından değiştirilebilir.

### CI Build

Uygulama travis-ci ile entegre çalışarak git repository'e yapılan herhangi bir push işleminde otomatik olarak entegrasyonun sağlıklı olup olmadığınu kontrol etmektedir.

Build çıktıları ve mail bildirimi aşağıda yer almaktadır;

  ![iyzico-challenge travis](/dist/images/iyzico-challenge-travis.png)

  ![iyzico-challenge travis](/dist/images/iyzico-challenge-travis-2.png)

  ![iyzico-challenge travis mail](/dist/images/iyzcio-challenge-travis-mail.png)
### SonarQube

SonarQube çıktısı aşağıdaki gibidir;
  ![iyzico-challenge SonarQube](/dist/images/iyzico-challenge-sonarqube.png)

### SwaggerUI

Swagger entegrasyonu ile servislerin detayına ulaşabilirsiniz.

Context path'den sonra **swagger-ui.html** adresine giderek servisleri listeleyebilirsiniz. Örnek çıktı aşağıdaki gibidir;

![iyzico-challenge swagger](/dist/images/iyzico-challenge-swagger.png)

### Docker

Docker ile kullanabilmek için Dockerfile ile build edilmesi gerekir. Docker ile kullanmak için aşağıdaki adımları takip ediniz;

1. Projenin root dizinine geliniz.
2. '**docker build -t iyzico-challenge .**' komutunu çalıştırınız. Aşağıdakine benzer bir çıktı görüyor olmalısınız;

  ![iyzico-challenge docker](/dist/images/iyzico-challenge-docker.png)
3. '**docker images**' ile image'ın yaratıldığından emin olunuz. **iyzico-challenge** image name ile bir image'ın oluşması gerekmektedir;

  ![iyzico-challenge docker](/dist/images/iyzico-challenge-docker-images.png)
4. '**docker run -p 8080:8080 iyzico-challenge**' komutu ile bir container oluşturunuz. Ardından '**docker ps**' komutunu çalıştırdığınızda aşağıdakine benzer bir çıktı almalısınız;

  ![iyzico-challenge docker](/dist/images/iyzico-challenge-docker-ps.png)
5. Herşey yolunda gitti ise localdeki tarayıcınızdan http://localhost:8080  adresine giderek uygulamaya erişebilirsiniz.

Docker Hub üzerinden erişmek için ise docker cli ile aşağıdaki komutu kullanabilirsiniz;
Docker cli command : **docker pull aakkus/iyzico-challenge**

### Unit test code coverage

Eclipse üzerinde ki plugin ile unit testler için alınmış olan code coverage değeri şöyledir;
  ![iyzico-challenge code coverage](/dist/images/iyzico-challenge-code-coverage.png)


### Application.properties file

Uygulama içerisinde kullanılan properties dosyası içerisindeki değişkenler ve anlamları aşağıdaki gibidir;

| Değişken adı                                                    | Değişken açıklaması                                     |
| -------------                                                   |:-------------------------------------------------------:|
| iyzico.application.name                                         | uygulama adı                                            |
| iyzico.application.description                                  | uygulama açıklaması                                     |
| iyzico.application.version                                      | uygulama açıklaması                                     |  
| iyzico.application.createdBy                                    | uygulamanın kim tarafından oluşturulduğu                |
| iyzico.application.reviewers                                    | uygulama inceleyicileri                                 |
| iyzico-challenge.security.enabled                               | server security enabled                                 |
| iyzico-challenge.security.userName                              | server security username                                |
| iyzico-challenge.security.password                              | server security password                                |
| iyzico-challenge.security.role                                  | server security role                                    |
| iyzico-challenge.api.key                                        | iyzico servislerini kullanmak için gerekli bilgiler     |
| iyzico-challenge.api.secret                                     | iyzico servislerini kullanmak için gerekli bilgiler     |
| iyzico-challenge.api.baseUrl                                    | iyzico servislerini kullanmak için gerekli bilgiler     |
| iyzico-challenge.allowed.credit.cards                           | ticket alınabilecek kredi kartları                      |
| iyzico-challenge.allowed.debit.cards                            | ticket alınabilecek debit kartları                      |
| iyzico-challenge.ticket.mail.notification.enabled               | ticket alındıktan sonra mail bildirim gönderme flag'i   |
| spring.h2.console.enabled                                       | in-memory db enabled                                    |
| spring.datasource.platform=                                     | in-memory olarak h2                                     |
| spring.datasource.continueOnError                               | hata alırsak devam etmeyelim                            |
| spring.datasource.data                                          | database Initialization                                 |
| spring.datasource.url                                           | h2 db url                                               |
| spring.datasource.driverClassName                               | h2 driver class name                                    |
| spring.datasource.username                                      | h2 db username                                          |
| spring.datasource.password                                      | h2 db password                                          |
| spring.jpa.database-platform                                    | h2 db platform                                          |
| logging.level.org.hibernate.SQL                                 | hibernate logging                                       |
| logging.level.org.hibernate.type.descriptor.sql.BasicBinder     | hibernate logging                                       |
| logging.pattern.console                                         | console logging layout                                  |
| spring.http.encoding.charset                                    | http charset                                            |
| spring.http.encoding.enabled                                    | h2 db password                                          |
| security.user.name                                              | security definitions for some url's                     |
| security.user.password                                          | security password                                       |
| management.security.roles                                       | actutator definitions                                   |
| management.context-path                                         | actutator path                                          |
| spring.jackson.serialization.INDENT_OUTPUT                      | pretty print json                                       |
| spring.mail.*                                                   | spring mail properties                                  |
| iyzico-challenge.register.inputs.test.count                     | ticket register input count                             |
| iyzico-challenge.register.inputs.{{number}}                     | ticket register input                                   |
| iyzico-challenge.register.inputs.expected.{{number}}            | ticket register output                                  |

### Local development

Aşağıdaki adımları takip edebilirsiniz;

1. Repo'yu clone ediniz;
  > git clone git@github.com:AlicanAkkus/iyzico-challenge.git

2. Proje dizinine gidiniz;
  > cd iyzico-challenge

3. Herhangi bir IDE yardımı ile maven projesi olarak import ettikten sonra çalışmaya başlayabilirsiniz.
