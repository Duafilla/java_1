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
        elements.get(7).click();
        break;
      }
    }
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

  public void createContact(ContactData contactData) {
    fillContactForm(contactData);
    submitContactCreation();
    returnToHomePage();
  }

  public void delete(ContactData contactData) {
    selectContactById(contactData.getId());
    deleteContact();
    submitDeleteContact();
    pause(5000);
  }

  public void modify(ContactData contactData) {
    initContactModification(contactData);
    fillContactForm(contactData);
    updateContact();
    returnToHomePage();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public Set<ContactData> all() {
    Set<ContactData> contacts = new HashSet<>();
    WebElement baseTable = wd.findElement(By.id("maintable"));
    List<WebElement> tableRows = baseTable.findElements(By.cssSelector("tr"));
    tableRows.remove(0);
    for (WebElement element:tableRows) {
      List<WebElement> elements = element.findElements(By.tagName("td"));
      String idS = element.findElement(By.tagName("input")).getAttribute("id");
      int id = Integer.parseInt(idS);
      String lastName = elements.get(1).getText();
      String firstName = elements.get(2).getText();
      ContactData contact = new ContactData(id,firstName,lastName,null,null,null,null,
              null,null,null,null);
      contacts.add(contact);
    }
    return contacts;
  }
}
