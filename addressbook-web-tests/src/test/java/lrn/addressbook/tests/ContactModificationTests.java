package lrn.addressbook.tests;

import lrn.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ContactModificationTests extends TestBase{

  @Test

  public void testContactModification() {

    if (!(app.contact().isThereAContact())) {
      app.contact().createContact(new ContactData( "qwerty", "qwerty",
              "qwerty", "11111", "111111", "111111","222", "333", "222222ddddd", "qwerty"));
    }

    Set<ContactData> before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contactData = new ContactData(modifiedContact.getId(), "EEE", "www", "2222", "121ddd", "fff",
            "222", "333", "222", "qw", null);
    app.contact().modify(contactData);
    Assert.assertEquals(before.size(),app.contact().getContactCount());

    Set<ContactData> after = app.contact().all();
    before.remove(modifiedContact);
    before.add(contactData);
    Assert.assertEquals(before,after);
  }


}

