package lrn.addressbook.tests;

import lrn.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Set;

public class GroupDeleteTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().all().size() == 0) {
      app.group().create(new GroupData("111", "111", "111"));
    }
  }

  @Test
  public void testGroupDelete() throws Exception {
    Set<GroupData> before = app.group().all();
    GroupData deletedGroup = before.iterator().next();
    app.group().delete(deletedGroup);
    Assert.assertEquals(app.group().getGroupCount(), before.size() - 1);

    Set<GroupData> after = app.group().all();
    before.remove(deletedGroup);
    Assert.assertEquals(after, before);
  }
}
