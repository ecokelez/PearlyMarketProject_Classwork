package tests.ersoy.US22;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ersoy.AddToCartPageWE;
import pages.ersoy.CheckoutPageWE;
import tests.ersoy.ersoy_utilities.ErsoyReusableMethods;
import utilities.Driver;
import utilities.ReusableMethods;




public class US22_TC01 {


    AddToCartPageWE addToCartPageWE = new AddToCartPageWE();
    CheckoutPageWE checkoutPageWE = new CheckoutPageWE();
    @Test
    public void test01() {

        ErsoyReusableMethods.signIn();
        //         Kullanici sayfanın ust  kısmındaki arama kutusuna 'Macbook Laptop ' yazar.
        ReusableMethods.waitFor(5);
        ErsoyReusableMethods.homePageSearchBox("Macbook Laptop");
        //         Kullanici urun sayfasında oldugunu dogrular.
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("https://pearlymarket.com/urun/apple-macbook-air-laptop/"));
        //         Kullanici ADD TO CART butonuna tiklar
        addToCartPageWE.addToCartButton.click();
        //         Kullanıcı, sayfada yesil renkli " 'Apple Macbook Air Laptop ' has been added to your cart " mesajinin  gorundugunu dogrular
        Assert.assertTrue(addToCartPageWE.addToCartMessage.isDisplayed());
        //        Kullanıcı, sag ust arafında gorunen Cart butonuna  tiklar.
        //        Kullanici SHHOPPING  CART basligi altında acilan kucuk pencerede mavi renkli CHECKOUT butonuna tiklar
        ErsoyReusableMethods.cartGoCheckout();
        ReusableMethods.waitFor(3);
        //        Kullanici  sol tarafta bulunan ENTER YOUR CODE  linkine tilklar
        //        Kullanici Coupon code isimli kutuya tiklar
        //        Kullanici  kupon kodunu girer
        //        Kullanici APPLY COUPON butonuna tiklar
        ErsoyReusableMethods.checkoutPage("ersoy_kupon01");
        //        Kullanici yesil renkli "Coupon code applied successfully." mesajini goruntuler
        Assert.assertTrue(checkoutPageWE.couponMessage.isDisplayed());
        ReusableMethods.waitFor(3);
        //        Kullanici sag tarafta YOUR ORDER bolumunde Subtotal basligi altinda   kupon indirim miktarını gorur
        checkoutPageWE.couponDiscount.isDisplayed();
        //        Kullanici Total basliginda fiyatin  guncellendigini dogrular
        Assert.assertTrue(checkoutPageWE.totalAmount.isDisplayed());
        ReusableMethods.waitFor(3);
        //        Kullanici Payment Methods basligi altında Pay at the door secenegini secer
        //        Kullanici Pay the door butonunun  secildigini dogrular
        //        Kullanici PLACE ORDER butonuna tiklar
        ErsoyReusableMethods.payAtTheDoor();
        ReusableMethods.waitFor(3);
        //        Kulllanici Order Complete basligi  altinda "Thank you.Your order has been received" mesajini goruntuler
        //        Kullanici  sayfanın  en alt  bolumune gelir
        //        Kullanici  MY ACCOUNT basligi altinda My Account linkine  tiklar
        ErsoyReusableMethods.orderCompleteGoMyAccount();
        //        Kullanici Orders butonu tiklar
        //        Kullanici siparisini goruntuler
        ErsoyReusableMethods.myAccountandOrderView();


    }
}
