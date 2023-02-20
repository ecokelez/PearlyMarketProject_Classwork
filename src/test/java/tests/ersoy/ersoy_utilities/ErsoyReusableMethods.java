package tests.ersoy.ersoy_utilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import pages.ersoy.*;
import utilities.ConfigReader;
import utilities.Driver;


import static utilities.ReusableMethods.*;


public class ErsoyReusableMethods  {

     public SignInPageWE signInPageObj = new SignInPageWE();
     public HomePageWE homePageObj = new HomePageWE();
     public OrderCompletePageWE orderCompleteObj = new OrderCompletePageWE();
     public CartPage_ForwardCheckoutPageWE cartGoCheckoutObj = new CartPage_ForwardCheckoutPageWE();
     public CheckoutPageWE checkoutPageObj = new CheckoutPageWE();
     public MyAccountPageWE myAccountPageObj = new MyAccountPageWE();
     public ShoppingCartPageWE shoppingCartPageObj = new ShoppingCartPageWE();
     public AddToCartPageWE addToCartPageObj = new AddToCartPageWE();




    public  void signInVendor(){
        // Kullanici  https://pearlymarket.com/  adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        waitFor(3);
        // Kullanıcı  Vendor olarak Sign in butonuna tiklar
        signInPageObj.singInButton.click();
        waitFor(3);
        // Kullanici, acilan ekrandaki e-mail bolumune gecerli e-mail adresini girer.
        signInPageObj.emailBox.sendKeys(ConfigReader.getProperty("vendor_username"));
        // Kullanici, acilan ekrandaki sifre girisine gecerli sifreyi girer.
        signInPageObj.passwordBox.sendKeys(ConfigReader.getProperty("vendor_password"));
        // Kullanici mavi SIGN IN  butonuna  tiklar.
        signInPageObj.blueSingInButton.click();
    }


    public void signInCustom() {
        // Kullanici  https://pearlymarket.com/  adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        waitFor(3);
        // Kullanıcı Sign in butonuna tiklar
        signInPageObj.singInButton.click();
        waitFor(3);
        // Kullanici, acilan ekrandaki e-mail bolumune gecerli e-posta adresini girer.
        signInPageObj.emailBox.sendKeys(ConfigReader.getProperty("ersoy_username"));
        // Kullanici, acilan ekrandaki sifre girisine gecerli sifreyi girer.
        signInPageObj.passwordBox.sendKeys(ConfigReader.getProperty("ersoy_password"));
        // Kullanici mavi SIGN IN  butonuna  tiklar.
        signInPageObj.blueSingInButton.click();
    }

    public  void homePageSearchBox(String text){
        // Kullanici sayfanın ust  kısmındaki arama kutusuna 'Macbook Laptop ' yazar.
        homePageObj.searchBox.sendKeys(text);
        // Kullanici, arama kutusunun sag tarafındaki arama simgesine tıklar.
        homePageObj.searchIcon.click();
    }

    public void addToCart(){
        // Kullanici ADD TO CART butonuna tiklar
        addToCartPageObj.addToCartButton.click();
        // Kullanıcı, sayfada yesil renkli " 'Apple Macbook Air Laptop ' has been added to your cart " mesajinin  gorundugunu dogrular
        Assert.assertTrue(addToCartPageObj.addToCartMessage.isDisplayed());
    }


    public    void cartGoCheckout(){
        // Kullanıcı, sag ust arafında gorunen Cart butonuna  tiklar.
        cartGoCheckoutObj.cartButton.click();
        // Kullanici SHHOPPING  CART basligi altında acilan kucuk pencerede mavi renkli CHECKOUT butonuna tiklar
        cartGoCheckoutObj.checkoutButton.click();
    }

    public  void cartGoShoppingCart(){
        // Kullanıcı, sag ust arafında gorunen Cart butonuna  tiklar.
        cartGoCheckoutObj.cartButton.click();
        //Kullanici SHHOPPING  CART basligi altında acilan kucuk pencerede  VIEW CART butonuna tiklar
        cartGoCheckoutObj.viewCartButton.click();

    }

    public  void shoppingCart(String text){
        // Kullanici  Shopping Cart bolumunde COUPON DISCOUNT alanina indirim kodunu girer
       scrollByJS(300);
        shoppingCartPageObj.enterCouponCodeButton.sendKeys(text);
        // Kullanici APPLY COUPON butonuna tiklar
        clickByJS(shoppingCartPageObj.applyCouponButton);

    }

    public  void checkoutPage(String text){
        // Kullanici  sol tarafta bulunan ENTER YOUR CODE  linkine tilklar
        checkoutPageObj.enterCodeButton.click();
        // Kullanici Coupon code isimli kutuya tiklar
        // Kullanici  kupon kodunu girer
        checkoutPageObj.couponCodeBox.sendKeys(text);
        // Kullanici APPLY COUPON butonuna tiklar
        checkoutPageObj.applyCouponButton.click();
    }

    public void payAtTheDoor(){
        // Kullanici Payment Methods yazisini dogrular
        Assert.assertTrue(checkoutPageObj.paymentMethods.isDisplayed());
        waitFor(3);
        // Kullanici Payment Methods basligi altında Pay at the door secenegini secer
        clickByJS(checkoutPageObj.payAtTheDoor);
        // Kullanici Pay the door butonunun  secildigini dogrular
        Assert.assertTrue(checkoutPageObj.payAtTheDoor.isSelected());
        // Kullanici PLACE ORDER butonuna tiklar
        clickByJS(checkoutPageObj.placeOrderButton);
    }

    public void wireTransfer(){
        //Kullanici Payment Methods yazisini dogrular
        Assert.assertTrue(checkoutPageObj.paymentMethods.isDisplayed());
        //Kullanici Payment Methods'dan Wire transfer/EFT butonun secer
        clickByJS(checkoutPageObj.wireTransfer);
        //Kullanici PLACE ORDER butonuna tiklar
        clickByJS(checkoutPageObj.placeOrderButton);
    }

    public  void orderCompleteGoMyAccount(){
        // Kulllanici Order Complete basligi  altinda "Thank you.Your order has been received" mesajini goruntuler
       orderCompleteObj.orderMessage.isDisplayed();
        // Kullanici  sayfanın  en alt  bolumune gelir
      scrollByJS(1500);
        // Kullanici  MY ACCOUNT basligi altinda My Account linkine  tiklar
        orderCompleteObj.myAccountLink.click();
    }

    public  void myAccountandOrderView(){
        // Kullanici Orders butonu tiklar
        clickByJS(myAccountPageObj.ordersButton);
        // Kullanici siparisini goruntuler
        myAccountPageObj.ordersTable.isDisplayed();
    }

    @AfterClass
    public void afterClass() {
        // ExtentReportsUtils.extentFlush();
       Driver.closeDriver();
    }
}
