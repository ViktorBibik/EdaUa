package eda;

import bayramix.com.FaceBookLogin;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.concurrent.TimeUnit;

/**
 * Created by Victor on 08.11.2016.
 */
public class CheckCookies {
    public static void main(String... args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();

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
