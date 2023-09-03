package lrn.addressbook.tests;

import lrn.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {

    app.getNavigationHelper().goToGroupPage();
    List<GroupData> before = app.getGroupHelper().getGroupList();
    GroupData groupData = new GroupData("111", "111", "111");
    app.getGroupHelper().createGroup(groupData);
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() + 1);

    int maxId = 0;
    for (GroupData group:after) {
      int current = group.getId();
      if (maxId < current) {
        maxId = current;
      }
    }
    groupData.setId(maxId);
    before.add(groupData);
    Assert.assertEquals(new HashSet<>(after), new HashSet<>(before));
  }

}
