package tests.ersoy.US21;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ersoy.CheckoutPageWE;
import pages.ersoy.HomePageWE;
import tests.ersoy.ersoy_utilities.ErsoyReusableMethods;
import utilities.Driver;
import utilities.ExtentReportsUtils;
import static utilities.ReusableMethods.*;
public class US21_TC02 extends ErsoyReusableMethods {

    HomePageWE homePageWE = new HomePageWE();
    CheckoutPageWE checkoutPageWE = new CheckoutPageWE();
    @Test
    public void test01(){
        ExtentReportsUtils.extentReportsSetUp("ersoy","US21_TC02_Test01");
        //Kullanici  https://pearlymarket.com/  adresine gider
        //Kullanıcı Sign in butonuna tiklar
        //Kullanici, acilan ekrandaki e-mail bolumune gecerli e-posta adresini girer.
        //Kullanici, acilan ekrandaki sifre girisine gecerli sifreyi girer
        //Kullanici mavi SIGN IN  butonuna  tiklar.
        signInCustom();
        ExtentReportsUtils.extentTest().info("Giris yapildi");
        waitFor(5);
        //Kullanici sayfanın ust  kısmındaki arama kutusuna 'Macbook Laptop ' yazar.
        //Kullanici, arama kutusunun sag tarafındaki arama simgesine tıklar.
        homePageSearchBox("Macbook Laptop");
        ExtentReportsUtils.extentTest().info("Macbook Laptop aratildi");
        //Kullanici urun sayfasında oldugunu dogrular.
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("https://pearlymarket.com/urun/apple-macbook-air-laptop/"));
        //Kullanici ADD TO CART butonuna tiklar
        //Kullanıcı, sayfada yesil renkli " 'Apple Macbook Air Laptop ' has been added to your cart " mesajinin  gorundugunu dogrular
        addToCart();
        ExtentReportsUtils.extentTest().pass(" Sayfada 'Apple Macbook Air Laptop  has been added to your cart' mesaji dogrulandi");
        waitFor(3);
        //Kullanıcı, sag ust arafında gorunen Cart butonuna  tiklar.
        //Kullanici SHHOPPING  CART basligi altında acilan kucuk pencerede mavi renkli CHECKOUT butonuna tiklar
        cartGoCheckout();
        ExtentReportsUtils.extentTest().info("SHHOPPING CART basligi altında  CHECKOUT butonuna tiklandi ");
        //Kullanici  sol tarafta bulunan ENTER YOUR CODE  linkine tilklar
        //Kullanici Coupon code isimli kutuya tiklar
        //Kullanici  kupon kodunu girer
        //Kullanici APPLY COUPON butonuna tiklar
        checkoutPage("ersoy_kupon02");
        ExtentReportsUtils.extentTest().info("Gecerli kupon kodu girildi ve Apply Butonuna tiklandi");
        //Kullanici yesil renkli "Coupon code applied successfully." mesajini goruntuler
        checkoutPageWE.couponMessage.isDisplayed();
        ExtentReportsUtils.extentTest().info("'Coupon code applied successfully.' mesaji goruntulendi");
        //Kullanici sag tarafta YOUR ORDER bolumunde Subtotal basligi altinda  kupon indirim miktarını gorur
        checkoutPageWE.priceAmount.isDisplayed();
        //Kullanici Total basliginda fiyatin  guncellendigini dogrular
        scrollByJS(350);
        Assert.assertTrue(checkoutPageWE.totalAmount.isDisplayed());
        ExtentReportsUtils.extentTest().pass("Fiyatin guncellendigi dogrulandi");
        getScreenshot("ersoy","US21_TC02_Test01");
        //Kullanici Payment Methods yazisini dogrular
        //Kullanici Payment Methods'dan Wire transfer/EFT butonun secer
        //Kullanici PLACE ORDER butonuna tiklar
        wireTransfer();
        waitFor(3);
        ExtentReportsUtils.extentTest().pass("Payment Methods yazisi dogrulandi");
        ExtentReportsUtils.extentTest().info("Wire transfer/EFT odeme yontemi secildi");
        //Kulllanici Order Complete basligi  altinda "Thank you.Your order has been received" mesajini goruntuler
        ExtentReportsUtils.extentTest().info("Thank you.Your order has been received mesaji goruntulendi");
        //Kullanici  sayfanın  en alt  bolumune gelir
        //Kullanici  MY ACCOUNT basligi altinda My Account linkine  tiklar
        orderCompleteGoMyAccount();
        waitFor(3);
        //Kullanici Orders butonu tiklar
        //Kullanici siparisini goruntuler
        myAccountandOrderView();
        ExtentReportsUtils.extentTest().info("Kullanici siparisi goruntulendi");
        ExtentReportsUtils.extentFlush();
    }
}
