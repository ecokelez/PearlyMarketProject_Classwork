package tests.ersoy.ersoy_utilities;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pages.ersoy.*;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExcelUtils;
import  utilities.ReusableMethods;

import static utilities.ReusableMethods.*;


public class ErsoyReusableMethods  {

    static SignInPageWE signInPageObj = new SignInPageWE();
    static HomePageWE homePageObj = new HomePageWE();
    static OrderCompletePageWE orderCompleteObj = new OrderCompletePageWE();
    static CartPage_ForwardCheckoutPageWE cartGoCheckoutObj = new CartPage_ForwardCheckoutPageWE();
    static CheckoutPageWE checkoutPageObj = new CheckoutPageWE();
    static MyAccountPageWE myAccountPageObj = new MyAccountPageWE();

    static BillingDetailsPageWE billingDetailsPageObj = new BillingDetailsPageWE();

     static Faker faker = new Faker();

    static Actions actions = new Actions(Driver.getDriver());



    ExcelUtils excelUtilsObj = new ExcelUtils("src/test/java/tests/ersoy/ersoy_resources/ersoy_excel.xlsx","Sheet1");

    public static void signIn(){
        //        Kullanici  https://pearlymarket.com/  adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        //        Kullanıcı  Vendor olarak Sign in butonuna tiklar
        signInPageObj.singInButton.click();
        //        Kullanici, acilan ekrandaki e-mail bolumune gecerli e-mail adresini girer.
        signInPageObj.emailBox.sendKeys(ConfigReader.getProperty("vendor_username"));
        //        Kullanici, acilan ekrandaki sifre girisine gecerli sifreyi girer.
        signInPageObj.passwordBox.sendKeys(ConfigReader.getProperty("vendor_password"));
        //        Kullanici mavi SIGN IN  butonuna  tiklar.
        signInPageObj.blueSingInButton.click();
    }


    public static void homePageSearchBox(String text){
        // Kullanici sayfanın ust  kısmındaki arama kutusuna 'Macbook Laptop ' yazar.
        homePageObj.searchBox.sendKeys(text);
        // Kullanici, arama kutusunun sag tarafındaki arama simgesine tıklar.
        homePageObj.searchIcon.click();

    }

    public static   void cartGoCheckout(){
        // Kullanıcı, sag ust arafında gorunen Cart butonuna  tiklar.
        cartGoCheckoutObj.cartButton.click();
        // Kullanici SHHOPPING  CART basligi altında acilan kucuk pencerede mavi renkli CHECKOUT butonuna tiklar
        cartGoCheckoutObj.checkoutButton.click();
    }

    public static void checkoutPage(String text){
        checkoutPageObj.enterCodeButton.click();
        checkoutPageObj.couponCodeBox.sendKeys(text);
        checkoutPageObj.applyCouponButton.click();
    }

   /* public void enterCode(){
        excelUtilsObj.getCellData(95,5);
    }

    */

    /*
    public static void billingDetails(){
        ReusableMethods.clickByJS(billingDetailsPageObj.firstnameTextBox);
        actions.click(billingDetailsPageObj.firstnameTextBox).sendKeys( faker.name().firstName()).sendKeys(Keys.TAB).
                sendKeys(faker.name().lastName()).sendKeys(Keys.TAB).
                sendKeys(faker.company().name()).perform();
        getSelectedOptionFromDropdown(billingDetailsPageObj.countryName).click();
        actions.click(billingDetailsPageObj.streetAdressTextBox).sendKeys(faker.address().streetName()).perform();
        getSelectedOptionFromDropdown(billingDetailsPageObj.stateName).click();
        actions.click(billingDetailsPageObj.zipCodeTextBox).sendKeys(faker.address().zipCode()).sendKeys(Keys.TAB).
                sendKeys(faker.phoneNumber().cellPhone()).perform();

    }

     */


    public static void payAtTheDoor(){
        //        Kullanici Payment Methods basligi altında Pay at the door secenegini secer
        ReusableMethods.clickByJS(checkoutPageObj.payAtTheDoor);
        //        Kullanici Pay the door butonunun  secildigini dogrular
        Assert.assertTrue(checkoutPageObj.payAtTheDoor.isSelected());
        //        Kullanici PLACE ORDER butonuna tiklar
        ReusableMethods.clickByJS(checkoutPageObj.placeOrderButton);

    }

    public static void orderCompleteGoMyAccount(){
        // Kulllanici Order Complete basligi  altinda "Thank you.Your order has been received" mesajini goruntuler
       orderCompleteObj.orderMessage.isDisplayed();
        // Kullanici  sayfanın  en alt  bolumune gelir
      scrollByJS(1500);
        // Kullanici  MY ACCOUNT basligi altinda My Account linkine  tiklar
        orderCompleteObj.myAccountLink.click();

    }

    public static void myAccountandOrderView(){
        ReusableMethods.clickByJS(myAccountPageObj.ordersButton);
        myAccountPageObj.ordersTable.isDisplayed();
    }



}
