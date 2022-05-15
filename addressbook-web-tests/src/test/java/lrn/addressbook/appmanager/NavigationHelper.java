package lrn.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper {
  private WebDriver wd;

  public NavigationHelper(WebDriver wd) {
    this.wd = wd;
  }

  public void goToGroupPage() {
    wd.findElement(By.linkText("groups")).click();
  }

  public void returnHomepage() {
    wd.findElement(By.linkText("home page")).click();
    wd.get("http://localhost/addressbook/index.php");
  }

  public void goToContactForm() {
    wd.findElement(By.linkText("add new")).click();
  }
}
