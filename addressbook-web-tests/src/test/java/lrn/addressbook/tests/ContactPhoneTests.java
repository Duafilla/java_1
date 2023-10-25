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

        Assert.assertEquals(cleanedString(contactData), mergePhones(contactInfoFromEditForm));
    }

    private String mergePhones(ContactData contact) {
        return contact.getHomePhoneNumber() + contact.getMobilePhoneNumber() + contact.getWorkPhoneNumber();
    }

    public String cleanedString(ContactData contactData) {
        String phone = contactData.getHomePhoneNumber() + contactData.getMobilePhoneNumber()
                + contactData.getWorkPhoneNumber();
        return phone.replaceAll("\\s", "").replaceAll("[-()]", "").replaceAll("null","");
    }
}
