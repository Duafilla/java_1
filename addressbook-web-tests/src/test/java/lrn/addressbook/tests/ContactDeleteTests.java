package lrn.addressbook.tests;

import lrn.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactDeleteTests extends TestBase {

  @Test
  public void testContactDelete() {
    if (!(app.getContactHelper().isThereAContact())) {
      app.getContactHelper().createContact(new ContactData("qwerty", "qwerty",
              "qwerty", "11111", "111111", "111111", "222222ddddd", "qwerty"), true);
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteContact();
    app.getContactHelper().submitDeleteContact();


  }
}
