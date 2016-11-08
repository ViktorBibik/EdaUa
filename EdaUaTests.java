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
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test //add valid user in Sign In form
    public void addValidUser() throws InterruptedException {

        driver.get("https://eda.ua/");

        BasePageElements basePageElements = new BasePageElements(driver);
        LoginRegistrtionForm loginRegistrtionForm = new LoginRegistrtionForm(driver);

        basePageElements.buttonLogin.click();

        Thread.sleep(2000);
        loginRegistrtionForm.fieldEmail.sendKeys("viktorbibik@ukr.net");
        loginRegistrtionForm.fieldPassword.sendKeys("deadmananor_1");
        loginRegistrtionForm.buttonLogin.click();
        loginRegistrtionForm.buttonClose.click();

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
