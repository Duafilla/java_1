package lrn.addressbook.tests;

import lrn.addressbook.model.GroupData;
import org.testng.annotations.Test;

public class GroupDeleteTests extends TestBase{

  @Test
  public void testGroupDelete() throws Exception {
    app.getNavigationHelper().goToGroupPage();
    if (!(app.getGroupHelper().isThereAGroup())) {
      app.getGroupHelper().createGroup(new GroupData("111", "111", "111"));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGroup();
    app.getGroupHelper().returnToGroupPage();
  }

}
