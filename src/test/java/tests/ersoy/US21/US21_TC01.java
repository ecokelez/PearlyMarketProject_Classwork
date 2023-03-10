package tests.ersoy.US21;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ersoy.ErsoyPMP;
import utilities.ConfigReader;
import utilities.Driver;

import static utilities.ReusableMethods.waitFor;

public class US21_TC01 {

    public static ErsoyPMP ersoyPMP = new ErsoyPMP();
    public static Actions actions = new Actions(Driver.getDriver());
    public static JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

    @Test
    public void test01() {

        // Kullanici  https://pearlymarket.com/  adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        // Kullanıcı Sign in butonuna tiklar
        ersoyPMP.singInButton.click();
        // Kullanici, acilan ekrandaki e-mail bolumune gecerli e-posta adresini girer.
        ersoyPMP.emailBox.sendKeys(ConfigReader.getProperty("ersoy_usermail"));
        // Kullanici, acilan ekrandaki sifre girisine gecerli sifreyi girer.
        // Kullanici mavi SIGN IN  butonuna  tiklar.
        actions.click(ersoyPMP.passwordBox).sendKeys(ConfigReader.getProperty("ersoy_password")).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        // Kullanici sayfanın ust  kısmındaki arama kutusuna 'Macbook Laptop ' yazar.
         waitFor(5);
        ersoyPMP.searchBox.sendKeys("Macbook Laptop");
        // Kullanici, arama kutusunun sag tarafındaki arama simgesine tıklar.
        ersoyPMP.searchIcon.click();
        // Kullanici urun sayfasında oldugunu dogrular.
        Assert.assertTrue(ersoyPMP.productInfoButton.isDisplayed());
        // Kullanici ADD TO CART butonuna tiklar
        ersoyPMP.addToCartButton.click();
        // Kullanıcı, sayfada yesil renkli " 'Apple Macbook Air Laptop ' has been added to your cart " mesajinin  gorundugunu dogrular
        Assert.assertTrue(ersoyPMP.addToCartMessage.isDisplayed());
        // Kullanıcı, yesil metnin hemen sol tarafında gorunen VIEW CART butonuna  tiklar.
        ersoyPMP.greenViewCartButton.click();
        // Kullanici  Shopping Cart bolumunde COUPON DISCOUNT alanina indirim kodunu girer
        ersoyPMP.couponTextBox.sendKeys("ersoy_kupon");
        // Kullanici APPLY COUPON butonuna tiklar
        waitFor(3);
        jse.executeScript("arguments[0].click()",ersoyPMP.applyCouponButton);
        // Kullanici "Coupon code applied successfully." mesajini goruntuler
        ersoyPMP.couponMessage.isDisplayed();
        // Kullanici PROCEED TO CHECKOUT kutusuna tiklar
        waitFor(3);
        jse.executeScript("arguments[0].scrollIntoView(true)",ersoyPMP.proceedCheckButton);
        jse.executeScript("arguments[0].click();",ersoyPMP.proceedCheckButton);
        // Kullanici sag tarafta YOUR ORDER kisminda  Total basligini  gorur
        waitFor(3);
        jse.executeScript("arguments[0].scrollIntoView(true)",ersoyPMP.totalHeader);
        ersoyPMP.totalHeader.isDisplayed();
        // Kullanici Total basliginda fiyatin guncellendigini dogrular
        waitFor(3);
        actions.scrollToElement(ersoyPMP.totalAmount);
        Assert.assertTrue(ersoyPMP.totalAmount.isDisplayed());
        // Kullanici Payment Methods yazisini dogrular
        Assert.assertTrue(ersoyPMP.paymentMethods.isDisplayed());
        // Kullanici Payment Methods basligi altında Pay at the door secenegini secer
        waitFor(3);
        ersoyPMP.payAtTheDoor.click();
        // Kullanici Pay the door butonunun  secildigini dogrular
        Assert.assertTrue(ersoyPMP.payAtTheDoor.isSelected());
        // Kullanici PLACE ORDER butonuna tiklar
        ersoyPMP.placeOrderButton.click();
        // Kulllanici Order Complete basligi  altinda "Thank you.Your order has been received" mesajini goruntuler
        waitFor(3);
        ersoyPMP.orderMessage.isDisplayed();
        // Kullanici  sayfanın  en alt  bolumune gelir
        jse.executeScript("arguments[0].scrollIntoView(true)",ersoyPMP.myAccountLink);
        // Kullanici  MY ACCOUNT basligi altinda My Account linkine  tiklar
        waitFor(3);
        ersoyPMP.myAccountLink.click();
        // Kullanici Orders butonu tiklar
        ersoyPMP.ordersButton.click();
        // Kullanici siparisini goruntuler
        ersoyPMP.ordersTable.isDisplayed();
    }
}
