package lrn.addressbook.tests;

import lrn.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ContactPhoneTests extends TestBase {
    @Test
    public void testContactPhones() {
        if (!(app.contact().isThereAContact())) {
            app.contact().create(new ContactData( "qwerty", "qwerty",
                    "qwerty", "11111", "111111", "111111","222", "333", "222222ddddd", "qwerty"));
        }

        app.goTo().goToHomePage();
        ContactData contactData = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().InfoFromEditForm(contactData);

        Assert.assertEquals(contactData.getHomePhoneNumber(), cleaned(contactInfoFromEditForm.getHomePhoneNumber()));
        Assert.assertEquals(contactData.getMobilePhoneNumber(),cleaned(contactInfoFromEditForm.getMobilePhoneNumber()));
        Assert.assertEquals(contactData.getWorkPhoneNumber(),cleaned(contactInfoFromEditForm.getWorkPhoneNumber()));
    }

    public String cleaned(String phone) {
        return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
    }
}
