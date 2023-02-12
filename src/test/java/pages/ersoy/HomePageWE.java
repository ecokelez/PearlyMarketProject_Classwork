package pages.ersoy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HomePageWE {

    public HomePageWE(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@class='form-control'][1]")
    public  WebElement searchBox;

    @FindBy (xpath = "//*[@class='btn btn-search'][1]")
    public WebElement searchIcon;

}
