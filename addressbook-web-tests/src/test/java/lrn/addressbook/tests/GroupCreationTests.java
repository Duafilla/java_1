package lrn.addressbook.tests;

import lrn.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Set;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {

    app.goTo().groupPage();
    Set<GroupData> before = app.group().all();
    GroupData groupData = new GroupData("112", "111", "111");
    app.group().create(groupData);
    Assert.assertEquals(app.group().getGroupCount(), before.size() + 1);

    Set<GroupData> after = app.group().all();
    groupData.setId(after.stream().mapToInt((GroupData::getId)).max().getAsInt());
    before.add(groupData);
    Assert.assertEquals(before, after);

  }

  @Test
  public void testBadGroupCreation() throws Exception {

    app.goTo().groupPage();
    Set<GroupData> before = app.group().all();
    GroupData groupData = new GroupData("112'", "111", "111");
    app.group().create(groupData);
    Assert.assertEquals(app.group().getGroupCount(), before.size());

    Set<GroupData> after = app.group().all();
    Assert.assertEquals(before, after);

  }

}
