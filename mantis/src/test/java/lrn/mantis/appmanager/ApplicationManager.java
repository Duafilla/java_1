package lrn.mantis.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

  private final Properties properties;
  protected WebDriver wd;
  private String browser;

  public ApplicationManager(String browser) {
    this.browser = browser;
    properties = new Properties();

  }

  public void init() throws IOException {

    String target = System.getProperty("target", "local");
    properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
    System.setProperty("webdriver.chrome.driver", "c:\\windows\\system32\\chromedriver.exe");
    System.setProperty("webdriver.firefox.driver", "c:\\windows\\system32\\geckodriver.exe"); /*вообще можно эту строку удалить т.к. в else есть ссылка на драйвер*/


    if(browser == BrowserType.CHROME) {
      wd = new ChromeDriver();
    } else {
        System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        wd = new FirefoxDriver();
      }

    wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    wd.get(properties.getProperty("web.baseUrl"));
  }
  public void stop() {
    wd.quit();
  }
}
