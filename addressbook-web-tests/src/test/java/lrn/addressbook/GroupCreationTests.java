package lrn.addressbook;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {

    goToGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("111", "111", "111"));
    submitGroupCreation();
    returnToGroupPage();
    logout();
  }

}
