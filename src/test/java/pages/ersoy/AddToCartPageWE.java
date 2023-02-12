package pages.ersoy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AddToCartPageWE {

    public AddToCartPageWE(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@class='product_meta no-brand-image']")
    public WebElement productInfoButton;

    @FindBy (xpath = "//*[@name='add-to-cart']") //*[@name='add-to-cart']
    public WebElement addToCartButton;

    @FindBy (xpath = "//*[@class='woocommerce-notices-wrapper']")
    public WebElement addToCartMessage;

    @FindBy (xpath = "//*[@class='btn btn-success btn-md'][1]")
    public WebElement greenViewCartButton;

}
