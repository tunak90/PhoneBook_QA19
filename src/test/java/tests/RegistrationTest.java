package tests;

import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {


    @BeforeMethod
    public void precondition() {
        if (app.getUser().isLogged()) {
            app.getUser().logout();
        }
    }


    @Test
    public void registrationPositiveTest() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String email = "h0h" + i + "@gmail.com";
        String password = "dr56ghji$DR";
        User user = new User().withEmail(email).withPassword(password);

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(user);

        app.getUser().submitRegistration();

        app.getUser().pause(3000);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//a[@href='/add']")));
    }

    @Test
    public void registrationNegativeTestWrongEmail() {

        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String email = "h0h" + i + "gmail.com";
        String password = "dr56ghji$DR";
        User user = new User().withEmail(email).withPassword(password);
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(user);
        app.getUser().submitRegistration();
        app.getUser().pause(5000);
        Assert.assertTrue(app.getUser().isErrorMessageFormat());
        Assert.assertTrue(app.getUser().isAlertPresent());

    }

    @Test
    public void registrationNegativeTestWrongPassword() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String email = "h0h" + i + "@gmail.com";
        String password = "dr56ghjiDR";
        User user = new User().withEmail(email).withPassword(password);
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(user);
        app.getUser().submitRegistration();
        app.getUser().pause(5000);
        Assert.assertTrue(app.getUser().isErrorMessageFormat());
        Assert.assertTrue(app.getUser().isAlertPresent());
    }

    @AfterMethod
    public void tearDown() {

    }


}
