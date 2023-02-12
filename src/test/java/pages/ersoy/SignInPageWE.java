package pages.ersoy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SignInPageWE {

    public SignInPageWE(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@class='login inline-type']")
    public WebElement singInButton;

    @FindBy (xpath = "//*[@id='username']")
    public WebElement emailBox;

    @FindBy (xpath = "//*[@id='password']")
    public WebElement passwordBox;

    @FindBy (xpath = "//*[@name='login'][1]")
    public WebElement blueSingInButton;


}
