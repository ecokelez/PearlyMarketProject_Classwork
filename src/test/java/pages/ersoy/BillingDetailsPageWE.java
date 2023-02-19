package pages.ersoy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BillingDetailsPageWE {

    public BillingDetailsPageWE(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "//*[@id='billing_first_name']")
    public WebElement firstnameTextBox;

    @FindBy (xpath = "//*[@id='select2-billing_country-container']")
    public  WebElement countryName;

    @FindBy (xpath = "//*[@id='billing_address_1']")
    public WebElement streetAdressTextBox;

    @FindBy (xpath = "//*[@id='select2-billing_state-container']")
    public WebElement stateName;

    @FindBy (xpath = "//*[@id='billing_postcode']")
    public WebElement zipCodeTextBox;

    /*
    public static void billingDetails(){
        ReusableMethods.clickByJS(billingDetailsPageObj.firstnameTextBox);
        actions.click(billingDetailsPageObj.firstnameTextBox).sendKeys( faker.name().firstName()).sendKeys(Keys.TAB).
                sendKeys(faker.name().lastName()).sendKeys(Keys.TAB).
                sendKeys(faker.company().name()).perform();
        ReusableMethods.selectFromDropdown(billingDetailsPageObj.countryName,"Turkey");
        actions.click(billingDetailsPageObj.streetAdressTextBox).sendKeys(faker.address().streetName()).perform();
        getSelectedOptionFromDropdown(billingDetailsPageObj.stateName);
        actions.click(billingDetailsPageObj.zipCodeTextBox).sendKeys(faker.address().zipCode()).sendKeys(Keys.TAB).
                sendKeys(faker.phoneNumber().cellPhone()).perform();

    }

 */

}
