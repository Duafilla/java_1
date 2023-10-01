package lrn.addressbook.tests;

import lrn.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class GroupDeleteTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    app.getNavigationHelper().goToGroupPage();
    if (!(app.getGroupHelper().isThereAGroup())) {
      app.getGroupHelper().createGroup(new GroupData("111", "111", "111"));
    }
  }

  @Test
  public void testGroupDelete() throws Exception {
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup(before.size() - 1);
    app.getGroupHelper().deleteSelectedGroup();
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() - 1);
    Assert.assertEquals(after, before);
  }

}
