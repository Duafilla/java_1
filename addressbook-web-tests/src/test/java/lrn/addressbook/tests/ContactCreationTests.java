package lrn.addressbook.tests;

import lrn.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase{

  @Test
  public void testContactCreation() throws Exception {

    List<ContactData> before = app.getContactHelper().getContactList();
    app.getNavigationHelper().goToContactForm();
    ContactData contactData = new ContactData( "qwerty", "qwerty",
            "qwerty", "11111", "111111", "111111", "222222ddddd", "qwerty");
    app.getContactHelper().fillContactForm(contactData,true);
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().goToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(before.size() + 1,after.size());

    before.add(contactData);
    Comparator<ContactData> comparator = Comparator.comparing(ContactData::getId);
    before.sort(comparator);
    after.sort(comparator);
    Assert.assertEquals(before,after);
  }

}
