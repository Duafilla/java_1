package lrn.addressbook.tests;

import lrn.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupDeleteTests extends TestBase{

  @Test
  public void testGroupDelete() throws Exception {
    app.getNavigationHelper().goToGroupPage();
    int before = app.getGroupHelper().getGroupCount();
    if (!(app.getGroupHelper().isThereAGroup())) {
      app.getGroupHelper().createGroup(new GroupData("111", "111", "111"));
    }
    app.getGroupHelper().selectGroup(before - 1);
    app.getGroupHelper().deleteSelectedGroup();
    app.getGroupHelper().returnToGroupPage();
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before - 1);
  }

}
