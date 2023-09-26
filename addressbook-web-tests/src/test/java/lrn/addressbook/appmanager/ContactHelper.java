package lrn.addressbook.appmanager;

import lrn.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitContactCreation() {

    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("nickname"), contactData.getNick());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getHomePhoneNumber());
    type(By.name("email2"), contactData.getEmail());
    type(By.name("company"), contactData.getCompany());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    }
    else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void initContactModification() {
    click(By.xpath("//img[@alt='Edit']"));
  }

  public void updateContact() {
    click(By.name("update"));
  }

  public void selectContact() {
    click(By.name("selected[]"));
  }

  public void deleteContact() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void submitDeleteContact() {
    sub();
  }

  public void createContact(ContactData contactData, boolean b) {
    fillContactForm(contactData, b);
    submitContactCreation();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<>();
    WebElement baseTable = wd.findElement(By.id("maintable"));
    List<WebElement> tableRows = baseTable.findElements(By.cssSelector("tr"));
    tableRows.remove(0);
    for (WebElement element:tableRows) {
      List<WebElement> elements = element.findElements(By.tagName("td"));
      String idS = element.findElement(By.tagName("input")).getAttribute("id");
      int id = Integer.parseInt(idS);
      String lastName = elements.get(1).getText();
      String firstName = elements.get(2).getText();
      ContactData contact = new ContactData(id,firstName,lastName,null,null,null,null,null,null);
      contacts.add(contact);
    }
    return contacts;
  }
}
