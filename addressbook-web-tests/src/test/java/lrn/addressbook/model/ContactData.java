package lrn.addressbook.model;

public class ContactData {
    private final String firstname;
    private final String midname;
    private final String nick;
    private final String company;
    private final String address;
    private final String homePhoneNumber;
    private final String email;
    private String group;

    public ContactData(String firstname, String midname, String nick, String company, String address, String homePhoneNumber, String email, String group) {
        this.firstname = firstname;
        this.midname = midname;
        this.nick = nick;
        this.company = company;
        this.address = address;
        this.homePhoneNumber = homePhoneNumber;
        this.email = email;
        this.group = group;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getMidname() {
        return midname;
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
}
