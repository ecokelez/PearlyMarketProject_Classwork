package tests.ersoy.US22_22;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import static tests.ersoy.US21.US21_TC01.actions;
import static tests.ersoy.US21.US21_TC01.ersoyPMP;

public class US22_TC03 {

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
        //=>actions.click(ersoyPMP.searchBox).sendKeys("Macbook Laptop").sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        // Kullanici, arama kutusunun sag tarafındaki arama simgesine tıklar.
        ersoyPMP.searchIcon.click();
        // Kullanici urun sayfasında oldugunu dogrular.
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("https://pearlymarket.com/urun/apple-macbook-air-laptop/"));
        //Assert.assertTrue(ersoyPMP.productInfoButton.isDisplayed());
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
        // Kullanici  yanlis kupon kodunu girer
        ersoyPMP.couponCodeBox.sendKeys("xyz2023");
        //Kullanici APPLY COUPON butonuna tiklar
        ersoyPMP.applyCouponButton.click();
        //Kullanici  sayfada kirmizi renkli "Coupon 'abc2023' does not exist!" mesajini dogrular
        Assert.assertTrue(ersoyPMP.errorCouponMessage.isDisplayed());
    }
}
