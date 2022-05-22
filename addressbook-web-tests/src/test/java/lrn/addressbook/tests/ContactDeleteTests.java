package lrn.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeleteTests extends TestBase {

  @Test
  public void testContactDelete() {
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteContact();
    app.getContactHelper().submitDeleteContact();


  }
}
