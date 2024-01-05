package lrn.addressbook.tests;

import lrn.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class ContactModificationTests extends TestBase{

  @Test

  public void testContactModification() {

    if (!(app.contact().isThereAContact())) {
      app.contact().create(new ContactData("qwerty", "qwerty",
              "qwerty", "11111", "111111", "111111","222", "333", "222222ddddd", "qwerty"));
    }

    app.goTo().goToHomePage();
    Set<ContactData> before = new HashSet<>(app.db().contacts());
    ContactData modifiedContact = before.iterator().next();
    ContactData contactData = new ContactData(modifiedContact.getId(), "EEE", "www", "2222", "121ddd", "666",
            "222", "333", "222", "qw");
    app.contact().modify(contactData);
    Assert.assertEquals(before.size(),app.contact().getContactCount());

    Set<ContactData> after = new HashSet<>(app.db().contacts());
    before.remove(modifiedContact);
    before.add(contactData);
    Assert.assertEquals(before,after);
  }


}

