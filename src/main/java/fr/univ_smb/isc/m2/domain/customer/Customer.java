package fr.univ_smb.isc.m2.domain.customer;

public class Customer {

    public String login;
    public String password;
    public Integer id;

    public Customer() {
        // Jackson
    }

    public Customer(int id, String login, String lastName) {
        this.login = login;
        this.password = password;
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

}
