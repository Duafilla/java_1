package lrn.addressbook.tests;

import lrn.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class GroupCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validGroups() {
    List<Object[]> list = new ArrayList<>();
    list.add(new Object[] {new GroupData("test1","header1", "footer1")});
    list.add(new Object[] {new GroupData("test2","header2", "footer2")});
    return list.iterator();
  }

  @Test(dataProvider = "validGroups")
  public void testGroupCreation(GroupData groupData) {

    app.goTo().groupPage();
    Set<GroupData> before = app.group().all();
    app.group().create(groupData);
    Assert.assertEquals(app.group().getGroupCount(), before.size() + 1);

    Set<GroupData> after = app.group().all();
    groupData.setId(after.stream().mapToInt((GroupData::getId)).max().getAsInt());
    before.add(groupData);
    Assert.assertEquals(before, after);

  }

  @Test
  public void testBadGroupCreation() {

    app.goTo().groupPage();
    Set<GroupData> before = app.group().all();
    GroupData groupData = new GroupData("112'", "111", "111");
    app.group().create(groupData);
    Assert.assertEquals(app.group().getGroupCount(), before.size());

    Set<GroupData> after = app.group().all();
    Assert.assertEquals(before, after);

  }

}
