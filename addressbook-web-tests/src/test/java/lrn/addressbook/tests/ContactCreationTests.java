package lrn.addressbook.tests;

import lrn.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Set;

public class ContactCreationTests extends TestBase{

  @Test
  public void testContactCreation() throws Exception {

      app.goTo().goToHomePage();
      Set<ContactData> before = app.contact().all();
      app.goTo().goToContactForm();
      File photo = new File("src/test/resources/pic.jpg");
      ContactData contactData = new ContactData(photo, "qwerty", "qwerty",
              "qwerty", "11111", "111111", "111111", "222", "333", "222222ddddd", "qwerty");
      app.contact().create(contactData);
      Assert.assertEquals(before.size() + 1, app.contact().getContactCount());

      Set<ContactData> after = app.contact().all();
      contactData.setId(after.stream().mapToInt((ContactData::getId)).max().getAsInt());
      before.add(contactData);
      Assert.assertEquals(before, after);
  }

}
