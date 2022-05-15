package lrn.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase{

  @Test
  public void testContactCreation() throws Exception {

    newContactForm();
    fillContactForm(new ContactData("qwerty", "qwerty", "qwerty", "11111", "111111", "111111", "222222ddddd"));
    submitContactCreation();
    returnHomepage();
    logout();
  }

}
