package pages.ersoy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class OrderCompletePageWE {

    public OrderCompletePageWE(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "//*[@id='menu-item-1079']")
    public WebElement myAccountLink;
    @FindBy(xpath = "//*[@class='woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received order-success']")
    public WebElement orderMessage;



}
