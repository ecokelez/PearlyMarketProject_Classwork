package tests.ersoy.US21;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class US21_TC01 {

   /*
          Kullanici  https://pearlymarket.com/  adresine gider
          Kullanıcı Sign in butonuna tiklar
          Kullanici, acilan ekrandaki e-mail bolumune gecerli e-posta adresini girer.
          Kullanici, acilan ekrandaki sifre girisine gecerli sifreyi girer.
          Kullanici mavi SIGN IN  butonuna  tiklar.
          Kullanici sayfanın ust  kısmındaki arama kutusuna 'Macbook Laptop ' yazar.
          Kullanici, arama kutusunun sag tarafındaki arama simgesine tıklar.
          Kullanici urun sayfasında oldugunu dogrular.
          Kullanici ADD TO CART butonuna tiklar
          Kullanıcı, sayfada yesil renkli " 'Apple Macbook Air Laptop ' has been added to your cart " mesajinin  gorundugunu dogrular
          Kullanıcı, yesil metnin hemen sol tarafında gorunen VIEW CART butonuna  tiklar.
          Kullanici  Shopping Cart bolumunde COUPON DISCOUNT alanina indirim kodunu girer
          Kullanici APPLY COUPON butonuna tiklar
          Kullanici "Coupon code applied successfully." mesajini goruntuler
          Kullanici PROCEED TO CHECKOUT kutusuna tiklar
          Kullanici sag tarafta YOUR ORDER kisminda  Total basligini  gorur
          Kullanici Total basliginda fiyatin guncellendigini dogrular
          Kullanici Payment Methods yazisini dogrular
          Kullanici Payment Methods basligi altında Pay at the door secenegini secer
          Kullanici Pay the door butonunun  secildigini dogrular
          Kullanici PLACE ORDER butonuna tiklar
          Kulllanici Order Complete basligi  altinda "Thank you.Your order has been received" mesajini goruntuler
          Kullanici  sayfanın  en alt  bolumune gelir
          Kullanici  MY ACCOUNT basligi altinda My Account linkine  tiklar
          Kullanici Orders butonu tiklar
          Kullanici siparisini goruntuler
        */

    @Test
    public void test01() {
        // Kullanici  https://pearlymarket.com/  adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        // Kullanıcı Sign in butonuna tiklar

        // Kullanici, acilan ekrandaki e-mail bolumune gecerli e-posta adresini girer.
        // Kullanici, acilan ekrandaki sifre girisine gecerli sifreyi girer.
        // Kullanici mavi SIGN IN  butonuna  tiklar.
        // Kullanici sayfanın ust  kısmındaki arama kutusuna 'Macbook Laptop ' yazar.
        // Kullanici, arama kutusunun sag tarafındaki arama simgesine tıklar.
        // Kullanici urun sayfasında oldugunu dogrular.
        // Kullanici ADD TO CART butonuna tiklar
        // Kullanıcı, sayfada yesil renkli " 'Apple Macbook Air Laptop ' has been added to your cart " mesajinin  gorundugunu dogrular
        // Kullanıcı, yesil metnin hemen sol tarafında gorunen VIEW CART butonuna  tiklar.
        // Kullanici  Shopping Cart bolumunde COUPON DISCOUNT alanina indirim kodunu girer
        // Kullanici APPLY COUPON butonuna tiklar
        // Kullanici "Coupon code applied successfully." mesajini goruntuler
        // Kullanici PROCEED TO CHECKOUT kutusuna tiklar
        // Kullanici sag tarafta YOUR ORDER kisminda  Total basligini  gorur
        // Kullanici Total basliginda fiyatin guncellendigini dogrular
        // Kullanici Payment Methods yazisini dogrular
        // Kullanici Payment Methods basligi altında Pay at the door secenegini secer
        // Kullanici Pay the door butonunun  secildigini dogrular
        // Kullanici PLACE ORDER butonuna tiklar
        // Kulllanici Order Complete basligi  altinda "Thank you.Your order has been received" mesajini goruntuler
        // Kullanici  sayfanın  en alt  bolumune gelir
        // Kullanici  MY ACCOUNT basligi altinda My Account linkine  tiklar
        // Kullanici Orders butonu tiklar
        // Kullanici siparisini goruntuler
    }
}
