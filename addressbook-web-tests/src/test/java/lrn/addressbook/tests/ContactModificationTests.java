package lrn.addressbook.tests;

import lrn.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase{

  @Test

  public void testContactModification() {

    if (!(app.getContactHelper().isThereAContact())) {
      app.getContactHelper().createContact(new ContactData("qwerty", "qwerty",
              "qwerty", "11111", "111111", "111111", "222222ddddd", "qwerty"), true);
    }
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("www", "www", "2222", "121ddd", "fff",
            "222", "qw", null),false);
    app.getContactHelper().updateContact();
    app.getNavigationHelper().goToHomePage();
  }


}

