package pages.ersoy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CheckoutPageWE {

    public CheckoutPageWE(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@class='showcoupon']")
    public WebElement enterCodeButton;

    @FindBy(xpath = "//*[@id='coupon_code']")
    public WebElement couponCodeBox;

    @FindBy (xpath = "//*[@name='apply_coupon']")
    public WebElement applyCouponButton;

    @FindBy (xpath = "//*[@role='alert']")
    public WebElement couponMessage;

    @FindBy (xpath = "//*[@class='cart-discount coupon-ersoy_kupon01']")
    public WebElement couponDiscount;


    @FindBy (xpath = "//*[text()='Total']")
    public WebElement totalHeader;

    @FindBy (xpath = "//*[@class='woocommerce-Price-amount amount'][1]")
    public WebElement priceAmount;

    @FindBy (xpath = "//*[text()='Payment Methods']")
    public WebElement paymentMethods;

    @FindBy (xpath = "//*[@id='payment_method_cod']")
    public WebElement payAtTheDoor;

    @FindBy (xpath = "//*[@class='input-radio'][1]")
    public WebElement wireTransfer;

    @FindBy (xpath = "//*[@class='order-total']")
    public WebElement totalAmount;

    @FindBy (xpath = "//*[@id='place_order']")
    public WebElement placeOrderButton;

    /*
    Billing Adress
     @FindBy (xpath = "//*[@id='billing_first_name']")
    public WebElement firstnameTextBox;

    @FindBy (xpath = "//*[@id='select2-billing_country-container']")
    public  WebElement countryNameTextBox;

    @FindBy (xpath = "//*[@id='select2-billing_country-container']")
    public WebElement countryNameTextBox02;

    @FindBy (xpath = "//*[@id='billing_address_1']")
    public WebElement streetAdressTextBox;
     */



}
