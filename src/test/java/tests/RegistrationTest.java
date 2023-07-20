package tests;


import manager.ProviderDataReg;
import models.User;
import models.UserLombok;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {


    @BeforeMethod(alwaysRun = true)
    public void precondition() {
        if (app.getUser().isLogged()) {
            app.getUser().logout();
        }
    }


    @Test(groups = {"sanityGroup","regressionGroup"})
    public void registrationPositiveTest() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;

//        String email = "h0h" + i + "@gmail.com";
//        String password = "dr56ghji$DR";
//        User user = new User().withEmail(email).withPassword(password);

        UserLombok user = UserLombok.builder()
                .email("h0h" + i + "@gmail.com")
                .password("dr56ghji$DR")
                .build();

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(user);

        app.getUser().submitRegistration();

        app.getUser().pause(3000);
        logger.info("Registration test starts with data : " + user.getEmail()
                + " & " + user.getPassword());
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//a[@href='/add']")));

        app.getUser().logout();
    }
    @Test(dataProvider = "dataCSV", dataProviderClass = ProviderDataReg.class)
    public void registrationPositiveTestCSV(User user) {
        app.getUser().openLoginRegistrationForm();

        app.getUser().fillLoginRegistrationForm(user);

        app.getUser().submitRegistration();

        app.getUser().pause(3000);
        logger.info("Registration test starts with data : " + user.getEmail()
                + " & " + user.getPassword());
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//a[@href='/add']")));

        app.getUser().logout();
    }

    @Test
    public void registrationNegativeTestWrongEmail() {

        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
//        User user = new User().withEmail(email).withPassword(password);
        UserLombok user = UserLombok.builder()
                .email("h0h" + i + "gmail.com")
                .password("dr56ghji$DR")
                .build();
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
//        User user = new User().withEmail(email).withPassword(password);
        UserLombok user = UserLombok.builder()
                .email("h0h" + i + "@gmail.com")
                .password("dr56ghjiDR")
                .build();
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(user);
        app.getUser().submitRegistration();
        app.getUser().pause(5000);
        Assert.assertTrue(app.getUser().isErrorMessageFormat());
        Assert.assertTrue(app.getUser().isAlertPresent());
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

    }


}
