package lrn.addressbook.tests;

import lrn.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

public class GroupModificationTests extends TestBase{

  @Test

  public void testGroupModification() {
    app.getNavigationHelper().goToGroupPage();
    if (!(app.getGroupHelper().isThereAGroup())) {
      app.getGroupHelper().createGroup(new GroupData("111", "111", "111"));
    }
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup(before.size() - 1);
    app.getGroupHelper().initGroupModificatin();
    GroupData groupData = new GroupData(before.get(before.size() - 1).getId(),"qwerty", "qwerty", "qwerty");
    app.getGroupHelper().fillGroupForm(groupData);
    app.getGroupHelper().updateGroup();
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(groupData);
    Assert.assertEquals(new HashSet<>(after), new HashSet<>(before));
  }
}
