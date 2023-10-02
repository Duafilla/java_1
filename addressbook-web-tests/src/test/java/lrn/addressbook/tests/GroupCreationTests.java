package lrn.addressbook.tests;

import lrn.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {

    app.goTo().groupPage();
    List<GroupData> before = app.group().list();
    GroupData groupData = new GroupData("112", "111", "111");
    app.group().create(groupData);
    List<GroupData> after = app.group().list();
    Assert.assertEquals(after.size(), before.size() + 1);

    before.add(groupData);
    Comparator<GroupData> comparatorById = Comparator.comparingInt(GroupData::getId);
    before.sort(comparatorById);
    after.sort(comparatorById);
    Assert.assertEquals(before, after);

  }

}
