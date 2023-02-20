package tests.ersoy.US21;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ersoy.CheckoutPageWE;
import tests.ersoy.ersoy_utilities.ErsoyReusableMethods;
import utilities.Driver;
import utilities.ExtentReportsUtils;
import static utilities.ReusableMethods.getScreenshot;
import static utilities.ReusableMethods.waitFor;
public class US21_TC03 extends ErsoyReusableMethods {
    CheckoutPageWE checkoutPageWE = new CheckoutPageWE();
    @Test
    public void test01() {
        ExtentReportsUtils.extentReportsSetUp("ersoy","US21_TC03_Test01");
        //Kullanici  https://pearlymarket.com/  adresine gider
        //Kullanıcı Sign in butonuna tiklar
        //Kullanici, acilan ekrandaki e-mail bolumune gecerli e-posta adresini girer.
        //Kullanici, acilan ekrandaki sifre girisine gecerli sifreyi girer.
        //Kullanici mavi SIGN IN  butonuna  tiklar.
        signInCustom();
        ExtentReportsUtils.extentTest().info("Giris yapildi");
        waitFor(5);
        //Kullanici sayfanın ust  kısmındaki arama kutusuna 'Macbook Laptop ' yazar.
        //Kullanici, arama kutusunun sag tarafındaki arama simgesine tıklar.
        homePageSearchBox("Macbook Laptop");
        ExtentReportsUtils.extentTest().info("Macbook Laptop aratildi");
        waitFor(3);
        //Kullanici urun sayfasında oldugunu dogrular.
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("https://pearlymarket.com/urun/apple-macbook-air-laptop/"));
        ExtentReportsUtils.extentTest().pass("Urun sayfasinda olundugu dogrulandi");
        //Kullanici ADD TO CART butonuna tiklar
        //Kullanıcı, sayfada yesil renkli " 'Apple Macbook Air Laptop ' has been added to your cart " mesajinin  gorundugunu dogrular
        addToCart();
        ExtentReportsUtils.extentTest().pass(" Sayfada 'Apple Macbook Air Laptop  has been added to your cart' mesaji dogrulandi");
        waitFor(3);
        //Kullanıcı, sag ust arafında gorunen Cart butonuna  tiklar.
        //Kullanici SHHOPPING  CART basligi altında acilan kucuk pencerede mavi renkli CHECKOUT butonuna tiklar
        cartGoCheckout();
        ExtentReportsUtils.extentTest().info("SHHOPPING CART basligi altında  CHECKOUT butonuna tiklandi ");
        waitFor(3);
        //Kullanici  sol tarafta bulunan ENTER YOUR CODE  linkine tilklar
        //Kullanici Coupon code isimli kutuya tiklar
        //Kullanici  yanlis kupon kodunu girer
        //Kullanici APPLY COUPON butonuna tiklar
        checkoutPage("abc2023");
        ExtentReportsUtils.extentTest().info("Gecersiz kupon kodu girildi ve Apply Butonuna tiklandi");
        //Kullanici  sayfada kirmizi renkli "Coupon 'abc2023' does not exist!" mesajini dogrular
        Assert.assertTrue(checkoutPageWE.errorCouponMessage.isDisplayed());
        ExtentReportsUtils.extentTest().pass("'Coupon abc2023 does not exist! ' mesaji dogrulandi");
        getScreenshot("ersoy","US21_TC03_Test01");
        ExtentReportsUtils.extentFlush();
    }
}
