package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @BeforeMethod
    public void precondition() {
        if (app.getUser().isLogged()) {
            app.getUser().logout();
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

//        //open login form
//        wd.findElement(By.xpath("//*[text()='LOGIN']")).click();
//        //fill in the form
//
//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("h0hjjkv@ejio.com");
//
//        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
//        passInput.click();
//        passInput.clear();
//        passInput.sendKeys("dr56ghji$DR");
//        //click on login button
//        wd.findElement(By.xpath("//button[1]")).click();
//        //assert
//        pause(3000);
//        Assert.assertTrue(isElementPresent(By.xpath("//*[text()='Sign Out']")));
//        //Assert.assertTrue(wd.findElements(By.xpath("//*[text()='Sign Out']")).size() > 0);
        String email = "h0hjjkv@ejio.com";
        String password = "dr56ghji$DR";


        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(email, password);

        app.getUser().submitLogin();

        app.getUser().pause(3000);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//*[text()='Sign Out']")));
  }

    @Test
    public void loginNegativeTest() {
        String email = "h0hjjkvejio.com", password = "dr56ghji$DR";
        //open login form
        app.getUser().openLoginRegistrationForm();
//        wd.findElement(By.xpath("//*[text()='LOGIN']")).click();
//        click(By.xpath("//*[text()='LOGIN']"));

        //fill in the form
        app.getUser().fillLoginRegistrationForm(email, password);
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
        app.getUser().submitLogin();
        //assert

    }

    @AfterMethod

    public void tearDown() {

    }

}
