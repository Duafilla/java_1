package lrn.addressbook.tests;

import lrn.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase{

  @Test
  public void testContactCreation() throws Exception {

    app.getNavigationHelper().goToContactForm();
    app.getContactHelper().fillContactForm(new ContactData("qwerty", "qwerty",
            "qwerty", "11111", "111111", "111111", "222222ddddd", "qwerty"), true);
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().goToHomePage();
  }

}
