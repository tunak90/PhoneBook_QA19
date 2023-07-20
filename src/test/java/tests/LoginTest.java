package tests;

import manager.NgListener;
import models.UserLombok;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(NgListener.class)
public class LoginTest extends TestBase {

    @BeforeMethod(alwaysRun = true)
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


    @Test(groups = {"smokeGroup","sanityGroup","regressionGroup"})
    public void loginPositiveTest() {
        //1

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

        //2
//        String email = "h0hjjkv@ejio.com";
//        String password = "dr56ghji$DR";
//
//        User user = new User().withEmail(email).withPassword(password);
//        app.getUser().openLoginRegistrationForm();
//        app.getUser().fillLoginRegistrationForm(user);
//
//        app.getUser().submitLogin();
//
//        app.getUser().pause(3000);
//        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//*[text()='Sign Out']")));
        //3
        UserLombok user = UserLombok.builder()
                .email("h0hjjkv@ejio.com")
                .password("dr56ghji$DR")
                .build();

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(user);
        app.getUser().submitLogin();
        app.getUser().pause(3000);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//*[text()='Sign Out']")));


        app.getUser().logout();
    }
    @Test(groups = {"smokeGroup","sanityGroup","regressionGroup"})
    public void loginPositiveTestUserProp() {

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(app.getEmail(),app.getPassword());
        app.getUser().submitLogin();
        Assert.assertTrue(app.getUser().isLogged());


        app.getUser().logout();
    }


    @Test
    public void loginNegativeTest() {

//        String email = "h0hjjkvejio.com", password = "dr56ghji$DR";
//        User user = new User().withEmail(email).withPassword(password);
        UserLombok user = UserLombok.builder()
                .email("h0hjjkvejio.com")
                .password("dr56ghji$DR")
                .build();

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(user);
        app.getUser().submitLogin();
        app.getUser().pause(3000);
        Assert.assertTrue(app.getUser().isErrorMessageFormatForLogin());
        Assert.assertTrue(app.getUser().isAlertPresent());
    }

    @AfterMethod(alwaysRun = true)

    public void tearDown() {

    }

}
