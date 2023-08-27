package lrn.addressbook.tests;

import lrn.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase{

  @Test

  public void testContactModification() {

    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("www", "www", "2222", "121ddd", "fff",
            "222", "qw", null));
    app.getContactHelper().updateContact();
    app.getNavigationHelper().returnHomepage();
  }
}

