package lrn.addressbook.tests;

import lrn.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase{

  @Test(enabled = false)

  public void testContactModification() {

    if (!(app.getContactHelper().isThereAContact())) {
      app.getContactHelper().createContact(new ContactData( "qwerty", "qwerty",
              "qwerty", "11111", "111111", "111111", "222222ddddd", "qwerty"), true);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().initContactModification();
    ContactData contactData = new ContactData(before.get(0).getId(), "www", "www", "2222", "121ddd", "fff", "222", "qw", null);
    app.getContactHelper().fillContactForm(contactData,false);
    app.getContactHelper().updateContact();
    app.goTo().goToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(before.size(),after.size());


    before.remove(0);
    before.add(contactData);
    Comparator<ContactData> comparator = Comparator.comparing(ContactData::getId);
    before.sort(comparator);
    after.sort(comparator);
    Assert.assertEquals(before,after);
  }


}

