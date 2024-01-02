package lrn.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;
import lrn.addressbook.model.GroupData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

  Logger logger = LoggerFactory.getLogger(GroupCreationTests.class);

  @DataProvider
  public Iterator<Object[]> validGroupsFromXml() throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/groups.xml"))) {
      String xml = "";
      String line = reader.readLine();
      while (line != null) {
        xml += line;
        line = reader.readLine();
      }
      XStream xStream = new XStream();
      xStream.addPermission(AnyTypePermission.ANY);
      xStream.processAnnotations(GroupData.class);
      List<GroupData> groups = (List<GroupData>) xStream.fromXML(xml);
      return groups.stream().map((groupData -> new Object[] {groupData})).collect(Collectors.toList()).iterator();
    }
  }

  @DataProvider
  public Iterator<Object[]> validGroupsFromJson() throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/groups.json"))) {
      String json = "";
      String line = reader.readLine();
      while (line != null) {
        json += line;
        line = reader.readLine();
      }
      Gson gson = new  Gson();
      List<GroupData> groups = (List<GroupData>) gson.fromJson(json, new TypeToken<List<GroupData>>(){}.getType()); //равносильно если бы можно было сделать List<GroupData>.class
      return groups.stream().map((groupData -> new Object[] {groupData})).collect(Collectors.toList()).iterator();
    }
  }

  @Test(dataProvider = "validGroupsFromJson")
  public void testGroupCreation(GroupData groupData) {

    logger.info("Start test testGroupCreation");
    app.goTo().groupPage();
    Set<GroupData> before = app.group().all();
    app.group().create(groupData);
    Assert.assertEquals(app.group().getGroupCount(), before.size() + 1);

    Set<GroupData> after = app.group().all();
    groupData.setId(after.stream().mapToInt((GroupData::getId)).max().getAsInt());
    before.add(groupData);
    Assert.assertEquals(before, after);
    logger.info("Stop test testGroupCreation");

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
