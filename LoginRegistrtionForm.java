package eda;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Victor on 08.11.2016.
 */
public class LoginRegistrtionForm {

    public LoginRegistrtionForm(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    //Login user

    @FindBy(xpath = "//form[@class='form-horizontal log-form active']//input[@id='user_models_User_email']")
    public WebElement fieldEmail;

    @FindBy(xpath = "//form[@class='form-horizontal log-form active']//input[@id='user_models_User_password']")
    public WebElement fieldPassword;

    @FindBy(xpath = "//form[@class='form-horizontal log-form active']//input[@class='btn btn-primary btn-lg']")
    public WebElement buttonLogin;

    @FindBy(xpath = "//div[@id='login']//button[@class='close']")
    public WebElement buttonClose;
}
