package tests.ersoy.US21;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ersoy.*;
import tests.ersoy.ersoy_utilities.ErsoyReusableMethods;
import utilities.Driver;
import utilities.ExtentReportsUtils;

import static utilities.ReusableMethods.*;
public class US21_TC01 extends ErsoyReusableMethods {


  CartPage_ForwardCheckoutPageWE cartPage_forwardCheckoutPageWE = new CartPage_ForwardCheckoutPageWE();
  CheckoutPageWE checkoutPageWE = new CheckoutPageWE();
  ShoppingCartPageWE shoppingCartPageWE = new ShoppingCartPageWE();


    @Test
    public void test01() {
        // Kullanici  https://pearlymarket.com/  adresine gider
        // Kullanıcı Sign in butonuna tiklar
        // Kullanici, acilan ekrandaki e-mail bolumune gecerli e-posta adresini girer.
        // Kullanici, acilan ekrandaki sifre girisine gecerli sifreyi girer.
        // Kullanici mavi SIGN IN  butonuna  tiklar.
        signInCustom();
        ExtentReportsUtils.extentTest().info("Giris yapildi");
        waitFor(5);
        // Kullanici sayfanın ust  kısmındaki arama kutusuna 'Macbook Laptop ' yazar.
        //Kullanici, arama kutusunun sag tarafındaki arama simgesine tıklar.
        homePageSearchBox("Macbook Laptop");
        ExtentReportsUtils.extentTest().info("Macbook Laptop aratildi");
        // Kullanici urun sayfasında oldugunu dogrular.
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("https://pearlymarket.com/urun/apple-macbook-air-laptop/"));
        ExtentReportsUtils.extentTest().pass("Urun sayfasinda olundugu dogrulandi.");
        // Kullanici ADD TO CART butonuna tiklar
        // Kullanıcı, sayfada yesil renkli " 'Apple Macbook Air Laptop ' has been added to your cart " mesajinin  gorundugunu dogrular
        addToCart();
        ExtentReportsUtils.extentTest().pass(" Sayfada 'Apple Macbook Air Laptop  has been added to your cart' mesaji dogrulandi");
        // Kullanıcı, yesil metnin hemen sol tarafında gorunen VIEW CART butonuna  tiklar.
        cartPage_forwardCheckoutPageWE.greenViewCartButton.click();
        // Kullanici  Shopping Cart bolumunde COUPON DISCOUNT alanina indirim kodunu girer
        // Kullanici APPLY COUPON butonuna tiklar
        shoppingCart("ersoy_kupon");
        ExtentReportsUtils.extentTest().info("Gecerli kupon kodu girildi ve Apply Butonuna tiklandi");
        // Kullanici "Coupon code applied successfully." mesajini goruntuler
        checkoutPageWE.couponMessage.isDisplayed();
        ExtentReportsUtils.extentTest().info("'Coupon code applied successfully.' mesaji dogrulandi");
        // Kullanici PROCEED TO CHECKOUT kutusuna tiklar
        clickByJS(shoppingCartPageWE.proceedCheckButton);
        // Kullanici sag tarafta YOUR ORDER kisminda  Total basligini  gorur
        waitFor(5);
        checkoutPageWE.totalHeader.isDisplayed();
        waitFor(5);
        // Kullanici Total basliginda fiyatin guncellendigini dogrular
        scrollByJS(450);
        Assert.assertTrue(checkoutPageWE.totalAmount.isDisplayed());
        ExtentReportsUtils.extentTest().pass("Fiyatin guncellendigi dogrulandi");
        getScreenshot("ersoy","US21_TC01_Test01");
        waitFor(3);
        // Kullanici Payment Methods yazisini dogrular
        // Kullanici Payment Methods basligi altında Pay at the door secenegini secer
        // Kullanici Pay the door butonunun  secildigini dogrular
        // Kullanici PLACE ORDER butonuna tiklar
       payAtTheDoor();
        ExtentReportsUtils.extentTest().pass("Payment Methods yazisi dogrulandi");
        ExtentReportsUtils.extentTest().info("'Pay at the door' odeme yonteminin secildigi dogrulandi");
        // Kulllanici Order Complete basligi  altinda "Thank you.Your order has been received" mesajini goruntuler
        // Kullanici  sayfanın  en alt  bolumune gelir
        // Kullanici  MY ACCOUNT basligi altinda My Account linkine  tiklar
        orderCompleteGoMyAccount();
        ExtentReportsUtils.extentTest().info("Thank you.Your order has been received mesaji goruntulendi");
        waitFor(3);
        // Kullanici Orders butonu tiklar
        // Kullanici siparisini goruntuler
        myAccountandOrderView();
        ExtentReportsUtils.extentTest().info("Kullanici siparisi goruntulendi");
        ExtentReportsUtils.extentFlush();


    }
}
