import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class loginTest extends TestBase {
//    WebDriver wd;
//
   @BeforeMethod
   public void precondition(){
       if(isLogged()){
           logout();
       }
   }

//    public void init() {
//
//        wd = new ChromeDriver();
//        wd.navigate().to("https://telranedu.web.app/home");
//
//        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//    }


    @Test
    public void loginPositiveTest() {

        //open login form
        wd.findElement(By.xpath("//*[text()='LOGIN']")).click();
        //fill in the form

        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("h0hjjkv@ejio.com");

        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
        passInput.click();
        passInput.clear();
        passInput.sendKeys("dr56ghji$DR");
        //click on login button
        wd.findElement(By.xpath("//button[1]")).click();
        //assert
        pause(3000);
        Assert.assertTrue(isElementPresent(By.xpath("//*[text()='Sign Out']")));
        //Assert.assertTrue(wd.findElements(By.xpath("//*[text()='Sign Out']")).size() > 0);
    }

    @Test
    public void loginNegativeTest() {
        String email = "h0hjjkvejio.com", password = "dr56ghji$DR";
        //open login form
        openLoginRegistrationForm();
//        wd.findElement(By.xpath("//*[text()='LOGIN']")).click();
//        click(By.xpath("//*[text()='LOGIN']"));

        //fill in the form
        fillLoginRegistrationForm(email, password);
//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("h0hjjkvejio.com");

//        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
//        passInput.click();
//        passInput.clear();
//        passInput.sendKeys("dr56ghji$DR");
        //click on login button
//         wd.findElement(By.xpath("//button[1]")).click();
        submitLogin();
        //assert

    }

    @AfterMethod

    public void tearDown() {

    }

}
