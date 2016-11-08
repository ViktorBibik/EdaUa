package eda;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Victor on 08.11.2016.
 */
public class AddDeliveryAdress {
    public AddDeliveryAdress(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    //AddDeliveryAdress

    @FindBy(xpath = "//a[@class='location__get-location2']")
    public WebElement adressSign;

    @FindBy(xpath = "//span[@class='twitter-typeahead']//input[@id='address']")
    public WebElement fieldAdress;

    @FindBy(xpath = "//div[@class='tab-pane active']//button[@class='btn btn-lg btn-block btn-primary']")
    public WebElement buttonConfirm;

}
