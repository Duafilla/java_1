package lrn.addressbook.tests;

import lrn.addressbook.model.GroupData;
import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase{

  @Test

  public void testGroupModification() {
    app.getNavigationHelper().goToGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModificatin();
    app.getGroupHelper().fillGroupForm(new GroupData("qwerty", "qwerty", "qwerty"));
    app.getGroupHelper().updateGroup();
    app.getGroupHelper().returnToGroupPage();
  }
}
