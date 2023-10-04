package lrn.addressbook.appmanager;

import lrn.addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupHelper extends HelperBase {

  public GroupHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToGroupPage() {
    click(By.linkText("group page"));
  }

  public void submitGroupCreation() {

    click(By.name("submit"));
  }

  public void fillGroupForm(GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());
  }

  public void initGroupCreation() {
    click(By.name("new"));
  }

  public void deleteSelectedGroup() {
    click(By.name("delete"));
  }


  public void selectGroupById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public void initGroupModificatin() {
    click(By.name("edit"));
  }

  public void updateGroup() {
    click(By.name("update"));
  }

  public boolean isThereAGroup() {
      return isElementPresent(By.name("selected[]"));
  }

  public void create(GroupData groupData) {
    initGroupCreation();
    fillGroupForm(groupData);
    submitGroupCreation();
    groupCache = null;
    returnToGroupPage();
  }


  public void delete(GroupData group) {
    selectGroupById(group.getId());
    deleteSelectedGroup();
    groupCache = null;
    returnToGroupPage();
  }

  public int getGroupCount() {
    return  wd.findElements(By.name("selected[]")).size();
    }


  public void modify(GroupData groupData) {
    selectGroupById(groupData.getId());
    initGroupModificatin();
    fillGroupForm(groupData);
    updateGroup();
    groupCache = null;
    returnToGroupPage();
  }

  private Set<GroupData> groupCache = null;
  private Set<GroupData> copyGroupCache = groupCache;

  public Set<GroupData> all() {
    if (groupCache != null) {
      return copyGroupCache;
    }
    Set<GroupData> groupCache = new HashSet<>();
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
    for (WebElement element: elements) {
      String name = element.getText();
      String idS = element.findElement(By.tagName("input")).getAttribute("value");
      int id = Integer.parseInt(idS);
      GroupData group = new GroupData(id, name, null, null);
      groupCache.add(group);
    }
    return copyGroupCache = groupCache;
  }
}
