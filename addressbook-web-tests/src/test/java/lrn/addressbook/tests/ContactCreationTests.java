package lrn.addressbook.tests;

import lrn.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Set;

public class ContactCreationTests extends TestBase{

  @Test
  public void testContactCreation() throws Exception {

    Set<ContactData> before = app.contact().all();
    app.goTo().goToContactForm();
    ContactData contactData = new ContactData( "qwerty", "qwerty",
            "qwerty", "11111", "111111", "111111", "222", "333", "222222ddddd", "qwerty");
    app.contact().create(contactData);
    Assert.assertEquals(before.size() + 1,app.contact().getContactCount());

    Set<ContactData> after = app.contact().all();
    contactData.setId(after.stream().mapToInt((ContactData::getId)).max().getAsInt());
    before.add(contactData);
    Assert.assertEquals(before,after);
  }

}
