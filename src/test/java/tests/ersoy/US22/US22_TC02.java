package tests.ersoy.US22;

import org.testng.annotations.Test;
import pages.ersoy.AddToCartPageWE;
import pages.ersoy.CheckoutPageWE;
import pages.ersoy.ShoppingCartPageWE;
import tests.ersoy.ersoy_utilities.ErsoyReusableMethods;
import utilities.Driver;
import utilities.ExtentReportsUtils;
import static org.testng.Assert.assertTrue;
import static utilities.ReusableMethods.*;

public class US22_TC02 extends ErsoyReusableMethods{
    CheckoutPageWE checkoutPageWE = new CheckoutPageWE();
    ShoppingCartPageWE shoppingCartPageWE = new ShoppingCartPageWE();
    @Test
    public void test01() {
        ExtentReportsUtils.extentReportsSetUp("ersoy","US22_TC02_Test01");
        //Kullanici  https://pearlymarket.com/  adresine gider
        //Kullanıcı  Vendor olarak Sign in butonuna tiklar
        //Kullanici, acilan ekrandaki e-mail bolumune gecerli e-posta adresini girer.
        //Kullanici, acilan ekrandaki sifre girisine gecerli sifreyi girer.
        //Kullanici mavi SIGN IN  butonuna  tiklar.
        signInVendor();
        ExtentReportsUtils.extentTest().info("Vendor olarak giris yapildi");
        waitFor(3);
        //Kullanici sayfanın ust  kısmındaki arama kutusuna 'Macbook Laptop ' yazar.
        //Kullanici, arama kutusunun sag tarafındaki arama simgesine tıklar.
        homePageSearchBox("Macbook Laptop");
        ExtentReportsUtils.extentTest().info("Macbook Laptop aratildi");
        //Kullanici urun sayfasında oldugunu dogrular.
        assertTrue(Driver.getDriver().getCurrentUrl().contains("https://pearlymarket.com/urun/apple-macbook-air-laptop/"));
        ExtentReportsUtils.extentTest().pass("Urun sayfasinda olundugu dogrulandi.");
        //Kullanici ADD TO CART butonuna tiklar
        //Kullanıcı, sayfada yesil renkli " 'Apple Macbook Air Laptop ' has been added to your cart " mesajinin  gorundugunu dogrular
        addToCart();
        ExtentReportsUtils.extentTest().pass("Sayfada 'Apple Macbook Air Laptop  has been added to your cart' mesaji dogrulandi");
        waitFor(3);
        //Kullanıcı, sag ust arafında gorunen Cart butonuna  tiklar.
        //Kullanici SHHOPPING  CART basligi altında acilan kucuk pencerede  VIEW CART butonuna tiklar
        cartGoShoppingCart();
        ExtentReportsUtils.extentTest().info("SHHOPPING CART basligi altında  VIEW CART butonuna tiklandi ");
        waitFor(3);
        //Kullanici  Shopping Cart bolumunde COUPON DISCOUNT alanina indirim kodunu girer
        //Kullanici APPLY COUPON butonuna tiklar
        shoppingCart("ersoy_kupon05");
        ExtentReportsUtils.extentTest().info("Gecerli kupon kodu girildi ve Apply Butonuna tiklandi");
        //Kullanici "Coupon code applied successfully." mesajini gorunuler
        shoppingCartPageWE.couponMessage.isDisplayed();
        //Kullanici PROCEED TO CHECKOUT kutusuna tiklar
        clickByJS(shoppingCartPageWE.proceedCheckButton);
        //Kullanici sag tarafta YOUR ORDER kisminda  Total basligini  gorur
        checkoutPageWE.totalHeader.isDisplayed();
        //Kullanici Total basliginda fiyatin guncellendigini dogrular
        assertTrue(checkoutPageWE.totalAmount.isDisplayed());
        ExtentReportsUtils.extentTest().pass("Fiyatin guncellendigi dogrulandi");
        scrollByJS(400);
        getScreenshot("ersoy","US22_TC02_Test01");
        //Kullanici Payment Methods basligi altında Pay at the door secenegini secer
        //Kullanici Pay the door butonunun  secildigini dogrular
        //Kullanici PLACE ORDER butonuna tiklar
        payAtTheDoor();
        ExtentReportsUtils.extentTest().info("Pay at the door odeme yontemi secildigi dogrulandi");
        waitFor(3);
        //Kulllanici Order Complete basligi  altinda "Thank you.Your order has been received" mesajini goruntuler
        //Kullanici  sayfanın  en alt  bolumune gelir
        //Kullanici  MY ACCOUNT basligi altinda My Account linkine  tiklar
        orderCompleteGoMyAccount();
        //Kullanici Orders butonu tiklar
        //Kullanici siparisini goruntuler
        myAccountandOrderView();
        ExtentReportsUtils.extentTest().info("Kullanici siparisi goruntulendi");
        ExtentReportsUtils.extentFlush();


    }
}

