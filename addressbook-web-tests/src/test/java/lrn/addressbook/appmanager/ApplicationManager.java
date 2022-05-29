package lrn.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

  protected WebDriver wd;
  private ContactHelper contactHelper;
  private NavigationHelper navigationHelper;
  private GroupHelper groupHelper;
  private SessionHelper sessionHelper;
  private String browser;

  public ApplicationManager(String browser) {
    this.browser = browser;
  }

  public void init() {
    if(browser == BrowserType.CHROME) {
      wd = new ChromeDriver();
    } else {
      if (browser == BrowserType.FIREFOX) {
        wd = new FirefoxDriver();
      } else {
        wd = new EdgeDriver();
      }
    }
    System.setProperty("webdriver.chrome.driver", "c:\\windows\\system32\\chromedriver.exe");
    System.setProperty("webdriver.firefox.driver", "c:\\windows\\system32\\geckodriver.exe");
    System.setProperty("webdriver.MicrosoftEdge.driver", "c:\\windows\\system32\\msedgedriver.exe");
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/");
    groupHelper = new GroupHelper(wd);
    navigationHelper = new NavigationHelper(wd);
    contactHelper = new ContactHelper(wd);
    sessionHelper = new SessionHelper(wd);
    sessionHelper.login("admin", "secret");

  }

  public void stop() {
    sessionHelper.logout();
    wd.quit();
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }

  public ContactHelper getContactHelper() {
    return contactHelper;
  }
}
