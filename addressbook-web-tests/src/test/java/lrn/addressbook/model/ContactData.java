package lrn.addressbook.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.Objects;

@Entity
@Table(name = "addressbook")
public class ContactData {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "firstname")
    private final String firstname;
    @Column(name = "lastName")
    private final String lastName;
    @Column(name = "nickname")
    private final String nick;
    @Column(name = "company")
    private final String company;
    @Column(name = "address")
    @Type(type = "text")
    private final String address;
    @Column(name = "home")
    @Type(type = "text")
    private final String homePhoneNumber;
    @Column(name = "mobile")
    @Type(type = "text")
    private final String mobilePhoneNumber;
    @Column(name = "work")
    @Type(type = "text")
    private final String workPhoneNumber;
    @Column(name = "email")
    @Type(type = "text")
    private final String email;
    @Transient
    private String group;
    @Transient
    private String photo;
    public File getPhoto() {
        return new File(photo);
    }

    public void setPhoto(File photo) {
        this.photo = photo.getPath();
    }

    public ContactData() {
        this.firstname = "";
        this.lastName = "";
        this.nick = "";
        this.company = "";
        this.address = "";
        this.homePhoneNumber = "";
        this.mobilePhoneNumber = "";
        this.workPhoneNumber = "";
        this.email = "";

    }

    public ContactData(String firstname, String lastName, String nick, String company, String address, String homePhoneNumber, String mobilePhoneNumber,
                       String workPhoneNumber, String email, String group) {
        this.id = Integer.MAX_VALUE;
        this.firstname = firstname;
        this.lastName = lastName;
        this.nick = nick;
        this.company = company;
        this.address = address;
        this.homePhoneNumber = homePhoneNumber;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.workPhoneNumber = workPhoneNumber;
        this.email = email;
        this.group = group;
    }

    public ContactData(int id, String firstname, String lastName, String nick, String address, String homePhoneNumber, String mobilePhoneNumber,
                       String workPhoneNumber, String email, String company, String group) {
        this.id = id;
        this.firstname = firstname;
        this.lastName = lastName;
        this.nick = nick;
        this.address = address;
        this.homePhoneNumber = homePhoneNumber;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.workPhoneNumber = workPhoneNumber;
        this.email = email;
        this.company = company;
        this.group = group;
    }

    public ContactData(File photo, String firstname, String lastName, String nick, String address, String homePhoneNumber, String mobilePhoneNumber,
                       String workPhoneNumber, String email, String company, String group) {
        this.photo = photo.getPath();
        this.firstname = firstname;
        this.lastName = lastName;
        this.nick = nick;
        this.address = address;
        this.homePhoneNumber = homePhoneNumber;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.workPhoneNumber = workPhoneNumber;
        this.email = email;
        this.company = company;
        this.group = group;
    }


    public String getFirstname() {
        return firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNick() {
        return nick;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress() {
        return address;
    }

    public String getHomePhoneNumber() {
        return homePhoneNumber;
    }
    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }
    public String getWorkPhoneNumber() {
        return workPhoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getGroup() {
        return group;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nick='" + nick + '\'' +
                ", company='" + company + '\'' +
                ", address='" + address + '\'' +
                ", homePhoneNumber='" + homePhoneNumber + '\'' +
                ", mobilePhoneNumber='" + mobilePhoneNumber + '\'' +
                ", workPhoneNumber='" + workPhoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", group='" + group + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return id == that.id && Objects.equals(firstname, that.firstname) && Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastName);
    }
}
