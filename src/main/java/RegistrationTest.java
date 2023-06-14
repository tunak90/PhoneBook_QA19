import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RegistrationTest extends TestBase {


    WebDriver wd;

    @BeforeMethod
    public void precondition(){
        if(isLogged()){
            logout();
        }
    }


    @Test
    public void registrationPositiveTest() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String email = "h0h" + i + "@gmail.com";
        String password = "dr56ghji$DR";

      
        openLoginRegistrationForm();
        fillLoginRegistrationForm(email, password);

        click(By.xpath("//button[2]"));

        pause(3000);
        Assert.assertTrue(isElementPresent(By.xpath("//a[@href='/add']")));
    }
    @Test
    public void registrationNegativeTestWrongEmail() {

        String email = "h0h@gmail.com";
        String password = "dr56ghji$DR";

        openLoginRegistrationForm();
        fillLoginRegistrationForm(email, password);
        submitLogin();

    }
    @Test
    public void registrationNegativeTestWrongPassword() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String email = "h0h" + i + "@gmail.com";
        String password = "dr56ghjiDR";

        openLoginRegistrationForm();
        fillLoginRegistrationForm(email, password);
        submitLogin();
}

    @AfterMethod

    public void tearDown()  {

    }

}
