package lrn.addressbook.tests;

import lrn.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class GroupCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validGroups() throws IOException {
    List<Object[]> list = new ArrayList<>();
    BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/groups.csv"));
    String line = reader.readLine();
    while (line != null) {
      String[] split = line.split(";");
      list.add(new Object[]{new GroupData(split[0], split[1], split[2])});
      line = reader.readLine();
    }
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
