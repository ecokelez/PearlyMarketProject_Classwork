package pages.ersoy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public  class ErsoyPMP {

    public ErsoyPMP(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "//*[@class='login inline-type']")
    public WebElement singInButton;

    @FindBy (xpath = "//*[@id='username']")
    public WebElement emailBox;

    @FindBy (xpath = "//*[@id='password']")
    public WebElement passwordBox;

    @FindBy (xpath = "//*[@class='form-control'][1]")
    public WebElement searchBox;

    @FindBy (xpath = "//*[@class='btn btn-search'][1]")
    public WebElement searchIcon;

    @FindBy (xpath = "//*[@class='product_meta no-brand-image']")
    public WebElement productInfoButton;

    @FindBy (xpath = "//*[@name='add-to-cart']")
    public WebElement addToCartButton;

    @FindBy (xpath = "//*[@class='woocommerce-notices-wrapper']")
    public WebElement addToCartMessage;

    @FindBy (xpath = "//*[@class='btn btn-success btn-md'][1]")
    public WebElement greenViewCartButton;

    @FindBy (xpath = "//*[@id='coupon_code']")
    public WebElement couponTextBox;

    @FindBy (xpath = "//*[@name='apply_coupon']")
    public WebElement applyCouponButton;

    @FindBy (xpath = "//*[@role='alert']")
    public WebElement couponMessage;

    @FindBy (xpath = "//*[@class='checkout-button button alt wc-forward']")
    public WebElement proceedCheckButton;

    @FindBy (xpath = "//*[text()='Total']")
    public WebElement totalHeader;

    @FindBy (xpath = "//*[@class='woocommerce-Price-amount amount'][1]")
    public WebElement priceAmount;   //*[text()='1,370.00']

    @FindBy (xpath = "//*[text()='Payment Methods']")
    public WebElement paymentMethods;

    @FindBy (xpath = "//*[@id='payment_method_cod']")
    public WebElement payAtTheDoor;

    @FindBy (xpath = "//*[@id='place_order']")
    public WebElement placeOrderButton;

    @FindBy (xpath = "//*[@class='woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received order-success']")
    public WebElement orderMessage;

    @FindBy (xpath = "//*[@id='menu-item-1079']")
    public WebElement myAccountLink;

    @FindBy (xpath = "//*[text()='Orders'][1]")
    public WebElement ordersButton;

    @FindBy (xpath = "//*[@class='woocommerce-orders-table__row woocommerce-orders-table__row--status-processing order'][1]")
    public WebElement ordersTable;

    @FindBy (xpath = "//*[@class='w-icon-cart'][1]")
    public WebElement cartButton;

    @FindBy (xpath = "//*[text()='Checkout'][1]")
    public WebElement checkoutButton;

    @FindBy (xpath = "//*[@class='showcoupon']")
    public WebElement enterCodeButton;

    @FindBy (xpath = "//*[@id='coupon_code']")
    public WebElement couponCodeBox;

    @FindBy (xpath = "//*[@class='cart-discount coupon-ersoy_kupon02']")
    public WebElement couponDiscount;

    @FindBy (xpath = "//*[@class='input-radio'][1]")
    public WebElement wireTransfer;

    @FindBy (xpath = "//*[@class='woocommerce-error']")
    public WebElement errorCouponMessage;

    @FindBy (xpath = "//*[@class='button wc-forward']")
    public WebElement blueViewCartButton;

    @FindBy (xpath = "//*[@class='order-total']")
    public WebElement totalAmount;

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
