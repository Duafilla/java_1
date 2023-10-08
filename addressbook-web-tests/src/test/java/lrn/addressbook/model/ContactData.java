package lrn.addressbook.model;

import java.util.Objects;

public class ContactData {

    private int id;
    private final String firstname;
    private final String lastName;
    private final String nick;
    private final String company;
    private final String address;
    private final String homePhoneNumber;
    private final String mobilePhoneNumber;
    private final String workPhoneNumber;
    private final String email;
    private String group;


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
