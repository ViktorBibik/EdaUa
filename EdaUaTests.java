package eda;

import org.openqa.selenium.Cookie;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Time;
import java.util.concurrent.TimeUnit;


/**
 * Created by Victor on 08.11.2016.
 */
public class EdaUaTests {

    public WebDriver driver;

    @BeforeClass
    public void setUp() {

        System.setProperty("webdriver.gecko.driver","D:\\Selenium\\geckodriver.exe");
        //System.setProperty("webdriver.gecko.driver","D:\\Selenium\\geckodriver-v0.10.0-win64\\geckodriver.exe");

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test //add valid user in "Sign In" form
    public void addValidUser() throws InterruptedException {

        driver.get("https://eda.ua/");

        BasePageElements basePageElements = new BasePageElements(driver);
        LoginRegistrtionForm loginRegistrtionForm = new LoginRegistrtionForm(driver);
        AddDeliveryAdress addDeliveryAdress = new AddDeliveryAdress(driver);

        basePageElements.buttonLogin.click();

        Thread.sleep(2000);// I have to change it!!!
        loginRegistrtionForm.fieldEmail.sendKeys("viktorbibik@ukr.net");
        loginRegistrtionForm.fieldPassword.sendKeys("deadmananor_1");
        loginRegistrtionForm.buttonLogin.click();
        loginRegistrtionForm.buttonClose.click();


        Thread.sleep(2000);// I have to change it!!!
        driver.get("https://eda.ua/");
        addDeliveryAdress.adressSign.click();
        Thread.sleep(4000);// I have to change it!!!
        addDeliveryAdress.fieldAdress.sendKeys("sacdvjdhnjlkh3242376ygdvkh2364t23ghfgdhf");
        addDeliveryAdress.buttonConfirm.click();

        File file= new File("browser.data");

        try{
            file.delete();
            file.createNewFile();
            FileWriter filewriter = new FileWriter(file);
            BufferedWriter bufwriter = new BufferedWriter(filewriter);

            for(Cookie ck : driver.manage().getCookies()){
                bufwriter.write(( ck.getName() + ";"
                        +ck.getValue() + ";"
                        +ck.getDomain() + ";"
                        +ck.getPath() + ";"
                        +ck.getExpiry() + ";"
                        +ck.getName() + ";"
                        +ck.isSecure()));
                System.out.println(ck);
                bufwriter.newLine();
            }
            bufwriter.flush();
            bufwriter.close();
            filewriter.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
