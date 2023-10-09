package lrn.addressbook.tests;

import lrn.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Set;

public class ContactDeleteTests extends TestBase {

  @Test
  public void testContactDelete() {
    if (!(app.contact().isThereAContact())) {
      app.contact().create(new ContactData( "qwerty", "qwerty",
              "qwerty", "11111", "111111", "111111","222", "333", "222222ddddd", "qwerty"));
    }

    Set<ContactData> before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    Assert.assertEquals(before.size() - 1,app.contact().getContactCount());

    Set<ContactData> after = app.contact().all();
    before.remove(deletedContact);
    Assert.assertEquals(before,after);


  }
}
