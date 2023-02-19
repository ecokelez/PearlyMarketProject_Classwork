package tests.ersoy.US22;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ersoy.AddToCartPageWE;
import pages.ersoy.CheckoutPageWE;
import tests.ersoy.ersoy_utilities.ErsoyReusableMethods;
import utilities.Driver;
import utilities.ReusableMethods;

import static utilities.ReusableMethods.*;


public class US22_TC01 extends ErsoyReusableMethods{


    AddToCartPageWE addToCartPageWE = new AddToCartPageWE();
    CheckoutPageWE checkoutPageWE = new CheckoutPageWE();


    @Test
    public void test01 () {

        signInVendor();
        // Kullanici sayfanın ust kısmındaki arama kutusuna 'Macbook Laptop ' yazar.
        waitFor(5);
        homePageSearchBox("Macbook Laptop");
        // Kullanici urun sayfasında oldugunu dogrular.
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("https://pearlymarket.com/urun/apple-macbook-air-laptop/"));
        // Kullanici ADD TO CART butonuna tiklar
        ReusableMethods.clickByJS(addToCartPageWE.addToCartButton);
        // Kullanıcı, sayfada yesil renkli " 'Apple Macbook Air Laptop ' has been added to your cart " mesajinin  gorundugunu dogrular
        Assert.assertTrue(addToCartPageWE.addToCartMessage.isDisplayed());
        // Kullanıcı, sag ust arafında gorunen Cart butonuna  tiklar.
        // Kullanici SHHOPPING  CART basligi altında acilan kucuk pencerede mavi renkli CHECKOUT butonuna tiklar
        cartGoCheckout();
        waitFor(3);
        // Kullanici  sol tarafta bulunan ENTER YOUR CODE  linkine tilklar
        // Kullanici Coupon code isimli kutuya tiklar
        // Kullanici  kupon kodunu girer
        // Kullanici APPLY COUPON butonuna tiklar
        checkoutPage("ersoy_kupon01");
        // Kullanici yesil renkli "Coupon code applied successfully." mesajini goruntuler
        Assert.assertTrue(checkoutPageWE.couponMessage.isDisplayed());
        waitFor(3);
        // Kullanici sag tarafta YOUR ORDER bolumunde Subtotal basligi altinda   kupon indirim miktarını gorur
        checkoutPageWE.couponDiscount.isDisplayed();
        waitFor(3);
        // Kullanici Total basliginda fiyatin  guncellendigini dogrular
        Assert.assertTrue(checkoutPageWE.totalAmount.isDisplayed());
        waitFor(3);
        // Kullanici Payment Methods basligi altında Pay at the door secenegini secer
        // Kullanici Pay the door butonunun  secildigini dogrular
        // Kullanici PLACE ORDER butonuna tiklar
        payAtTheDoor();
        waitFor(3);
        // Kulllanici Order Complete basligi  altinda "Thank you.Your order has been received" mesajini goruntuler
        // Kullanici  sayfanın  en alt  bolumune gelir
        // Kullanici  MY ACCOUNT basligi altinda My Account linkine  tiklar
        orderCompleteGoMyAccount();
        // Kullanici Orders butonu tiklar
        // Kullanici siparisini goruntuler
        myAccountandOrderView();



    }
}
