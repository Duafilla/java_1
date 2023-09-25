package lrn.addressbook.model;

public class ContactData {
    private final String firstname;
    private final String lastName;
    private final String nick;
    private final String company;
    private final String address;
    private final String homePhoneNumber;
    private final String email;
    private String group;

    public ContactData(String firstname, String lastName, String nick, String address, String homePhoneNumber, String email, String company, String group) {
        this.firstname = firstname;
        this.lastName = lastName;
        this.nick = nick;
        this.address = address;
        this.homePhoneNumber = homePhoneNumber;
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

    public String getEmail() {
        return email;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "firstname='" + firstname + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nick='" + nick + '\'' +
                ", company='" + company + '\'' +
                ", address='" + address + '\'' +
                ", homePhoneNumber='" + homePhoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", group='" + group + '\'' +
                '}';
    }


}
