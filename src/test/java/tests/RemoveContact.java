package tests;

import models.UserLombok;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContact extends TestBase {

        @BeforeMethod(alwaysRun = true)
    public void precondition(){

        UserLombok user = UserLombok.builder()
                .email("h0hjjkv@ejio.com")
                .password("dr56ghji$DR")
                .build();

        if(!app.getUser().isLogged()){
            app.getUser().login(user);
        }
    }
//    @BeforeMethod(alwaysRun = true)
//    public void precondition() {
//
//        User user = User.builder()
//                .email("h0hjjkv@ejio.com")
//                .password("dr56ghji$DR")
//                .build();
//        if (app.getUser().isLogged()) {
//            app.getUser().logout();
//            app.getUser().login(user);
//        }
//    }

    @Test(priority = 1, groups = {"sanityGroup"})
    public void removeOneContact() {
        int res = app.getContact().removeOneContact();
        Assert.assertEquals(res, -1);
        System.out.println("Deleted");
    }

    @Test(priority = 2, groups = {"sanityGroup"})
    public void removeAllContacts() {
        app.getContact().removeAllContacts();
        Assert.assertTrue(!app.getContact().isElementPresent(By.xpath("//div[@class='contact-item_card__2SOIM']")));
    }

}