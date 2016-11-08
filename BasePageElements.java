package eda;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Victor on 08.11.2016.
 */
public class BasePageElements {

    public BasePageElements(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    //header elements

    @FindBy(xpath = "//a[@class='user-panel-auth__link'][@title='Вход']")
    public WebElement buttonLogin;

    @FindBy(xpath = "//a[@class='user-panel-auth__link'][@title='Регистрация']")
    public  WebElement ButtonRegistration;

    @FindBy(xpath ="//div[@class='phones']//a[@class='phones__current']")
    public  WebElement PhoneLinkCity;

    @FindBy(xpath ="//div[@class='phones__dropdown']/a[@class='phones__item phones__item_life']")
    public  WebElement PhoneLinkLIFE;

    @FindBy(xpath ="//div[@class='phones__dropdown']/a[@class='phones__item phones__item_mts']")
    public  WebElement PhoneLinkMTS;

    @FindBy(xpath ="//div[@class='phones__dropdown']/a[@class='phones__item phones__item_kyivstar']")
    public  WebElement PhoneLinkKIEVSTAR;

    // body elements - categories categories_simple version-1

    @FindBy(xpath = "//li[@class='categories__toggle-item active first-child']//span[@data-target='#categories-item-1']")
    public WebElement ButtonRestourants;

    @FindBy(xpath = "//li[@class='categories__toggle-item']//span[@data-target='#categories-item-2']")
    public WebElement ButtonShops;

    @FindBy(xpath = "//li[@class='categories__toggle-item last-child']//span[@data-target='#categories-item-3']")
    public WebElement ButtonOfficeDinner;
}
