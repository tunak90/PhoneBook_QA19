package maanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {


    WebDriver wd;
    HelperUser user;


    public void init() {

        wd = new ChromeDriver();
        wd.navigate().to("https://telranedu.web.app/home");

        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        user = new HelperUser(wd);
    }


    public void tearDown() {
        wd.quit();
    }

    public HelperUser getUser() {
        return user;
    }
}
