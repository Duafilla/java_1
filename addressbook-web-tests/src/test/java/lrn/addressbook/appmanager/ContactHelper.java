package lrn.addressbook.appmanager;

import lrn.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactHelper extends HelperBase {

  private Set<ContactData> contactCache = null;
  private Set<ContactData> copyContactCache = contactCache;

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitContactCreation() {

    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void returnToHomePage() {
    click(By.linkText("home page"));
  }

  public void fillContactForm(ContactData contactData) {
    if (contactData.getPhoto() != null) {
      attach(By.name("photo"), contactData.getPhoto());
    }
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("nickname"), contactData.getNick());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getHomePhoneNumber());
    type(By.name("mobile"), contactData.getMobilePhoneNumber());
    type(By.name("work"), contactData.getWorkPhoneNumber());
    type(By.name("email2"), contactData.getEmail());
    type(By.name("company"), contactData.getCompany());
  }

  public void initContactModification(ContactData contactData) {
    String id = (String.valueOf(contactData.getId()));
    WebElement baseTable = wd.findElement(By.id("maintable"));
    List<WebElement> tableRows = baseTable.findElements(By.cssSelector("tr"));
    tableRows.remove(0);
    for(WebElement element:tableRows) {
      String idS = element.findElement(By.tagName("input")).getAttribute("id");
      if (id.equals(idS)) {
        List<WebElement> elements = element.findElements(By.tagName("td"));
        elements.get(7).findElement(By.tagName("a")).click();
        break;
      }
    }
  }

  public ContactData InfoFromEditForm(ContactData contactData) {
    initContactModification(contactData);
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    wd.navigate().back();
    return new ContactData(contactData.getId(),firstname,lastname, contactData.getNick(), contactData.getAddress(), home, mobile, work, contactData.getEmail(),
            contactData.getCompany());
  }

  public int getContactCount() {
    return  wd.findElements(By.name("selected[]")).size();
  }

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[id='" + id + "']")).click();
  }



  public void updateContact() {
    click(By.name("update"));
  }


  public void deleteContact() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void submitDeleteContact() {
    sub();
  }

  public void create(ContactData contactData) {
    fillContactForm(contactData);
    submitContactCreation();
    contactCache = null;
    returnToHomePage();
  }

  public void delete(ContactData contactData) {
    selectContactById(contactData.getId());
    deleteContact();
    submitDeleteContact();
    contactCache = null;
    pause(5000);
  }

  public void modify(ContactData contactData) {
    initContactModification(contactData);
    fillContactForm(contactData);
    updateContact();
    contactCache = null;
    returnToHomePage();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public Set<ContactData> all() {
    if (contactCache != null) {
      return copyContactCache;
    }
    Set<ContactData> contactCache = new HashSet<>();
    List<WebElement> tableRows = wd.findElements(By.xpath("//*/tbody/tr[@name='entry']"));
    for (WebElement element:tableRows) {
      String string = element.findElement(By.cssSelector("input[type='checkbox']")).getAttribute("id");
      int id = Integer.parseInt(string);
      String lastName = element.findElement(By.cssSelector("td:nth-child(2)")).getText();
      String firstName = element.findElement(By.cssSelector("td:nth-child(3)")).getText();
      String allPhones = element.findElement(By.cssSelector("td:nth-child(6)")).getText();
      String[] phones = allPhones.split("\n");
      ContactData contact;
      switch (phones.length) {
        case 1: contact = new ContactData(id,firstName,lastName,null,null,phones[0],null,
                null,null,null);
          break;
        case 2: contact = new ContactData(id,firstName,lastName,null,null,phones[0],phones[1],
                null,null,null);
          break;
        case 3: contact = new ContactData(id,firstName,lastName,null,null,phones[0],phones[1],
                phones[2],null,null);
          break;
        default: contact = new ContactData(id,firstName,lastName,null,null,null,null,
                null,null,null);
      }

      contactCache.add(contact);
    }
    return copyContactCache = contactCache;
  }
}
