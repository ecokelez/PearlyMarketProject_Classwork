package pages.ersoy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ShoppingCartPageWE {

    public ShoppingCartPageWE(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@id='coupon_code']")
    public WebElement enterCouponCodeButton;

    @FindBy (xpath = "//*[@name='apply_coupon']")
    public WebElement applyCouponButton;

    @FindBy (xpath = "//*[@role='alert']")
    public WebElement couponMessage;

    @FindBy (xpath = "//*[@class='checkout-button button alt wc-forward']")
    public WebElement proceedCheckButton;





}
