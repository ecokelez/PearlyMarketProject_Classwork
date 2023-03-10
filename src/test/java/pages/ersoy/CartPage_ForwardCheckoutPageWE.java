package pages.ersoy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CartPage_ForwardCheckoutPageWE {

    public CartPage_ForwardCheckoutPageWE(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@class='w-icon-cart'][1]")
    public WebElement cartButton;

    @FindBy (xpath = "//*[text()='Checkout'][1]")
    public WebElement checkoutButton;
}
