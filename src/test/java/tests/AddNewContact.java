package tests;

import models.Contact;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContact extends TestBase {
    @BeforeMethod(alwaysRun = true)
    public void precondition() {
        if (!app.getUser().isLogged()) {
            app.getUser().openLoginRegistrationForm();
            app.getUser().fillLoginRegistrationForm("h0hjjkv@ejio.com", "dr56ghji$DR");
            app.getUser().submitLogin();
        }
    }

    @Test(invocationCount = 5,groups = {"sanityGroup"})
    public void addNewContactPositive() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        Contact contact = Contact.builder()
                .name("Joe")
                .lastName("Doe")
                .phone("1234567" + i)
                .email("joe" + i + "@example.com")
                .address("Haifa")
                .description("Best friend")
                .build();

        app.getContact().openContactForm();
        app.getContact().fillContactForm(contact);
        app.getContact().submitContactForm();

        Assert.assertTrue(
                app.getUser().getText(
                        By.xpath("//div[@class='contact-item_card__2SOIM']" +
                                "[last()]//h3")).equals(contact.getPhone())
        );
        app.getUser().logout();
    }
}



