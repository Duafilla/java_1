package lrn.addressbook.tests;

import com.thoughtworks.xstream.XStream;
import lrn.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class GroupCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validGroups() throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/groups.xml"));
    String xml = "";
    String line = reader.readLine();
    while (line != null) {
      xml += line;
      line = reader.readLine();
    }
    XStream xStream = new XStream();
    xStream.allowTypesByWildcard(
            new String[] { "lrn.addressbook.model.GroupData.*"});
    xStream.processAnnotations(GroupData.class);
    List<GroupData> groups = (List<GroupData>) xStream.fromXML(xml);
    return groups.stream().map((groupData -> new Object[] {groupData})).collect(Collectors.toList()).iterator();
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

  @Test(enabled = false)
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
