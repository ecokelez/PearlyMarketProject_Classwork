package pages.ersoy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MyAccountPageWE {

    public MyAccountPageWE(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//*[text()='Orders'][1]")
    public WebElement ordersButton;

    @FindBy (xpath = "//*[@class='woocommerce-orders-table__row woocommerce-orders-table__row--status-processing order'][1]")
    public WebElement ordersTable;

}
