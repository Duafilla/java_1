package lrn.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void goToGroupPage() {

    click(By.linkText("groups"));
  }

  public void returnHomepage() {
    click(By.linkText("home page"));
    wd.get("http://localhost/addressbook/index.php");
  }

  public void goToContactForm() {

    click(By.linkText("add new"));
  }
}
