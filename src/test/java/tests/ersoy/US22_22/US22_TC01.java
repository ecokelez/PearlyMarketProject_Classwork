package tests.ersoy.US22_22;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import static tests.ersoy.US21.US21_TC01.*;

public class US22_TC01 {
    @Test
    public void test01() {
        // Kullanici  https://pearlymarket.com/  adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        // Kullanıcı Vendor olarak Sign in butonuna tiklar
        ersoyPMP.singInButton.click();
        // Kullanici, acilan ekrandaki e-mail bolumune gecerli e-posta adresini girer.
        ersoyPMP.emailBox.sendKeys(ConfigReader.getProperty("vendor_username"));
        // Kullanici, acilan ekrandaki sifre girisine gecerli sifreyi girer.
        // Kullanici mavi SIGN IN  butonuna  tiklar.
        actions.click(ersoyPMP.passwordBox).sendKeys(ConfigReader.getProperty("vendor_password")).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        // Kullanici sayfanın ust  kısmındaki arama kutusuna 'Macbook Laptop ' yazar.
        ReusableMethods.waitFor(5);
        ersoyPMP.searchBox.sendKeys("Macbook Laptop");
        // Kullanici, arama kutusunun sag tarafındaki arama simgesine tıklar.
        ersoyPMP.searchIcon.click();
        // Kullanici urun sayfasında oldugunu dogrular.
        Assert.assertTrue(ersoyPMP.productInfoButton.isDisplayed());
        // Kullanici ADD TO CART butonuna tiklar
        ersoyPMP.addToCartButton.click();
        // Kullanıcı, sayfada yesil renkli " 'Apple Macbook Air Laptop ' has been added to your cart " mesajinin  gorundugunu dogrular
        Assert.assertTrue(ersoyPMP.addToCartMessage.isDisplayed());
        // Kullanıcı, sag ust arafında gorunen Cart butonuna  tiklar.
        ersoyPMP.cartButton.click();
        // Kullanici SHHOPPING  CART basligi altında acilan kucuk pencerede mavi renkli CHECKOUT butonuna tiklar
        ersoyPMP.checkoutButton.click();
        // Kullanici  sol tarafta bulunan ENTER YOUR CODE  linkine tilklar
        ReusableMethods.waitFor(3);
        ersoyPMP.enterCodeButton.click();
        // Kullanici Coupon code isimli kutuya tiklar
        // Kullanici  kupon kodunu girer
        ersoyPMP.couponCodeBox.sendKeys("ersoy_kupon02");
        // Kullanici APPLY COUPON butonuna tiklar
        ersoyPMP.applyCouponButton.click();
        // Kullanici yesil renkli "Coupon code applied successfully." mesajini goruntuler
        ersoyPMP.couponMessage.isDisplayed();
        ReusableMethods.waitFor(3);
        // Kullanici sag tarafta YOUR ORDER bolumunde Subtotal basligi altinda   kupon indirim miktarını gorur
        ersoyPMP.couponDiscount.isDisplayed();
        // Kullanici Total basliginda fiyatin  guncellendigini dogrular
        ReusableMethods.waitFor(3);
        Assert.assertTrue(ersoyPMP.totalAmount.isDisplayed());
        // Kullanici Payment Methods basligi altında Pay at the door secenegini secer
        ReusableMethods.waitFor(3);
        jse.executeScript("arguments[0].scrollIntoView(true)",ersoyPMP.payAtTheDoor);
        jse.executeScript("arguments[0].click();",ersoyPMP.payAtTheDoor);
        // Kullanici Pay the door butonunun  secildigini dogrular
        Assert.assertTrue(ersoyPMP.payAtTheDoor.isSelected());
        // Kullanici PLACE ORDER butonuna tiklar
        jse.executeScript("arguments[0].scrollIntoView(true)",ersoyPMP.placeOrderButton);
        jse.executeScript("arguments[0].click();",ersoyPMP.placeOrderButton);
        // Kulllanici Order Complete basligi  altinda "Thank you.Your order has been received" mesajini goruntuler
        ersoyPMP.orderMessage.isDisplayed();
        // Kullanici  sayfanın  en alt  bolumune gelir
        ReusableMethods.waitFor(3);
        jse.executeScript("arguments[0].scrollIntoView(true)",ersoyPMP.myAccountLink);
        // Kullanici  MY ACCOUNT basligi altinda My Account linkine  tiklar
        ReusableMethods.waitFor(3);
        ersoyPMP.myAccountLink.click();
        // Kullanici Orders butonu tiklar
        ersoyPMP.ordersButton.click();
        // Kullanici siparisini goruntuler
        ersoyPMP.ordersTable.isDisplayed();
    }
}
