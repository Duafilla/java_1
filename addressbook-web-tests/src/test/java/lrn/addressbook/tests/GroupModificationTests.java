package lrn.addressbook.tests;

import lrn.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class GroupModificationTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().list().size() == 0) {
      app.group().create(new GroupData("111", "111", "111"));
    }
  }

  @Test

  public void testGroupModification() {
    List<GroupData> before = app.group().list();
    int index = before.size() - 1;
    GroupData groupData = new GroupData(before.get(index).getId(),"qwerty", "qwerty", "qwerty");
    app.group().modify(index, groupData);
    List<GroupData> after = app.group().list();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(groupData);
    Comparator<GroupData> comparatorById = Comparator.comparingInt(GroupData::getId);
    before.sort(comparatorById);
    after.sort(comparatorById);
    Assert.assertEquals(before, after);
  }
}
