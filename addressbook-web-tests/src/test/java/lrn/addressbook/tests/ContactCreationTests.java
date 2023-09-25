package lrn.addressbook.tests;

import lrn.addressbook.model.ContactData;
import lrn.addressbook.model.GroupData;
import org.testng.annotations.Test;

import java.util.List;

public class ContactCreationTests extends TestBase{

  @Test
  public void testContactCreation() throws Exception {

    app.getNavigationHelper().goToContactForm();
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().fillContactForm(new ContactData("qwerty", "qwerty",
            "qwerty", "11111", "111111", "111111", "222222ddddd", "qwerty"), true);
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().goToHomePage();
  }

}
