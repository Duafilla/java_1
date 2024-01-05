package lrn.addressbook.tests;

import lrn.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

public class GroupModificationTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.db().groups().size() == 0) {
      app.group().create(new GroupData("111", "111", "111"));
    }
  }

  @Test

  public void testGroupModification() {
    Set<GroupData> before = new HashSet<>(app.db().groups());
    GroupData modifiedGroup = before.iterator().next();
    GroupData groupData = new GroupData(modifiedGroup.getId(),"qwerty", "qwerty", "qwerty");
    app.group().modify(groupData);
    Assert.assertEquals(app.group().getGroupCount(), before.size());

    Set<GroupData> after = new HashSet<>(app.db().groups());
    before.remove(modifiedGroup);
    before.add(groupData);
    Assert.assertEquals(before, after);


  }
}
