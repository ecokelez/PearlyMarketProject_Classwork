package tests.ersoy.US22;


import org.testng.annotations.Test;
import pages.ersoy.AddToCartPageWE;
import pages.ersoy.CheckoutPageWE;
import tests.ersoy.ersoy_utilities.ErsoyReusableMethods;
import utilities.Driver;
import utilities.ExtentReportsUtils;


import static org.testng.Assert.assertTrue;
import static utilities.ReusableMethods.*;

public class US22_TC03 extends ErsoyReusableMethods{

    AddToCartPageWE addToCartPageWE = new AddToCartPageWE();
    CheckoutPageWE checkoutPageWE = new CheckoutPageWE();


    @Test
    public void test01() {
        ExtentReportsUtils.extentReportsSetUp("ersoy","US22_TC03_Test01");
       //Kullanici  https://pearlymarket.com/  adresine gider
        //Kullanıcı  Vendor olarak Sign in butonuna tiklar
        //Kullanici, acilan ekrandaki e-mail bolumune gecerli e-mail adresini girer.
        //Kullanici, acilan ekrandaki sifre girisine gecerli sifreyi girer.
        //Kullanici mavi SIGN IN  butonuna  tiklar.
        signInVendor();
        ExtentReportsUtils.extentTest().info("Giris yapildi");
        waitFor(3);
        //Kullanici sayfanın ust  kısmındaki arama kutusuna 'Macbook Laptop ' yazar.
        //Kullanici, arama kutusunun sag tarafındaki arama simgesine tıklar.
        homePageSearchBox("Macbook Laptop");
        ExtentReportsUtils.extentTest().info("Macbook Laptop aratildi");
        waitFor(3);
        //Kullanici urun sayfasında oldugunu dogrular.
        assertTrue(Driver.getDriver().getCurrentUrl().contains("https://pearlymarket.com/urun/apple-macbook-air-laptop/"));
        //Kullanici ADD TO CART butonuna tiklar
        addToCartPageWE.addToCartButton.click();
        //Kullanıcı, sayfada yesil renkli " 'Apple Macbook Air Laptop ' has been added to your cart " mesajinin  gorundugunu dogrular
        assertTrue(addToCartPageWE.addToCartMessage.isDisplayed());
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
        checkoutPage("xyz2023");
        ExtentReportsUtils.extentTest().info("Gecersiz kupon kodu girildi ve Apply Butonuna tiklandi");
        //Kullanici  kirmizi renkli "Coupon 'abc2023' does not exist!" mesajini dogrular
        assertTrue(checkoutPageWE.errorCouponMessage.isDisplayed());
        getScreenshot("ersoy","US22_TC03_Test01");
        ExtentReportsUtils.extentTest().pass("'Coupon xyz2023 does not exist! ' mesaji dogrulandi");
        ExtentReportsUtils.extentFlush();

    }
}
