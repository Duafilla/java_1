package lrn.addressbook.tests;

import lrn.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class ContactDeleteTests extends TestBase {

  @Test(enabled = false)
  public void testContactDelete() {
    if (!(app.getContactHelper().isThereAContact())) {
      app.getContactHelper().createContact(new ContactData( "qwerty", "qwerty",
              "qwerty", "11111", "111111", "111111", "222222ddddd", "qwerty"), true);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteContact();
    app.getContactHelper().submitDeleteContact();
    app.getContactHelper().pause(5000);
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(before.size() - 1,after.size());

    before.remove(0);
    Assert.assertEquals(before,after);


  }
}
